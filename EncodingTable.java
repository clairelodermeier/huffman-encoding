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

    CharPathPair[] encodings;
    int size;

    public EncodingTable() {
        encodings = new CharPathPair[256]; // max capacity: 256 possible ASCII characters
        size = 0;
    }

    /**
     * Adds CharPathPair into the Table while
     * setting its binPath to path.
     */
    public void add(char c, String path) {
        int hashIndex = Math.abs(Character.hashCode(c)) % encodings.length;

        CharPathPair currPair = encodings[hashIndex];
        while (currPair != null) {
            if (currPair.getCharacter() == c) {
                return;
            }
            hashIndex = (hashIndex + 1) % encodings.length;
            currPair = encodings[hashIndex];
        }

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
        while (currPair != null) {
            if (currPair.getCharacter() == c) {
                return currPair;
            }

            hashIndex = (hashIndex + 1) % encodings.length;
            currPair = encodings[hashIndex];
        }

        return null;
    }

    /**
     * Returns the encoding path for char c if it
     * is in the Table else return Null
     */
    public String getPath(char c) {
        int hashIndex = Math.abs(Character.hashCode(c)) % encodings.length;

        CharPathPair currPair = encodings[hashIndex];
        while (currPair != null) {
            if (currPair.getCharacter() == c) {
                return currPair.getPath();
            }

            hashIndex = (hashIndex + 1) % encodings.length;
            currPair = encodings[hashIndex];
        }

        return null;
    }

    public int getSize() {
        return size;
    }
}