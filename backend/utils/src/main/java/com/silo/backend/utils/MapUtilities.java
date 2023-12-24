package com.silo.backend.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.emptyMap;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class MapUtilities {

	public static <K, V> HashMap<K, V> newHashMap() {
		return new HashMap<>();
	}

	public static <K, V> Map<K, V> newHashMap(K key, V val) {
		HashMap<K, V> map = newHashMap();
		map.put(key, val);
		return map;
	}

	public static <K, V> Map<K, V> newHashMap(K k1, V v1, K k2, V v2) {
		Map<K, V> map = newHashMap(k1, v1);
		map.put(k2, v2);
		return map;
	}

	public static <K, V> Map<K, V> newHashMap(K k1, V v1, K k2, V v2, K k3, V v3) {
		Map<K, V> map = newHashMap(k1, v1, k2, v2);
		map.put(k3, v3);
		return map;
	}

	public static <K, V> Map<K, V> newHashMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
		Map<K, V> map = newHashMap(k1, v1, k2, v2, k3, v3);
		map.put(k4, v4);
		return map;
	}

	public static <K, V> Map<K, V> newHashMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
		Map<K, V> map = newHashMap(k1, v1, k2, v2, k3, v3, k4, v4);
		map.put(k5, v5);
		return map;
	}

	public static <K, V> Map<K, V> newHashMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
		Map<K, V> map = newHashMap(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
		map.put(k6, v6);
		return map;
	}

	public static <K, V> Map<K, Collection<V>> groupBy(Function<V, K> keyFn, Collection<V> xs) {
		return groupBy(keyFn, x -> x, xs);
	}

	public static <K, V> Map<K, Collection<V>> groupBy(Collection<V> xs, Function<V, K> keyFn) {
		return groupBy(keyFn, x -> x, xs);
	}

	public static <K, V, V2> Map<K, Collection<V2>> groupBy(Collection<V> xs, Function<V, K> keyFn,
			Function<V, V2> valueFn) {
		return groupBy(keyFn, valueFn, xs);
	}

	public static <K, V, V2> Map<K, Collection<V2>> groupBy(Function<V, K> keyFn, Function<V, V2> valueFn,
			Collection<V> xs) {
		ChecksUtilities.checkNotNull(xs, "xs cannot be null");
		ChecksUtilities.checkNotNull(keyFn, "keyFn cannot be null");
		ChecksUtilities.checkNotNull(valueFn, "valueFn cannot be null");

		Map<K, Collection<V2>> result = MapUtilities.newHashMap();
		for (V v : xs) {
			K key = keyFn.apply(v);
			Collection<V2> bucket = result.computeIfAbsent(key, u -> ListUtilities.newArrayList());
			bucket.add(valueFn.apply(v));
			result.put(key, bucket);
		}
		return result;
	}

	public static <K, V> Map<K, V> indexBy(Collection<V> xs, Function<V, K> keyFn) {
		return indexBy(keyFn, xs);
	}

	public static <K, V, V2> Map<K, V2> indexBy(Collection<V> xs, Function<V, K> keyFn, Function<V, V2> valueFn) {
		return indexBy(keyFn, valueFn, xs);
	}

	public static <K, V> Map<K, V> indexBy(Function<V, K> keyFn, Collection<V> xs) {
		ChecksUtilities.checkNotNull(xs, "xs cannot be null");
		ChecksUtilities.checkNotNull(keyFn, "keyFn cannot be null");

		return indexBy(keyFn, identity(), xs);
	}

	public static <K, R, V> Map<K, R> indexBy(Function<V, K> keyFn, Function<V, R> valueFn, Collection<V> xs) {
		ChecksUtilities.checkNotNull(xs, "xs cannot be null");
		ChecksUtilities.checkNotNull(keyFn, "keyFn cannot be null");
		ChecksUtilities.checkNotNull(valueFn, "valueFn cannot be null");

		return xs.stream().collect(HashMap::new, (acc, d) -> acc.put(keyFn.apply(d), valueFn.apply(d)), Map::putAll);
	}

	public static <K, R, V> Map<K, R> indexBy(Function<V, K> keyFn, Function<V, R> valueFn, Collection<V> xs,
			BinaryOperator<R> mergeFunction) {
		ChecksUtilities.checkNotNull(xs, "xs cannot be null");
		ChecksUtilities.checkNotNull(keyFn, "keyFn cannot be null");
		ChecksUtilities.checkNotNull(valueFn, "valueFn cannot be null");

		return xs.stream().collect(toMap(keyFn, valueFn, mergeFunction));
	}

	public static <K, R, V> Map<K, R> indexBy(Collection<V> xs, Function<V, K> keyFn, Function<V, R> valueFn,
			BinaryOperator<R> mergeFunction) {
		return indexBy(keyFn, valueFn, xs, mergeFunction);
	}

	public static <K, V> Map<K, Long> countBy(Function<V, K> keyFn, Collection<V> xs) {
		if (xs == null) {
			return emptyMap();
		}
		return xs.stream().collect(Collectors.groupingBy(keyFn, Collectors.counting()));
	}

	public static <K, V> Map<K, V> ensureNotNull(Map<K, V> maybeMap) {
		return maybeMap == null ? newHashMap() : maybeMap;
	}

	public static <K, V> boolean isEmpty(Map<K, V> map) {
		return map == null || map.isEmpty();
	}

	public static <K, V> Optional<V> maybeGet(Map<K, V> map, K key) {
		return map == null ? Optional.empty() : Optional.ofNullable(map.get(key));
	}

	public static <K, V, V2> Map<K, V2> groupAndThen(Collection<V> xs, Function<V, K> keyFn,
			Function<Collection<V>, V2> valueFn) {
		ChecksUtilities.checkNotNull(xs, "xs cannot be null");
		ChecksUtilities.checkNotNull(keyFn, "keyFn cannot be null");
		ChecksUtilities.checkNotNull(valueFn, "valueFn cannot be null");

		Map<K, V2> result = MapUtilities.newHashMap();
		Map<K, Collection<V>> step1 = groupBy(keyFn, xs);

		for (Map.Entry<K, Collection<V>> entry : step1.entrySet()) {

			K key = entry.getKey();
			Collection<V> group = entry.getValue();
			V2 transformedGroup = valueFn.apply(group);
			result.put(key, transformedGroup);
		}
		return result;
	}

	public static <K, K2, V> Map<K2, V> transformKeys(Map<K, V> original, Function<K, K2> transformation) {
		Map<K2, V> output = new HashMap<>();
		original.forEach((key, value) -> output.put(transformation.apply(key), value));
		return output;
	}

	public static <K1, K2, V> Map<K1, V> compose(Map<K1, K2> map1, Map<K2, V> map2) {
		Map<K1, V> result = new HashMap<>();
		map1.forEach((key, value) -> result.put(key, map2.get(value)));
		return result;
	}

	public static <K, V> Map<K, V> merge(Map<K, V>... maps) {
		HashMap<K, V> newMap = newHashMap();
		Stream.of(maps).forEach(newMap::putAll);

		return newMap;
	}
}
