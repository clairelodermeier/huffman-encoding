Includes classes that implement the Huffman Encoding Process, along with JUnit tests and some .txt files for testing. 

Classes: 

HuffmanTree.java: This class builds a Huffman tree using a PriorityQueue, which implements a min-heap. The PriorityQueue uses the data in the FrequencyTable made in the FrequencyCalculator to create nodes in the Node class and inserts them into the queue. After all the nodes are inserted into the queue, the tree is then printed horizontally.

Node.java: This class represents the nodes in the Huffman Tree. Each node contains the character it holds and its frequency value, as well as its left and right nodes.

PriorityQueue.java: This class implements a data structure that is sorted based on each inserted element's prioirity. Each element is dequed in order of their priority, which means the one with the highest priority is removed first. This priority queue in particular implements a max-heap.

FrequencyTable.java: This class is a hashtable that creates and stores (char, frequency) pairs containing a character and its frequency in the input text. There is a method that returns present pairs as an array for quicker processing when building the tree. It takes in the length of the text (string) as a parameter.

FrequencyCalculator.java: This class takes in a file name as a parameter and builds a Frequency Table from its contents. The name of the file is passed to the constructor as a parameter, and it turns the file's contents into a string. Then, it creates a FrequencyTable object with the number of characters in the file (length of the string) as the parameter. Finally, it iterates through each character and updates the Frequency Table accordingly with its methods. 

EncodingTable.java: This class is a simple hash table that stores the (char, binaryPath) pairs that are later used in the Encoder.java class to quickly retrieve the binary paths associated with each key(character) in the input text.

Encoder.java: This class contains all the necessary objects and methods to properly perform Huffman Encoding on the contents of a file. The name of this file is passed into the constructor and then a Huffman Tree is built from the contents of the file. An instance of an EncodingTable is then initialized and built from this Huffman Tree. The file content is then retrieved through getter methods from the FrequencyCalculator in the Huffman Tree and is traversed. The encoded string is built while traversing the file content by appending the binary path associated with each character to a stringBuilder. You can then retrieve the encoded string by calling the getter method getEncodedString().

Decoder.java: This class contains all the necessary objects and methods to decode a Huffman encoded string. The constructor requires both the encoded string and the associated Huffman Tree to be passed in. Then, the decodeString() method performs the decoding logic. It performs the task of traversing the Huffman Tree to the left for each 0 encountered in the encoded string and right for each 1 encountered. This rebuilds the original string by appending each key(character) associated with every leaf node that is reached when traversing the Huffman Tree. You can retrieve the decoded string by using the getOriginalString() getter method. 


Test Classes: 
  FrequencyCalculatorTest.java tests the implementation of the algorithm that calculates the frequency of a character in a String. 
  FrequencyTableTest.java tests the implementation of the data structure that maps characters to their frequencies. 
  EncodingTableTest.java tests the implementation of the data structure that maps characters to their binary encodings. 
  EncoderTest.java provides tests for encoding a text file. Includes the process from input file through Huffman Tree encoding. 
  DecoderTest.java provides tests for encoding and decoding a text file. Includes the process from input file, through Huffman Tree encoding, back to the original string. 

How to run: 
  Run provided JUnit test cases. 
    DecoderTest.java is the most comprehensive display of the Huffman Encoding process. 
  To run with your own input file, run the HuffmanEncoding.java class and follow input prompts. 
  
