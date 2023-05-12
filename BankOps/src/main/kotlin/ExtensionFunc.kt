class ExtensionFunc {
    class Dish(val dishName: String, val ingredients: MutableList<String>)

    fun Dish.printIngredients(){
        println(ingredients)
    }

    fun Dish.removeSalt(){
        ingredients.remove("Salt")
    }

    fun main() {
        val onionSoup = Dish("onion soup", mutableListOf("Onion", "Cheese", "Water", "Salt"))
        onionSoup.removeSalt()
        onionSoup.printIngredients()
    }
}