public class Node {
	private Integer key;
	private Integer balancingFactor;
	private Node left;
	private Node right;

	public Node(Integer key) {
		this.key = key;
	}

	public Integer getKey() {
		return key;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

}
