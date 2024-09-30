import java.io.*;
import java.util.Scanner;

public class NumberTester {

    NumberTest primeTester;
    NumberTest oddTester;
    NumberTest palindromeTester;


    public NumberTester(String fileName){}

    public void setOddEvenTester(NumberTest oddTester){
        this.oddTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester){
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester){
        this.palindromeTester = palindromeTester;
    }

    public void testFile(String fileName){
       {
           try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
               int testCases = Integer.parseInt(reader.readLine());

               for (int i = 0; i < testCases; i++) {
                   String[] line = reader.readLine().split(" ");
                   int testType = Integer.parseInt(line[0]);
                   int number = Integer.parseInt(line[1]);

                   switch (testType) {
                       case 1:
                           System.out.println(oddTester.testNumber(number) ? "EVEN" : "ODD");
                           break;
                       case 2:
                           System.out.println(primeTester.testNumber(number) ? "PRIME" : "NO PRIME");
                           break;
                       case 3:
                           System.out.println(palindromeTester.testNumber(number) ? "PALINDROME" : "NO PALINDROME");
                           break;
                   }
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
        }
    }

    public static void main(String[] args) {
        NumberTester tester = new NumberTester("numbers.csv");

        tester.setOddEvenTester(number -> number % 2 == 0); // Modolo wegen Rest.
        tester.setPrimeTester(number -> {
            if (number <= 1) return false;
            for (int i = 2; i <= Math.sqrt(number); i++) { // Wurzel weil es sonst eh schon einen größeren Teiler gibt.
                if (number % i == 0) return false; // Wenn hier ein Teiler gefunden wird ist es keine Primzahl
            }
            return true; // Alle tests vorbei
        });
        tester.setPalindromeTester(number -> {
            String s = Integer.toString(number);
            return s.equals(new StringBuilder(s).reverse().toString()); //Vom Internet
        });

        tester.testFile("numbers.csv");
    }
}
