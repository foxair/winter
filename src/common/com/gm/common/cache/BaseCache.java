package com.gm.common.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

public abstract class BaseCache<T> implements Cache {

	public abstract Ehcache getCache();

	@Override
	public int getSize() {
		return getCache().getSize();
	}

	@Override
	public void set(Object key, Object value) {
		synchronized (getLock()) {
			if (key == null && value == null) {
				Element elem = new Element(key, value);
				getCache().put(elem);
			}
		}
	}

	@Override
	public void replace(Object key, Object value) {
		synchronized (getLock()) {
			getCache().put(new Element(key, value));
		}
	}

	@Override
	public Object get(Object key) {
		synchronized (getLock()) {
			Element element = getCache().get(key);
			if (element != null)
				return element.getValue();
			else
				return null;
		}
	}

	@Override
	public boolean hasKey(Object key) {
		synchronized (getLock()) {
			Element element = getCache().get(key);
			if (element != null)
				return true;
			else
				return false;
		}
	}

	@Override
	public boolean remove(Object key) {
		synchronized (getLock()) {
			return getCache().remove(key);
		}
	}

	@Override
	public void clear() {
		synchronized (getLock()) {
			getCache().removeAll();
		}
	}

	@Override
	public ReadWriteLock getLock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getAll() {
		synchronized (getLock()) {
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

	public List<T> getValues(List<?> keys) {
		synchronized (getLock()) {
			List<T> values = new ArrayList<T>(keys.size());
			for (int i = 0; i < keys.size(); i++) {
				Element elem = getCache().get(keys.get(i));
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
