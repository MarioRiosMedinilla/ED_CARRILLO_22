package es.iescarrillo.daw.endes.Cuenta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PruebaCuenta {		    
	@Test
    public void ingresarMontoPositivoIncrementaSaldo() throws Exception {
        Cuenta cuenta = new Cuenta("1234", "Juan");
        double saldoInicial = cuenta.getSaldo();
        cuenta.ingresar(50);
        double saldoFinal = cuenta.getSaldo();
        assertEquals(saldoInicial + 50, saldoFinal, 0.001);
    }
    
    @Test
    public void retirarMontoPositivoDecrementaSaldo() throws Exception {
        Cuenta cuenta = new Cuenta("1234", "Juan");
        cuenta.ingresar(100);
        double saldoInicial = cuenta.getSaldo();
        cuenta.retirar(50);
        double saldoFinal = cuenta.getSaldo();
        assertEquals(saldoInicial - 50, saldoFinal, 0.001);
    }
    
    @Test
    public void agregarMovimientoIncrementaTamanioVector() {
        Cuenta cuenta = new Cuenta("1234", "Juan");
        Movimiento m = new Movimiento();
        m.setConcepto("Pago de factura");
        m.setImporte(-50);
        int tamInicial = cuenta.mMovimientos.size();
        cuenta.addMovimiento(m);
        int tamFinal = cuenta.mMovimientos.size();
        assertEquals(tamInicial + 1, tamFinal);
    }
    
    @Test
    public void saldoInicialEsCero() {
        Cuenta cuenta = new Cuenta("1234", "Juan");
        assertEquals(0, cuenta.getSaldo(), 0.001);
    }
    
    @Test
    public void saldoEsCorrecto() throws Exception {
    	Cuenta cuenta = new Cuenta("1234", "Juan");
    	cuenta.ingresar(100);
    	cuenta.retirar(50);
    	cuenta.ingresar(25);
    	assertEquals(75, cuenta.getSaldo(), 0.001);
    	}
    
    @Test
    public void agregarMovimientoEsCorrecto() {
    	Cuenta cuenta = new Cuenta("1234", "Juan");
    	Movimiento m = new Movimiento();
    	m.setConcepto("Pago de factura");
    	m.setImporte(-50);
    	cuenta.addMovimiento(m);
    	assertEquals(-50, cuenta.getSaldo(), 0.001);
    	}
    }
