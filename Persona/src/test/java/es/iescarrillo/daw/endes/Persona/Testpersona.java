package es.iescarrillo.daw.endes.Persona;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import  org.junit.jupiter.api.Assertions;
import  org.junit.jupiter.api.Test;
public class Testpersona {

	Persona p1 = new Persona ("Mario", 11, 'H', 65, 1.75);
	Persona p2 = new Persona ("Manoli", 14, 'M', 70, 1.54);
	Persona p3 = new Persona ("Pablo", 13, 'H', 55, 1.73);
	Persona p4 = new Persona ("Alberto", 14, 'H', 85, 1.56);
	Persona p5 = new Persona ("Alejandra", 15, 'M', 75, 1.85);
	Persona p6 = new Persona ("Sofia", 17, 'M', 65, 1.55);
	
		@Test
		void test() {
			
			assertFalse(p1.esMayorDeEdad());
		}
		
		
		@Test
		void testIMC_P1() {
			
			Assertions.assertEquals(1, p2.calcularIMC());
		}
		
		@Test
		void testIMC_P2() {
			
			Assertions.assertEquals(1, p2.calcularIMC());
		}
		
		@Test
		void testIMC_P3() {
			
			Assertions.assertEquals(1, p2.calcularIMC());
		}
		
		@Test
		void testIMC_P4() {
			
			Assertions.assertEquals(1, p4.calcularIMC());
		}
		
		
		@Test
		void testIMC_P5() {
			
			Assertions.assertEquals(1, p2.calcularIMC());
		}
		
		@Test
		void testIMC_P6() {
			
			Assertions.assertEquals(1, p6.calcularIMC());
		}
		
		@Test
		void test1() {
			
			assertFalse(p2.esMayorDeEdad());
		}
		
		
}
