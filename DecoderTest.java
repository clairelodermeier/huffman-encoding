import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class DecoderTest {

    @Test
    void testAbc() throws IOException {
        FrequencyCalculator calc = new FrequencyCalculator("abc.txt");
        Encoder enc = new Encoder(calc.getFileContent());
        HuffmanTree ht = new HuffmanTree();
        String encodedStr = enc.getEncodedString();
        Decoder dec = new Decoder(encodedStr, ht);
        System.out.println(dec.getOriginalString());

    }

}
