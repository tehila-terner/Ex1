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
        int num1 = Ex1.number2Int(number1);
        int num2 = Ex1.number2Int(number2);
        int bas =  Ex1.number2Int(base);
        System.out.println(num1 + "+"  + num2 +  "=" + Ex1.int2Number(num1+num2,bas));
        System.out.println(num1 + "*"  + num2 +  "=" + Ex1.int2Number(num1*num2,bas));

    }

    public static String getNumber(Scanner scan, String numberCount){
        System.out.println("Enter a string as number#" +numberCount+ "(or \"quit\" to end the program): ");
        String num = scan.next();

        if(num.equals("quit") || Ex1.isNumber(num)){
            return num;
        }

        System.out.println("ERR: num" + numberCount + "is in the wrong format!" + "("+num+")" );
        return "";
    }

    public static String getBase(Scanner scan){
        System.out.println("Enter a base for output: (a number [2,16]");
        String base = scan.next();
        if(!Ex1.isNumber(base) || Ex1.number2Int(base) > 16 || Ex1.number2Int(base) < 2){
            System.out.println("ERR: wrong base, should be [2,16], got" + "("+base+")");
            return "";
        }
        return base;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit", base = "";

//        System.out.println(Ex1.getCleanString("111111312"));
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            num1 = Ex1Main.getNumber(sc, "1");
            if (num1 != "" && !num1.equals("quit")) {
                Ex1Main.printNumberInfo(num1);
                num2 = Ex1Main.getNumber(sc, "2");
                if (!num2.equals("") && !num2.equals("quit")) {
                    Ex1Main.printNumberInfo(num2);
                    base = Ex1Main.getBase(sc);
                    if(!base.equals("")){
                        Ex1Main.printCalc(num1, num2, base);
                    }
                }
            }



        }
        System.out.println("quiting now...");
    }
}
