/*
In class Assignment #2
Due Date: 2/5/19
Name: Armando Valdez
 */
package classpet;


public class Pet {
    private String name;
    private String animal;
    private int age;
    
    public void setName(String n)
    {
        name = n;
    }
    
    public void setAnimal(String ani)
    {
        animal = ani;
    }
    
    public void setAge(int a)
    {
        age = a;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getAnimal()
    {
        return animal;
    }
    
    public int getAge()
    {
        return age;
    }
}
