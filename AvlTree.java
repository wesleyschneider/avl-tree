public class AvlTree {
	private Node root;

	public AvlTree(Node root) {
		this.root = root;
	}

	public String toString() {
		return nodeToString(root);
	}

	private String nodeToString(Node node) {
		var result = "(" + node.getKey();

		var leftNode = node.getLeft();
		var rightNode = node.getRight();

		var existsLeft = leftNode != null;
		var existsRight = rightNode != null;

		if (existsLeft || existsRight) {
			result += "(";

			if (existsLeft) {
				result += leftNode.getKey();
				result += nodeToString(leftNode);

				if (existsRight) {
					result += ", ";
				}
			}

			if (existsRight) {
				result += rightNode.getKey();
				result += nodeToString(rightNode);
			}

			result += ")";
		}

		return result + ")";
	}

}
