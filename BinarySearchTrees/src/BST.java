
/*************************************************************************
 * Binary Search Tree class. Adapted from Sedgewick and Wayne.
 *
 * @version 3.0 1/11/15 16:49:42
 *
 * @author Dearbhla Boylan Time Spent: 15-20 hours
 *
 *************************************************************************/

// import java.util.NoSuchElementException;

// import org.junit.platform.engine.support.hierarchical.Node;

public class BST<Key extends Comparable<Key>, Value> {
	private Node root; // root of BST

	/**
	 * Private node class.
	 */
	private class Node {
		private Key key; // sorted by key
		private Value val; // associated data
		private Node left, right; // left and right subtrees
		private int N; // number of nodes in subtree

		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}

	// is the symbol table empty?
	public boolean isEmpty() {
		return size() == 0;
	}

	// return number of key-value pairs in BST
	public int size() {
		return size(root);
	}

	// return number of key-value pairs in BST rooted at x
	private int size(Node x) {
		if (x == null)
			return 0;
		else
			return x.N;
	}

	/**
	 * Search BST for given key. Does there exist a key-value pair with given key?
	 *
	 * @param key
	 *            the search key
	 * @return true if key is found and false otherwise
	 */
	public boolean contains(Key key) {
		return get(key) != null;
	}

	/**
	 * Search BST for given key. What is the value associated with given key?
	 *
	 * @param key
	 *            the search key
	 * @return value associated with the given key if found, or null if no such key
	 *         exists.
	 */
	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return x.val;
	}

	/**
	 * Insert key-value pair into BST. If key already exists, update with new value.
	 *
	 * @param key
	 *            the key to insert
	 * @param val
	 *            the value associated with key
	 */
	public void put(Key key, Value val) {
		if (val == null) {
			delete(key);
			return;
		}
		root = put(root, key, val);
	}

	private Node put(Node x, Key key, Value val) {
		if (x == null)
			return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = put(x.left, key, val);
		else if (cmp > 0)
			x.right = put(x.right, key, val);
		else
			x.val = val;
		x.N = 1 + size(x.left) + size(x.right);
		return x;
	}

	/**
	 * Tree height.
	 *
	 * Asymptotic worst-case running time using Theta notation: The asymptotic worst
	 * case running time for public int height() is theta(1) as the execution of the
	 * line takes place one time. The worst case asymptotic running time of private
	 * int height2(Node node) is Theta(N).This is because lines 140-142 execute at
	 * theta(1), but line 143 uses Math.max which has to check each node so it
	 * executes N times where N is the number of nodes in the tree. Therefore the
	 * recursive function worst case asymptotic running time = theta(1) + theta(N) =
	 * theta(N)
	 * 
	 *
	 * @return the number of links from the root to the deepest leaf.
	 *
	 *         Example 1: for an empty tree this should return -1. Example 2: for a
	 *         tree with only one node it should return 0. Example 3: for the
	 *         following tree it should return 2. B / \ A C \ D
	 */
	public int height() {
		// TODO fill in the correct implementation.
		return height2(root);
	}

	private int height2(Node node) {
		if (node == null) {
			return -1;
		} else {
			return 1 + Math.max(height2(node.left), height2(node.right));
		}
	}

	public int rank(Key key) {
		return rank(key, root);
	}

	private int rank(Key key, Node node) {
		if (node == null) {
			return 0;
		}
		int cmp = key.compareTo(node.key);
		if (cmp < 0) {
			return rank(key, node.left);
		} else if (cmp > 0) {
			return (size(node.left) + rank(key, node.right) + 1);
		} else {
			return size(node.left);
		}
	}

	/**
	 * Median key. If the tree has N keys k1 < k2 < k3 < ... < kN, then their median
	 * key is the element at position (N+1)/2 (where "/" here is integer division)
	 *
	 * @return the median key, or null if the tree is empty.
	 */
	public Key median() {
		if (isEmpty())
			return null;
		// TODO fill in the correct implementation. The running time should be Theta(h),
		// where h is the height of the tree.
		else {
			return median2(root);
		}
	}

	private Key median2(Node node) {
		int medianPosition = (size(root) - 1) / 2;
		int keyPosition = rank(node.key);
		if (keyPosition < medianPosition) {
			return median2(node.right);

		} else if (keyPosition > medianPosition) {
			return median2(node.left);

		} else {
			return node.key;
		}

	}

	/**
	 * Print all keys of the tree in a sequence, in-order. That is, for each node,
	 * the keys in the left subtree should appear before the key in the node. Also,
	 * for each node, the keys in the right subtree should appear before the key in
	 * the node. For each subtree, its keys should appear within a parenthesis.
	 *
	 * Example 1: Empty tree -- output: "()" Example 2: Tree containing only "A" --
	 * output: "(()A())" Example 3: Tree: B / \ A C \ D
	 *
	 * output: "((()A())B(()C(()D())))"
	 *
	 * output of example in the assignment:
	 * (((()A(()C()))E((()H(()M()))R()))S(()X()))
	 *
	 * @return a String with all keys in the tree, in order, parenthesized.
	 */
	public String printKeysInOrder() {
		if (isEmpty()) {
			return "()";
		}
		// TODO fill in the correct implementation
		else {
			return "(" + printKeysInOrder(root) + ")";
		}
	}

	private String printKeysInOrder(Node node) {
		String output = "";
		if (node == null) {
			return output;
		} else {
			output += "(";
			output += printKeysInOrder(node.left);
			output += ")" + node.key + "(";
			output += printKeysInOrder(node.right);
			output += ")";
			return output;
		}
	}

	/**
	 * Pretty Printing the tree. Each node is on one line -- see assignment for
	 * details.
	 *
	 * @return a multi-line string with the pretty ascii picture of the tree.
	 */
	public String prettyPrintKeys() {
		// TODO fill in the correct implementation.
		String output = "";
		if (root == null) {
			output = "-null\n";
		} else {
			output = prettyPrintKeys(root, "") + "\n";
		}
		return output;
	}

	private String prettyPrintKeys(Node node, String string) {
		String output = "";
		if (node == null) {
			output = string + "-null";
		} else {
			output = string + "-" + node.val + "\n" + prettyPrintKeys(node.left, string + " |") + "\n"
					+ prettyPrintKeys(node.right, string + "  ");
		}
		return output;

	}

	/**
	 * Deteles a key from a tree (if the key is in the tree). Note that this method
	 * works symmetrically from the Hibbard deletion: If the node to be deleted has
	 * two child nodes, then it needs to be replaced with its predecessor (not its
	 * successor) node.
	 *
	 * @param key
	 *            the key to delete
	 */

	public void deleteMax() {
		root = deleteMax(root);
	}

	private Node deleteMax(Node node) {
		if (node.right == null) {
			return node.left;
		}
		node.right = deleteMax(node.right);
		node.N = (size(node.left) + size(node.right) + 1);
		return node;
	}

	public Key max() {
		return max(root).key;
	}

	public Node max(Node node) {
		if (node.right == null) {
			return node;
		} else {
			return max(node.right);
		}
	}

	public void delete(Key key) { // TODO fill in the correct implementation. //
		root = delete(root, key);
	}

	private Node delete(Node node, Key key) {
		if (node == null) {
			return null;
		}
		int cmp = key.compareTo(node.key);
		if (cmp < 0) {
			node.left = delete(node.left, key);
		} else if (cmp > 0) {
			node.right = delete(node.right, key);
		} else {
			if (node.right == null) {
				return node.left;
			}
			if (node.left == null) {
				return node.right;
			}
			Node temp = node;
			node = max(temp.left);
			node.left = deleteMax(temp.left);
			node.right = temp.right;
		}
		node.N = (size(node.left) + size(node.right) + 1);
		return node;
	}

}
