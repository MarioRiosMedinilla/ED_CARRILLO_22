package es.iescarrillo.daw.endes.Videojuegos;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

public class VideojuegoTest {

	  @Test
	  public void testGetTitulo() {
	    Videojuego videojuego = new Videojuego();
	    videojuego.setTitulo("Super Mario Bros");
	    assertThat(videojuego.getTitulo(), equalTo("Super Mario Bros"));
	  }

	  @Test
	  public void testGetHorasEstimadas() {
	    Videojuego videojuego = new Videojuego();
	    videojuego.setHorasEstimadas(10);
	    assertThat(videojuego.getHorasEstimadas(), equalTo(10));
	  }

	  @Test
	  public void testGetGenero() {
	    Videojuego videojuego = new Videojuego();
	    videojuego.setGenero("Plataformas");
	    assertThat(videojuego.getGenero(), equalTo("Plataformas"));
	  }

	  @Test
	  public void testGetCompania() {
	    Videojuego videojuego = new Videojuego();
	    videojuego.setcompania("Nintendo");
	    assertThat(videojuego.getcompania(), equalTo("Nintendo"));
	  }

	  @Test
	  public void testEntregar() {
	    Videojuego videojuego = new Videojuego();
	    videojuego.entregar();
	    assertThat(videojuego.isEntregado(), equalTo(true));
	  }

	  @Test
	  public void testDevolver() {
	    Videojuego videojuego = new Videojuego();
	    videojuego.entregar();
	    videojuego.devolver();
	    assertThat(videojuego.isEntregado(), equalTo(false));
	  }

	  @Test
	  public void testCompareTo() {
	    Videojuego videojuego1 = new Videojuego();
	    videojuego1.setHorasEstimadas(10);
	    Videojuego videojuego2 = new Videojuego();
	    videojuego2.setHorasEstimadas(20);
	    assertThat(videojuego1.compareTo(videojuego2), equalTo(-1));
	  }
	}