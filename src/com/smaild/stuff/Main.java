package com.smaild.stuff;

import com.smaild.stuff.formatters.*;
import com.smaild.stuff.rules.*;

public class Main {

    public static void main(String[] args) {

	    FizzBuzzQizz fizzBuzz = new FizzBuzzQizz();
		fizzBuzz.addRule(new FooRule());
		fizzBuzz.addRule(new BarRule());
		fizzBuzz.addRule(new QizzRule());
		fizzBuzz.addFormatter(new FooFormatter());
		fizzBuzz.addFormatter(new BarFormatter());
		fizzBuzz.addFormatter(new QizzFormatter());
		fizzBuzz.addFormatter(new ZeroFormmater());

	    String result = fizzBuzz.run(105);
        System.out.println(result);
    }
}
