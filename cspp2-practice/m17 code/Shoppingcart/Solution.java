import java.util.Scanner;
import java.util.Arrays;
/**
 * @author Priyanka maladi.
 */

/**
 * Class for item.
 */
class Item {
	/**
	 * product name.
	 */
	private String productname;
	/**
	 * qunatity.
	 */
	private int quantity;
	/**
	 * unitprice.
	 */
	private double unitprice;

	/**
	 * Constructs the object.
	 *
	 * @param      prductnam  The prductnam
	 * @param      quant      The quant
	 * @param      unitcost   The unitcost
	 */
	Item(final String prductnam, final int quant, final double unitcost) {
		this.productname = prductnam;
		this.quantity = quant;
		this.unitprice = unitcost;
	}

	/**
	 * Constructs the object.
	 *
	 * @param      prodtname  The prodtname
	 * @param      quanti     The quanti
	 */
	Item(final String prodtname, final int quanti) {
		this.productname = prodtname;
		this.quantity = quanti;
	}

	/**
	 * Gets the product name.
	 *
	 * @return     The product name.
	 */
	public String getProductName() {
		return this.productname;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return     The quantity.
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * Gets the unit price.
	 *
	 * @return     The unit price.
	 */
	public double getUnitPrice() {
		return this.unitprice;
	}

	/**
	 * Sets the product name.
	 *
	 * @param      prodtname  The prodtname
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String setProductName(String prodtname) {
		return this.productname = prodtname;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param      quanti  The quanti
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int setQuantity(int quanti) {
		return this.quantity = quanti;
	}

	/**
	 * Sets the unit price.
	 *
	 * @param      giveprice  The giveprice
	 *
	 * @return     { description_of_the_return_value }
	 */
	public double setUnitPrice(double giveprice) {
		return this.unitprice = giveprice;
	}

	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		String s = "";
		s += productname + " " + quantity + " " + unitprice;
		return s;
	}
}
/**
 * Class for shopping cartesian.
 */
class ShoppingCart {
	/**
	 * catalog array.
	 */
	private Item[] cata;
	/**
	 * cart array.
	 */
	private Item[] cart;
	/**
	 * coupon array;
	 */
	private String[] coupons;
	/**
	 * coupon available.
	 */
	private boolean couponavail;
	/**
	 * coupon.
	 */
	private double coup;
	/**
	 * tax.
	 */
	private double tax;
	/**
	 * discount.
	 */
	private double discount;
	/**
	 * catalog size.
	 */
	private int catasize;
	/**
	 * cart size.
	 */
	private int cartsize;
	/**
     * @variable TEN.
     */
    private static final int TEN = 10;

	/**
	 * Constructs the object.
	 */
	ShoppingCart() {
		couponavail = false;
		coupons = new String[]{"IND10", "IND20", "IND30", "IND50"};
		cata = new Item[TEN];
		cart = new Item[TEN];
		catasize = 0;
		cartsize = 0;
		coup = 0.0;
		discount = 0.0;
		tax = 0.0;
	}

	/**
	 * catalog resize.
	 */
	public void cataresize() {
		cata = Arrays.copyOf(cata, cata.length * 2);
	}

	/**
	 * cart resize.
	 */
	public void cartresize() {
		cart = Arrays.copyOf(cart, cart.length * 2);
	}

	/**
	 * Adds to catalog.
	 *
	 * @param      items  The items
	 */
	public void addToCatalog(final Item items) {
		if (catasize == cata.length) {
			cataresize();
		}
		if (catasize >= 0) {
			cata[catasize] = items;
			catasize += 1;
		}
	}
	/**
	 * Adds to cartesian.
	 *
	 * @param      item  The item
	 */
	public void addToCart(final Item item)  {
		if (cartsize == cart.length) {
			cartresize();
		}
		int index = indexOfCartItem(item);
		if (index == -1) {
			for (int i = 0; i < catasize; i++) {
				if (cata[i].getProductName().equals(item.getProductName()) && (cata[i].getQuantity() >= item.getQuantity())) {
					cart[cartsize] = item;
					cartsize += 1;
				}
			}
		} else {
			int quan = cart[index].getQuantity() + item.getQuantity();
			if (cata[index].getQuantity() >= item.getQuantity()) {
				cart[index].setQuantity(quan);
			}
		}
	}
	public int indexOfCartItem(final Item item) {
		for (int i = 0; i < cartsize; i++) {
			if (cart[i].getProductName().equals(item.getProductName())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * { function_description }
	 *
	 * @param      item  The item
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int indexOfCataItem(final Item item) {
		for (int i = 0; i < catasize; i++) {
			if (cata[i].getProductName().equals(item.getProductName())) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Removes a from cartesian.
	 *
	 * @param      item  The item
	 */
	public void removeFromCart(final Item item) {
		int p = indexOfCartItem(item);
		if (p != -1) {
			if (cart[p].getQuantity() == item.getQuantity()) {
				for (int i = p; i < cartsize; i++) {
					cart[i] = cart[i+1];
				}
				cartsize -= 1;
			} else if (cart[p].getQuantity() > item.getQuantity()) {

				cart[p].setQuantity(cart[p].getQuantity() - (item.getQuantity()));
			} else {
				System.out.println("Not Applicable");
			}
		}
	}
	/**
	 * Shows the cartesian.
	 */
	public void showCart() {
		for (int i = 0; i < cartsize; i++) {
			System.out.println(cart[i].getProductName() + " " + cart[i].getQuantity());
		}
	}
	/**
	 * Shows the catalog.
	 */
	public void showCatalog() {
		for (int i = 0; i < catasize; i++) {
			System.out.println(cata[i]);
		}
	}
	/**
	 * Gets the total amount.
	 *
	 * @return     The total amount.
	 */
	public double getTotalAmount() {
		double amu = 0.0;
		for (int i = 0; i < cartsize; i++) {
			for (int j = 0; j < catasize; j++) {
				if (cart[i].getProductName().equals(cata[j].getProductName())) {
					amu += cart[i].getQuantity() * cata[j].getUnitPrice();
				}
			}
		}
		return amu;
	}
	private static final double DE = 0.15;
	/** 
	 * Gets the payable amount.
	 *
	 * @return     The payable amount.
	 */
	public double getPayableAmount() {
		double amount = getTotalAmount();
		discount = amount * coup / TEN;
		amount -= discount;
		tax = amount * DE;
		amount += tax;
		return amount;
	}
	/**
	 * { var_description }
	 */
	private static final int THREE = 3;

	/**
	 * Determines if coupon.
	 *
	 * @param      coupon  The coupon
	 */
	public void isCoupon(final String coupon) {
		for (int i = 0; i < coupons.length; i++) {
			if (coupon.equals(coupons[i]) && !couponavail) {
				coup = Character.getNumericValue(coupons[i].charAt(THREE));
				couponavail = true;
				break;
			}
		}
		if (!couponavail) {
			System.out.println("Invalid coupon");
		}
	}
	/**
	 * { function_description }
	 */
	public void printInvoice() {
		System.out.println("Name   quantity   Price");
		for (int i = 0; i < cartsize; i++) {
			int p = indexOfCataItem(cart[i]);
			System.out.println(cart[i].getProductName() + " " + cart[i].getQuantity() + " " + cata[p].getUnitPrice());
		}
		System.out.println("Total:" + getTotalAmount());
		System.out.println("Disc%:" + discount);
		System.out.println("Tax:" + tax);
		System.out.println("Payable amount: " + getPayableAmount());
	}
}
/**
 * Class for solution.
 */
public class Solution {
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
				case "Item":
				String[] items = tokens[1].split(",");
				cart.addToCatalog(new Item(items[0], Integer.parseInt(items[1]), Double.parseDouble(items[2])));
				break;
				case "add":
					items = tokens[1].split(",");
					cart.addToCart(new Item(items[0], Integer.parseInt(items[1])));
					break;
				case "remove":
					items = tokens[1].split(",");
					cart.removeFromCart(new Item(items[0], Integer.parseInt(items[1])));
					break;
				case "show":
					cart.showCart();
					break;
				case "totalAmount":
					System.out.println("totalAmount: " + cart.getTotalAmount());
					break;
				case "payableAmount":
					System.out.println("Payable amount: " + cart.getPayableAmount());
					break;
				case "catalog":
					cart.showCatalog();
					break;
				case "coupon":
					cart.isCoupon(tokens[1]);
					break;
				case "print":
					cart.printInvoice();
					break;
				default:
			}
		}
	}
}
