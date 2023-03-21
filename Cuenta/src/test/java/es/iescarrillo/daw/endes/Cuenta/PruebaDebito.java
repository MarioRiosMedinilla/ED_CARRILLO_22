package es.iescarrillo.daw.endes.Cuenta;

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.sql.Date;

public class PruebaDebito {		
        private double saldo = 1000.0;
        
        @Test
        public void retirar(String concepto, double cantidad) throws Exception {
            if (cantidad > saldo) {
                throw new Exception("Saldo insuficiente");
            }
            saldo -= cantidad;
        }

        @Test
        public void ingresar(String concepto, double cantidad) throws Exception {
            saldo += cantidad;
        }

        @Test
        public double getSaldo() {
            return saldo;
        }
}
