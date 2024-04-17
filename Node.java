class Node implements Comparable<Node> {

	/*
	 * Represents one node of the Huffman Tree.
	 * 
	 */

	private char val;
	private int freq;

	Node right;
	Node left;

	public Node(char value, int frequency) {

		this.val = value;
		this.freq = frequency;

	}

	public char getVal() {
		return this.val;
	}

	public int getFreq() {
		return this.freq;
	}

	public void setRight(Node node) {
		this.right = node;
	}

	public void setLeft(Node node) {
		this.left = node;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.getFreq(), o.getFreq());
	}

}
