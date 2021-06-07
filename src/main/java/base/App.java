/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Alice Yu
 */
package base;
import java.util.Scanner;
import java.util.* ;

/*
Exercise 17 - Blood Alcohol Calculator
Sometimes you have to perform a more complex calculation based on some provided inputs and then use that result to make a determination.

Create a program that prompts for your weight, gender, total alcohol consumed (in ounces), and the amount of time since your last drink. Calculate your blood alcohol content (BAC) using this formula

BAC = (A × 5.14 / W × r) − .015 × H
where

A is total alcohol consumed, in ounces (oz).
W is body weight in pounds.
r is the alcohol distribution ratio:
0.73 for men
0.66 for women
H is number of hours since the last drink.
Display whether or not it’s legal to drive by comparing the blood alcohol content to 0.08.

Example Output
Enter a 1 is you are male or a 2 if you are female: 1
How many ounces of alcohol did you have? 3
What is your weight, in pounds? 175
How many hours has it been since your last drink? 1

Your BAC is 0.049323
It is legal for you to drive.


Enter a 1 is you are male or a 2 if you are female: 1
How many ounces of alcohol did you have? 5
What is your weight, in pounds? 175
How many hours has it been since your last drink? 1

Your BAC is 0.092206
It is not legal for you to drive.
Constraint
Prevent the user from entering non-numeric values.
Challenges
Handle metric units.
Look up the legal BAC limit by state and prompt for the state.
Display a message that states whether or not it’s legal to drive based on the computed BAC.
Develop this as a mobile application that makes it easy to record each drink, updating the BAC each time a drink is entered.

 */

public class App {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        App myApp = new App();

        try
        {
            int sex = myApp.readInputInteger("Enter a 1 if you are male or a 2 if you are female: ");
            double ounces = myApp.readInputDouble("How many ounces of alcohol did you have? ");
            double pounds = myApp.readInputDouble("What is your weight, in pounds? ");
            int hours = myApp.readInputInteger("How many hours has it been since your last drink? ");

            final double r = (sex == 1) ? 0.73 : 0.66;

            double bAC = ((ounces * 5.14) / pounds * r) - (0.015 * hours);

            String displayBAC = ("Your BAC is " + String.format("%.6f", bAC));
            myApp.printOutput(displayBAC);

            if (bAC < 0.08)
            {
                String outputString = ("\nIt is legal for you to drive.");
                myApp.printOutput(outputString);
            }
            else
            {
                String outputString = ("It is not legal for you to drive.");
                myApp.printOutput(outputString);
            }
        }
        catch (InputMismatchException ex)
        {
            System.out.println("Please enter in a number");
        }
    }

    public int readInputInteger(String input)
    {
        System.out.print(input);
        return in.nextInt();
    }

    public double readInputDouble(String input)
    {
        System.out.print(input);
        return in.nextDouble();
    }

    public void printOutput(String input)
    {
        System.out.println(input);
    }
}
