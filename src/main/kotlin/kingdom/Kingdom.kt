package kingdom

import peasants.Occupation
import peasants.Peasant

fun main() {

    val kingdom = Kingdom()

    println("Name: ${kingdom.ruler.name}. Power: ${kingdom.ruler.power}. Intellect: ${kingdom.ruler.intellect}.")

    kingdom.heirs.forEach{
        println("Name: ${it.name}. Power: ${it.power}. Intellect: ${it.intellect}")
    }

    println(kingdom.archers)
    println(kingdom.warriors)

}

class Kingdom {
    val ruler = Ruler("Sergio")
    val heirs = mutableListOf<Heir>()

    val archers = mutableListOf<Archer>()
    val warriors = mutableListOf<Warrior>()

    val peasants = mutableListOf<Peasant>()

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

        for (i in 1..3) {
            val whellOfFortune = WheelOfFortune()
            heirs.add(Heir("Heirs $i", whellOfFortune))
        }

        /*
        * Creat Peasants
        */

        for (i in 0..99) {
            when {
                i % 3 == 0 -> {
                    peasants.add(Peasant(Occupation.FARMER))
                }
                i % 2 == 0 -> {
                    peasants.add(Peasant(Occupation.BUILDER))
                }
                else -> {
                    peasants.add(Peasant(Occupation.WORKER))
                }
            }
        }
    }


}

open class Ruler(val name: String) {
    var power = 100f
    var intellect = 100f

    companion object{
        fun geroldGreetings() {
            println("Его Величиство в здании!")
        }
    }
}

class Heir(name: String, whellOfFortune: WheelOfFortune): Ruler(name) {
    init {
        power *= whellOfFortune.coefficient()
        intellect *= whellOfFortune.coefficient()
    }
}

data class Archer(var bow: String = "Longbow", val dagger: String) {
    constructor(dagger: String): this("Longbow", dagger)
}

data class Warrior (val weapon: String) {
}

class WheelOfFortune {
    fun coefficient(): Float = (0..100).random() / 100f
}