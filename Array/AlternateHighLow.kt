package Array

fun main(args : Array<String>){
    var arr : Array<Int> = arrayOf(1,2,3,4,5,6,7,8)
    var answer = makeArray(arr)

    for(i in arr){
        print("  " + i)
    }
}

private fun makeArray(arr : Array<Int>) : Array<Int>{
    for(i in 1..arr.size-2 step(2)){
        if(arr[i-1] > arr[i] ){
            var temp = arr[i-1]
            arr[i-1] = arr[i]
            arr[i] = temp
        }
        if(arr[i+1] > arr[i]){
            var temp = arr[i+1]
            arr[i+1] = arr[i]
            arr[i] = temp
        }
    }
    return arr
}