package com.implemica.task_3;

import java.math.BigInteger;

public class Factorial2 {
    BigInteger bigInteger;
//  write down the factorial number
    public BigInteger factorial(Integer number) {
        bigInteger = new BigInteger(number.toString());
//      multiply the numbers
        for (int i = number - 1; i > 0; i--) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }
//      return the factorial number
        return bigInteger;
    }
//  we introduce the factorial number
    public int sumOfDigits(Integer integer) {
//      call the method for calculating the factorial and write it
        bigInteger = factorial(integer);
        System.out.println(bigInteger);
        int sum = 0;
//      go through the digits of the number and write down the sum of the received digits
        for (int i = bigInteger.toString().length(); i > 0; i--) {
            sum = bigInteger.remainder(BigInteger.TEN).intValue() + sum;
            bigInteger = bigInteger.divide(BigInteger.TEN);
        }
        return sum;
    }
}
