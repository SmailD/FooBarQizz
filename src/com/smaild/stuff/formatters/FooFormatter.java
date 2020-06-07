package com.smaild.stuff.formatters;

import java.util.function.UnaryOperator;

public class FooFormatter implements UnaryOperator<String> {

    @Override
    public String apply(String value) {
        return value.replace("3", "Foo");
    }
}
