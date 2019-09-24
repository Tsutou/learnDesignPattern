import java.lang.IllegalArgumentException

class Singleton private constructor() {

    init {
        println("インスタンスを作成しました")
    }

    companion object {

        private var instance: Singleton? = null

        fun getInstance(): Singleton = synchronized(this) {
            instance ?: Singleton().apply {
                instance = this
            }
        }
    }
}

class TicketMaker private constructor() {
    private var ticket = 1000

    companion object {
        private var instance: TicketMaker? = null

        fun getInstance(): TicketMaker = synchronized(this) {
            instance ?: TicketMaker().apply {
                instance = this
            }
        }

    }

    fun getNextTicketNumber(): Int = synchronized(this) { ticket++ }
}

class Triple private constructor() {
    companion object {
        private var instance1: Triple? = null
        private var instance2: Triple? = null
        private var instance3: Triple? = null

        fun getInstance(id: Int): Triple? =
                when (id) {
                    1 -> instance1 ?: Triple().apply { instance1 = this }
                    2 -> instance2 ?: Triple().apply { instance2 = this }
                    3 -> instance3 ?: Triple().apply { instance3 = this }
                    else -> throw IllegalArgumentException()
                }
    }
}


fun main() {

    println("Start.")

    val obj1 = Singleton.getInstance()
    val obj2 = Singleton.getInstance()

    if (obj1 == obj2) {
        println("obj1とobj2は同じインスタンスです")
    } else {
        println("obj1とobj2は違うインスタンスです")
    }

    println("End.")

    repeat(10) {
        println(TicketMaker.getInstance().getNextTicketNumber())
    }
}