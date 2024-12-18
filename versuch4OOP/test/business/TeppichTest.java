package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TeppichTest {

	private Teppich teppich;

	void test1() {
		assertThrows(IllegalArgumentException.class,() -> new Teppich(2, "fjj", 4, 4, null));
	}
	@Test
	void test() {
		this.teppich = new Teppich(2, "fjj", 4, 4, new String[] { "d", "jf"});
		assertTrue( () -> this.teppich.getArtikelNummer() == 2);
	}

}
