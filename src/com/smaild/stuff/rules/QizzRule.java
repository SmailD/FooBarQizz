package com.smaild.stuff.rules;

public class QizzRule implements Rule {

    @Override
    public boolean match(int number) {
        return number % 7 == 0;
    }

    @Override
    public String apply(int number) {
        return "Qizz";
    }
}
