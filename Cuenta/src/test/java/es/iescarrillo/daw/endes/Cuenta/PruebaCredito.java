package es.iescarrillo.daw.endes.Cuenta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PruebaCredito {
	 private Credito credito;
	    private Cuenta cuenta;

	    @BeforeEach
	    void setUp() {
	        cuenta = new Cuenta("1234", "Juan Pérez");
	        credito = new Credito("5678", "Juan Pérez", new Date(), 1000.0);
	        credito.setCuenta(cuenta);
	    }

	    @Test
	    void testRetirar() throws Exception {
	        credito.retirar(100.0);
	        assertEquals(93.0, credito.getCreditoDisponible(), 0.001);
	    }

	    @Test
	    void testRetirarConComisionMinima() throws Exception {
	        credito.retirar(50.0);
	        assertEquals(947.5, credito.getCreditoDisponible(), 0.001);
	    }

	    @Test
	    void testRetirarConCreditoInsuficiente() {
	        assertThrows(Exception.class, () -> credito.retirar(1100.0));
	    }

	    @Test
	    void testIngresar() throws Exception {
	        credito.ingresar(100.0);
	        assertEquals(100.0, cuenta.getSaldo(), 0.001);
	    }

	    @Test
	    void testPagoEnEstablecimiento() throws Exception {
	        credito.pagoEnEstablecimiento("Tienda de ropa", 50.0);
	        assertEquals(50.0, credito.getSaldo(), 0.001);
	    }

	    @Test
	    void testGetSaldo() throws Exception {
	        credito.retirar(100.0);
	        credito.pagoEnEstablecimiento("Tienda de ropa", 50.0);
	        assertEquals(-53.0, credito.getSaldo(), 0.001);
	    }

	    @Test
	    void testGetCreditoDisponible() throws Exception {
	        credito.retirar(100.0);
	        assertEquals(900.0, credito.getCreditoDisponible(), 0.001);
	    }

	    @Test
        public void testLiquidar() throws Exception {
            Credito c = new Credito("1234-5678-9012-3456", "Juan Perez", new Date(), 1000.0);
            c.pagoEnEstablecimiento("Supermercado", 50.0);
            c.liquidar(1, 2023);
            assertEquals(0.0, c.getSaldo());
        }

	}