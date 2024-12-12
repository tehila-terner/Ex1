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
    /**
     * this function
     * @param hexNumber
     * @return
     */

        private static int getNumberChar(char hexNumber){
            if(hexNumber >= '0' && hexNumber <= '9' ){
                return hexNumber -'0';
            }
            else if(hexNumber >= 'A' && hexNumber <= 'G' ){
                return hexNumber - 'A' + 10;
            }
            return -1;
        }

        private static char getHexChar(int number){
            if(number >= 0 && number <= 9 ){
                return (char)(number + '0');
            }
            else if(number >= 10 && number <= 16 ){
                return (char)(number - 10 + 'A');
            }
            return '\0';
        }

        public static boolean isValidBaseNumber(String baseNumber){
            isNumber(baseNumber);
            int nume = Ex1.number2Int(baseNumber);


        }

        private static int getBase(String number) {
            if (number == null){
                return -1;
            }
            if(number.length() < 2 || number.charAt(number.length() - 2) != 'b'){
                return 10;
            }
            int base = Ex1.getNumberChar(number.charAt(number.length() - 1));
            if (base <= 1){
                return -1;
            }
            return base;
        }

        private static String reversString(String string){
            String reversed = "";
            for(int i = string.length()-1; i >= 0; i--){
                reversed += string.charAt(i);
            }
            return reversed;
        }

        private static String getStringBase(int base){
            return "b"+Ex1.getHexChar(base);
        }

        private static String getCleanNumber(String number){
            if(number.length()>2 && number.charAt(number.length() - 2) == 'b'){
                return number.substring(0, number.length() - 2);
            }
         return  number;
        }

        private static boolean isBaseValid( String number, int base){
            int digit = 0;

            for (int i = number.length()-1; i >= 0; i--){
                digit = Ex1.getNumberChar( number.charAt(i));
                if (digit == -1 || digit >= base){
                    return false;
                }
            }
            return true;
        }

        /**
         * Convert the given number (num) to a decimal representation (as int).
         * It the given number is not in a valid format returns -1.
         * @param num a String representing a number in basis [2,16]
         * @return
         */
        public static int number2Int(String num) {
            if (!isNumber(num)){
                return -1;
            }
            int sum = 0;
            int power = 0;
            int base = Ex1.getBase(num);
            num = Ex1.getCleanNumber(num);
            for(int i =num.length()-1; i >=0; i--){
//                System.out.print(num.charAt(i)+" ");
                sum += getNumberChar(num.charAt(i))*Math.pow(base, power);
                power++;

            }
//            System.out.println(sum);
            return sum;
        }

        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
        public static boolean isNumber(String a) {
            int base = getBase(a);
            String cleanNumber = Ex1.getCleanNumber(a);
            if (a == null || base == -1  || !Ex1.isBaseValid(cleanNumber,base)) {
                return false;
            }
            return true;
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
                ans = ans + Ex1.getStringBase(base);
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
            return Ex1.number2Int(n1) == Ex1.number2Int(n2);
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
            int temp =0;
            int index = 0;
            for (int i = 0 ;  i < arr.length; i++) {
                ans = Ex1.number2Int(arr[i]);
                if (ans > temp){
                    temp = ans;
                    index= i;
                }
            }

            return index;
        }
}
