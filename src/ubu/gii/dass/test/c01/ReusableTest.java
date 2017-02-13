package ubu.gii.dass.test.c01;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ubu.gii.dass.c01.Reusable;

public class ReusableTest {

	/**
	 * Test method for
	 * {@link ubu.gii.dass.c01.Reusable#util(ubu.gii.dass.c01.Reusable)}.
	 * 
	 * Descripcion: Comprobamos que al devolvernos una cadena contenga una subcadena especifica..
	 * Entrada: un nuevo objeto reusable.
	 * Salida: true o false en funcion de si es correcto o no.
	 */
	@Test
	public void utilTest() {
		Reusable re = new Reusable();
		assertTrue(re.util().contains("  :Uso del objeto Reutilizable"));
	}

}
