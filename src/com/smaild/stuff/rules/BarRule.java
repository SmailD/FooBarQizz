package com.smaild.stuff.rules;

public class BarRule implements Rule {

    @Override
    public boolean match(int number) {
        return number % 5 == 0;
    }

    @Override
    public String apply(int number) {
        return "Bar";
    }
}
