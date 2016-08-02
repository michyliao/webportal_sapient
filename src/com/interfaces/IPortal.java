package com.interfaces;

import java.util.Hashtable;
import java.util.UUID; // Reference to why using UUID http://stackoverflow.com/questions/20180901/how-to-generate-unique-keys-for-a-hashtable-and-recycle-deleted-keys

public interface IPortal<T> {
	void add(T t);
	void print(T t);
	T find(String name);
	Hashtable<UUID,T> returnAll();
	void viewAll();
}
