package model;

import java.util.Objects;

public class Paint {
	private String name;
	private String price;

	public Paint(String name, String price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Paint)) return false;
		Paint paint = (Paint) o;
		return name.equals(paint.getName()) && price.equals(paint.getPrice());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getPrice());
	}

	@Override
	public String toString() {
		return "Paint{" +
				"paintName='" + name + '\'' +
				", price='" + price + '\'' +
				'}';
	}
}