import java.io.IOException;
import java.util.PriorityQueue;

public class HuffmanTree {

	private static FrequencyCalculator buildTable;
	private static FrequencyTable table;
	private static PriorityQueue<Node> tree ;

	public static void main(String[] args) {

		try {
			buildTable = new FrequencyCalculator("abc.txt");
			table = buildTable.table();

			tree = new PriorityQueue<>(table.size);

			createLeafNodes();
			Node root = buildTree();
			printTree(root, "");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void createLeafNodes() {
		// TODO Auto-generated method stub
		
		FrequencyTable.CharFreqPair[] array = table.toArray();
		for (FrequencyTable.CharFreqPair ch : array) {
			tree.add(new Node(ch.character(), ch.count()));
		}
	}

	private static Node buildTree() {
		// TODO Auto-generated method stub

		Node root = null;
		
		while(tree.size() > 1) {
			Node min1 = tree.poll();
			Node min2 = tree.poll();
			
			Node upcomingRoot = new Node('-', min1.getVal() + min2.getFreq());
			
			upcomingRoot.setLeft(min1);
			upcomingRoot.setRight(min2);
			
			root = upcomingRoot;
			
			tree.add(upcomingRoot);
		}
		return root;
	}
	
	public static void printTree(Node root, String o) {
		
		if(root.left == null && root.right == null && Character.isLetter(root.getVal())) {
			System.out.println(root.getVal() + ": " + o);
			return;
		}
		
		printTree(root.left, o + "0");
		printTree(root.right, o + "1");
	}


}
