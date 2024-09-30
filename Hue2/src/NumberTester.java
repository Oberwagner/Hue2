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

    
}
