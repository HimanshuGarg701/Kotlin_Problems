class List<T> {
    var head : Node<T>? = null

    fun add(value : T){
        var newNode = Node<T>(value)
        if(head==null){
            head = newNode
        }
        else{
            var temp = head
            while(temp!!.next!=null){
                temp = temp.next
            }
            temp.next = newNode
        }
    }

    fun printData(){
        var tempNode = head
        while(tempNode!=null){
            println(tempNode.data)
            tempNode = tempNode.next
        }
    }
}