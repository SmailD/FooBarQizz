package com.smaild.stuff.formatters;

import java.util.function.UnaryOperator;

public class BarFormatter implements UnaryOperator<String> {

    @Override
    public String apply(String value) {
        return value.replace("5", "Bar");
    }
}
