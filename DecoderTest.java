import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class DecoderTest {

	@Test
	void testAbc() throws IOException {
		Encoder enc = new Encoder("abc.txt");
		HuffmanTree ht = new HuffmanTree();
		String encodedStr = enc.getEncodedString();
		Decoder dec = new Decoder(encodedStr, ht);
		System.out.println(dec.getOriginalString());
		
	}

}
