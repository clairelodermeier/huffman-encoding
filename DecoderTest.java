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
        FrequencyCalculator calc = new FrequencyCalculator("abc.txt");
        Encoder enc = new Encoder(calc.getFileContent());
        HuffmanTree ht = new HuffmanTree();
        String encodedStr = enc.getEncodedString();
        
        // decode the binary encoded string
        Decoder dec = new Decoder(encodedStr, ht);
        assertEquals(dec.getOriginalString(), calc.getFileContent());

    }

}
