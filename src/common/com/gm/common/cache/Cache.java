package com.gm.common.cache;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

public interface Cache {

	int getSize();

	void set(Object key, Object value);

	/**
	 * Replace the cached element only if an Element is currently cached for this key
	 * @param key
	 * @param value
	 */
	void replace(Object key, Object value);

	Object get(Object key);

	boolean hasKey(Object key);

	/**
	 * true if the element was removed, false if it was not found in the cache
	 * @param key
	 * @return
	 */
	boolean remove(Object key);

	void clear();

	ReadWriteLock getLock();

	List getAll();

	List getByKeys();
}