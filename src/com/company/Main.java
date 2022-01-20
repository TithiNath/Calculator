package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static int evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();
        Stack<Integer> operand = new Stack<Integer>();
        Stack<Character> operator = new Stack<Character>();
        for (int i = 0; i < tokens.length; i++)
        {
            if (tokens[i] == ' ')
                continue;
            if (tokens[i] >= '0' &&
                    tokens[i] <= '9')
            {
                StringBuffer sbuf = new
                        StringBuffer();
                while (i < tokens.length &&
                        tokens[i] >= '0' &&
                        tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                operand.push(Integer.parseInt(sbuf.
                        toString()));
                i--;
            }
            else if (tokens[i] == '(')
                operator.push(tokens[i]);
            else if (tokens[i] == ')')
            {
                while (operator.peek() != '(')
                    operand.push(applyOp(operator.pop(),operand.pop(),operand.pop()));
                operator.pop();
            }

            // Current token is an operator.
            else if (tokens[i] == '+' ||
                    tokens[i] == '-' ||
                    tokens[i] == '*' ||
                    tokens[i] == '/')
            {
                while (!operator.empty() &&
                        hasPrecedence(tokens[i],operator.peek()))
                    operand.push(applyOp(operator.pop(),operand.pop(),operand.pop()));
                operator.push(tokens[i]);
            }
        }
        while (!operator.empty())
            operand.push(applyOp(operator.pop(),operand.pop(),operand.pop()));
        return operand.pop();
    }
    public static boolean hasPrecedence(
            char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') &&
                (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
    public static int applyOp(char op,
                              int b, int a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException(
                            "Cannot divide by zero");
                return a / b;
        }
        return 0;
    }


    public static void calculate(Double operand){
        Scanner sc = new Scanner(System.in);
        System.out.print(">");
        String str=sc.nextLine();
        try {
            if (str.startsWith("0")) {
                System.out.println("Bye, now.");
                System.exit(0);
            }
            else if(str.startsWith("infix"))
            {
                System.out.println("Enter the expression which you want to evaluate:");
                String exp=sc.nextLine();
                System.out.println(evaluate(exp));
                calculate(operand);
            }
            else if (str.startsWith("sin")) {
                double degrees = Double.valueOf(str.substring(3));
                double radians = Math.toRadians(degrees);
                double sinValue = Math.sin(radians);
                operand = sinValue;
                System.out.println(sinValue);
                calculate(operand);
            } else if (str.startsWith("cos")) {
                double degrees = Double.valueOf(str.substring(3));
                double radians = Math.toRadians(degrees);
                double cosValue = Math.cos(radians);
                operand = cosValue;
                System.out.println(cosValue);
                calculate(operand);
            } else if (str.startsWith("tan")) {
                double degrees = Double.valueOf(str.substring(3));
                double radians = Math.toRadians(degrees);
                double tanValue = Math.tan(radians);
                operand = tanValue;
                System.out.println(tanValue);
                calculate(operand);
            } else if (str.startsWith("binary")) {
                int num = Integer.valueOf(str.substring(6));
                System.out.println(Integer.toBinaryString(num));
                calculate(operand);
            } else if (str.startsWith("sqrt")) {
                double number = Double.valueOf(str.substring(4));
                double result = Math.sqrt(number);
                operand = result;
                System.out.println(result);
                calculate(operand);
            } else if (str.startsWith("~")) {
                double number = Double.valueOf(str.substring(1));
                double result = -(number);
                operand = result;
                System.out.println(result);
                calculate(operand);
            } else if (str.contains("+")) {
                int index = str.indexOf("+");
                String s1;
                if (index == 1) {
                    s1 = str.substring(0, 1);
                } else
                    s1 = str.substring(0, index);
                String s2 = str.substring(index + 1);
                Double a = Double.valueOf(s1);
                Double b = Double.valueOf(s2);
                Double c = a + b;
                operand = c;
                System.out.println(c);
                calculate(operand);
            } else if (str.contains("-")) {
                int index = str.indexOf("-");
                String s1;
                if (index == 1) {
                    s1 = str.substring(0, 1);
                } else
                    s1 = str.substring(0, index);
                String s2 = str.substring(index + 1);
                Double a = Double.valueOf(s1);
                Double b = Double.valueOf(s2);
                Double c = a - b;
                operand = c;
                System.out.println(c);
                calculate(operand);
            } else if (str.contains("*")) {
                int index = str.indexOf("*");
                String s1;
                if (index == 1) {
                    s1 = str.substring(0, 1);
                } else
                    s1 = str.substring(0, index);
                String s2 = str.substring(index + 1);
                Double a = Double.valueOf(s1);
                Double b = Double.valueOf(s2);
                Double c = a * b;
                operand = c;
                System.out.println(c);
                calculate(operand);
            } else if (str.contains("/")) {
                int index = str.indexOf("/");
                String s1;
                if (index == 1) {
                    s1 = str.substring(0, 1);
                } else
                    s1 = str.substring(0, index);
                String s2 = str.substring(index + 1);
                Double a = Double.valueOf(s1);
                Double b = Double.valueOf(s2);
                Double c = a / b;
                operand = c;
                System.out.println(c);
                calculate(operand);
            } else if (str.contains("^")) {
                int index = str.indexOf("^");
                String s1;
                if (index == 1) {
                    s1 = str.substring(0, 1);
                } else
                    s1 = str.substring(0, index);
                String s2 = str.substring(index + 1);
                Double a = Double.valueOf(s1);
                Double b = Double.valueOf(s2);
                Double c = Math.pow(a, b);
                operand = c;
                System.out.println(c);
                calculate(operand);
            } else if (str.contains("%")) {
                int index = str.indexOf("%");
                String s1;
                if (index == 1) {
                    s1 = str.substring(0, 1);
                } else
                    s1 = str.substring(0, index);
                String s2 = str.substring(index + 1);
                Double a = Double.valueOf(s1);
                Double b = Double.valueOf(s2);
                Double c = a % b;
                operand = c;
                System.out.println(c);
                calculate(operand);
            } else if (str.contains("!")) {
                int index = str.indexOf("!");
                String s1;
                Double fact = 1.0;
                if (index == 1) {
                    s1 = str.substring(0, 1);
                } else
                    s1 = str.substring(0, index);
                int a = Integer.valueOf(s1);
                for (int i = 1; i <= a; i++)
                    fact = fact * i;
                operand = fact;
                System.out.println(fact);
                calculate(operand);
            } else if (str.contains("%")) {
                int index = str.indexOf("%");
                String s1;
                if (index == 1) {
                    s1 = str.substring(0, 1);
                } else
                    s1 = str.substring(0, index);
                int a = Integer.valueOf(s1);
                String s2 = str.substring(index + 1);
                int b = Integer.valueOf(s2);
                int c = a % b;
                double d = c;
                operand = d;
                System.out.println(d);
                calculate(operand);
            } else if (str.startsWith("help")) {
                System.out.println("1.Addition='+'");
                System.out.println("2.Subtraction='-'");
                System.out.println("3.Multiplication='*'");
                System.out.println("4.Division='/'");
                System.out.println("5.Exponent='^'");
                System.out.println("6.Modulus='%'");
                System.out.println("7.Factorial='!'");
                System.out.println("8.Trigonometric functions='(sin,cos,tan)'");
                System.out.println("9.Negation='~'");
                System.out.println("10.Square Root='sqrt'");
                System.out.println("1.Conversion from base 10 to binary='binary'");
                System.out.println("11.log b to the base a='log(a)(b)'");
                System.out.println("12.Previous result used as first operand='prev'(+,-,*,/,%,^,!,~,sin,cos,tan,sqrt");
                System.out.println("13.evaluation of infix expression='infix'");
                calculate(operand);
            } else if (str.startsWith("log")) {
                double base = Double.valueOf(str.substring(1));
                double n = Double.valueOf(str.substring(1));
                int result = (int) (Math.log(n) / Math.log(base));
                System.out.println(result);
                calculate(operand);
            } else if (str.startsWith("prev")) {
                System.out.println("Your first operand is " + operand);
                System.out.println("Enter operation you want to do");
                String operator = sc.nextLine();
                Double operand2;
                Double result = 0.0;
                switch (operator) {
                    case "+":
                        System.out.println("Enter second operand");
                        operand2 = Double.valueOf(sc.nextInt());
                        result = operand + operand2;
                        System.out.println(result);
                        operand=result;
                        calculate(operand);
                        break;
                    case "-":
                        System.out.println("Enter second operand");
                        operand2 = Double.valueOf(sc.nextInt());
                        result = operand - operand2;
                        System.out.println(result);
                        operand=result;
                        calculate(operand);
                        break;
                    case "*":
                        System.out.println("Enter second operand");
                        operand2 = Double.valueOf(sc.nextInt());
                        result = operand * operand2;
                        System.out.println(result);
                        operand=result;
                        calculate(operand);
                        break;
                    case "/":
                        System.out.println("Enter second operand");
                        operand2 = Double.valueOf(sc.nextInt());
                        result = operand / operand2;
                        System.out.println(result);
                        operand=result;
                        calculate(operand);
                        break;
                    case "%":
                        System.out.println("Enter second operand");
                        operand2 = Double.valueOf(sc.nextInt());
                        result = operand % operand2;
                        System.out.println(result);
                        operand=result;
                        calculate(operand);
                        break;
                    case "^":
                        System.out.println("Enter second operand");
                        operand2 = Double.valueOf(sc.nextInt());
                        result = Math.pow(operand, operand2);
                        System.out.println(result);
                        operand=result;
                        calculate(operand);
                        break;
                    case "~":
                        result = -operand;
                        System.out.println(result);
                        operand=result;
                        calculate(operand);
                        break;
                    case "sin":
                        double radians1 = Math.toRadians(operand);
                        double sinValue = Math.sin(radians1);
                        System.out.println(sinValue);
                        operand=sinValue;
                        calculate(operand);
                        break;
                    case "cos":
                        double radians2 = Math.toRadians(operand);
                        double cosValue = Math.cos(radians2);
                        System.out.println(cosValue);
                        operand=cosValue;
                        calculate(operand);
                        break;
                    case "tan":
                        double radians3 = Math.toRadians(operand);
                        double tanValue = Math.tan(radians3);
                        System.out.println(tanValue);
                        operand=tanValue;
                        calculate(operand);
                        break;
                    case "sqrt":
                        result = Math.sqrt(operand);
                        System.out.println(result);
                        operand=result;
                        calculate(operand);
                        break;
                    case "!":
                        Double fact = 1.0;
                        for (int i = 1; i <= operand; i++)
                            fact = fact * i;
                        System.out.println(fact);
                        operand=fact;
                        calculate(operand);
                        break;
                    default:
                        System.out.println("Invalid operator!");
                        calculate(operand);
                        break;
                }
            }
        } catch(Exception e)
        {
            System.out.println("Invalid format please go to help and check the format!");
            calculate(operand);
        }
    }
    public static void main(String [] args) {
        System.out.println("Enter help to know legal syntax and supported functions");
        Double operand=0.0;
        calculate(operand);
    }
}
