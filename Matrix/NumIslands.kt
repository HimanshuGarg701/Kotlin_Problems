package Matrix

class NumIslands {
    fun getIslands(matrix : Array<Array<Int>>) : Int{
        var numberOfIslands = 0
        for(i in 0..matrix.size-1){
            for(j in 0..matrix[0].size-1){
                if(matrix[i][j] == 1){
                    numberOfIslands += searchConnectors(matrix, i, j)
                }
            }
        }
        return numberOfIslands
    }

    private fun searchConnectors(matrix : Array<Array<Int>>, i : Int, j : Int) : Int{
        if(i>=matrix.size || i<0 || j<0 || j>=matrix.size || matrix[i][j] == 0){
            return 0
        }
        else{
            matrix[i][j] = 0
            searchConnectors(matrix, i+1, j)
            searchConnectors(matrix, i-1, j)
            searchConnectors(matrix, i, j+1)
            searchConnectors(matrix, i, j-1)
            return 1
        }
    }
}

fun main(args : Array<String>){
    val matrix = arrayOf(
        arrayOf(1,1,1,0,0),
        arrayOf(1,1,0,0,1),
        arrayOf(1,1,1,0,0),
        arrayOf(0,0,0,0,1),
        arrayOf(1,0,0,0,0)
    )

    var obj = NumIslands()
    println("The number of islands : ${obj.getIslands(matrix)}")
}