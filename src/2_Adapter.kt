import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

fun main() {
    val p: Print = PrintBanner("Hello World")
    p.printWeak()
    p.printStrong()

    val f: FileIO = FileProperties()
    try {
        f.readFromFile("src/file.txt")
        f.setValue("year", "2004")
        f.setValue("month", "4")
        f.setValue("day", "21")
        f.writeToFile("newfile.txt")
    } catch (e: IOException) {
        e.printStackTrace()
    }
}

open class Banner(private val string: String) {

    fun showWithParen() {
        println("($string)")
    }

    fun showWithAster() {
        println("*$string*")
    }
}

interface Print {
    fun printWeak()
    fun printStrong()
}

class PrintBanner(string: String) : Banner(string), Print {
    override fun printWeak() {
        showWithParen()
    }

    override fun printStrong() {
        showWithAster()
    }
}

abstract class Print2 {
    abstract fun printWeak()
    abstract fun printStrong()
}

class PrintBanner2(private val string: String) : Print2() {

    private var banner: Banner = Banner(string)

    override fun printWeak() {
        banner.showWithParen()
    }

    override fun printStrong() {
        banner.showWithAster()
    }

}

interface FileIO {
    fun readFromFile(fileName: String)

    fun writeToFile(fileName: String)

    fun setValue(key: String, value: String)

    fun getValue(key: String)
}

class FileProperties : Properties(), FileIO {

    override fun readFromFile(fileName: String) {
        load(FileInputStream(fileName))
    }

    override fun writeToFile(fileName: String) {
        store(FileOutputStream(fileName), "written by FileProperties")
    }

    override fun setValue(key: String, value: String) {
        setProperty(key, value)
    }

    override fun getValue(key: String) {
        getProperty(key)
    }
}