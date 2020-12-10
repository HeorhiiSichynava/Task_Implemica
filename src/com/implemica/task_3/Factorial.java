package com.implemica.task_3;

import java.util.LinkedList;

public class Factorial {

    public Factorial() {
    }

    private String factorial(Integer number) {

        //listNumbers - used as a stack
        LinkedList<String> stackNumbers = new LinkedList<String>();
        int multiplierB = number;
        String multiplierA = number.toString(),
                result = "";

        // Decrease the value of the entered factorial number by 1
        for (multiplierB -= 1; multiplierB > 0; multiplierB--) {
            //we split the multiplier (A) into digits and re-multiply with the multiplier (B)
            for (int i = 0; i < multiplierA.length(); i++) {
                result = multiply(Integer.decode(String.valueOf(multiplierA.charAt(i))), multiplierB);
                if (stackNumbers.isEmpty())
                    stackNumbers.add(result);
                else {
                    // Summarize the results of multiplying the digits of the multiplier (A) with the multiplier (B)
                    stackNumbers.addLast(sum(stackNumbers.pop() + "0", result));
                }
            }
            //result of multiplication is entered into the multiplier (A)
            multiplierA = stackNumbers.pop();
        }
        return multiplierA;
    }

    private String multiply(Integer numberA, Integer numberB) {
        if (numberA == 0 || numberB == 0)
            return "0";
        return (numberA * numberB) + "";
    }

    private String sum(String numberA, String numberB) {
        int lengthA = numberA.length(),
                lengthB = numberB.length();

        int namA = 0, numB = 0, nextRunk = 0;
        String sumAB = "";

        //equalize the lengths of two numbers (A) and (B)
        if (lengthA > lengthB) {
            numberB = equalizeLength(lengthA - lengthB) + numberB;
        } else if (lengthB > lengthA) {
            numberA = equalizeLength(lengthB - lengthA) + numberA;
        }
        //
        //add the values of the digits of numbers (A) and (B)
        for (int i = numberB.length(); i >= 0; i--) {
            if (i > 0) {
                namA = Integer.decode(String.valueOf(numberA.charAt(i - 1)));
                numB = Integer.decode(String.valueOf(numberB.charAt(i - 1)));
                sumAB = ((namA + numB + nextRunk) % 10) + "" + sumAB;
                nextRunk = (namA + numB + nextRunk) / 10;
            } else sumAB = nextRunk > 0 ? nextRunk + "" + sumAB : sumAB;
        }

        //result of the sum
        return sumAB + "";
    }

    private String equalizeLength(int length) {
        String zero = "";
        for (int i = 0; i < length; i++) {
            zero += "0";
        }
        //insert the required number of zero digits into the number
        return zero;
    }

    public Integer sumOfDigits(Integer number) {
        String bigNumber = factorial(number);
        System.out.println(bigNumber);
        int sum = 0;
        //sum the values of the digits in the digits
        for (int i = 0; i < bigNumber.length(); i++) {
            //zero values are not summarized
            if (bigNumber.charAt(i) != '0')
                sum += Integer.decode(String.valueOf(bigNumber.charAt(i)));
        }
        return sum;
    }
}
