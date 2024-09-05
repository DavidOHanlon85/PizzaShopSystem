/**
 * 
 */
package p2PizzaShop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class PizzaShop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		MenuItem m1 = new MenuItem("Burger", 5.50);
//		
//		Pizza p1 = new Pizza(12);
//		
//		ArrayList<Topping> toppings = new ArrayList<Topping>();
//		ArrayList<Topping> toppings2 = new ArrayList<Topping>();
//		
//		Collections.addAll(toppings2, Topping.Extracheese, Topping.Onions, Topping.Extracheese);
//		Collections.addAll(toppings, Topping.Beef, Topping.Chicken);
//		
//		Pizza p2 = new Pizza(16, toppings);
//		Pizza p3 = new Pizza(10, toppings2);
//		
//		p1.printDetails();
//		
//		p2.printDetails();
//		
//		ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
//		
//		menuItems.add(m1);
//		menuItems.add(p1);
//		menuItems.add(p2);
//		menuItems.add(p3);
//
//		printReceipt(menuItems);
//		
//		System.out.println(p1.isVegetarian(p2.getExtraToppings()));
//		
//		System.out.println(Pizza.findVeggies(menuItems));

		// Read and Display 1 - Menu Items Only

//		ArrayList<MenuItem> menuItems1 = extractMenuItemsBasicList();
//
//		System.out.println(menuItems1.size());
//
//		for (MenuItem m : menuItems1) {
//			m.printDetails();
//		}

		// Read and Display 2 - Pizza Items Only
//		
//		ArrayList<MenuItem> menuItems2 = extractMenuItemsPizzasOnly();
//		
//		
//		for (MenuItem m : menuItems2) {
//			m.printDetails();
//		}
//		
		// Read and Display - Pizzas and Menu Items

		ArrayList<MenuItem> menuItems3 = extractMenuItemsAndPizzas();

		for (MenuItem m : menuItems3) {
			m.printDetails();
		}
		
		printReceipt(menuItems3);
	}

	/**
	 * @return
	 */
	public static ArrayList<MenuItem> extractMenuItemsAndPizzas() {
		ArrayList<MenuItem> menuItems3 = new ArrayList<MenuItem>();

		String line;
		double price;
		int size;

		File file = new File("OrderList-3-Full.csv");

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			// Remove Column Header

			line = br.readLine();

			// Read first line

			line = br.readLine();

			while (line != null) {

				String[] menuItemSplit = line.split(",");

				if (!menuItemSplit[0].equals("Pizza")) {

					price = Double.parseDouble(menuItemSplit[1]);

					menuItems3.add(new MenuItem(menuItemSplit[0], price));

				} else if (menuItemSplit[0].equals("Pizza")) {
					ArrayList<Topping> extraToppings = new ArrayList<Topping>();

					String[] pizzaItemSplit = line.split(",");

					size = Integer.parseInt(pizzaItemSplit[1]);

					if (pizzaItemSplit.length == 6) {
						extraToppings.add(Topping.valueOf(pizzaItemSplit[2]));
						extraToppings.add(Topping.valueOf(pizzaItemSplit[3]));
						extraToppings.add(Topping.valueOf(pizzaItemSplit[4]));
						extraToppings.add(Topping.valueOf(pizzaItemSplit[5]));
					}

					if (pizzaItemSplit.length == 5) {
						extraToppings.add(Topping.valueOf(pizzaItemSplit[2]));
						extraToppings.add(Topping.valueOf(pizzaItemSplit[3]));
						extraToppings.add(Topping.valueOf(pizzaItemSplit[4]));
					}

					if (pizzaItemSplit.length == 4) {
						extraToppings.add(Topping.valueOf(pizzaItemSplit[2]));
						extraToppings.add(Topping.valueOf(pizzaItemSplit[3]));
					}

					if (pizzaItemSplit.length == 3) {
						extraToppings.add(Topping.valueOf(pizzaItemSplit[2]));
					}

					if (pizzaItemSplit[0].equals("Pizza") && pizzaItemSplit.length == 2) {
						menuItems3.add(new Pizza(size));
					} else if (pizzaItemSplit[0].equals("Pizza")) {
						menuItems3.add(new Pizza(size, extraToppings));
					}

				}

				// read next line
				line = br.readLine();

			}
			
			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuItems3;
	}

	/**
	 * @param menuItems2
	 */
	public static ArrayList<MenuItem> extractMenuItemsPizzasOnly() {
		ArrayList<MenuItem> menuItems2 = new ArrayList<MenuItem>();
		String line;
		int size;

		File file = new File("OrderList-2-PizzasOnly.csv");

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			// Remove Column Header
			line = br.readLine();

			// Read first line
			line = br.readLine();

			while (line != null) {

				ArrayList<Topping> extraToppings = new ArrayList<Topping>();

				String[] pizzaItemSplit = line.split(",");

				size = Integer.parseInt(pizzaItemSplit[1]);

				if (pizzaItemSplit.length == 6) {
					extraToppings.add(Topping.valueOf(pizzaItemSplit[2]));
					extraToppings.add(Topping.valueOf(pizzaItemSplit[3]));
					extraToppings.add(Topping.valueOf(pizzaItemSplit[4]));
					extraToppings.add(Topping.valueOf(pizzaItemSplit[5]));
				}

				if (pizzaItemSplit.length == 5) {
					extraToppings.add(Topping.valueOf(pizzaItemSplit[2]));
					extraToppings.add(Topping.valueOf(pizzaItemSplit[3]));
					extraToppings.add(Topping.valueOf(pizzaItemSplit[4]));
				}

				if (pizzaItemSplit.length == 4) {
					extraToppings.add(Topping.valueOf(pizzaItemSplit[2]));
					extraToppings.add(Topping.valueOf(pizzaItemSplit[3]));
				}

				if (pizzaItemSplit.length == 3) {
					extraToppings.add(Topping.valueOf(pizzaItemSplit[2]));
				}

				if (pizzaItemSplit[0].equals("Pizza") && pizzaItemSplit.length == 2) {
					menuItems2.add(new Pizza(size));
				} else if (pizzaItemSplit[0].equals("Pizza")) {
					menuItems2.add(new Pizza(size, extraToppings));
				}

				// read next line
				line = br.readLine();

			}

			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuItems2;
	}

	/**
	 * @return
	 */
	public static ArrayList<MenuItem> extractMenuItemsBasicList() {
		ArrayList<MenuItem> menuItems1 = new ArrayList<MenuItem>();
		String line;
		double price;

		File file = new File("OrderList-1-BasicOnly.csv");

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			// Removing Column Headers
			line = br.readLine();
			// Test line
			// System.out.println(line);

			// Read in First Line
			line = br.readLine();

			System.out.println(line);

			while (line != null) {

				String[] menuItemSplit = line.split(",");

				price = Double.parseDouble(menuItemSplit[1]);

				menuItems1.add(new MenuItem(menuItemSplit[0], price));

				line = br.readLine();

			}

			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuItems1;
	}

	public static void printReceipt(ArrayList<MenuItem> menuItems) {

		double totalPrice = 0;

		for (MenuItem m : menuItems) {
			m.printDetails();
			totalPrice += m.getPrice();
		}

		System.out.println("-------------");
		System.out.printf("Total cost: £%.2f\n", totalPrice);
		System.out.println("-------------");

	}

}
