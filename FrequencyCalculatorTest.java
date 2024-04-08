import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;


/*
 * JUnit tests for FrequencyCalculator class. 
 * @author Claire Lodermeier
 */

class FrequencyCalculatorTest {

	@Test
	void testAbc() throws IOException {
		FrequencyCalculator calc = new FrequencyCalculator("abc.txt");
		FrequencyTable table = calc.table();
		assertEquals((1.0 / 26.0), table.get('a').freq);
		assertEquals((1.0 / 26.0), table.get('b').freq);
		assertEquals((1.0 / 26.0), table.get('c').freq);
		assertEquals((1.0 / 26.0), table.get('d').freq);
		assertEquals((1.0 / 26.0), table.get('e').freq);
		assertEquals((1.0 / 26.0), table.get('f').freq);
		assertEquals((1.0 / 26.0), table.get('g').freq);
		assertEquals((1.0 / 26.0), table.get('h').freq);
		assertEquals((1.0 / 26.0), table.get('i').freq);
		assertEquals((1.0 / 26.0), table.get('j').freq);
		assertEquals((1.0 / 26.0), table.get('k').freq);
		assertEquals((1.0 / 26.0), table.get('l').freq);
		assertEquals((1.0 / 26.0), table.get('m').freq);
		assertEquals((1.0 / 26.0), table.get('n').freq);
		assertEquals((1.0 / 26.0), table.get('o').freq);
		assertEquals((1.0 / 26.0), table.get('p').freq);
		assertEquals((1.0 / 26.0), table.get('q').freq);
		assertEquals((1.0 / 26.0), table.get('r').freq);
		assertEquals((1.0 / 26.0), table.get('s').freq);
		assertEquals((1.0 / 26.0), table.get('t').freq);
		assertEquals((1.0 / 26.0), table.get('u').freq);
		assertEquals((1.0 / 26.0), table.get('v').freq);
		assertEquals((1.0 / 26.0), table.get('w').freq);
		assertEquals((1.0 / 26.0), table.get('x').freq);
		assertEquals((1.0 / 26.0), table.get('y').freq);
		assertEquals((1.0 / 26.0), table.get('z').freq);
		assertEquals(null, table.get('='));

	}

	@Test
	void testAusten() throws IOException {
		FrequencyCalculator calc = new FrequencyCalculator("austen.txt");
		FrequencyTable table = calc.table();
		assertEquals((3.0 / 5598.0), table.get('J').freq);
		assertEquals((1100.0 / 5598.0), table.get(' ').freq);
		assertEquals((77.0 / 5598.0), table.get('.').freq);
		assertEquals(null, table.get('='));

	}

	@Test
	void testYoga() throws IOException {
		FrequencyCalculator calc = new FrequencyCalculator("yoga.txt");
		FrequencyTable table = calc.table();
		assertEquals((280.0 / 1589.0), table.get(' ').freq);
		assertEquals((146.0 / 1589.0), table.get('e').freq);
		assertEquals((42.0 / 1589.0), table.get('y').freq);
		assertEquals(null, table.get('='));

	}

}
