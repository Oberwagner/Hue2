import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumberTester {

    NumberTest primeTester;
    NumberTest oddTester;
    NumberTest palindromeTester;

    static boolean usePrimeTester = false;
    static boolean useOddTester = false;
    static boolean usePalindromeTester = false;

    static int Number2 = 0;

    public NumberTester(String fileName){

        try {
            Scanner filescanner = new Scanner(new File(fileName));
            filescanner.nextLine();
            while (filescanner.hasNextLine()){

                String line = filescanner.nextLine();
                String[] parts = line.split(" ");

                if (parts[0].equals("1")){
                    useOddTester = true;
                }
                if (parts[0].equals("2")){
                    usePrimeTester = true;
                }
                if (parts[0].equals("3")){
                    usePalindromeTester = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void setOddEvenTester(NumberTest oddTester){
        this.oddTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester){
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester){
        this.palindromeTester = palindromeTester;
    }

    public void testFile(){
        /*primeTester.testNumber(int number2)*/{

        }
    }
}
