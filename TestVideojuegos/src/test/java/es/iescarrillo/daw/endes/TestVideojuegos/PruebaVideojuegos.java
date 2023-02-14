package es.iescarrillo.daw.endes.TestVideojuegos;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class PruebaVideojuegos {

	  @Test
	  public void testGetTitulo() {
	    Videojuego videojuego = new Videojuego();
	    videojuego.setTitulo("Titulo del videojuego");
	    assertThat(videojuego.getTitulo(), is("Titulo del videojuego"));
	  }

	  @Test
	  public void testGetHorasEstimadas() {
	    Videojuego videojuego = new Videojuego();
	    videojuego.setHorasEstimadas(10);
	    assertThat(videojuego.getHorasEstimadas(), is(10));
	  }

	  @Test
	  public void testGetGenero() {
	    Videojuego videojuego = new Videojuego();
	    videojuego.setGenero("Accion");
	    assertThat(videojuego.getGenero(), is("Accion"));
	  }

	  @Test
	  public void testGetCompania() {
	    Videojuego videojuego = new Videojuego();
	    videojuego.setcompania("Compania");
	    assertThat(videojuego.getcompania(), is("Compania"));
	  }

	  @Test
	  public void testIsEntregado() {
	    Videojuego videojuego = new Videojuego();
	    videojuego.entregar();
	    assertThat(videojuego.isEntregado(), is(true));
	  }

	  @Test
	  public void testCompareTo() {
	    Videojuego videojuego1 = new Videojuego();
	    videojuego1.setHorasEstimadas(10);
	    Videojuego videojuego2 = new Videojuego();
	    videojuego2.setHorasEstimadas(20);
	    assertThat(videojuego1.compareTo(videojuego2), is(-1));
	  }

	}


