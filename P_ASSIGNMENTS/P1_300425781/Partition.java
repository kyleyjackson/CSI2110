package P_ASSIGNMENTS.P1_300425781;

public class PartitionADT<E> {
    
    private List<Node<E>> clusters;
    private int numClusters;
    private List<Node<E>> allPositions;
    
    public PartitionADT() {
        this.clusters = new ArrayList<>();
        this.allPositions = new ArrayList<>();
        this.numClusters = 0;
    }
    
    public Node<E> makeCluster(E x) {
        Node<E> newNode = new Node<>(x);
        clusters.add(newNode);
        allPositions.add(newNode);
        numClusters++;
        return newNode;
    }

    public Node<E> find(Node<E> p) {
        if (p == null) {
            throw new IllegalArgumentException("Invalid position: null");
        }
        return p.leader;
    }

    public void union(Node<E> p, Node<E> q) {
        if (p == null || q == null) {
            throw new IllegalArgumentException("Invalid positions");
        }
        
        Node<E> leaderP = find(p);
        Node<E> leaderQ = find(q);

        if (leaderP == leaderQ) {
            return;
        }
        
        int sizeP = leaderP.clusterSize;
        int sizeQ = leaderQ.clusterSize;

        if (sizeP >= sizeQ) {
            mergeClusters(leaderP, leaderQ, sizeP, sizeQ);
        } else {
            mergeClusters(leaderQ, leaderP, sizeQ, sizeP);
        }
    }
    
    private void mergeClusters(Node<E> largerLeader, Node<E> smallerLeader, int sizeLarge, int sizeSmall) {
        largerLeader.clusterSize = sizeLarge + sizeSmall;

        Node<E> current = largerLeader;
        while (current.next != null) {
            current = current.next;
        }

        current.next = smallerLeader;
        Node<E> temp = smallerLeader;

        while (temp != null) {
            temp.leader = largerLeader;
            temp = temp.next;
        }

        clusters.remove(smallerLeader);
        numClusters--;
    }

    public E element(Node<E> p) {
        if (p == null) { throw new IllegalArgumentException("Invalid position"); }

        return p.element;
    }

    public int numberOfClusters() { return numClusters; }
    
    public int clusterSize(Node<E> p) {
        if (p == null) { throw new IllegalArgumentException("Invalid position"); }
        Node<E> leader = find(p);
        return leader.clusterSize;
    }

    public List<Node<E>> clusterPositions(Node<E> p) {
        if (p == null) { throw new IllegalArgumentException("Invalid position"); }
        
        Node<E> leader = find(p);
        List<Node<E>> positions = new ArrayList<>();
        Node<E> current = leader;

        while (current != null) {
            positions.add(current);
            current = current.next;
        }
        
        return positions;
    }

    public List<Integer> clusterSizes() {
        List<Integer> sizes = new ArrayList<>();

        for (Node<E> leader : clusters) {
            sizes.add(leader.clusterSize);
        }

        sizes.sort(Collections.reverseOrder());
        return sizes;
    }

    public List<E> clusterElements(Node<E> p) {
        List<Node<E>> positions = clusterPositions(p);
        List<E> elements = new ArrayList<>();

        for (Node<E> node : positions) {
            elements.add(node.element);
        }

        return elements;
    }
}