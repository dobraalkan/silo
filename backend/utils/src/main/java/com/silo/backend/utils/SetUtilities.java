package com.silo.backend.utils;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SetUtilities {

	@SafeVarargs
	public static <T> Set<T> asSet(T... ts) {
		return fromArray(ts);
	}

	@SafeVarargs
	public static <T> Set<T> fromArray(T... ts) {
		if (ts == null || ts.length == 0)
			return new HashSet<>();

		return new HashSet<>(Arrays.asList(ts));
	}

	public static <T> Set<T> fromCollection(Collection<? extends T> ts) {
		if (ts == null || ts.isEmpty())
			return new HashSet<>();

		return new HashSet<>(ts);
	}

	public static <X, Y> Set<Y> map(Collection<X> xs, Function<X, Y> fn) {
		if (xs == null || xs.isEmpty())
			return new HashSet<>();
		return xs.stream().map(fn).collect(Collectors.toSet());
	}

	public static <X> Set<X> filter(Collection<X> xs, Predicate<X> predicate) {
		if (xs == null || xs.isEmpty())
			return new HashSet<>();
		return xs.stream().filter(predicate).collect(Collectors.toSet());
	}

	@SafeVarargs
	public static <T> Set<T> union(Collection<? extends T>... xss) {
		Set<T> result = new HashSet<>();
		for (Collection<? extends T> xs : xss) {
			result.addAll(xs);
		}
		return result;
	}

	@SafeVarargs
	public static <T> Set<T> orderedUnion(Collection<T>... xss) {
		// LinkedHashSet preserves iteration ordering, source:
		// https://stackoverflow.com/a/16480560
		Set<T> result = new LinkedHashSet<>();
		for (Collection<T> xs : xss) {
			result.addAll(xs);
		}

		return result;
	}

	@SafeVarargs
	public static <T> Set<T> minus(Set<T> xs, Set<T>... yss) {
		ChecksUtilities.checkNotNull(xs, "xs cannot be null");
		ChecksUtilities.checkNotNull(yss, "yss cannot be null");

		Set<T> working = new HashSet<>(xs);
		ArrayList<Set<T>> sets = ListUtilities.newArrayList(yss);
		sets.forEach(working::removeAll);

		return working;
	}

	public static <T> Set<T> intersection(Set<T> xs, Set<T> ys) {
		ChecksUtilities.checkNotNull(xs, "xs cannot be null");
		ChecksUtilities.checkNotNull(ys, "ys cannot be null");

		Set<T> working = new HashSet<>(xs);
		working.retainAll(ys);
		return working;
	}

	public static <T, K> Set<T> uniqBy(Collection<T> xs, Function<T, K> comparator) {
		Set<K> seen = new HashSet<>();
		return xs.stream().filter(x -> {
			K k = comparator.apply(x);
			if (seen.contains(k)) {
				return false;
			} else {
				seen.add(k);
				return true;
			}
		}).collect(Collectors.toSet());
	}

	public static <T> Collection<T> unionAll(Collection<? extends Collection<T>> values) {
		ChecksUtilities.checkNotNull(values, "Cannot union all a null collection of collections");
		Set<T> result = new HashSet<>();
		values.forEach(result::addAll);
		return result;
	}

	public static <T> Set<T> complement(Set<T> xs, Set<T> ys) {
		ChecksUtilities.checkNotNull(xs, "xs cannot be null");
		ChecksUtilities.checkNotNull(ys, "ys cannot be null");

		return minus(union(xs, ys), intersection(xs, ys));

	}

	public static <T> boolean hasIntersection(Set<T> xs, Set<T> ys) {
		return !intersection(xs, ys).isEmpty();
	}

	public static <T> Set<T> fromOptionals(Collection<Optional<T>> ts) {
		return ts.stream().filter(Optional::isPresent).map(Optional::get).collect(Collectors.toSet());
	}

	public static <T> Set<T> maybeAdd(Set<T> ts, Optional<T> toAdd) {
		return toAdd.map(t -> union(ts, asSet(t))).orElse(ts);
	}

	public static <T> Set<T> add(Set<T> orig, T... ts) {
		return union(orig, asSet(ts));
	}

	public static <T> Set<T> remove(Set<T> orig, T... ts) {
		return minus(orig, asSet(ts));
	}
}
