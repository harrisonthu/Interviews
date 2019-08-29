public class BinarySearchTree {

    // Create nested class for Node class
    public class Node{
        int key;
        Node left;
        Node right;
    }

    // Root of the Node
    Node root;

    //Constructor ==> contain Node ==> NULL
    BinarySearchTree(){
        this.root = null;
    }

    //Insertion
    // value = new value that I want to insert
    void Insertion(int value){
        root = InsertionHelper(root,value);
    }

    // use helper class for insertion
    // Reason using helper, so move left/right of the root.
    Node InsertionHelper(Node root,int value){
        if (root == null){
            root = new Node();
            return root;
        }
        // not null BST, already exist
        // recursively go down the tree
        if (value < root.key){ // less than current value
            InsertionHelper(root.left, value);
        }
        else if (value > root.key){
            InsertionHelper(root.right, value);
        }

        return root;
    }



    //End of BinarySearchTree Class
}
