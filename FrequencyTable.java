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

        int h = Math.abs(Character.hashCode(c)) % frequencies.length;

        int hashIndex = h;

        CharFreqPair currPair = frequencies[hashIndex];
        while(currPair != null){
            // If the pair is present simply add to its frequency and return
            if (currPair.character() == c){
                currPair.freq += 1.0;
                return;
            }
            hashIndex = hashIndex + 1 % frequencies.length;
            currPair = frequencies[hashIndex];
        }

        // If we reach a null spot then the character is not present, add new pair
        frequencies[hashIndex] = new CharFreqPair(c);
        size++;
    }

    public CharFreqPair get(char c){
        // Returns the character and frequency pair for the character specified
        // Returns null if it does not exist
        int h = Math.abs(Character.hashCode(c)) % frequencies.length;

        int hashIndex = h;

        CharFreqPair currPair = frequencies[hashIndex];
        while(currPair != null){
            // If the pair is present return it
            if (currPair.character() == c){
                return currPair;
            }
            hashIndex = hashIndex + 1 % frequencies.length;
            currPair = frequencies[hashIndex];
        }

        // If we reach a null spot then the character is not present
        return null;
    }

    public CharFreqPair[] toArray(){
        // Returns an array of CharFreqPairs present in the frequency table. For use when creating
        // tree nodes after data is in the table, so we can iterate through all the pairs.

        CharFreqPair[] toReturn = new CharFreqPair[size];

        int i = 0;
        for (CharFreqPair cfp : frequencies){
            if (cfp != null){
                toReturn[i] = cfp;
                i++;
            }
        }
        return toReturn;
    }
}