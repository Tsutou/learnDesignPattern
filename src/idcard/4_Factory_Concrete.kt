package idcard
import framework.*

class IdCard(private val owner: String) : Product() {

    init {
        println("{$owner}のカードを作ります")
    }

    override fun use() {
        println("{$owner}のカードを使います")
    }

    fun getOwner(): String {
        return owner
    }
}

class IdCardFactory() : Factory() {

    private val owners: MutableList<String> = mutableListOf()

    override fun createProduct(owner: String): Product {
        return IdCard(owner)
    }

    override fun registerProduct(product: Product) {
        val idCard : IdCard = product as? IdCard ?: return
        owners.add(idCard.getOwner())
    }

    fun getOwners() : List<String>{
        return owners
    }
}