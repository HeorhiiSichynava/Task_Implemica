package com.implemica.task_1;

public class DoubleBrackets {
    private int code = 0;
    private int sourceCode = 0;

//reference to the next pair of parentheses
    private DoubleBrackets nextDoubleBrackets;

    public DoubleBrackets() {
    }

    public DoubleBrackets(int code) {
        this.sourceCode = code;
        this.code = code;
    }

    public int getAllCode() {
        if (!nextDoubleBrackets.isEmptyNext())
            return this.getCode() + nextDoubleBrackets.getCode();
        else return this.getCode();
    }
// change the state of the binary to 1

    public boolean deCode() {
        boolean stop = false;

// if the code is greater than 0, decrease by 1
        if (this.getCode() > 0)
            this.setCode(getCode() - 1);
// if the code is 0 but there is one more pair of brackets then we decode the next pair and return the current code to the initial state
        else if (this.getCode() < 1 && !this.isEmptyNext()) {
            stop = this.getNextDoubleBrackets().deCode();
            if (!stop)
                this.setCode(sourceCode);
        } else if (this.getCode() < 1 && isEmptyNext()) {
            return true;
        } else stop = false;
        return stop;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DoubleBrackets getNextDoubleBrackets() {
        return nextDoubleBrackets;
    }

    public void setNextDoubleBrackets(DoubleBrackets nextDoubleBrackets) {
        this.nextDoubleBrackets = nextDoubleBrackets;
    }

    public boolean isEmptyNext() {
        if (this.nextDoubleBrackets == null)
            return true;
        return false;
    }
}
