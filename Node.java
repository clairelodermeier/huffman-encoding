class Node implements Comparable<Node> {

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


		public String toString() {
			return "" + this.val;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.getFreq(), o.getFreq());
		}

		public boolean leaf() {
			// TODO Auto-generated method stub
			return (this.left == null && this.right == null);
		}
	}
