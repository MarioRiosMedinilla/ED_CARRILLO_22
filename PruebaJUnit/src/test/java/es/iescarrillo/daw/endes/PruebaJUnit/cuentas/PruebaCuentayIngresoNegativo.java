package es.iescarrillo.daw.endes.PruebaJUnit.cuentas;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

public class PruebaCuentayIngresoNegativo {
	    @Test
	    public void testIngresoPositivo() throws IngresoNegativoException {
	        Cuenta cuenta = new Cuenta("1234", "Juan Perez");
	        cuenta.ingresar("Salario", 1000.0);
	        assertThat(cuenta.getSaldo(), equalTo(1000.0));
	    }

	    @Test
	    public void testIngresoNegativo() {
	        Cuenta cuenta = new Cuenta("1234", "Juan Perez");
	        try {
	            cuenta.ingresar("Deuda", -100.0);
	        } catch (IngresoNegativoException e) {
	            assertThat(e.getMessage(), equalTo("No se puede ingresar una cantidad negativa"));
	        }
	    }

	    @Test
	    public void testRetiroPositivo() throws IngresoNegativoException, SaldoInsuficienteException {
	        Cuenta cuenta = new Cuenta("1234", "Juan Perez");
	        cuenta.ingresar("Salario", 1000.0);
	        cuenta.retirar("Alquiler", 500.0);
	        assertThat(cuenta.getSaldo(), equalTo(500.0));
	    }

	    @Test
	    public void testRetiroNegativo() throws IngresoNegativoException, SaldoInsuficienteException {
	        Cuenta cuenta = new Cuenta("1234", "Juan Perez");
	        cuenta.ingresar("Salario", 1000.0);
	        try {
	            cuenta.retirar("Deuda", -100.0);
	        } catch (IngresoNegativoException e) {
	            assertThat(e.getMessage(), equalTo("No se puede retirar una cantidad negativa"));
	        }
	    }

	    @Test
	    public void testSaldoInsuficiente() throws IngresoNegativoException {
	        Cuenta cuenta = new Cuenta("1234", "Juan Perez");
	        cuenta.ingresar("Salario", 1000.0);
	        try {
	            cuenta.retirar("Alquiler", 1500.0);
	        } catch (SaldoInsuficienteException e) {
	            assertThat(e.getMessage(), equalTo("Saldo insuficiente"));
	            assertThat(cuenta.getSaldo(), equalTo(1000.0));
	        }
	    }
	}
