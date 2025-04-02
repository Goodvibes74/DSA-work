 /*
 * A Binary Search Tree is a data structure that maintains elements in a sorted order,
 * allowing for efficient insertion, deletion, and search operations.
 */
package BST;
public class BSTree {

    Node root;

    // Method to insert a node into the BST
    public void insert(Node node) {
        root = insertHelper(root, node);
    }

    // Helper method for insertion
    private Node insertHelper(Node root, Node node) {
        int data = node.data;
        // if there are no items in the tree, the node becomes the root
        if (root == null) {
            root = node;
            return root;
        }
        // If the data is less than the root, insert into the left subtree
        else if (data < root.data) {
            root.left = insertHelper(root.left, node);
        }
        // If the data is greater than the root, insert into the right subtree
        else {
            root.right = insertHelper(root.right, node);
        }
        return root;
    }

    // Method to display the BST in an inorder traversal
    public void display() {
        displayHelper(root);
    }

    // Helper method for inorder traversal
    private void displayHelper(Node root) {
        if (root != null) {
            displayHelper(root.left); // Visit left subtree
            System.out.println(root.data); // Visit root
            displayHelper(root.right); // Visit right subtree
        }
    }

    // Method to search for a value in the BST
    public boolean search(int data) {
        return searchHelper(root, data);
    }

    // Helper method for searching
    private boolean searchHelper(Node root, int data) {
        // If the tree is empty or the value is not found
        if (root == null) {
            return false;
        }
        // If the value is found
        else if (root.data == data) {
            return true;
        }
        // If the value is less than the root, search in the left subtree
        else if (root.data > data) {
            return searchHelper(root.left, data);
        }
        // If the value is greater than the root, search in the right subtree
        else {
            return searchHelper(root.right, data);
        }
    }

    // Method to remove a node from the BST
    public void remove(int data) {
        // Check if the value exists in the tree
        if (search(data)) {
            removeHelper(root, data);
        } else {
            System.out.println(data + " data could not be found");
        }
    }

    // Helper method for removing a node
    public Node removeHelper(Node root, int data) {
        if (root == null) {
            return root;
        }
        // If the value is less than the root, go to the left subtree
        else if (data < root.data) {
            root.left = removeHelper(root.left, data);
        }
        // If the value is greater than the root, go to the right subtree
        else if (data > root.data) {
            root.right = removeHelper(root.right, data);
        }
        // Node to be deleted is found
        else {
            // Case 1: Node has no children
            if (root.left == null && root.right == null) {
                root = null;
            }
            // Case 2: Node has a right child
            else if (root.right != null) {
                // Replace with the successor
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            }
            // Case 3: Node has a left child
            else {
                // Replace with the predecessor
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }
        return root;
    }

    // Method to find the successor (smallest value in the right subtree)
    private int successor(Node root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    // Method to find the predecessor (largest value in the left subtree)
    private int predecessor(Node root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }
}