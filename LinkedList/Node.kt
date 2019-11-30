class Node<T>(value : T) {

    var data : T = value;
    var next : Node<T>? = null;

    fun setValue(value : T){
        this.data = value
    }

    fun getValue() : T{
        return this.data
    }

    fun setNextNode(next : Node<T>){
        this.next = next
    }
}