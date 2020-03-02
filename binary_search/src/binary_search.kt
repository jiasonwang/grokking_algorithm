fun main(args: Array<String>) {
    println(BinarySearch(arrayOf(1, 3, 5, 7, 9)).search(7))
    println(BinarySearch(arrayOf(2, 4, 6, 8, 10)).search(10))
}

class BinarySearch(private val list: Array<Int>) {
    fun search(value: Int): Int {
        var low = 0
        var high = list.size - 1
        var count = 0
        while (low <= high) {
            count ++
            val mid = (low + high) / 2
            val guess = list.get(mid)
            if (value < guess) {
                high = mid - 1
            } else if (value > guess) {
                low = mid + 1
            } else {
                println("count : $count")
                return mid
            }
        }
        println("count : $count")
        return -1
    }
}