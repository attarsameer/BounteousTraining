package JavaCollectionsAssignment;

import java.util.*;


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
public boolean equals(Object o){
if(this==o)return true;
if(o==null||getClass()!=o.getClass())return false;
Product product=(Product)o;
return productId==product.productId;
}

@Override
public int hashCode(){
return Objects.hash(productId);
}

@Override
public String toString(){
return productId+" "+productName+" "+category+" "+price;
}
}

class ProductCatalogue{
private Map<Product,Integer> catalogue=new HashMap<>();

public boolean addProduct(Product p,int quantity){
if(catalogue.containsKey(p))return false;
catalogue.put(p,quantity);
return true;
}

public Integer getQuantity(Product p){
return catalogue.get(p);
}

public boolean updateProduct(Product p,String name,String category,double price,int quantity){
if(catalogue.containsKey(p)){
p.setProductName(name);
p.setCategory(category);
p.setPrice(price);
catalogue.put(p,quantity);
return true;
}
return false;
}

public boolean deleteProduct(Product p){
return catalogue.remove(p)!=null;
}

public List<Map.Entry<Product,Integer>> getProductsSortedById(){
List<Map.Entry<Product,Integer>> list=new ArrayList<>(catalogue.entrySet());
list.sort(Comparator.comparing(e->e.getKey().getProductId()));
return list;
}

public List<Map.Entry<Product,Integer>> getProductsSortedByName(){
List<Map.Entry<Product,Integer>> list=new ArrayList<>(catalogue.entrySet());
list.sort(Comparator.comparing(e->e.getKey().getProductName()));
return list;
}
}

public class CollectionExp2{
public static void main(String[] args){
ProductCatalogue pc=new ProductCatalogue();
Product p1=new Product(101,"Laptop","Electronics",999.99);
Product p2=new Product(102,"Shampoo","Toiletries",5.49);
Product p3=new Product(103,"Notebook","Stationery",1.99);
pc.addProduct(p1,10);
pc.addProduct(p2,50);
pc.addProduct(p3,100);
for(Map.Entry<Product,Integer> e:pc.getProductsSortedById())System.out.println(e.getKey()+" Qty:"+e.getValue());
System.out.println("---");
for(Map.Entry<Product,Integer> e:pc.getProductsSortedByName())System.out.println(e.getKey()+" Qty:"+e.getValue());
}
}

