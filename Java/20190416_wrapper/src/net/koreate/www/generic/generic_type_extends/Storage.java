package net.koreate.www.generic.generic_type_extends;

public interface Storage<T> {
	void add(T item, int index);
	T get(int index);

}
