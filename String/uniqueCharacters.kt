import java.util.*;

fun main(args : Array<String>){
    println(allUnique("aple"))
}

private fun allUnique(str : String) : Boolean{
    var hashset = HashSet<Int>()
    for(i in 0..str.length()-1){
        if(!hashset.contains(str[i])){
            hashset.add(str[i])
        }
        else{
            return false
        }
    }
    return true
}