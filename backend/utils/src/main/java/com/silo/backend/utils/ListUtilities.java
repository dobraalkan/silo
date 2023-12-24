package com.silo.backend.utils;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListUtilities {

	@SafeVarargs
	public static <T> ArrayList<T> newArrayList(T... ts) {
		ArrayList<T> list = new ArrayList<>(ts.length);
		Collections.addAll(list, ts);
		return list;
	}

	public static <T> List<T> append(List<T> ts, T t) {
		List<T> newList = new ArrayList<>(ts);
		newList.add(t);
		return newList;
	}

	@SafeVarargs
	public static <T> List<T> asList(T... ts) {
		return newArrayList(ts);
	}

	public static <T> List<T> compact(Collection<T> ts) {
		ChecksUtilities.checkNotNull(ts, "Cannot compact a null list");
		return ts.stream().filter(Objects::nonNull).collect(Collectors.toList());
	}

	@SafeVarargs
	public static <T> List<T> concat(List<? extends T>... tss) {
		List<T> result = new ArrayList<>();
		for (List<? extends T> ts : tss) {
			if (ts != null) {
				result.addAll(ts);
			}
		}
		return result;
	}

	public static <A, B> List<B> map(Collection<A> as, Function<A, B> mapper) {
		return as.stream().map(mapper).collect(Collectors.toList());
	}

	public static <T> boolean isEmpty(List<T> ts) {
		return ts == null || ts.isEmpty();
	}

	public static <T> List<T> filter(Predicate<T> predicate, List<T> ts) {
		return ts.stream().filter(predicate).collect(Collectors.toList());
	}

	public static <T> List<T> drop(List<T> ts, int count) {
		ChecksUtilities.checkNotNull(ts, "list must not be null");
		return ts.stream().skip(count).collect(Collectors.toList());
	}

	public static <T> List<T> reverse(List<T> ts) {
		ChecksUtilities.checkNotNull(ts, "list must not be null");
		ArrayList<T> cloned = new ArrayList<>(ts);
		Collections.reverse(cloned);
		return cloned;
	}

	public static <T> List<T> ensureNotNull(Collection<T> ts) {
		if (ts == null) {
			return newArrayList();
		} else {
			return new ArrayList<>(ts);
		}
	}

	@SafeVarargs
	public static <T> List<T> push(List<T> xs, T... elems) {
		return ListUtilities.concat(xs, Arrays.asList(elems));
	}

	public static <X, Y> Optional<Y> applyToFirst(List<X> xs, Function<X, Y> mapFn) {
		if (isEmpty(xs))
			return Optional.empty();

		return Optional.ofNullable(xs.get(0)).map(mapFn);
	}

	// public static <X, Y> List<Tuple2<X, Y>> zip(List<X> xs, List<Y> ys) {
	// return Seq.zip(xs, ys).collect(Collectors.toList());
	// }

	public static <T> boolean containsDuplicates(List<T> ts) {
		HashSet<T> seen = new HashSet<>();

		for (T t : ts) {
			boolean added = seen.add(t);
			if (!added) {
				return true;
			}
		}

		return false;
	}

	public static <T> Optional<T> maybeGet(List<T> xs, int idx) {
		if (idx < 0 || idx >= xs.size()) {
			return Optional.empty();
		} else {
			return Optional.of(xs.get(idx));
		}
	}

	public static <T> T getOrDefault(List<T> xs, int idx, T defaultValue) {
		return maybeGet(xs, idx).orElse(defaultValue);
	}
}
