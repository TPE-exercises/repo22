package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;

public class MyString implements Comparable {
	private String value;
	public MyString(String value) {
		this.value = value;
	}
	public boolean equals(Object o) {
		if (this.getClass() == o.getClass()) {
			return true;
		} else {
			return false;
		}
	}
	public int compareTo(Object o) {
		if(o.getClass() != (new MyString("")).getClass()) {
			return 1;
		}
		return compareTo((MyString) o);
	}
	/**
	 * @param o: The argument MyString to be compared to
	 * @return The result which grants information about the lexicographical difference between the two MyStrings.
	 */
	public int compareTo(MyString o) {
		// The compareTo() method of String seemingly does not only deliver +-1 and 0 but also different positive 
		// and negative integers. Thus, these if-conditions are implemented.
		if(this.value.compareTo(o.value) < 0) {
			return -1;
		} else if(this.value.compareTo(o.value) > 0) {
			return 1;
		} else {
			return 0;
		}
//		return this.value.compareTo(o.value);
//		if (this.value.length() < o.value.length()) {
//			return -1;
//		} else if (this.value.length() == o.value.length()) {
//			return 0;
//		} else {
//			return 1;
//		}
	}
	public String getValue() {
		return this.value;
	}
	public String toString() {
		return this.value;
	}
}
