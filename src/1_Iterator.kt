fun main() {

    val bookShelf = BookShelf()
    bookShelf.apply {
        appendBook(Book("夜と霧"))
        appendBook(Book("愛と幻想のファシズム"))
        appendBook(Book("対岸の彼女"))
        appendBook(Book("不夜城"))
    }
    val iterator = bookShelf.iterator()

    while (iterator.hasNext()) {
        val book = iterator.next() as? Book
        println(book?.name)
    }

}

interface Aggregate {
    fun iterator(): Iterator
}

interface Iterator {
    fun hasNext(): Boolean
    fun next(): Any
}

data class Book(
        val name: String
)

class BookShelf : Aggregate {

    private val books: MutableList<Book> by lazy {
        mutableListOf<Book>()
    }

    private var last: Int = 0

    fun getBookAt(index: Int): Book {
        return books[index]
    }

    fun appendBook(book: Book) {
        books.add(last, book)
        last++
    }

    fun getLength(): Int {
        return last
    }

    override fun iterator(): Iterator {
        return BookShelfIterator(this)
    }
}

class BookShelfIterator(
        private val bookShelf: BookShelf,
        private var index: Int = 0) : Iterator {

    override fun hasNext(): Boolean {
        return index < bookShelf.getLength()
    }

    override fun next(): Any {
        val book = bookShelf.getBookAt(index)
        index++
        return book
    }
}