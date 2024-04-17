
import java.io.IOException;
import java.util.Scanner;

/*
 * Client side code for testing Huffman Encoding with an input file. 
 * 
 * @author Claire Lodermeier
 */

public class HuffmanEncoding {

	public static void main(String[] args) throws IOException {

		// prompt for input
		Scanner k = new Scanner(System.in);
		System.out.print("Input file name: ");
		String fileName = k.next();

		// encode the file
		System.out.println("Encoding file... ");
		Encoder enc = new Encoder(fileName);
		System.out.println("Original Text: " + enc.getTree().getBuildTable().getFileContent());
		String encodedStr = enc.getEncodedString();
		System.out.println("Encoded string: " + encodedStr);

		// prompt for decode
		System.out.print("Would you like to decode? [yes/no]: ");
		String answer = k.next();
		if (answer.equals("yes")) {
			Decoder dec = new Decoder(encodedStr, enc.getTree());
			System.out.println("Decoded Text: " + dec.getOriginalString());
		}
		k.close();

	}

}
