import java.io.IOException;

/**
 * @author Dawson Szarek Class to Encode an ASCII string into a compressed
 *         encoded binary string.
 */
public class Encoder {
	EncodingTable encodingTable;
	HuffmanTree tree;
	String fileContent;
	String encodedString;

	public Encoder(String fileName) throws IOException {
		this.tree = new HuffmanTree(fileName); // Create Huffman Tree from file
		this.fileContent = tree.getBuildTable().getFileContent(); // Set fileContent to the text from fileName
		this.encodingTable = new EncodingTable();
		buildTable(tree.root(), "");
		encodeContent();
	}

	// Returns the encoded binary string
	public String getEncodedString() {
		return this.encodedString;
	}

	// Returns the Huffman Tree tree
	public HuffmanTree getTree() {
		return this.tree;
	}

	// Traverse the huffman tree and build the encodingTable
	private void buildTable(Node root, String binaryPath) {
		if (root == null) {
			return;
		}

		// If a leaf node, add the value and binaryPath to the encodingTable
		if (root.left == null && root.right == null) {
			encodingTable.add(root.getVal(), binaryPath);
		}

		// Traverse left and add 0 to the current binaryPath
		if (root.left != null) {
			buildTable(root.left, binaryPath + "0");
		}

		// Traverse right and add 1 to the current binaryPath
		if (root.right != null) {
			buildTable(root.right, binaryPath + "1");
		}
	}

	/**
	 * Will get binary Path for each char from EncodingTable and build the
	 * compressed encoded binary string one character at a time.
	 */
	private void encodeContent() {
		StringBuilder stringBuilder = new StringBuilder();

		// Traverses each character in the fileContent
		for (int i = 0; i < fileContent.length(); i++) {
			char ch = fileContent.charAt(i);
			// Append the binaryPath value to the current stringBuilder for each char
			stringBuilder.append(encodingTable.getPath(ch));
		}

		// Set the encodedString the completed stringBuilder.
		encodedString = stringBuilder.toString();
	}
}