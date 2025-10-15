package P_ASSIGNMENTS.P1_300425781;

public class Partition<E> {

    public class Node<E> {
        private E element;
        private Cluster<E> cluster;  

        private Node(E element, Cluster<E> cluster) {
            this.element = element;
            this.cluster = cluster;
        }

        public E getElement() {
            return element;
        }

        public Cluster<E> getCluster() {
            return cluster;
        }
    }

    private class Cluster<E> {
        private LinkedList<Node<E>> sequence;

        private Cluster() {
            sequence = new LinkedList<>();
        }
    }

    private List<Cluster<E>> clusterList;  

    public Partition() {
        clusterList = new LinkedList<>();
    }

    public Node<E> makeCluster(E x) {
        Cluster<E> cluster = new Cluster<>();
        Node<E> node = new Node<>(x, cluster);

        cluster.sequence.add(node);
        clusterList.add(cluster);
        
        return node;
    }

    public Node<E> find(Node<E> p) {
        if (p == null) { throw new IllegalArgumentException("Null position"); }

        Cluster<E> c = p.getCluster();
        return c.sequence.getFirst(); 
    }

    public void union(Node<E> p, Node<E> q) {
        if (p == null || q == null) { throw new IllegalArgumentException("Null position"); }

        Cluster<E> A = p.getCluster();
        Cluster<E> B = q.getCluster();

        if (A == B) { return; }

        if (A.sequence.size() > B.sequence.size()) {
            Cluster<E> temp = A;
            A = B;
            B = temp;
        }

        for (Node<E> node : A.sequence) {
            node.cluster = B;
            B.sequence.addLast(node);
        }

        clusterList.remove(A);
    }

    public int numberClusters() { return clusterList.size(); }

    public int clusterSize(Node<E> p) { return p.getCluster().sequence.size(); }

    public List<E> clusterElements(Node<E> p) {
        List<E> list = new ArrayList<>();

        for (Node<E> n : p.getCluster().sequence) {
            list.add(n.getElement());
        }

        return list;
    }

    public List<Integer> clusterSizes() {
        List<Integer> sizes = new ArrayList<>();

        for (Cluster<E> c : clusterList) {
            sizes.add(c.sequence.size());
        }

        sizes.sort(Collections.reverseOrder());
        return sizes;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        int i = 1;

        for (Cluster<E> c : clusterList) {
            sb.append("Cluster ").append(i++).append(": ");

            for (Node<E> n : c.sequence) {
                sb.append(n.getElement()).append(" ");
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}
