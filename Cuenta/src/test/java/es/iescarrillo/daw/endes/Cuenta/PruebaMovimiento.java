package es.iescarrillo.daw.endes.Cuenta;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
public class PruebaMovimiento {


	    @Test
	    public void testGetImporte() {
	        Movimiento movimiento = new Movimiento();
	        movimiento.setImporte(100.0);
	        assertThat(movimiento.getImporte(), equalTo(100.0));
	    }

	    @Test
	    public void testGetConcepto() {
	        Movimiento movimiento = new Movimiento();
	        movimiento.setConcepto("compra");
	        assertThat(movimiento.getConcepto(), equalTo("compra"));
	    }

	    @Test
	    public void testGetFecha() {
	        Movimiento movimiento = new Movimiento();
	        assertThat(movimiento.getFecha(), instanceOf(Date.class));
	    }

	    @Test
	    public void testSetConcepto() {
	        Movimiento movimiento = new Movimiento();
	        movimiento.setConcepto("compra");
	        assertThat(movimiento.getConcepto(), equalTo("compra"));
	        movimiento.setConcepto("venta");
	        assertThat(movimiento.getConcepto(), equalTo("venta"));
	    }

	    @Test
	    public void testSetFecha() {
	        Movimiento movimiento = new Movimiento();
	        Date fecha = new Date(123456789);
	        movimiento.setFecha(fecha);
	        assertThat(movimiento.getFecha(), equalTo(fecha));
	    }

	    @Test
	    public void testSetImporte() {
	        Movimiento movimiento = new Movimiento();
	        movimiento.setImporte(100.0);
	        assertThat(movimiento.getImporte(), equalTo(100.0));
	        movimiento.setImporte(200.0);
	        assertThat(movimiento.getImporte(), equalTo(200.0));
	    }
	}