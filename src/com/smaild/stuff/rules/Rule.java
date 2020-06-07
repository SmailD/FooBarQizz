package com.smaild.stuff.rules;

public interface Rule {

    boolean match(int number);

    String apply(int number);
}
