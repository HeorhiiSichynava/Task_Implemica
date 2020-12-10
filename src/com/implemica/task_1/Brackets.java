package com.implemica.task_1;

import java.util.Stack;

public class Brackets {
    private DoubleBrackets[] buildBrackets;
    private int length = 0;
    private String mask[] = {"))", ")(", "()", "(("};

    public Brackets(int setNumberBrackets) throws MaximumLengthBracketsException {
//      input restriction
        if (setNumberBrackets > 15)
            throw new MaximumLengthBracketsException();

//        the length of the bracket sequence
        length = setNumberBrackets;

        this.buildBrackets = new DoubleBrackets[length];

//      fill the array with objects and assign the source code to them.
        for (int i = 0; i < length; i++) {
            this.buildBrackets[i] = new DoubleBrackets(0b11);

//          assigning links to objects
            if (i > 0)
                this.buildBrackets[i - 1].setNextDoubleBrackets(buildBrackets[i]);
        }
    }

    //  number of parenthesis pairs
    public int getLength() {
        return length;
    }

    //  get bracket sequence
    public String getBracketsPrint() {
        String brackets = "";
        for (int i = 0; i < buildBrackets.length; i++) {
//          get a pair of brackets and assign the string "brackets";
            brackets += mask[buildBrackets[i].getCode()];
        }
        return brackets;
    }

    public void setLength(int length) {
        this.length = length;
    }

    //get bracket sequence code
    public Integer getBracketsCode() {
//        Integer brackets = 0;
        Integer brackets = 0;
        for (int i = 0; i < buildBrackets.length; i++) {
            //shift the binary code by two digits
            brackets <<= 2;
            //fill in free digits
            brackets += buildBrackets[i].getCode();
        }
        //display the resulting binary code
        return brackets;
    }

    //output the number of right bracket expressions
    public int checkCorrectBrackets() {
        int count = 0;
        boolean stop = false;

        while (!stop) {
//            if the expression finds the correct parenthesis sequence, then increment the counter by 1
            if (checkCorrectBrackets(getBracketsCode()) == 1) {
                count += checkCorrectBrackets(getBracketsCode());
                System.out.println(count + ") " + getBracketsPrint());
            }
            if (getBracketsCode() >= 0) {

//if all possible variants of parenthesis are checked return "true"
                stop = buildBrackets[0].deCode();
            }
        }
        return count;
    }

    //check the binary code of the bracket sequence if correct return 1 if not 0
    private int checkCorrectBrackets(Integer code) {
        Stack<Integer> stack = new Stack();
        int key = 0;

//we go through the binary code, looking through a pair of digits
        for (int i = getLength(); i > 0; i--) {
            key = code % 4;

//check the correctness of the code (corresponds to the parenthesis sequence)
            switch (key) {
                case 3: //3 - equivalent to 0b11 / "(("
                    if (!stack.isEmpty())
                        stack.pop();// if the stack is not empty, then kill 1 cell (pair of brackets "))")
                    else {
                        return 0;
                    }
                    break;
                case 2://2 - equivalent to 0b10 / "()"
//                    do not do anything since the sequence is correct
                    break;
                case 1:// 1 - equivalent to 0b01 / ")("
                    if (stack.isEmpty()) {
                        return 0; // если стек пуст то скобочная последовательность не верна
                    }
                    break;
                case 0:// 0 - equivalent to 0b00 / "))"
                    stack.push(key);// push the value to the stack
                    break;
                default:
                    return 0;
            }
//          shift the (tested) code by two rows
            code >>= 2;
        }
        if (stack.isEmpty() && key > 0) {
            return 1; // if the stack is empty then the parenthesis sequence was correct
        } else {
            return 0; // bracket sequence is wrong
        }
    }
}