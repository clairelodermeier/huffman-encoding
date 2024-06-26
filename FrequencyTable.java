
public class FrequencyTable {

	// Helper class for character and frequency pairs
	class CharFreqPair {
		char character;
		int count;
		double freq;

		public CharFreqPair(char character) {
			this.character = character;
			this.count = 1;
			this.freq = 0; // temporary, as it will be updated when adding to table
		}

		public char character() {
			// Returns the pair's character (key)
			return this.character;
		}

		// the only method i added for huffman tree
		public int count() {
			return this.count;
		}
	}

	CharFreqPair[] frequencies;
	int size;
	double totalLength;

	public FrequencyTable(double totalLength) {
		// parameter is the length of the string for which we store frequencies
		this.frequencies = new CharFreqPair[256]; // max capacity: 256 possible ASCII characters
		this.size = 0;
		this.totalLength = totalLength * 1.0;
	}

	public void add(char c) {
		// Adds a character to the frequency table if it is not already present
		// Increases its count by 1 if it is already in the table

		int h = Math.abs(Character.hashCode(c)) % frequencies.length;

		int hashIndex = h;

		CharFreqPair currPair = frequencies[hashIndex];
		while (currPair != null) {
			// If the pair is present simply add to its frequency and return
			if (currPair.character() == c) {
				currPair.count += 1;
				currPair.freq = (currPair.count * 1.0) / (totalLength * 1.0); // convert to double
				return;
			}
			hashIndex = hashIndex + 1 % frequencies.length;
			currPair = frequencies[hashIndex];
		}

		// If we reach a null spot then the character is not present, add new pair
		CharFreqPair newPair = new CharFreqPair(c);
		newPair.freq = 1.0 / totalLength;
		frequencies[hashIndex] = newPair;
		size++;
	}

	public CharFreqPair get(char c) {
		// Returns the character and frequency pair for the character specified
		// Returns null if it does not exist
		int h = Math.abs(Character.hashCode(c)) % frequencies.length;

		int hashIndex = h;

		CharFreqPair currPair = frequencies[hashIndex];
		while (currPair != null) {
			// If the pair is present return it
			if (currPair.character() == c) {
				return currPair;
			}
			hashIndex = hashIndex + 1 % frequencies.length;
			currPair = frequencies[hashIndex];
		}
		// If we reach a null spot then the character is not present
		return null;
	}

	public CharFreqPair[] toArray() {
		// Returns an array of CharFreqPairs present in the frequency table. For use
		// when creating
		// tree nodes after data is in the table, so we can iterate through all the
		// pairs.

		CharFreqPair[] toReturn = new CharFreqPair[size];

		int i = 0;
		for (CharFreqPair cfp : frequencies) {
			if (cfp != null) {
				toReturn[i] = cfp;
				i++;
			}
		}

		return toReturn;
	}
}
