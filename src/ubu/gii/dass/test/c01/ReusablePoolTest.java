/**
 * 
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ubu.gii.dass.c01.NotFreeInstanceException;
import ubu.gii.dass.c01.ReusablePool;

/**
 * @author alumno
 *
 */
public class ReusablePoolTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 * 
	 * Descripcion: Comprobamos que getInstance nos devuelva una instancia y que sea la misma si lo llamamos varias veces
	 * Entrada: No hay
	 * Salida: Una instancia no nula y que sea igual entre llamadas.
	 */
	@Test
	public void testGetInstance() {
		ReusablePool rp = ReusablePool.getInstance();
		assertTrue(rp != null);
		assertTrue(rp == ReusablePool.getInstance());
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 * 
	 * Descripcion: comprobamos que haya objetos reusables y comprobamos que cuando no haya salte la excepcion.
	 * datos entrada: instance ReusablePool.
	 * datos salida: comprobamos que haya al menos un reusable y comprobamos que salte la excepcion.
	 */
	@Test
	public void testAcquireReusable() {
		ReusablePool rp = ReusablePool.getInstance();
		boolean reusable = false;
		boolean emptyPool = false;
		try {
			while (true) {
				assertTrue(rp.acquireReusable() != null);
				reusable = true;
			}
		} catch (NotFreeInstanceException e) {
			emptyPool = true;
		}
		assertTrue(reusable);
		assertTrue(emptyPool);
	}

	/**
	 * Test method for
	 * {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		fail("Not yet implemented");
	}

}
