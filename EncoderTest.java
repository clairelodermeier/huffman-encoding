

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
        System.out.println("Encoded string: " + enc.getEncodedString());
    }

    @Test
    void testYoga() throws IOException {
        Encoder enc = new Encoder("yoga.txt");
        System.out.println("Encoded string: " + enc.getEncodedString());

    }

    @Test
    void testAusten() throws IOException {
        Encoder enc = new Encoder("austen.txt");
        System.out.println("Encoded string: " + enc.getEncodedString());

    }
    
}
