import com.stark.grokking_algorithm.ChoiceSort

fun main(args:Array<String>){
//    print("hello world")
    val result = ChoiceSort().sort(arrayOf(3,7,0,2,10,9,8,8),false)
    val result2 = ChoiceSort().sort(arrayOf(3,7,0,2,10,9,8,8))
    print(result.toList())
    print(result2.toList())
}