package com.thoughtworks.tddintro.factorial;

public class Factorial {
    public Integer compute(int i) {
        if(i<0)
            throw new IllegalArgumentException("Invalid input: negative.");
        else {
            if (i == 0)
                return 1;
            else
                return compute(i - 1) * i;
        }
    }

}
