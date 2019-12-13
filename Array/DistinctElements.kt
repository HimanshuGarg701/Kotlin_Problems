package Array

fun main(args : Array<String>){
    val arr = arrayOf(1,2,3,4,3,4,5,6,4,3,6,7,8)
    var subArraySize = 5

    printDistinct(arr, subArraySize)
}

private fun printDistinct(arr : Array<Int>, size : Int){
    var set : HashSet<Int> = hashSetOf()
    var list : ArrayList<Int> = arrayListOf()
    for( i  in arr){
        list.add(i)
    }
    for(i in 0..arr.size-size){
        var set : HashSet<Int> = hashSetOf()
        set.addAll(list.subList(i, i+size))
        println("The number of unique items in [$i to ${i+size}] : ${set.size}")
    }
}