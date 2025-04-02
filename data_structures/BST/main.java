package BST;
public class main {
    public main(String[] args) {
        
        BSTree tree= new BSTree();

        tree.insert(new Node(5));
        tree.insert(new Node(1));
        tree.insert(new Node(3));
        tree.insert(new Node(7));
        tree.insert(new Node(9));
        tree.insert(new Node(4));
        tree.insert(new Node(6));
        tree.insert(new Node(2));

        tree.display(); //2, 3, 4, 5, 6, 7, 9

        System.out.println(tree.search(9));
        tree.remove(9);
        tree.display();
    }    
}
