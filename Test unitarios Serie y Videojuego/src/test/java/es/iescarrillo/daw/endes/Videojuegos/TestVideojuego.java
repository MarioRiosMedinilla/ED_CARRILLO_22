package es.iescarrillo.daw.endes.Videojuegos;

public class TestVideojuego {
		  public static void main(String[] args) {
		    Videojuego v1 = new Videojuego();
		    Videojuego v2 = new Videojuego();
		    
		    v1.setTitulo("Videojuego 1");
		    v1.setHorasEstimadas(150);
		    v1.setGenero("Acción");
		    v1.setcompania("Compañia A");
		    v1.entregar();
		    
		    v2.setTitulo("Videojuego 2");
		    v2.setHorasEstimadas(200);
		    v2.setGenero("Aventura");
		    v2.setcompania("Compañia B");
		    
		    System.out.println("Titulo v1: " + v1.getTitulo());
		    System.out.println("Horas Estimadas v1: " + v1.getHorasEstimadas());
		    System.out.println("Genero v1: " + v1.getGenero());
		    System.out.println("Compañia v1: " + v1.getcompania());
		    System.out.println("Entregado v1: " + v1.isEntregado());
		    
		    System.out.println("Titulo v2: " + v2.getTitulo());
		    System.out.println("Horas Estimadas v2: " + v2.getHorasEstimadas());
		    System.out.println("Genero v2: " + v2.getGenero());
		    System.out.println("Compañia v2: " + v2.getcompania());
		    System.out.println("Entregado v2: " + v2.isEntregado());
		  }
		}

