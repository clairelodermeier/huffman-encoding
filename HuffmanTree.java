
import java.io.IOException;

public class HuffmanTree {

	private static FrequencyCalculator buildTable;
	private static FrequencyTable table;
	private static PriorityQueue tree;
	private Node root;

	/*
	 * Constructor builds a Huffman tree using a priority queue, or min-heap. The
	 * priority queue uses the data in the FrequencyTable made in the
	 * FrequencyCalculator to create nodes/leaves and inserts them into the queue.
	 */
	public HuffmanTree(String fileName) {

		try {
			// creating a frequency table from the given file
			buildTable = new FrequencyCalculator(fileName); // file can be changed
			// grabbing the newly made table
			table = buildTable.table();
			// making the priority queue that will contain all the characters in the file
			tree = new PriorityQueue(table.size);

			createLeafNodes();

			root = buildTree();
			// printTree(root, "");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * method receives the table containing the characters in the file and their
	 * frequency in that file, from there creating leaves for each unique character
	 * and adding them to the priority queue
	 */
	private static void createLeafNodes() {
		// TODO Auto-generated method stub

		FrequencyTable.CharFreqPair[] array = table.toArray();
		// for each characters in the table
		for (FrequencyTable.CharFreqPair ch : array) {
			// create a Node from it and add it to the PriorityQueue
			tree.add(new Node(ch.character(), ch.count()));
		}
	}

	/*
	 * method builds a tree from the PriorityQueue by creating a root node then
	 * looping through the queue and making them be either left or right of the root
	 * and so on and so forth *** WARNING: will ONLY build a tree if the number of
	 * characters in the file is over 1 ***
	 */
	private static Node buildTree() {
		// TODO Auto-generated method stub

		// we start with an empty tree
		Node root = null;

		// while the priority queue has more than 1 character
		while (tree.size() > 1) {
			// grab the two least frequent characters
			Node min1 = tree.poll();
			Node min2 = tree.poll();
			// create a new Node with min1 and min2 being its children
			Node upcomingRoot = new Node('-', min1.getVal() + min2.getFreq());

			upcomingRoot.setLeft(min1);
			upcomingRoot.setRight(min2);
			// set it to be the root node
			root = upcomingRoot;

			tree.add(upcomingRoot);
		}
		return root;
	}

	public FrequencyCalculator getBuildTable() {
		return buildTable;
	}

	public Node root() {
		return this.root;
	}

}
