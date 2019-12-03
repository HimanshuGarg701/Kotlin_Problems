package Matrix

import java.util.*

fun main(args : Array<String>){
    val arr = arrayOf(1,4,5,6,7,2)
    Arrays.sort(arr)
    val sum = 15

    println(isPresent(arr, sum))
}

private fun isPresent(arr : Array<Int>, sum : Int) : Boolean{
    var matrix = Array(arr.size){Array (sum+1){false} }


    // Filling out the first column where sum is zero
    for(i in 0..matrix.size-1){
        matrix[i][0] = true
    }
    /*
    matrix
        0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15
    1   T   T   F   F   F   F   F   F   F   F   F   F   F   F   F   F
    2   T   T   T   T   F   F   F   F   F   F   F   F   F   F   F   F
    4   T   T   T   T   T   T   T   T   F   F   F   F   F   F   F   F
    5   T   T   T   T   T   T   T   T   T   T   T   T   T   F   F   F
    6   T   T   T   T   T   T   T   T   T   T   T   T   T   T   T   T
    7   T   T   T   T   T   T   T   T   T   T   T   T   T   T   T   T
     */

    // Filling out the first row to check if the sum can be generated
    for(i in 1..matrix[0].size-1){
        if(i % arr[0] == 0 && i <= arr[0]){
            matrix[0][i] = true
        }
    }

    // Filling out the rest of the rows based on above result or at matrix[i-1][j-arr[i]]
    for(i in 1..matrix.size-1){
        for(j in 1..matrix[i].size-1){
            if(matrix[i-1][j] == true){
                matrix[i][j] = true
            }
            if(j - arr[i] >=0){
                if(matrix[i-1][j-arr[i]]){
                    matrix[i][j] = true
                }
            }
        }
    }
    return matrix[matrix.size-1][matrix[0].size-1]
}