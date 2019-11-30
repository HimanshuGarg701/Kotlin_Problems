package BinaryTree

import java.util.*

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
}