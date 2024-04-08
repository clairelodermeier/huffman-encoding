
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class FrequencyTableTest {

	@Test
	void testOneChar() {
		FrequencyTable ft = new FrequencyTable(1);
		ft.add('a');
		assertEquals(1, ft.get('a').freq);
	}
	
	@Test
	void testSameChar() {
		FrequencyTable ft = new FrequencyTable(7);
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
		FrequencyTable ft = new FrequencyTable(2);
		ft.add('a');
		ft.add('b');
		assertEquals(0.5, ft.get('a').freq);
		assertEquals(0.5, ft.get('b').freq);		

	}

	@Test
	void testTenChars() {
		FrequencyTable ft = new FrequencyTable(10);
		ft.add('a');
		ft.add('b');
		ft.add('c');
		ft.add('d');
		ft.add('e');
		ft.add('f');
		ft.add('g');
		ft.add('h');
		ft.add('i');
		ft.add('j');

		assertEquals(0.1, ft.get('a').freq);
		assertEquals(0.1, ft.get('b').freq);		

	}
	
	@Test
	void testNoChars() {
		FrequencyTable ft = new FrequencyTable(0);
		assertEquals(null, ft.get('a'));

	}
	
	@Test
	void testNotFound() {
		FrequencyTable ft = new FrequencyTable(5);
		ft.add('a');
		ft.add('b');
		ft.add('c');
		ft.add('d');
		ft.add('e');
		assertEquals(null, ft.get('f'));

	}
	
	@Test
	void testOtherChars() {
		FrequencyTable ft = new FrequencyTable(9);
		ft.add('9');
		ft.add('*');
		ft.add(')');
		ft.add('@');
		ft.add('?');
		ft.add('&');
		ft.add('<');
		ft.add('.');
		ft.add(' ');
		
		assertEquals((1.0/9.0), ft.get('9').freq);
		assertEquals((1.0/9.0), ft.get('@').freq);
		assertEquals((1.0/9.0), ft.get('.').freq);
		assertEquals((1.0/9.0), ft.get(' ').freq);

		assertEquals(null, ft.get('f'));

	}


}
