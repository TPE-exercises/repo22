package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;

public class MyString implements Comparable {
	private String value;
	public boolean equals(Object o) {
		if (this.getClass() == o.getClass()) {
			return true;
		} else {
			return false;
		}
	}
	public int compareTo(Object o) {
		return compareTo((MyString) o);
	}
	public int compareTo(MyString o) {
		if (this.value.length() < o.value.length()) {
			return -1;
		} else if (this.value.length() == o.value.length()) {
			return 0;
		} else {
			return 1;
		}
	}
	public String getValue() {
		return this.value;
	}
	public String toString() {
		return this.value;
	}
}
