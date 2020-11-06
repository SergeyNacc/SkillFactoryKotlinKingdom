package kingdom

fun main() {

    val kingdom = Kingdom()

    println("Name: ${kingdom.ruler.name}. Power: ${kingdom.ruler.power}. Intellect: ${kingdom.ruler.intellect}.")


    println(kingdom.archers)
    println(kingdom.warriors)

}

class Kingdom {
    val ruler = Ruler("Sergio")
    val heirs = mutableListOf<Heir>()

    val archers = mutableListOf<Archer>()
    val warriors = mutableListOf<Warrior>()

    init {
        for (i in 0..19) {
            if (i % 2 == 0) {
                archers.add(Archer("Dagger"))
            } else {
                archers.add(Archer("None"))
            }
        }

        for (i in 0..29) {
            if (i % 2 == 0) {
                warriors.add(Warrior("Sword"))
            } else {
                warriors.add(Warrior("Axe"))
            }
        }
    }


}

open class Ruler(val name: String) {
    val power = 100f
    val intellect = 100f
}

class Heir(name: String): Ruler(name) {

}

data class Archer(val bow: String) {

}

data class Warrior (val weapon: String) {

}