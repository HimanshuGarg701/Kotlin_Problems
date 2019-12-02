package Matrix
import java.util.*
class DiagonalTraversal {
    var map = mutableMapOf<Int, ArrayList<Int>>()
    fun printTraversal(matrix : Array<Array<Int>>) : Array<Array<Int>>{
        println("-----------PRINTING THE MATRIX DIAGONALLY---------------------")
        var index = 0
        for(i in 0..matrix.size-1){
            var j : Int = i
            var k : Int = 0
            var list = arrayListOf<Int>()
            while(k < matrix[0].size && j>=0){
                print("${matrix[j][k]}    ")
                list.add(matrix[j][k])
                k++
                j--
            }
            Collections.sort(list)
            map.put(index, list)
            index++
            println()
        }

        for(i in 1..matrix[0].size-1){
            var j = i
            var k = matrix.size-1
            var list = arrayListOf<Int>()
            while(k>=0 && j<matrix.size){
                print("${matrix[k][j]}    ")
                list.add(matrix[k][j])
                k--
                j++
            }
            Collections.sort(list)
            map.put(index, list)
            index++
            println()
        }
        return changeToDiagonalSort(matrix)
    }
    // After the above function, we have all the sorted elements diagonally in map with value of arrayList

    private fun changeToDiagonalSort(matrix : Array<Array<Int>>) : Array<Array<Int>>{
        var index = 0
        for(i in 0..matrix.size-1){
            var j = i
            var k = 0
            var arrIndex = 0
            while(k <matrix[0].size && j>=0){
                matrix[j][k] = map.get(index)!!.get(arrIndex)
                arrIndex++
                k++
                j--
            }
            index++
        }
        for(i in 1..matrix[0].size-1) {
            var j = i
            var k = matrix.size - 1
            var arrIndex = 0
            while (k >= 0 && j < matrix.size) {
                matrix[k][j] = map.get(index)!!.get(arrIndex)
                arrIndex++
                k--
                j++
            }
            index++
        }
        return matrix
    }
}

fun main(args : Array<String>){
    val matrix = arrayOf(
                    arrayOf(1,2,1,6,5),
                    arrayOf(1,4,9,2,3),
                    arrayOf(9,5,2,7,1),
                    arrayOf(8,1,6,2,3),
                    arrayOf(9,3,9,7,11)
                )

    val obj = DiagonalTraversal()

    var sortedResult = obj.printTraversal(matrix)

    println()
    println("---------------------DIAGONALLY SORTED MATRIX------------------------\n")
    for(i in 0..matrix.size-1){
        for(j in 0..matrix[i].size-1){
            print("${matrix[i][j]}    ")
        }
        println()
    }
}