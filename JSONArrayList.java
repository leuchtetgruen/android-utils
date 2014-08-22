package de.leuchtetgruen.utils;

import java.util.Collection;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;


public class JSONArrayList implements Collection<Object>  {
	
	private JSONArray arr;
	
	public JSONArrayList(JSONArray arr) {
		this.arr = arr;
	}
	
	@Override
	public boolean add(Object object) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Object> arg0) {
		return false;
	}

	@Override
	public void clear() {
	}

	@Override
	public boolean contains(Object object) {
		for (int i=0; i < arr.length(); i++) {
			Object o = null;
			try {
				o = arr.get(i);
			} catch (JSONException e) {

				e.printStackTrace();
			}
			if (object.equals(o)) return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		for (Object object : arg0) {
			if (!contains(object)) return false;
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		return (arr.length() > 0);
	}

	@Override
	public Iterator<Object> iterator() {
		return new Iterator<Object>() {

			int curIdx = 0;
			
			@Override
			public boolean hasNext() {
				return (curIdx < (arr.length()));
			}

			@Override
			public Object next() {
				Object o = null;
				try {
					o = arr.get(curIdx);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				curIdx++;
				return o;
			}

			@Override
			public void remove() {
			}
			
		};
	}

	@Override
	public boolean remove(Object object) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {

		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		return false;
	}

	@Override
	public int size() {
		return arr.length();
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] array) {
		return null;
	}

}
