package BinaryTree

fun main(args : Array<String>){
    var obj = Tree()
    obj.addElement(3)
    obj.addElement(2)
    obj.addElement(5)
    obj.addElement(4)
    obj.addElement(7)
    obj.addElement(6)

    obj.printTree()
    println("-----------PRE-ORDER----------------")
    obj.preOrder()

    println("------------POST-ORDER----------------")
    obj.postOrder()

    println("-----------IN-ORDER------------------")
    obj.iterativeInOrder()

    println("-----------LEVEL-ORDER----------------")
    obj.levelOrder()

    println("----------RECURSIVE-LEVEL-ORDER---------")
    obj.levelPrinting()

    println("-----------------INVERTING------------------")
    obj.invertTree(obj.root)
}