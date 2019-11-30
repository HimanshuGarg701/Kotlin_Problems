package BinaryTree

class Tree {
    var root : Node? = null

    fun addElement(value : Int){
        if(root == null){
            root = Node(value)
        }
        else{
            addHelper(root!!, value)
        }
    }

    private fun addHelper(node : Node?, value : Int) : Node{
        if(node==null){
            return Node(value)
        }
        if(value < node.value){
            node.left = addHelper(node.left, value)
        }

        else if(value>node.value){
            node.right = addHelper(node.right, value)
        }
        else{
            // Node already exists
        }
        return node
    }

    fun printTree(){
        if(root!=null){
            printHelper(root)
        }
    }

    private fun printHelper(node : Node?){
        if(node!=null){
            printHelper(node.left)
            println(node.value)
            printHelper(node.right)
        }

    }
}