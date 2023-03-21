package es.iescarrillo.daw.endes.Cuenta;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PruebaTarjeta { 
	  private Credito credito;
	  private Cuenta cuentaAsociada;
	 
	    @BeforeEach
	    public void setUp() {
	        cuentaAsociada = new Cuenta("1234567890", "Juan Pérez");
	        credito = new Credito("1111222233334444", "Juan Pérez", new Date(0), 1000.0);
	        credito.setCuenta(cuentaAsociada);
	    }

	    @Test
	    public void testRetirar1() throws Exception {
	        credito.retirar(500.0);
	        assertEquals(500.0, credito.getSaldo());
	        assertEquals(500.0, credito.getCreditoDisponible());

	        Exception exception = assertThrows(Exception.class, () -> {
	            credito.retirar(600.0);
	        });
	        assertEquals("Crédito insuficiente", exception.getMessage());

	        credito.retirar(500.0);
	        assertEquals(1000.0, credito.getSaldo());
	        assertEquals(0.0, credito.getCreditoDisponible());
	    }

	    @Test
	    public void testIngresar1() throws Exception {
	        credito.ingresar(500.0);
	        assertEquals(500.0, credito.getSaldo());
	        assertEquals(500.0, credito.getCreditoDisponible());
	        assertEquals(500.0, cuentaAsociada.getSaldo());
	    }

	    @Test
	    public void testPagoEnEstablecimiento1() throws Exception {
	        credito.pagoEnEstablecimiento("Amazon", 200.0);
	        assertEquals(200.0, credito.getSaldo());
	        assertEquals(800.0, credito.getCreditoDisponible());
	    }

	    @Test
	    public void testGetSaldo1() throws Exception {
	        credito.retirar(500.0);
	        credito.ingresar(200.0);
	        credito.pagoEnEstablecimiento("Amazon", 100.0);
	        assertEquals(-400.0, credito.getSaldo());
	    }

	    @Test
	    public void testGetCreditoDisponible1() throws Exception {
	        credito.retirar(500.0);
	        assertEquals(500.0, credito.getCreditoDisponible());

	        credito.retirar(600.0);
	        assertEquals(0.0, credito.getCreditoDisponible());
	    }

	    @Test
	    public void testLiquidar1() throws Exception {
	        credito.retirar(500.0);
	        credito.ingresar(200.0);
	        credito.pagoEnEstablecimiento("Amazon", 100.0);

	        credito.liquidar(1, 2023);

	        assertEquals(0.0, credito.getSaldo());
	        assertEquals(1000.0, credito.getCreditoDisponible());
	        assertEquals(-400.0, cuentaAsociada.getSaldo());
	    }
}

