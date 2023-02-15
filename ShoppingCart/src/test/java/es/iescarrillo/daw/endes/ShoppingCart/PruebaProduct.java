package es.iescarrillo.daw.endes.ShoppingCart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PruebaProduct {


	private ShoppingCart cart;
	private Product product1;
	private Product product2;
	private Product product3;
	
	@BeforeEach
	public void setUp() {
		cart = new ShoppingCart();
		product1 = new Product("Camisa", 25.0);
		product2 = new Product("Pantalón", 35.0);
		product3 = new Product("Calcetines", 5.0);
	}

	@Test
	public void testConstructor() {
		assertEquals(0, cart.getItemCount());
		assertEquals(0.0, cart.getBalance(), 0.01);
	}

	@Test
	public void testAddItem() {
		cart.addItem(product1);
		assertEquals(1, cart.getItemCount());
		assertEquals(25.0, cart.getBalance(), 0.01);
		cart.addItem(product2);
		assertEquals(2, cart.getItemCount());
		assertEquals(60.0, cart.getBalance(), 0.01);
		cart.addItem(product3);
		assertEquals(3, cart.getItemCount());
		assertEquals(65.0, cart.getBalance(), 0.01);
	}

	@Test
	public void testRemoveItem() {
		cart.addItem(product1);
		cart.addItem(product2);
		cart.addItem(product3);
		try {
			cart.removeItem(product2);
		} catch (ProductNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		assertEquals(2, cart.getItemCount());
		assertEquals(30.0, cart.getBalance(), 0.01);
		try {
			cart.removeItem(new Product("Zapatos", 50.0));
			fail("Expected ProductNotFoundException to be thrown");
		} catch (ProductNotFoundException e) {
			// Expected exception to be thrown
		}
	}

	@Test
	public void testEmpty() {
		cart.addItem(product1);
		cart.addItem(product2);
		cart.addItem(product3);
		cart.empty();
		assertEquals(0, cart.getItemCount());
		assertEquals(0.0, cart.getBalance(), 0.01);
	}
}