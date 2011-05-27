package com.gm.common.cache;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

public abstract class BaseCacheManager<T> implements CacheManager {

	public abstract Ehcache getCache();

	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	@Override
	public int getSize() {
		return getCache().getSize();
	}

	@Override
	public void put(Object key, Object value) {
		if (key != null && value != null) {
			synchronized (this) {
				Element elem = new Element(key, value);
				getCache().put(elem);
			}
		}
	}

	@Override
	public synchronized void addMap(Map elements) {
		if (elements == null || elements.size() == 0)
			return;
		Set<Map.Entry<?, ?>> set = elements.entrySet();
		Iterator<Map.Entry<?, ?>> entryIter = set.iterator();
		while (entryIter.hasNext()) {
			Map.Entry entry = entryIter.next();
			Element elem = new Element(entry.getKey(), entry.getValue());
			getCache().put(elem);
		}
	}

	@Override
	public void replace(Object key, Object value) {
		if (key != null && value != null) {
			synchronized (this) {
				getCache().put(new Element(key, value));
			}
		}
	}

	@Override
	public T get(Object key) {
		synchronized (this) {
			Element element = getCache().get(key);
			if (element != null)
				return (T) element.getValue();
			else
				return null;
		}
	}

	@Override
	public boolean hasKey(Object key) {
		synchronized (this) {
			Element element = getCache().get(key);
			if (element != null)
				return true;
			else
				return false;
		}
	}

	@Override
	public boolean remove(Object key) {
		synchronized (this) {
			return getCache().remove(key);
		}
	}

	@Override
	public void clear() {
		synchronized (this) {
			getCache().removeAll();
		}
	}

	@Override
	public ReadWriteLock getLock() {
		return this.readWriteLock;
	}

	@Override
	public List<T> getAll() {
		synchronized (this) {
			List<?> keys = getCache().getKeys();
			List<T> values = new ArrayList<T>(keys.size());
			for (int i = 0; i < keys.size(); i++) {
				Element elem = getCache().get(keys.get(i));
				if (elem != null)
					values.add(extracted(elem));
			}
			return values;
		}
	}

	@Override
	public List<T> getByKeys(List<?> keys) {
		return getByKeys(keys.toArray());
	}

	@Override
	public List<T> getByKeys(Object[] keys) {
		synchronized (this) {
			List<T> values = new ArrayList<T>(keys.length);
			for (int i = 0; i < keys.length; i++) {
				Element elem = getCache().get(keys[i]);
				if (elem != null)
					values.add(extracted(elem));
			}
			return values;
		}
	}

	private T extracted(Element elem) {
		return (T) elem.getValue();
	}

}
