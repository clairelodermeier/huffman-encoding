import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Dawson Szarek
 * Class to Encode an ASCII string into a compressed encoded
 * binary string.
 */
public class Encoder {
    EncodingTable encodingTable;
    HuffmanTree tree;
    String fileContent;
    String encodedString;

    public Encoder(String fileName) throws IOException {
        this.fileContent = fileToString(fileName);
        this.tree = new HuffmanTree();
        encodingTable = new EncodingTable();
        buildTable(tree.root(), "");
        encodeContent();
    }

    // Returns the encoded binary string
    public String getEncodedString() {
        return this.encodedString;
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
     * Will get binary Path for each char from EncodingTable
     * and build the compressed encoded binary string one character
     * at a time.
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

    private String fileToString(String fileName) throws IOException {
        String result = "";
        // Turns the contents of the file named fileName into a string
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();

            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line);
                line = reader.readLine();
            }
            reader.close();
            result = stringBuilder.toString();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return result;
    }
}