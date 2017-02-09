/**
 * 
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ubu.gii.dass.c01.DuplicatedInstanceException;
import ubu.gii.dass.c01.NotFreeInstanceException;
import ubu.gii.dass.c01.ReusablePool;
import ubu.gii.dass.c01.Reusable;

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
	 * 
	 * Descripcion: Comprobamos que releaseReusable funciona y que no se puede liberar un recurso ya liberado.
	 * Entrada: getInstance y acquireReusable tienen que funcionar.
	 * Salida: releaseReusable tiene que funcionar una vez y a la segunda con el mismo reusable lanzar una excepcion.
	 */
	@Test
	public void testReleaseReusable() {
		boolean excep = false;
		boolean release = false;
		ReusablePool rp = ReusablePool.getInstance();
		Reusable r = null;
		try {
			r = rp.acquireReusable();
		} catch (NotFreeInstanceException e) {
			assertTrue(false);
		}
		try {
			rp.releaseReusable(r);
			release = true;
			rp.releaseReusable(r);
		} catch (DuplicatedInstanceException e) {
			excep = true;			
		}
		assertTrue(release);
		assertTrue(excep);
	}

}
