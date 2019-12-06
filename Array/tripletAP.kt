package Array

fun main(args : Array<String>){
    var arr = arrayOf(5,8,9,11,12,15)

    findApTriplet(arr)
}

private fun findApTriplet(arr : Array<Int>){
    for(j in 1..arr.size-2){
        var i = j-1
        var k = j+1
        while(i>=0 && k<arr.size){
            var leftSide = arr[i] + arr[k]
            var rightSide = 2 * arr[j]
            if(leftSide == rightSide){
                println("${arr[i]}  ${arr[j]}  ${arr[k]}")
                k++
                i--
            }
            else if(leftSide < rightSide){
                k++
            }
            else{
                i--
            }
        }
    }
}