import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Encoder {
    EncodingTable table;
    HuffmanTree tree;
    String fileContent;
    String encodedString;

    public Encoder(String fileName) throws IOException {
        this.fileContent = fileToString(fileName);
        this.tree = new HuffmanTree();
        table = new EncodingTable();
        buildTable(tree.root(), "");
        encodeContent();
        System.out.println(encodedString);
    }

    public String getEncodedString(){
        return this.encodedString;
    }

    // Traverse the huffman tree and build the table
    private void buildTable(Node root, String binaryPath) {
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            table.add(root.getVal(), binaryPath);
        }

        if(root.left != null){
            buildTable(root.left, binaryPath + "0");
        }

        if(root.right != null){
            buildTable(root.right, binaryPath + "1");
        }
    }

    /**
     * Will get binary Path for each char from EncodingTable
     * and build the encoded one character at a time
     * @return - The binary Encoded String
     */
    private void encodeContent(){
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < fileContent.length(); i++){
            char ch = fileContent.charAt(i);
            stringBuilder.append(table.getPath(ch));
        }

        encodedString = stringBuilder.toString();
    }

    private String fileToString(String fileName) throws IOException {
        String result = "";
        // Turns the contents of the file named fileName into a string
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();

            String line = reader.readLine();
            while (line != null){
                stringBuilder.append(line);
                line = reader.readLine();
            }
            reader.close();
            result = stringBuilder.toString();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        return result;
    }
}