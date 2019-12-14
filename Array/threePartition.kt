package Array

fun main(args : Array<String>){
    var arr = arrayListOf(8,2,5,4,1,5,5)

    printPartitions(arr)
}

private fun printPartitions(arr : ArrayList<Int>){
    var answerIndex = Array(2){0}
    var sum = 0
    for(i in arr){
        sum += i
    }

    var currentSum = 0
    var index = 0
    for(i in 0..arr.size-1){
        currentSum += arr[i]
        if(currentSum == sum - currentSum){
            answerIndex[index] = i
            index++
        }
    }
    for(i in answerIndex){
        println(i)
    }
    println("The first half ${arr.subList(0, answerIndex[0]+1).toString()}")
    println("The second partition ${arr.subList(answerIndex[0]+1 , answerIndex[1] + 1).toString()}")
    println("The last partition ${arr.subList(answerIndex[1], arr.size).toString()}")
}