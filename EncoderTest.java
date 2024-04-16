import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;


/*
 * JUnit tests for Encoder class.
 * @author Claire Lodermeier
 */

class EncoderTest {

    @Test
    void testAbc() throws IOException {
        FrequencyCalculator calc = new FrequencyCalculator("abc.txt");
        Encoder enc = new Encoder(calc.getFileContent());
    }

    @Test
    void testYoga() throws IOException {
        FrequencyCalculator calc = new FrequencyCalculator("yoga.txt");
        Encoder enc = new Encoder(calc.getFileContent());
    }

    @Test
    void testAusten() throws IOException {
        FrequencyCalculator calc = new FrequencyCalculator("austen.txt");
        Encoder enc = new Encoder(calc.getFileContent());
    }
}
