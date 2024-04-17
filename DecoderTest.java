
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

/*
 * 
 * JUnit tests for the Huffman encoding and decoding process. 
 * 
 * @author Claire Lodermeier
 */

class DecoderTest {

	@Test
	void testAbc() throws IOException {
		// encode file
		Encoder enc = new Encoder("abc.txt");
		String encodedStr = enc.getEncodedString();

		// decode the binary encoded string
		Decoder dec = new Decoder(encodedStr, enc.getTree());
		assertEquals(dec.getOriginalString(), enc.getTree().getBuildTable().getFileContent());

	}

}
