package com.implemica.task_1;

public class App_Brackets {
    public static void main(String[] args) throws MaximumLengthBracketsException {
        Brackets brackets = new Brackets(4);
        System.out.println(brackets.checkCorrectBrackets());
    }
}
