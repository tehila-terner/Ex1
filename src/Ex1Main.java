import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {

    public static void printNumberInfo(String number){
        System.out.println("num1 = " + number  +  " is number = " +  Ex1.isNumber(number) + ", value: " + Ex1.number2Int(number));
    }

    public static void printCalc(String number1, String number2, String base){


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit", base = "";

//        System.out.println(Ex1.getCleanString("111111312"));
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals("quit")) {
                Ex1Main.printNumberInfo(num1);
            }
            num2 = sc.next();
            if (!num2.equals("quit")) {
                Ex1Main.printNumberInfo(num2);
            }
            base = sc.next();
            if(!Ex1.isNumber(base) || Ex1.number2Int(base) > 16 || Ex1.number2Int(base) < 2) {
                System.out.println("ERR: wrong base, should be [2,16], got" + "("+base+")");
                continue;
            }
            Ex1Main.printCalc(num1, num2, base);
        }
        System.out.println("quiting now...");
    }
}
