package com.silo.backend.domain.utils;

import java.util.stream.IntStream;

public class JooqUtilities {

    public static int summarizeResults(int[] rcs) {
        return IntStream.of(rcs).sum();
    }

}
