package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;

public class MyInt implements Comparable {
	private int value;

	public MyInt(int number) {
		this.value = number;
	}

	public boolean equals(Object o) {
		if (this.getClass() == o.getClass()) {
			return true;
		} else {
			return false;
		}
	}
	public int compareTo(Object o) {
		return compareTo((MyInt) o);
	}
	public int compareTo(MyInt o) {
		if (this.value < o.value) {
			return -1;
		} else if (this.value == o.value) {
			return 0;
		} else {
			return 1;
		}
	}
	public int getValue() {
		return this.value;
	}
	public String toString() {
		return this.value + "";
	}
}
