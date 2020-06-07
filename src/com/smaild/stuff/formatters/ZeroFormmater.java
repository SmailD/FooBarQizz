package com.smaild.stuff.formatters;

import java.util.function.UnaryOperator;

public class ZeroFormmater implements UnaryOperator<String> {

    @Override
    public String apply(String value) {
        return value.replace('0', '*');
    }
}
