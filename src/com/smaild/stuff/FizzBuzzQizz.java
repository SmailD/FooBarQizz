package com.smaild.stuff;

import com.smaild.stuff.rules.Rule;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.smaild.stuff.utils.CompletableFutureUtils.applyAllOf;

public class FizzBuzzQizz {

    private final Set<Rule> rules;
    private final Set<UnaryOperator<String>> formatters;
    private final StringBuilder sb;

    public FizzBuzzQizz() {
        rules = new LinkedHashSet<>();
        formatters = new LinkedHashSet<>();
        sb = new StringBuilder();
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public void addFormatter(UnaryOperator<String> formatter) {
        formatters.add(formatter);
    }

    public String run(int limit) {
        IntStream.rangeClosed(1, limit).forEach(this::runFizzBuzzQizz);
        return sb.toString();
    }

    private void runFizzBuzzQizz(int number) {
        applyAllOf(Stream.of(applyRules(number), applyFormatters(number)))
                .thenCompose(this::cleanUp)
                .thenApply(s -> sb.append(s).append("\n"))
                .join();
    }

    private CompletableFuture<String> applyRules(int number) {
        return CompletableFuture.supplyAsync(() ->
                rules.stream()
                        .filter(rule -> rule.match(number))
                        .map(rule -> rule.apply(number))
                        .collect(Collectors.joining()));
    }

    private CompletableFuture<String> applyFormatters(int number) {
        return CompletableFuture.supplyAsync(() ->
                formatters.stream()
                        .reduce(s -> s, (a, b) -> s -> b.apply(a.apply(s)))
                        .apply(String.valueOf(number)));
    }

    private CompletableFuture<String> cleanUp(String value) {
        return CompletableFuture.supplyAsync(() -> {
            if (value.matches(".*[A-Za-z].*")) {
                return value.replaceAll("\\d", "");
            }
            return value;
        });
    }
}
