import idcard.IdCardFactory

fun main(){
    val factory = IdCardFactory()
    val card1 = factory.create("Tsutou")
    val card2 = factory.create("Hanako")
    val card3 = factory.create("Taro")

    card1.use()
    card2.use()
    card3.use()
}