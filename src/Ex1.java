/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {


        private static int getNumberChar(char hexNumber){
            if(hexNumber >= '0' && hexNumber <= '9' ){
                return hexNumber -'0';
            }
            else if(hexNumber >= 'A' && hexNumber <= 'F' ){
                return hexNumber - 'A' + 10;
            }
            else if(hexNumber >= 'a' && hexNumber <= 'f' ){
                return hexNumber - 'a' + 10;
            }
            return -1;
        }

        private static char getHexChar(int number){
            if(number >= 0 && number <= 9 ){
                return (char)(number + '0');
            }
            else if(number >= 10 && number <= 15 ){
                return (char)(number - 10 + 'A');
            }
            return '\0';
        }

        private static int getBase(String number){
            return Ex1.getNumberChar(number.charAt(number.length()-1));
        }

        private static String reversString(String string){
            String reversed = "";
            for(int i = string.length()-1; i >= 0; i--){
                reversed += string.charAt(i);
            }
            return reversed;
        }

        private static String getBase(int base){
            return "b"+Ex1.getHexChar(base);
        }

        /**
         * Convert the given number (num) to a decimal representation (as int).
         * It the given number is not in a valid format returns -1.
         * @param num a String representing a number in basis [2,16]
         * @return
         */
        public static int number2Int(String num) {
            int ans = -1;
            int sum = 0;
            int power = 0;
            int base = Ex1.getBase(num);
            for(int i = num.length()-3; i >= 0; i--){
//                System.out.print(num.charAt(i)+" ");
                sum += getNumberChar(num.charAt(i))*Math.pow(base, power);
                power++;

            }
//            System.out.println(sum);
            ans=sum;

            return ans;
        }
        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
        public static boolean isNumber(String a) {
            boolean ans = true;
            // add your code here

            ////////////////////
            return ans;
        }

        /**
         * Calculate the number representation (in basis base)
         * of the given natural number (represented as an integer).
         * If num<0 or base is not in [2,16] the function should return "" (the empty String).
         * @param num the natural number (include 0).
         * @param base the basis [2,16]
         * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
         */
        public static String int2Number(int num, int base) {
            String ans = "";
                while (num > 0) {
                    ans += getHexChar(num % base);
                    num /= base;
                }
//                System.out.println(Ex1.reversString(ans));
                ans = Ex1.reversString(ans);
                ans = ans + Ex1.getBase(base);
                System.out.println(ans);

            return ans;
        }

        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true iff the two numbers have the same values.
         */
        public static boolean equals(String n1, String n2) {
            boolean ans = true;

            return ans;
        }

        /**
         * This static function search for the array index with the largest number (in value).
         * In case there are more than one maximum - returns the first index.
         * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
         * @param arr an array of numbers
         * @return the index in the array in with the largest number (in value).
         *
         */
        public static int maxIndex(String[] arr) {
            int ans = 0;
            // add your code here

            ////////////////////
            return ans;
        }
}
