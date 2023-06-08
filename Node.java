public class Node {
	private final Integer key;
	private Integer height = 0;
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

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getHeight() {
		return this.height;
	}

	public void updateHeight(){
		setHeight(Math.max(getHeightNode(left), getHeightNode(right)));
	}

	public Integer getBalanceFactor() {
		return getHeightNode(left) - getHeightNode(right);
	}

	private Integer getHeightNode(Node node) {
		return node != null ? node.getHeight() + 1 : 0;
	}
}
