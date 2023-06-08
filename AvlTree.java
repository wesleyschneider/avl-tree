public class AvlTree {
	private final Node root;

	public AvlTree(Node root) {
		this.root = root;
	}

	public void insert(Integer key) {
		insertNode(root, key, 0);
	}

	private Integer insertNode(Node node, Integer key, Integer branchHeight) {
		var nodeKey = node.getKey();
		var totalHeight = branchHeight;

		if (key >= nodeKey) {
			var right = node.getRight();

			if (right == null) {
				var child = new Node(key);
				node.setRight(child);
				totalHeight += 1;
			} else {
				totalHeight += insertNode(right, key, totalHeight);
			}
		}

		if (key < nodeKey) {
			var left = node.getLeft();

			if (left == null) {
				var child = new Node(key);
				node.setLeft(child);
				totalHeight += 1;
			} else {
				totalHeight += insertNode(left, key, totalHeight);
			}
		}

		if (totalHeight > node.getHeight()) {
			node.setHeight(totalHeight);
		}

		// Rotação para direita:
		// left.getHeight() - right.getHeight() > 1

		// Rotação para esquerda
		// left.getHeight() - right.getHeight() < -1

		return totalHeight + 1;
	}

	public String toString() {
		return nodeToString(root, true) + ")";
	}

	private String nodeToString(Node root, Boolean isStarting) {
		var result = root.getKey().toString();

		if (isStarting) {
			result = "(" + result;
		}

		var leftNode = root.getLeft();
		var rightNode = root.getRight();

		var existsLeft = leftNode != null;
		var existsRight = rightNode != null;

		if (existsLeft || existsRight) {
			if (existsLeft) {
				result += nodeToString(leftNode, true);

				if (existsRight) {
					result += ", ";
				} else {
					result += ")";
				}
			}

			if (existsRight) {
				result += nodeToString(rightNode, !existsLeft);
				result += ")";
			}
		}

		return result;
	}

}
