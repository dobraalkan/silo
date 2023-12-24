package com.silo.backend.utils;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionUtilities {

	public static <T> Optional<T> find(Predicate<T> pred, Collection<T> ts) {
		ChecksUtilities.checkNotNull(ts, "collection must not be null");
		ChecksUtilities.checkNotNull(pred, "predicate cannot be null");

		return ts.stream().filter(pred).findFirst();
	}

	public static <T> Optional<T> find(Collection<T> ts, Predicate<T> pred) {
		return find(pred, ts);
	}

	public static <T> boolean any(Collection<T> ts, Predicate<T> pred) {
		return find(pred, ts).isPresent();
	}

	public static <T> boolean all(Collection<T> ts, Predicate<T> pred) {
		ChecksUtilities.checkNotNull(ts, "Collection cannot be null");
		ChecksUtilities.checkNotNull(pred, "Predicate cannot be null");

		return ts.stream().allMatch(pred);
	}

	public static <T> T first(Collection<T> ts) {
		ChecksUtilities.checkNotEmpty(ts, "Cannot get first item from an empty collection");

		return ts.iterator().next();
	}

	public static <X, Y> Collection<Y> map(Collection<X> xs, Function<X, Y> fn) {
		ChecksUtilities.checkNotNull(xs, "collection must not be null");
		ChecksUtilities.checkNotNull(fn, "transformation fn cannot be null");

		return xs.stream().map(fn).collect(Collectors.toList());
	}

	public static <X> Collection<X> filter(Collection<X> xs, Predicate<X> pred) {
		ChecksUtilities.checkNotNull(xs, "collection must not be null");
		ChecksUtilities.checkNotNull(pred, "predicate fn cannot be null");

		return xs.stream().filter(pred).collect(Collectors.toList());
	}

	public static <X> void maybe(Collection<X> xs, Consumer<Collection<X>> fn) {
		if (notEmpty(xs))
			fn.accept(xs);
	}

	public static <T> boolean notEmpty(Collection<T> ts) {
		return ts != null && !ts.isEmpty();
	}

	public static <X> Optional<X> head(Collection<X> xs) {
		return isEmpty(xs) ? Optional.empty() : Optional.of(first(xs));
	}

	public static <X> List<X> sort(Collection<X> xs, Comparator<? super X> comparator) {
		ChecksUtilities.checkNotNull(xs, "xs cannot be null");
		ChecksUtilities.checkNotNull(comparator, "comparator cannot be null");

		List<X> sorted = new ArrayList<>(xs);
		sorted.sort(comparator);

		return sorted;
	}

	public static <X extends Comparable<X>> List<X> sort(Collection<X> xs) {
		ChecksUtilities.checkNotNull(xs, "xs cannot be null");

		List<X> sorted = new ArrayList<>(xs);
		Collections.sort(sorted);

		return sorted;
	}

	public static <X> boolean isEmpty(Collection<X> xs) {
		return xs == null || xs.isEmpty();
	}

	public static <X> Optional<X> maybeFirst(Collection<X> xs) {
		return isEmpty(xs) ? Optional.empty() : Optional.of(first(xs));
	}

	public static <X> Optional<X> maybeFirst(Collection<X> xs, Predicate<X> predicate) {
		ChecksUtilities.checkNotNull(predicate, "predicate cannot be null");

		return isEmpty(xs) ? Optional.empty() : xs.stream().filter(predicate).findFirst();
	}

	public static Long sumInts(Collection<Integer> values) {
		long acc = 0;
		for (Integer v : values) {
			acc += v;
		}

		return acc;
	}

}
