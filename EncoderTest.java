import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;


/*
 * JUnit tests for the Huffman encoding process. 
 * 
 * @author Claire Lodermeier
 */

class EncoderTest {

    @Test
    void testAbc() throws IOException {
        Encoder enc = new Encoder("abc.txt");
    }

    @Test
    void testYoga() throws IOException {
        Encoder enc = new Encoder("yoga.txt");
    }

    @Test
    void testAusten() throws IOException {
        Encoder enc = new Encoder("austen.txt");
    }
    
    @Test
    void testEmpty() throws IOException {
    
        //FrequencyCalculator calc = new FrequencyCalculator("empty.txt");
        //Encoder enc = new Encoder(calc.getFileContent());
    }
}
