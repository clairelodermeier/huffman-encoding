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

    public String getOriginalString() {
        return this.originalString;
    }

    private void decodeString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node currNode = tree.root();

        try{
            for(int i = 0; i < encodedString.length(); i++){
                char ch = encodedString.charAt(i);
                // if ch is 0 traverse left
                if (ch == '0') {
                    currNode = currNode.left;
                } else {
                    // else traverse right
                    currNode = currNode.right;
                }
                // If a leaf node append character
                if(currNode.left == null && currNode.right == null){
                    stringBuilder.append(currNode.getVal());
                    currNode = tree.root();
                }
            }

            originalString = stringBuilder.toString();
        } catch (Exception e) {
            System.out.println("Invalid Huffman Tree for Binary Encoded String");
        }

    }
}