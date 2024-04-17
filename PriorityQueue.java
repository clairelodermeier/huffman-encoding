import java.util.ArrayList;

public class PriorityQueue {

    private ArrayList<Node> queue;
    private int numNodes;

    public PriorityQueue(int cap) {
        queue = new ArrayList<>();
        numNodes = 0;
    }

    public void add(Node node) {
        // TODO Auto-generated method stub
        queue.add(node); // Add element to the end
        numNodes++;
        int child = queue.size() - 1;
        while (child > 0) {
            int parent = (child - 1) / 2;
            if ( compare(queue.get(child), queue.get(parent))< 0) {
                swap(child, parent);
                child = parent;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        // TODO Auto-generated method stub
        Node temp = queue.get(i);
        queue.set(i, queue.get(j));
        queue.set(j, temp);
    }

    private int compare(Node child, Node parent) {
        return child.compareTo(parent);
    }

    private void swim(int i) {
        // TODO Auto-generated method stub
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        int curr = i;

        if(leftChild < queue.size() && queue.get(leftChild).compareTo(queue.get(curr)) < 0) {
            curr = leftChild;
        }
        if(rightChild < queue.size() && queue.get(rightChild).compareTo(queue.get(curr)) < 0) {
            curr = rightChild;
        }
        if(curr != i) {
            swap(i, curr);
            swim(curr);
        }
    }

    public int size() {
        // TODO Auto-generated method stub
        return queue.size();
    }

    public Node poll() {
        // TODO Auto-generated method stub
        if(queue.size() == 0) {
            return null;
        }

        Node removeNode = queue.get(0);
        numNodes--;
        Node lastNode = queue.remove(queue.size()-1);
        if(!queue.isEmpty()) {
            queue.set(0,  lastNode);
            swim(0);
        }
        return removeNode;
    }

}
