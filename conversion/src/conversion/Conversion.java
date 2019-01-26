/*
In Class Assignment #1
Due Date: 1/25/19
Name: Armando Valdez
*/
package conversion;
import java.util.Scanner;
import java.lang.Math;

public class Conversion {
        public static void main(String[] args) {
           Scanner scnr = new Scanner(System.in);
           int userMeters;
           int userChoice;
           
           System.out.println("Enter a distance in meters:");
           userMeters = scnr.nextInt();
           
           while (userMeters < 0)
           {
               System.out.println("Please enter a positive number");
               userMeters = scnr.nextInt();
           }
       
           while (true){
           showMenu();
           userChoice = scnr.nextInt();
            switch (userChoice) {
                case 1:
                    showKilometers(userMeters);
                    break;
                case 2:
                    showInches(userMeters);
                    break;
                case 3:
                    showFeet(userMeters);
                    break;
                case 4:
                    System.out.println("Bye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!!!!");
                    break;
            }
           }
        }

public static void showKilometers( int num )
{
    double kilometers;
    kilometers = num * 0.001;
    System.out.println( num+ " meters is " + kilometers + " killometers.");
    System.out.println();
}

public static void showInches(int num)
{
    double inches;
    inches = num * 39.37;
    System.out.println( num+ " meters is " + inches + " inches.");
    System.out.println();
}

public static void showFeet(int num)
{
    double feet;
    feet = num * 3.281;
    System.out.println( num+ " meters is " + feet + " feet.");
    System.out.println();
}

public static void showMenu()
{
    System.out.println("1. Convert to kilometers");
    System.out.println("2. Convert to inches");
    System.out.println("3. Convert to feet");
    System.out.println("4. Quit the progam");
    System.out.println();
    System.out.println("Enter your choice:");
}
}