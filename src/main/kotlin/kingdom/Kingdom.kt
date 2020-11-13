package kingdom

import army.Fighter
import army.Specialization
import monarchy.Heir
import monarchy.Noble
import monarchy.Ruler
import peasants.Occupation
import peasants.Peasant
import taxes.TaxCollector

/*
 *  upgrade Army
 */

fun Fighter.upgrade() {
    when (specialization) {
        Specialization.SWORDSMAN -> {
            weapon = "Longsword"
            strength += 1
        }

        Specialization.ARCHER -> {
            weapon = "Longbow"
            dextirity += 1
        }
    }
}

fun main() {

    val kingdom = Kingdom()

    collectTaxes(kingdom) {
        println("Мой Король, в казне: $it золота!")
    }

    upgradeArmy(kingdom.army)

    whoWillInheritThrone(kingdom.heirs) {
        println("Следующий король это - ${it.name}!")
    }
}

class Kingdom {

    var treasury = 0

    val ruler: Noble = createRuler()
    val heirs: List<Noble> = createHeirs()

    val army: List<Fighter> = createArmy()
    val peasants: List<Peasant> = createPeasants()

    val taxCollector: TaxCollector = TaxCollector()

    /*
     * created King
     */

    private fun createRuler() = Ruler("Sergio").also {
        println("Да здравствует король ${it.name}!")
    }


    /*
     *  created Heirs
     */

    private fun createHeirs(): List<Noble> = mutableListOf<Noble>().apply {
        add(Heir("Artur"))
        add(Heir("Maksim"))
        add(Heir("Aleksandr"))

        forEach {
            println("Приветствуем ${it.name}!")
        }
    }

    /*
     * created Army
     */

    private fun createArmy(): List<Fighter> = mutableListOf<Fighter>().apply {
        repeat(50) {
            if (it % 2 == 0) {
                add(Fighter(Specialization.ARCHER))
            } else {
                add(Fighter(Specialization.SWORDSMAN))
            }
        }
    }

    /*
     * created Peasants
     */

    private fun createPeasants() = mutableListOf<Peasant>().apply {
        repeat(100) {
            when {
                it % 3 == 0 -> add(Peasant(Occupation.FARMER))
                it % 2 == 0 -> add(Peasant(Occupation.BUILDER))
                else -> add(Peasant(Occupation.WORKER))
            }
        }
    }

}

/*
* tax collection
*/

private fun collectTaxes(kingdom: Kingdom, function: (tax: Int) -> Unit) {
    kingdom.peasants.forEach {
        val tax = kingdom.taxCollector.collection(it)
        kingdom.treasury += tax
    }
    function(kingdom.treasury)
}

/*
 * extension fun
 */

private fun upgradeArmy(army: List<Fighter>) {
    army.forEach {
        it.upgrade()
    }
}


/*
 * next Heir
 */

fun whoWillInheritThrone(heirs: List<Noble>, function: (Noble) -> Unit) {
    val heir = heirs.maxByOrNull {
        it.power + it.intellect
    }
    function (heir!!)
}