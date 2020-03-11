import com.stark.grokking_algorithm.*
import java.util.*

fun main(args:Array<String>){
//    print("hello world")
//    val source = mutableListOf<Int>()
//    for (i in 1..100000){
//        source.add((0..100000).random())
//    }
//    var start = Date().time
//    var result = ChoiceSort().sort(source.toTypedArray(),false)
//    var end = Date().time
//    println("Choice sort time ${end - start}")
////    val result2 = ChoiceSort().sort(source.toTypedArray())
////    println(result.toList())
////    println(result2.toList())
//    start = Date().time
//    result = QuickSort().sort(source.toTypedArray())
//    end = Date().time
//    println("quick sort time ${end - start}")
////    println("quick sort result ${result.toList()}")
//
//    println("gcd :189,18: ${GCD().gcd(189,18)}")
//    println(BreadthFirstSearch().find(createNode()){node -> node?.name == "lily" })
    DirectedGraph.test()
}
fun createNode(): Node {
    val lily = Node(null,"lily")
    val a = Node(listOf(lily),"a")
    val b = Node(listOf(a),"b")
    val c = Node(listOf(a),"c")
    val d = Node(listOf(a),"d")
    val e = Node(listOf(b,c),"e")
    return Node(listOf(e,d),"root")
}