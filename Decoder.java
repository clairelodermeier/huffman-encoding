public class Decoder {
    //Huffman Tree
    String originalString;
    String encodedString;

    // Will also need Huffman Tree Object as parameter
    public Decoder(String encodedString) {
        this.encodedString = encodedString;
        decodeString();
    }

    public String getOriginalString() {
        return this.originalString;
    }

    private void decodeString() {
        // Will use the encoded String to traverse the
        // Huffman tree and build the originalString
    }
}