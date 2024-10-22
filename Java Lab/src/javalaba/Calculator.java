package javalaba;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number:");
        double n1 = sc.nextDouble();
        System.out.println("Enter Second Number: ");
        double n2 = sc.nextDouble();

        System.out.println("Enter Operator:(+,-,*,/,%");

        char operator = sc.next().charAt(0);
        double result;
        switch(operator){
            case '+':

                result = n1 +n2;
                System.out.println(result);
                break;

            case '-':

                result = n1 - n2;
                System.out.println(result);
                break;

            case '*':

                result = n1 * n2;
                System.out.println(result);
                break;
            case '/':
if(n2!=0){
    result = n1 /n2;
    System.out.println(result);
}
        else {
    System.out.println("error");
}

                break;

            default:
                System.out.println("invalid opeartor");

        }
    }
}
