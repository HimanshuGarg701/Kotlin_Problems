package Matrix

fun main(args : Array<String>){
    val matrix = arrayOf(
                    arrayOf(1,2,3,4,5),
                    arrayOf(3,4,5,6,7),
                    arrayOf(4,5,6,7,8),
                    arrayOf(6,7,8,9,10)
                )

    printSpiral(matrix)
}

private fun printSpiral(matrix : Array<Array<Int>>){
    var top = 0
    var left = 0
    var right = matrix[0].size-1
    var bottom = matrix.size-1

    while(true){
        if(left > right){
            break
        }

        // Printing the top row of the matrix
        for(i in left..right){
            println("  " + matrix[top][i])
        }

        // After printing the top row, narrow down the matrix
        top++

        if(top>bottom){
            break
        }

        // Printing the right column
        for(i in top..bottom){
            println("  " + matrix[i][right])
        }

        // After printing the right column, narrow down the area from the right side
        right--

        if(left>right){
            break
        }

        // Printing the bottom row
        for(i in right.downTo(left)){
            println("  " + matrix[bottom][i])
        }

        // After printing the bottom row, narrow down the area from the bottom
        bottom--

        if(top > bottom){
            break
        }

        // Printing out the left column
        for(i in bottom.downTo(top)){
            println("  " + matrix[i][left])
        }
        left++
    }
}