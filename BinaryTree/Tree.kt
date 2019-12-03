package BinaryTree

import java.util.*
import kotlin.collections.HashMap

class Tree {
    var root : Node? = null

    // Adding elements to the Binary Tree
    fun addElement(value : Int){
        // Check if root is null, if yes than initialize the root
        if(root == null){
            root = Node(value)
        }
        // if root is not null call the helper to add the next elements
        else{
            addHelper(root!!, value)
        }
    }

    // Use recursion in the helper method to reach the right location
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

    fun preOrder(){
        if(root==null){
            return
        }
        else{
            preOrderHelper(root)
        }
    }

    private fun preOrderHelper(node : Node?){
        var stack = Stack<Node>()
        stack.push(node)
        while(!stack.isEmpty()){
            val removed = stack.pop()
            println(removed.value)
            if(removed.right!=null){
                stack.push(removed.right)
            }
            if(removed.left!=null){
                stack.push(removed.left)
            }
        }
    }

    fun postOrder(){
        if(root==null){
            return
        }
        else{
            postOrderHelper(root)
        }
    }

    private fun postOrderHelper(node : Node?){
        var stack1 = Stack<Node>()
        var stack2 = Stack<Node>()
        stack1.push(node)
        while(!stack1.isEmpty()){
            val removed = stack1.pop()
            stack2.push(removed)
            if(removed.left!=null){
                stack1.push(removed.left)
            }
            if(removed.right!=null){
                stack1.push(removed.right)
            }
        }

        // Printing the data from stack 2
        while(!stack2.isEmpty()){
            println(stack2.pop().value)
        }
    }

    fun iterativeInOrder(){
        if(root==null){
            return
        }
        else{
            iterativeInOrderHelper(root)
        }
    }

    private fun iterativeInOrderHelper(node : Node?){
        var nod = node
        var stack = Stack<Node>()
        while(true){
            if(nod!=null){
                stack.push(nod)
                nod = nod.left
            }
            else{
                if(stack.isEmpty()) {
                    break
                }
                nod = stack.pop()
                println(nod.value)
                nod = nod.right
            }
        }
    }

    // Iterative level order traversal
    fun levelOrder(){
        if(root==null){
            return
        }
        else{
            levelOrderHelper(root)
        }
    }

    private fun levelOrderHelper(node : Node?){
        var que : Queue<Node> = LinkedList()
        que.add(node)
        while(!que.isEmpty()){
            var removed = que.poll()
            println(removed.value)
            if(removed.left!=null){
                que.add(removed.left)
            }
            if(removed.right!=null) {
                que.add(removed.right)
            }
        }
    }

    fun levelPrinting(){
        if(root==null){
            return
        }
        else{
            var map : HashMap<Int, ArrayList<Int>> = HashMap()
            levelHelper(root, 1, map)
            for(x in map.keys){
                println(map.get(x).toString())
            }
        }
    }

    private fun levelHelper(node : Node?, level : Int, map:HashMap<Int, ArrayList<Int>>){
        if(node!=null){
            if(!map.containsKey(level)){
                map.put(level, ArrayList<Int>())
            }

            map.get(level)!!.add(node.value)
            levelHelper(node.left, level+1, map)
            levelHelper(node.right, level+1, map)
        }
    }

    fun invertTree(node : Node?){
        if(node == null){
            return
        }
        else{
            printHelper(invertHelper(node))
        }
    }

    private fun invertHelper(node : Node?) : Node?{
        if(node==null){
            return null
        }
        var nodeRight = invertHelper(node.right)
        var nodeLeft = invertHelper(node.left)

        node.left = nodeRight
        node.right = nodeLeft
        return node
    }
}