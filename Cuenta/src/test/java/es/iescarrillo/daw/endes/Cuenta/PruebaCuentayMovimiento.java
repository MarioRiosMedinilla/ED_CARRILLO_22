package es.iescarrillo.daw.endes.Cuenta;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class PruebaCuentayMovimiento {

    @Test
    public void testIngreso() throws Exception {
        Cuenta cuenta = new Cuenta("123", "Juan");
        cuenta.ingresar(100);
        assertEquals(100, cuenta.getSaldo(), 0.01);
    }

    @Test
    public void testRetirada() throws Exception {
        Cuenta cuenta = new Cuenta("123", "Juan");
        cuenta.ingresar(100);
        cuenta.retirar(50);
        assertEquals(50, cuenta.getSaldo(), 0.01);
    }

    @Test
    public void testIngresoNegativo() {
        Cuenta cuenta = new Cuenta("123", "Juan");
        Exception exception = assertThrows(Exception.class, () -> cuenta.ingresar(-100));
        assertEquals("No se puede ingresar una cantidad negativa", exception.getMessage());
    }

    @Test
    public void testRetiradaNegativa() {
        Cuenta cuenta = new Cuenta("123", "Juan");
        Exception exception = assertThrows(Exception.class, () -> cuenta.retirar(-100));
        assertEquals("No se puede retirar una cantidad negativa", exception.getMessage());
    }

    @Test
    public void testRetiradaSaldoInsuficiente() throws Exception {
        Cuenta cuenta = new Cuenta("123", "Juan");
        cuenta.ingresar(100);
        Exception exception = assertThrows(Exception.class, () -> cuenta.retirar(150));
        assertEquals("Saldo insuficiente", exception.getMessage());
    }

    @Test
    public void testIngresoConConcepto() throws Exception {
        Cuenta cuenta = new Cuenta("123", "Juan");
        cuenta.ingresar("Ingreso por transferencia", 200);
        assertEquals(200, cuenta.getSaldo(), 0.01);
    }

    @Test
    public void testRetiradaConConcepto() throws Exception {
        Cuenta cuenta = new Cuenta("123", "Juan");
        cuenta.ingresar(200);
        cuenta.retirar("Retirada en cajero", 50);
        assertEquals(150, cuenta.getSaldo(), 0.01);
    }

}


