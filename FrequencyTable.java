public class FrequencyTable{

    // Helper class for character and frequency pairs
    class CharFreqPair {
        char character;
        double freq;
    
        public CharFreqPair(char character) {
            this.character = character;
            this.freq = 0;
        }
        
        public char character(){
            // Returns the pair's character (key)
            return this.character;
        }
    }

    CharFreqPair[] frequencies;
    int size;

    public FrequencyTable() {
        this.frequencies = new CharFreqPair[256]; // max capacity: 256 possible ASCII characters
        this.size = 0;
    }

    public void add(char c){
        // Adds a character to the frequency table if it is not already present
        // Increases its count by 1 if it is already in the table
    }

    public CharFreqPair get(char c){
        // Returns the character and frequency pair for the character specified
        // Returns null if it does not exist
        return null;
    }

    public CharFreqPair[] toArray(){
        // Returns an array of CharFreqPairs present in the frequency table. For use when creating
        // tree nodes after data is in the table, so we can iterate through all the pairs.

        CharFreqPair[] toReturn = new CharFreqPair[size];

        // rest of method

        return toReturn;
    }
}
