package kingdom

fun main() {

    val kingdom = Kingdom()

    println("Name: ${kingdom.ruler.name}. Power: ${kingdom.ruler.power}. Intellect: ${kingdom.ruler.intellect}.")

}

class Kingdom {
    val ruler = Ruler("Sergio")
}

open class Ruler(val name: String) {
    val power = 100f
    val intellect = 100f
}

class Heir(name: String): Ruler(name) {

}

data class Archer (val bow: String, val dagger: String) {

}

data class Warrior (val weapon: String) {

}