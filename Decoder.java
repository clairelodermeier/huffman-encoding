/**
 * @author Dawson Szarek Class to decode a binaryEncoded string back to the
 *         original ASCII string.
 */
public class Decoder {
	HuffmanTree tree;
	String originalString;
	String encodedString;

	// Given an encoded binary string and HuffmanTree will decode to orginal string.
	public Decoder(String encodedString, HuffmanTree tree) {
		this.encodedString = encodedString;
		this.tree = tree;
		decodeString();
	}

	// Returns the decoded original string
	public String getOriginalString() {
		return this.originalString;
	}

	/**
	 * Decodes the encoded string by traversing the huffman tree as the encoded
	 * String is traversed. Each time you hit a leaf node, append the character to
	 * the stringBuilder.
	 */
	private void decodeString() {
		StringBuilder stringBuilder = new StringBuilder();
		Node currNode = tree.root();

		try {
			// Iterate over the encoded binary string
			for (int i = 0; i < encodedString.length(); i++) {
				char ch = encodedString.charAt(i);
				// if ch is 0 traverse left
				if (ch == '0') {
					currNode = currNode.left;
				} else {
					// else traverse right
					currNode = currNode.right;
				}
				// If a leaf node append character
				if (currNode.left == null && currNode.right == null) {
					stringBuilder.append(currNode.getVal()); // append char to stringBuilder
					currNode = tree.root(); // reset currNode to root of Huffman Tree
				}
			}

			// Set originalString to the decoded stringBuilder
			originalString = stringBuilder.toString();
		} catch (Exception e) {
			// If Exception thrown, report a mismatch between the encoded string and Huffman
			// Tree
			System.out.println("Invalid Huffman Tree or Binary Encoded String");
		}
	}
}