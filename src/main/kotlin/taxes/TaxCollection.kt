package taxes

import peasants.Peasant

interface TaxCollection {
    fun collection(peasant: Peasant): Int
}