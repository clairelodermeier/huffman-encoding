/**
 * @author Dawson Szarek
 * Hashtable to store (char, binPath) pairs for Encoding
 */
public class EncodingTable {
    // Helper class that contains the character along with its encoding path
    class CharPathPair {
        char character;
        String binPath = null;

        public CharPathPair(char c, String path) {
            character = c;
            binPath = path;
        }

        public char getCharacter() {
            return character;
        }

        public void setPath(String path) {
            binPath = path;
        }

        public String getPath() {
            return binPath;
        }
    }

    CharPathPair[] encodings;   // Stores CharPathPairs
    int size;   // Number of CharPathPairs currently in encodings[]

    public EncodingTable() {
        encodings = new CharPathPair[256]; // max capacity: possible ASCII characters
        size = 0;
    }

    /**
     * Adds CharPathPair into the Table while
     * setting its binPath to path.
     */
    public void add(char c, String path) {
        int hashIndex = Math.abs(Character.hashCode(c)) % encodings.length;

        CharPathPair currPair = encodings[hashIndex];

        // Linearly probe until an open position is found
        while (currPair != null) {
            // If c already exists in table, return
            if (currPair.getCharacter() == c) {
                return;
            }

            hashIndex = (hashIndex + 1) % encodings.length; // Linear Probing
            currPair = encodings[hashIndex];
        }

        // Insert new CharPathPair at first open Index
        CharPathPair newPair = new CharPathPair(c, path);
        encodings[hashIndex] = newPair;
        size++;
    }

    /**
     * Will return the CharPathPair if it is in
     * the Table else return Null
     */
    public CharPathPair get(char c) {
        int hashIndex = Math.abs(Character.hashCode(c)) % encodings.length;

        CharPathPair currPair = encodings[hashIndex];

        // Linearly probe until c is found or null is hit
        while (currPair != null) {
            if (currPair.getCharacter() == c) {
                return currPair;
            }

            hashIndex = (hashIndex + 1) % encodings.length; // Linear Probing
            currPair = encodings[hashIndex];
        }

        // Return null if c not found in encodings[]
        return null;
    }

    /**
     * Returns the Binary encoding path for char c if it
     * is in the Table else return Null
     */
    public String getPath(char c) {
        int hashIndex = Math.abs(Character.hashCode(c)) % encodings.length;

        CharPathPair currPair = encodings[hashIndex];
        // Linearly probe until c is found or null is hit
        while (currPair != null) {
            // If c is found return Binary encoding path
            if (currPair.getCharacter() == c) {
                return currPair.getPath();
            }

            // If not found, Linearly probe
            hashIndex = (hashIndex + 1) % encodings.length;
            currPair = encodings[hashIndex];
        }

        // Return null if c not found in encodings[]
        return null;
    }

    public int getSize() {
        return size;
    }
}