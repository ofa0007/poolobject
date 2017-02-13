package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.junit.Test;

import ubu.gii.dass.c01.Client;
import ubu.gii.dass.c01.DuplicatedInstanceException;
import ubu.gii.dass.c01.NotFreeInstanceException;

public class ClientTest {
	
	/**
	 * Test method for
	 * {@link ubu.gii.dass.c01.Client#main(ubu.gii.dass.c01.Client)}.
	 * 
	 * Descripcion: Comprobamos que una ejecución sin argumentos del main en client no da excepciones.
	 * Entrada: Ninguna.
	 * Salida: Sin excepciones.
	 */
	@Test
	public void mainTest() {
		try {
			Client.main(null);
		} catch (NotFreeInstanceException | DuplicatedInstanceException e) {
			assertTrue(false);
		}
		assertTrue(true);
	}

}
