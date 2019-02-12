/*
In class Assignment #2
Due Date: 2/5/19
Name: Armando Valdez
 */
package classpet;

public class ClassPet {
    public static void main(String[] args) {
        Pet dot = new Pet();
        
        dot.setName("Bob");
        dot.setAnimal("Dog");
        dot.setAge(4);
        
        System.out.println("The name of my pet is " +dot.getName());
        
        System.out.println(dot.getName()+ " is a " +dot.getAnimal());
        
        System.out.println("My pet is " + dot.getAge()+ " years old");
        
    }
    
}
