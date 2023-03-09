package es.iescarrillo.daw.endes.PruebaJUnit.cuentas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PruebaDeCuentaySaldoinsuficiente {
	    @Test
	    void testIngresoNegativoException() {
	        Cuenta cuenta = new Cuenta("123456789", "Juan Perez");
	        assertThrows(IngresoNegativoException.class, () -> cuenta.ingresar("Ingreso negativo", -100));
	    }

	    @Test
	    void testSaldoInsuficienteException() throws IngresoNegativoException {
	        Cuenta cuenta = new Cuenta("123456789", "Juan Perez");
	        cuenta.ingresar("Ingreso", 500);
	        assertThrows(SaldoInsuficienteException.class, () -> cuenta.retirar("Retiro", 600));
	    }

	    @Test
	    void testIngreso() throws IngresoNegativoException {
	        Cuenta cuenta = new Cuenta("123456789", "Juan Perez");
	        cuenta.ingresar("Ingreso", 500);
	        assertEquals(500, cuenta.getSaldo(), 0.01);
	    }

	    @Test
	    void testRetiro() throws IngresoNegativoException, SaldoInsuficienteException {
	        Cuenta cuenta = new Cuenta("123456789", "Juan Perez");
	        cuenta.ingresar("Ingreso", 500);
	        cuenta.retirar("Retiro", 300);
	        assertEquals(200, cuenta.getSaldo(), 0.01);
	    }
	}
