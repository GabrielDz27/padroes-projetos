package br.edu.ifsc.pps.gv.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DB {
	private static DB instance;
	
	public static DB getInstance() {
		if (instance == null) {
			instance = new DB();
		}
		return instance;
	}
	
	private final Map<Class<?>, List<?>> storage = new HashMap<>();
	
	public <T> void insert(Class<T> type, T item) {
		getTable(type).add(item);
	}
	
	public <T> boolean exists(Class<T> type, T item) {
		return getTable(type).contains(item);
	}
	
	public <T> boolean exists(Class<T> type, Predicate<T> where) {
		return where(type, where).size() > 0;
	}
	
	public <T> void delete(Class<T> type, T item) {
		getTable(type).remove(item);
	}
	
	public <T> void delete(Class<T> type, Predicate<T> where) {
		getTable(type).removeIf(where);
	}
	
	public <T> List<T> selectAll(Class<T> type) {
		return where(type, x -> true);
	}
	
	public <T> List<T> where(Class<T> type, Predicate<T> predicate) {
		return getTable(type).stream()
				.filter(predicate)
				.collect(Collectors.toList());
	}
	
	public <T> int getCount(Class<T> type) {
		return selectAll(type).size();
	}
	
	public <T> int getCount(Class<T> type, Predicate<T> predicate) {
		return where(type, predicate).size();
	}
	
	@SuppressWarnings("unchecked")
	private <T> List<T> getTable(Class<T> type) {
		Objects.requireNonNull(type, "É obrigatório informar o tipo do parâmetro.");
		return (List<T>) storage.computeIfAbsent(type, fn -> new ArrayList<T>());
	}
}
