package com.silo.backend.utils;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ChecksUtilities {

	public static <T> T checkNotNull(T t, String message, Object... args) {
		checkTrue(t != null, message, args);
		
		return t;
	}

	public static <T> T[] checkAll(T[] ts, Predicate<T> check, String message) {
		checkNotNull(ts, message + ": Array was null");
		checkNotNull(check, message + ": Predicate was null");
		checkTrue(ArrayUtilities.all(ts, check), message);
		
		return ts;
	}

	public static <T> Collection<T> checkAll(Collection<T> ts, Predicate<T> check, String message) {
		checkNotNull(ts, message + ": Array was null");
		checkNotNull(check, message + ": Predicate was null");
		checkTrue(CollectionUtilities.all(ts, check), message);
		
		return ts;
	}

	public static void checkTrue(boolean b, String msg, Object... args) {
		if (!b) {
			fail(msg, args);
		}
	}

	public static void checkFalse(boolean b, String message) {
		checkTrue(!b, message);
	}

	public static <T> T checkOptionalIsPresent(Optional<T> optional, String message) {
		return optional.orElseThrow(() -> mkFail(message));
	}

	public static <T> void checkNotEmpty(Collection<T> ts, String message) {
		checkNotNull(ts, message);
		checkFalse(ts.isEmpty(), message);
	}

	public static <T> void checkNotEmpty(T[] ts, String message) {
		checkNotNull(ts, message);
		checkFalse(ArrayUtilities.isEmpty(ts), message);
	}

	public static String checkNotEmpty(String str, String message) {
		checkNotNull(str, message);
		checkFalse(str.trim().equals(""), message);
		
		return str;
	}

	public static void fail(String msg, Object... args) {
		throw mkFail(msg, args);
	}

	public static IllegalArgumentException mkFail(String msg, Object... args) {
		throw new IllegalArgumentException(String.format(msg, args));
	}

	public static <T> void checkEmpty(Collection<T> ts, Supplier<String> messageSupplier) {
		checkTrue(CollectionUtilities.isEmpty(ts), messageSupplier.get());
	}

	public static <T> void checkEmpty(Collection<T> ts, String message) {
        checkTrue(CollectionUtilities.isEmpty(ts), message);
    }
}