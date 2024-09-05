/**
 * 
 */
package p2PizzaShop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 */
public class Pizza extends MenuItem {

	// Instance Variables

	private int size;
	private ArrayList<Topping> extraToppings;

	// Constructors

	/**
	 * 
	 */
	public Pizza() {
		setName("Pizza");
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor with size only
	 * 
	 * @param size
	 */
	public Pizza(int size) {
		setName("Pizza");
		this.setSize(size);
	}

	/**
	 * 
	 * 
	 * @param name
	 * @param price
	 */
	public Pizza(String name, double price) {
		super(name, price);
		setName("Pizza");
	}

	/**
	 * @param name
	 * @param price
	 * @param size
	 * @param extraToppings
	 * @throws IllegalArgumentException
	 */
	public Pizza(int size, ArrayList<Topping> extraToppings) throws IllegalArgumentException {
		setName("Pizza");
		this.setSize(size);
		this.setExtraToppings(extraToppings);
	}

	// Getters and Setters

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		if (size >= 8 && size <= 16) {
			this.size = size;
			setPrice(size);
		} else if (size > 16) {
			this.size = 16;
			setPrice(this.size);
		} else if (size < 8) {
			this.size = 8;
			setPrice(this.size);
		}

	}

	/**
	 * @return the extraToppings
	 */
	public ArrayList<Topping> getExtraToppings() {
		return extraToppings;
	}

	/**
	 * @param extraToppings the extraToppings to set
	 */
	public void setExtraToppings(ArrayList<Topping> extraToppings) {

		Set<Topping> removeDuplicates = new HashSet<Topping>(extraToppings);
		extraToppings.removeAll(extraToppings);
		extraToppings.addAll(removeDuplicates);
		
		this.extraToppings = extraToppings;

		setPrice(getSize() + (extraToppings.size() * 0.50));
	}

	@Override
	public void printDetails() {
		pizzaDetails(extraToppings);
	}

	private void pizzaDetails() {
		System.out.printf("Plain Pizza\t (%d) \t£%.2f\n", getSize(), getPrice());
	}

	private void pizzaDetails(ArrayList<Topping> extraToppings) {
		if (extraToppings == null) {
			pizzaDetails();
		} else {
			System.out.printf("Custom Pizza\t (%d) \t£%.2f\n", getSize(), getPrice());
			System.out.println("with toppings:");
			for (Topping t : extraToppings) {
				System.out.println("*" + t);
			}
		}
	}

	public void addTopping(Topping topping) {

		ArrayList<Topping> extraToppings = new ArrayList<Topping>();

		extraToppings.add(topping);

	}

	public boolean isVegetarian(ArrayList<Topping> extraToppings) {
		if (extraToppings == null || extraToppings.contains(Topping.EXTRACHEESE)
				|| extraToppings.contains(Topping.PINEAPPLE) || extraToppings.contains(Topping.PEPPERS)
				|| extraToppings.contains(Topping.ONIONS) || extraToppings.contains(Topping.MUSHROOMS)
				|| extraToppings.contains(Topping.OLIVES)) {
			return true;
		} else {
			return false;
		}
	}

	public static int findVeggies(ArrayList<MenuItem> menuItems) {
		
		int numberOfVeggieItems = 0; 
		
		for (MenuItem m : menuItems) {
			if (m instanceof Pizza) {
				Pizza temp = (Pizza) m;
				if (temp.getExtraToppings() == null || temp.getExtraToppings().contains(Topping.EXTRACHEESE)
						|| temp.getExtraToppings().contains(Topping.PINEAPPLE) || temp.getExtraToppings().contains(Topping.PEPPERS)
						|| temp.getExtraToppings().contains(Topping.ONIONS) || temp.getExtraToppings().contains(Topping.MUSHROOMS)
						|| temp.getExtraToppings().contains(Topping.OLIVES)) {
					numberOfVeggieItems++;
				}
			}
		}
		return numberOfVeggieItems;
	}

}
