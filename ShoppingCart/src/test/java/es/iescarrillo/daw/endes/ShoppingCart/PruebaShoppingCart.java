package es.iescarrillo.daw.endes.ShoppingCart;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class PruebaShoppingCart { 

		@Test
		public void testInitialItemCount() {
			ShoppingCart cart = new ShoppingCart();
			assertEquals(0, cart.getItemCount());
		}
		
		@Test
		public void testEmptyCart() {
			ShoppingCart cart = new ShoppingCart();
			cart.empty();
			assertEquals(0, cart.getItemCount());
		}
		
		@Test
		public void testAddItem() {
			ShoppingCart cart = new ShoppingCart();
			Product product = new Product("Test product", 10.0);
			cart.addItem(product);
			assertEquals(1, cart.getItemCount());
			assertEquals(10.0, cart.getBalance());
		}
		
		@Test
		public void testRemoveItem() throws ProductNotFoundException {
			ShoppingCart cart = new ShoppingCart();
			Product product = new Product("Test product", 10.0);
			cart.addItem(product);
			cart.removeItem(product);
			assertEquals(0, cart.getItemCount());
		}
		
		@Test
		public void testRemoveItemNotFound() {
			ShoppingCart cart = new ShoppingCart();
			Product product = new Product("Test product", 10.0);
			assertThrows(ProductNotFoundException.class, () -> {
				cart.removeItem(product);
			});
		}
	}


