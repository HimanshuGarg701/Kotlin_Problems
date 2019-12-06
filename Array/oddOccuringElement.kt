package Array

fun main(args : Array<String>){
    val arr = arrayOf(1,1,2,2,3,4,4,5,6,5,6)

    println(oddOccuringElement(arr))
}

private fun oddOccuringElement(arr : Array<Int>) : Int{
    var map : HashMap<Int, Int> = hashMapOf()
    for(i in arr){
        if(!map.contains(i)){
            map.put(i, 1)
        }
        else{
            map.put(i, map.get(i)!! + 1)
        }
    }

    for(i in map.keys){
        if(map.get(i)!! % 2!=0){
            return i
        }
    }
    return -1
}