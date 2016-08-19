import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CelularInversoTest {

	public void testV() {
		CelularInverso obj = new CelularInverso("V");
		assertEquals(8, obj.resolve());
	}

	public void testI() {
		CelularInverso obj = new CelularInverso("I");
		assertEquals(4, obj.resolve());
	}

	public void testVIVO() {
		CelularInverso obj = new CelularInverso("VIVO");
		assertEquals(8486, obj.resolve());
	}

	public void testABC() {
		CelularInverso obj = new CelularInverso("ABC");
		assertEquals(222, obj.resolve());
	}

	public void testDOJOMT() {
		CelularInverso obj = new CelularInverso("DOJOMT");
		assertEquals(365668, obj.resolve());
	}

	public void testHomeSweetHome() {
		CelularInverso obj = new CelularInverso("1-HOME-SWEET-HOME");
		assertEquals("1-4663-79338-4663", obj.resolve());
	}

	public void testLowerCase() {
		CelularInverso obj = new CelularInverso("home4241");
		assertEquals(46634241, obj.resolve());
	}

	public void testSpecialCharactersAllowed() {
		CelularInverso obj = new CelularInverso("#*35nk");
		assertEquals("#*3565", obj.resolve());
	}

	public void testSpaces() {
		CelularInverso obj = new CelularInverso("#*35 nk");
		assertEquals("#*35065", obj.resolve());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWithoutArgument() {
		new CelularInverso();
	}
}
