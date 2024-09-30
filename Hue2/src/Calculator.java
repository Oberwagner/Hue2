import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CalculationOperation add = (x, y) -> new Number(x.getA() + y.getA(), x.getB() + y.getB());
        CalculationOperation subtract = (x, y) -> new Number(x.getA() - y.getA(), x.getB() - y.getB());
        CalculationOperation multiplyVector = (x, y) -> new Number(x.getA() * y.getB() - x.getB() * y.getA(), x.getB() * y.getA() - x.getA() * y.getB()); // Kreuzprodukt
        CalculationOperation divideVector = (x, y) -> new Number(x.getA() * y.getA() + x.getB() * y.getB(), 0);

        RationalCalculator rationalCalculator = new RationalCalculator(add, subtract, multiplyVector, divideVector);
        VectorCalculator vectorCalculator = new VectorCalculator(add, subtract, multiplyVector, divideVector);
        ComplexCalculator complexCalculator = new ComplexCalculator(add, subtract, multiplyVector, divideVector);


        while (true) {
            System.out.println("Choose calculator:\n1 = Rational\n2 = Vector\n3 = Complex\n4 = Exit");
            int calculatorChoice = scanner.nextInt();
            if (calculatorChoice == 4) {
                break;
            }


            Number x;
            Number y;



            boolean enterNumbers = true;
            while (enterNumbers) {
                System.out.print("Enter number x a> ");
                double xa = scanner.nextDouble();
                System.out.print("Enter number x b> ");
                double xb = scanner.nextDouble();
                System.out.print("Enter number y a> ");
                double ya = scanner.nextDouble();
                System.out.print("Enter number y b> ");
                double yb = scanner.nextDouble();

                x = new Number(xa, xb);
                y = new Number(ya, yb);

                boolean validOperation = false;
                while (!validOperation) {
                    System.out.println("Choose operation:\n1 = add\n2 = subtract\n3 = multiply\n4 = divide\n5 = enter numbers again");
                    int operationChoice = scanner.nextInt();

                    if (operationChoice == 5) {
                        break;
                    }

                    validOperation = true;
                    AbstractCalculator calculator = null;
                    switch (calculatorChoice) {
                        case 1:
                            calculator = rationalCalculator;
                            break;
                        case 2:
                            calculator = vectorCalculator;
                            break;
                        case 3:
                            calculator = complexCalculator;
                            break;
                    }

                    Number result = null;
                    switch (operationChoice) {
                        case 1:
                            result = calculator.add(x, y);
                            break;
                        case 2:
                            result = calculator.subtract(x, y);
                            break;
                        case 3:
                            result = calculator.multiply(x, y);
                            break;
                        case 4:
                            result = calculator.divide(x, y);
                            break;
                        default:
                            validOperation = false;
                            break;
                    }

                    if (validOperation) {
                        System.out.println("=========================");
                        System.out.println("Solution: " + result);
                        System.out.println("=========================");
                    }
                }

                if (validOperation) {
                    enterNumbers = false;
                }
            }
        }

        scanner.close();
    }
}
