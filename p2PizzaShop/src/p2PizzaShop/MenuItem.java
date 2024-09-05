/**
 * 
 */
package p2PizzaShop;

import java.util.Objects;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class MenuItem implements Detail {

	// Instance variables

	private String name;
	private double price; // Constructors

	/**
	 * This is the default constructor
	 */

	public MenuItem() {

	}

	/**
	 * 
	 * Constructor with args
	 * 
	 * @param name
	 * @param price
	 */
	public MenuItem(String name, double price) throws IllegalArgumentException {
		this.setName(name);
		this.setPrice(price);
	}

	// Getters and Setters

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) throws IllegalArgumentException {
		if (name.isEmpty()) {
			throw new IllegalArgumentException("INVALID NAME");
		}

		if (name.substring(0, 1).equals(" ")) {
			throw new IllegalArgumentException("INVALID NAME");
		}

		if (name.matches("[a-zA-Z ]*")) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("INVALID NAME");
		}

	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {

		if (price < 0) {
			price = 0;
		} else {
			this.price = price;
		}

	}

	// Methods

	@Override
	public void printDetails() {

		System.out.printf("%s \t\t\t£%.2f\n", this.name, this.price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		return Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	
	

}
