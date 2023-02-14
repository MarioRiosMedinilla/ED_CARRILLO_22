package es.iescarrillo.daw.endes.Videojuegos;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Testserie {
	  @Test
	  public void testSerie() {
	    Serie serie = new Serie();
	    serie.setTitulo("Breaking Bad");
	    serie.setnumeroTemporadas(5);
	    serie.setGenero("Drama");
	    serie.setcreador("Vince GILLIGAN");
	    serie.entregar();

	    assertEquals("Breaking Bad", serie.getTitulo());
	    assertEquals(5, serie.getnumeroTemporadas());
	    assertEquals("Drama", serie.getGenero());
	    assertEquals("VINCE GILLIGAN", serie.getcreador());
	    assertEquals(true, serie.isEntregado());
	  }

	  @Test
	  public void testCompareTo() {
	    Serie serie1 = new Serie();
	    serie1.setnumeroTemporadas(3);

	    Serie serie2 = new Serie();
	    serie2.setnumeroTemporadas(5);

	    assertEquals(-1, serie1.compareTo(serie2));
	    assertEquals(0, serie1.compareTo(serie1));
	    assertEquals(1, serie2.compareTo(serie1));
	  }
	}
