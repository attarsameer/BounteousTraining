package JavaStreams;




import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    String gender;
    Student(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }
    public String getPrefixName() {
        return (gender.equalsIgnoreCase("Male") ? "Mr. " : "Ms. ") + name;
    }
}

class Problem3 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Sameer", "Male"),
            new Student("Anya", "Female"),
            new Student("Santosh", "Male"),
            new Student("Sony", "Female")
        );

        List<String> prefixedNames = students.stream()
                .map(Student::getPrefixName)
                .collect(Collectors.toList());

        prefixedNames.forEach(System.out::println);
    }
}

