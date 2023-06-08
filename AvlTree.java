public class AvlTree {
	private Node root;

	public AvlTree(Node root) {
		this.root = root;
	}

	public void insert(Integer key) {
		this.root = insertNode(root, key);
	}

	private Node insertNode(Node node, Integer key) {
		var nodeKey = node.getKey();

		if (key >= nodeKey) {
			var child = createNode(key, node.getRight());
			node.setRight(child);
		}

		if (key < nodeKey) {
			var child = createNode(key, node.getLeft());
			node.setLeft(child);
		}

		node.updateHeight();

		return balanceNode(node);
	}

	private Node createNode(Integer key, Node parent) {
		if (parent == null) {
			return new Node(key);
		}

		return insertNode(parent, key);
	}

	private Node balanceNode(Node node) {
		int balanceFactor = node.getBalanceFactor();

		// Rotação para direita:
		if(balanceFactor > 1) {
			return rotateRight(node);
		}

		// Rotação para esquerda
		if(balanceFactor < -1) {
			return rotateLeft(node);
		}

		// TODO: Rotação dupla para direita
		// TODO: Rotação dupla para esquerda

		return node;
	}

	private Node rotateRight(Node node) {
		var left = node.getLeft();

		left.setRight(node);
		node.setLeft(null);

		return left;
	}

	private Node rotateLeft(Node node) {
		var right = node.getRight();

		right.setLeft(node);
		node.setRight(null);

		return right;
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
