package es.iescarrillo.daw.endes.Videojuegos;

public interface Entregable {
	  
    public void entregar();
  
    public void devolver();
  
    public boolean isEntregado();
  
    public int compareTo(Object a);
}