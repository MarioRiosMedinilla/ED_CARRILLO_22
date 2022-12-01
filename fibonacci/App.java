package es.iescarrillo.daw.endes.fibonacci;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Scanner teclado;

	public static void main( String[] args )
    {
		  teclado = new Scanner(System.in);
	      
	      int a = 0, b = 1, c, n;
	     
	      System.out.print("Por favor ingrese cantidad de elmentos para la serie: ");
	      n = teclado.nextInt();
	     
	      for (int i = 0; i < n; i++) {
	          System.out.println(a);
	          c = a + b;
	          a = b;
	          b = c;
	      }
	  }
	}
