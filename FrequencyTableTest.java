
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class FrequencyTableTest {

	@Test
	void testOneChar() {
		FrequencyTable ft = new FrequencyTable();
		ft.add('a');
		assertEquals(1, ft.get('a').freq);
	}
	
	@Test
	void testSameChar() {
		FrequencyTable ft = new FrequencyTable();
		ft.add('a');
		ft.add('a');
		ft.add('a');
		ft.add('a');
		ft.add('a');
		ft.add('a');
		ft.add('a');
		assertEquals(1, ft.get('a').freq);		

	}
	
	@Test
	void testTwoChars() {
		FrequencyTable ft = new FrequencyTable();
		ft.add('a');
		ft.add('b');
		assertEquals(0.5, ft.get('a').freq);
		assertEquals(0.5, ft.get('b').freq);		

	}


}
