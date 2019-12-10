package Array

fun main(args : Array<String>){
    val arr  = arrayOf(5,6,2,2,3,4,4)
    val result = getPartition(arr)
    println(result[0].toString())
    println(result[1].toString())
}

private fun getPartition(arr : Array<Int>) : Array<ArrayList<Int>>{
    var answer = Array(2){ArrayList<Int>()}
    var sum = 0
    for (x in arr){
        sum += x
    }
    var continuousSum = 0
    var index : Int= -1
    for(x in 0..arr.size-1){
        continuousSum += arr[x]
        if(sum - continuousSum == continuousSum){
            index = x
        }
    }
    var list1: ArrayList<Int> = arrayListOf()
    var list2: ArrayList<Int> = arrayListOf()
    if(index!=-1) {
        for (i in 0..index) {
            list1.add(arr[i])
        }

        for (i in index + 1..arr.size - 1) {
            list2.add(arr[i])
        }
    }
    answer[0] = list1
    answer[1] = list2
    return answer
}