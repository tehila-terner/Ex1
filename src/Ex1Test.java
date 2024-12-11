import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
        @Test
        void computeNumberTest() {
            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEquals(v,11);
            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }

        @Test
        void isBasisNumberTest() {
            String[] good = { "1" ,"1b2", "01b2", "123bA", "ABbG", "0bA"};
            for(int i=0;i<good.length;i=i+1) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }
            String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }
        @Test
        void int2NumberTest() {
            int num = 11;
            int base  = 2;
            String s2 = Ex1.int2Number(num,base);
            assertEquals(s2 , "1011b2");
            int num1 = 32;
            int base2 = 16;
            String s16 = Ex1.int2Number(num1,base2);
            assertEquals(s16 , "20bG");
        }
        @Test
        void maxIndexTest() {
           String[] arr  = new String[]{"1101b2","1102b3", "1001b2"};
           int max = Ex1.maxIndex(arr);
           assertEquals(max , 1);
           String[] arr1 = new String[]{"1012b4", "1342b5","1111b2","12345b6"};
           int max1 = Ex1.maxIndex(arr1);
           assertEquals(max1 , 3);
        }

        // Add additional test functions - test as much as you can.
    }
