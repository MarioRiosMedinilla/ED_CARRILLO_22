package es.iescarrillo.daw.endes.PruebaJUnit.cuentas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PruebaDeCuentayMovimiento {
	    private Cuenta cuenta;

	    @BeforeEach
	    public void setUp() {
	        cuenta = new Cuenta("1234", "Juan Perez");
	    }

	    @Test
	    public void testIngresar() throws IngresoNegativoException {
	        cuenta.ingresar("Salario", 1000.0);
	        Assertions.assertEquals(1000.0, cuenta.getSaldo());
	    }

	    @Test
	    public void testRetirar() throws IngresoNegativoException, SaldoInsuficienteException {
	        cuenta.ingresar("Salario", 1000.0);
	        cuenta.retirar("Alquiler", 500.0);
	        Assertions.assertEquals(500.0, cuenta.getSaldo());
	    }

	    @Test
	    public void testRetirarConSaldoInsuficiente() {
	        Assertions.assertThrows(SaldoInsuficienteException.class, () -> cuenta.retirar("Alquiler", 500.0));
	    }

	    @Test
	    public void testIngresarNegativo() {
	        Assertions.assertThrows(IngresoNegativoException.class, () -> cuenta.ingresar("Salario", -100.0));
	    }

	    @Test
	    public void testRetirarNegativo() {
	        Assertions.assertThrows(IngresoNegativoException.class, () -> cuenta.retirar("Alquiler", -100.0));
	    }

	    @Test
	    public void testGetSaldo() throws IngresoNegativoException, SaldoInsuficienteException {
	        cuenta.ingresar("Salario", 1000.0);
	        cuenta.ingresar("Bonus", 500.0);
	        cuenta.retirar("Alquiler", 750.0);
	        Assertions.assertEquals(750.0, cuenta.getSaldo());
	    }
	    @Test
	    public void testAddMovimiento() {
	        Movimiento m1 = new Movimiento();
	        m1.setConcepto("Ingreso");
	        m1.setImporte(1000.0);
	        cuenta.addMovimiento(m1);
	        Assertions.assertEquals(1000.0, cuenta.getSaldo());
	        
	        Movimiento m2 = new Movimiento();
	        m2.setConcepto("Retiro");
	        m2.setImporte(-500.0);
	        cuenta.addMovimiento(m2);
	        Assertions.assertEquals(500.0, cuenta.getSaldo());
	    }
	    
	    @Test
	    public void testGetSaldoSinMovimientos() {
	        Assertions.assertEquals(0.0, cuenta.getSaldo());
	    }
	    
	    @Test
	    public void testRetirarConSaldoJusto() throws IngresoNegativoException, SaldoInsuficienteException {
	        cuenta.ingresar("Salario", 1000.0);
	        cuenta.retirar("Alquiler", 1000.0);
	        Assertions.assertEquals(0.0, cuenta.getSaldo());
	    }
	    
	}
