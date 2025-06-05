package JavaCollectionsAssignment;
import java.util.*;



class Product{
private int productId;
private String productName;
private String category;
private double price;

public Product(int productId,String productName,String category,double price){
this.productId=productId;
this.productName=productName;
this.category=category;
this.price=price;
}

public int getProductId(){
    return productId;
}
public void setProductId(int productId){
    this.productId=productId;
}
public String getProductName(){
    return productName;
}
public void setProductName(String productName){
    this.productName=productName;
}
public String getCategory(){
    return category;
}
public void setCategory(String category){
    this.category=category;
}
public double getPrice(){
    return price;
}
public void setPrice(double price){
    this.price=price;
}

@Override
public String toString(){
return productId+" "+productName+" "+category+" "+price;
}
}

class ProductManager{
private Map<Integer,Product> productMap=new HashMap<>();

public boolean addProduct(Product p){
if(productMap.containsKey(p.getProductId()))return false;
productMap.put(p.getProductId(),p);
return true;
}

public Product getProductById(int id){
return productMap.get(id);
}

public boolean updateProduct(int id,String name,String category,double price){
Product p=productMap.get(id);
if(p!=null){
p.setProductName(name);
p.setCategory(category);
p.setPrice(price);
return true;
}
return false;
}

public boolean deleteProduct(int id){
return productMap.remove(id)!=null;
}

public List<Product> getAllProductsSortedById(){
List<Product> list=new ArrayList<>(productMap.values());
list.sort(Comparator.comparingInt(Product::getProductId));
return list;
}

public List<Product> getAllProductsSortedByName(){
List<Product> list=new ArrayList<>(productMap.values());
list.sort(Comparator.comparing(Product::getProductName));
return list;
}
}

public class CollectionExp1{
public static void main(String[] args){
ProductManager pm=new ProductManager();
pm.addProduct(new Product(101,"Laptop","Electronics",999.99));
pm.addProduct(new Product(102,"Groceries","Household",5.49));
pm.addProduct(new Product(103,"Notebook","Stationery",1.99));
for(Product p:pm.getAllProductsSortedById())System.out.println(p);
System.out.println("---");
for(Product p:pm.getAllProductsSortedByName())System.out.println(p);
}
}

