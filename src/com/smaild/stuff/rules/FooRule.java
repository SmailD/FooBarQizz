package com.smaild.stuff.rules;

public class FooRule implements Rule {

    @Override
    public boolean match(int number) {
        return number % 3 == 0;
    }

    @Override
    public String apply(int number) {
        return "Foo";
    }
}
