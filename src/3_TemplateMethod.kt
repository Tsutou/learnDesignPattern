
abstract class AbstractDisplay {
    abstract fun open()
    abstract fun print()
    abstract fun close()
    fun display() {
        open()
        repeat(5) {
            print()
        }
        close()
    }
}

class CharDisplay(private val ch: CharSequence) : AbstractDisplay() {
    override fun open() {
        print("<<")
    }

    override fun print() {
        print(ch)
    }

    override fun close() {
        println(">>")
    }
}

class StringDisplay(private val string: String) : AbstractDisplay() {

    private val width : Int = string.toByteArray().size

    override fun open() {
        printLine()
    }

    override fun print() {
        println("|$string|")
    }

    override fun close() {
        printLine()
    }

    private fun printLine(){
        print("+")
        repeat(width){
            print("-")
        }
        println("+")
    }
}

fun main(){
    val d1 : AbstractDisplay = CharDisplay("h")
    val d2 : AbstractDisplay = StringDisplay("Hello World")
    val d3 : AbstractDisplay = StringDisplay("こんにちは。")

    d1.display()
    d2.display()
    d3.display()
}
