
import java.util.Scanner;

public class circle
{
   
    public long diameter;
    final double PI = 3.14159265358979;
    public double radius, area, circumference;
    
    public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the Circle's Diameter:  ");
    circle c = new circle(input.nextLong());
    System.out.println(c.calculateStats());
    }
    public circle (long inputValue)
    {
        diameter = inputValue;
    }

    public String calculateStats()
    {
    double radius = diameter/2;
    double area = (PI * diameter * diameter)/4;
    double circumference = (PI * diameter);

    return  "\ndiameter = " + diameter +
             "\nradius = " + radius +
             "\narea = " + area +
             "\ncircumference = " + circumference;
        
    
    }

    }

    

    

