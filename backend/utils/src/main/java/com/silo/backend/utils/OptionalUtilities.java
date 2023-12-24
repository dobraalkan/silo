package com.silo.backend.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalUtilities {

    public static <T> Optional<T> maybe(T value) {
        return Optional.ofNullable(value);
    }

    @SafeVarargs
    public static <T> List<T> toList(Optional<T>... optionals) {
        if (optionals == null) { return Collections.emptyList(); }

        return Stream
                .of(optionals)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

    }

    public static <T> Set<T> toSet(Collection<Optional<T>> xs) {
        return xs
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }

    public static <T> boolean contentsEqual(Optional<T> opt, T val) {
        ChecksUtilities.checkNotNull(opt, "'opt' cannot be null");
        return opt
                .map(v -> v.equals(val))
                .orElse(val == null);
    }

    public static <T> Optional<T> ofNullableOptional(Optional<T> nullable) {
        return nullable == null
                ? Optional.empty()
                : nullable;
    }

    public static boolean isEmpty(Optional<?> d) {
        return ! d.isPresent();
    }

    public static <T> Optional<T> ofExplodable(Supplier<T> supplier) {
        try {
            return Optional.of(supplier.get());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
