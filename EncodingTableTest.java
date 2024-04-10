import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EncodingTableTest {

	@Test
	void testAbc() {
		EncodingTable encTable = new EncodingTable();
		assertEquals(encTable.getSize(), 0);
		
		encTable.add('a', "101");
		assertEquals(encTable.get('b'), null);
		
		assertEquals(encTable.getSize(),1);

		assertEquals(encTable.get('a').getPath(), "101");
		assertEquals(encTable.get('a').getCharacter(), 'a');

		encTable.add('b', "1011");
		assertEquals(encTable.get('b').getPath(), "1011");
		encTable.add('c', "0");
		assertEquals(encTable.get('c').getPath(), "0");
		assertEquals(encTable.get('c').getCharacter(), 'c'                                           );

		
		assertEquals(encTable.getSize(),3);

		encTable.add('d', "1011");
		assertEquals(encTable.get('d').getPath(), "1011");
		encTable.add('e', "0");
		assertEquals(encTable.get('e').getPath(), "0");
		assertEquals(encTable.get('b').getPath(), "1011");
		
		assertEquals(encTable.getSize(),5);
		
		encTable.get('a').setPath("111");
		assertEquals(encTable.get('a').getPath(), "111");
		assertEquals(encTable.getSize(),5);


		


		
	}

}
