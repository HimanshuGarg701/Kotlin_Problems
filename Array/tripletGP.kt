package Array

fun main(args : Array<String>){
    val arr = arrayOf(2,4,6,12,24, 36)

    printTripletGP(arr)
}

private fun printTripletGP(arr : Array<Int>){
    for(j in 1..arr.size-2){
        var i = j-1
        var k = j+1
        while(i>=0 && k<arr.size){
            if(arr[j] * arr[j] == arr[i] * arr[k]){
                println("${arr[i]}    ${arr[j]}    ${arr[k]}")
                i--
                k++
            }
            else if(arr[j] * arr[j] < arr[i] * arr[k]){
                k++
            }
            else{
                i--
            }
        }
    }
}