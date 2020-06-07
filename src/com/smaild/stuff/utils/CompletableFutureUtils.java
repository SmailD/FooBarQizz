package com.smaild.stuff.utils;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class CompletableFutureUtils {

    public static CompletableFuture<String> applyAllOf(Stream<CompletableFuture<String>> futures) {
        return futures.collect(collectingAndThen(
                toList(),
                l -> CompletableFuture.allOf(l.toArray(new CompletableFuture[0]))
                        .thenApply(__ -> l.stream()
                                .map(CompletableFuture::join)
                                .collect(Collectors.joining()))));
    }
}
