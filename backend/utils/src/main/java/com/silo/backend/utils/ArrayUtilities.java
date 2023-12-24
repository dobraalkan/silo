package com.silo.backend.utils;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ArrayUtilities {

	public static <T> boolean all(T[] ts, Predicate<T> check) {
		ChecksUtilities.checkNotNull(ts, "Array must be provided");
		ChecksUtilities.checkNotNull(check, "Predicate must be provided");

		for (T t : ts) {
			if (!check.test(t))
				return false;
		}

		return true;
	}

	public static <T> boolean isEmpty(T[] arr) {
		if (arr == null)
			return true;
		
		return arr.length == 0;
	}

	public static int sum(int[] arr) {
		ChecksUtilities.checkNotNull(arr, "arr cannot be null");
		int total = 0;
		for (int value : arr) {
			total += value;
		}
		
		return total;
	}

	public static <T> T last(T[] arr) {
		ChecksUtilities.checkNotNull(arr, "array cannot be null");
		ChecksUtilities.checkTrue(arr.length > 0, "array must not be empty");
		
		return arr[arr.length - 1];
	}

	public static <T> T[] initial(T[] arr) {
		ChecksUtilities.checkNotNull(arr, "array cannot be null");
		ChecksUtilities.checkTrue(arr.length > 0, "array must not be empty");
		
		return Arrays.copyOf(arr, arr.length - 1);
	}

	@SuppressWarnings("unchecked")
	public static <A, B> B[] map(A[] arr, Function<A, B> mapper) {
		ChecksUtilities.checkNotNull(arr, "array cannot be null");
		ChecksUtilities.checkNotNull(mapper, "mapper cannot be null");
		
		return (B[]) Stream.of(arr).map(mapper).toArray();
	}

	public static <T> T idx(T[] arr, int idx, T dflt) {
		try {
			return arr[idx];
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			return dflt;
		}
	}
}
