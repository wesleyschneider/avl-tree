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

	public void delete(Integer key) {
		this.root = deleteNode(root, key);
	}

	private Node deleteNode(Node node, Integer key) {
		var nodeKey = node.getKey();
		var right = node.getRight();
		var left = node.getLeft();

		if (key > nodeKey) {
			node.setRight(deleteNode(right, key));
		}

		if (key < nodeKey) {
			node.setLeft(deleteNode(left, key));
		}

		if (key.equals(nodeKey)) {
			if (left != null) {
				if (left.getRight() == null) {
					return left;
				}

				var newNode = getMaxRightChild(left.getRight());

				left.setRight(left.getRight().getLeft());
				newNode.setLeft(left);
				newNode.setRight(right);

				newNode.updateHeight();
				left.updateHeight();

				return newNode;
			}

			if (right != null) {
				if (right.getLeft() == null) {
					return right;
				}

				var newNode = getMaxLeftChild(right.getLeft());

				right.setLeft(right.getLeft().getRight());
				newNode.setRight(right);
				newNode.setLeft(null);

				newNode.updateHeight();
				right.updateHeight();

				return newNode;
			}

			return null;
		}

		node.updateHeight();

		return balanceNode(node);

	}

	private Node getMaxRightChild(Node node) {
		var right = node.getRight();

		if (right == null) return node;

		var value = getMaxRightChild(right);

		if (value.getKey().equals(right.getKey())) {
			node.setRight(null);
		}

		return value;
	}

	private Node getMaxLeftChild(Node node) {
		var left = node.getLeft();

		if (left == null) return node;

		var value = getMaxLeftChild(left);

		if (value.getKey().equals(left.getKey())) {
			node.setLeft(null);
		}

		return value;
	}

	private Node balanceNode(Node node) {
		int balanceFactor = node.getBalanceFactor();

		// Rotação para direita
		if (balanceFactor > 1) {
			return rotateRight(node);
		}

		// Rotação para esquerda
		if(balanceFactor < -1) {
			return rotateLeft(node);
		}

		return node;
	}

	private Node rotateRight(Node node) {
		// Verifica se deve ser rotação dupla para direita
		var leftBalanceFactor = node.getLeft().getBalanceFactor();
		if (leftBalanceFactor <= -1) {
			node.setLeft(rotateLeft(node.getLeft()));
		}

		var left = node.getLeft();

		left.setRight(node);
		node.setLeft(null);

		return left;
	}

	private Node rotateLeft(Node node) {
		// Verifica se deve ser rotação dupla para esquerda
		var rightBalanceFactor = node.getRight().getBalanceFactor();
		if (rightBalanceFactor >= 1) {
			node.setRight(rotateRight(node.getRight()));
		}

		var right = node.getRight();

		right.setLeft(node);
		node.setRight(null);

		return right;
	}

	public Node search(Integer key) {
		Node node = root;

		while(node != null) {
			if(key.equals(node.getKey())){
				break;
			}

			node = key >= node.getKey() ? node.getRight() : node.getLeft();
		}

		return node;
	}

	public String toString() {
		return nodeToString(root, true) + ")";
	}

	private String nodeToString(Node root, Boolean isStarting) {
		if (root == null) return "( )";

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
