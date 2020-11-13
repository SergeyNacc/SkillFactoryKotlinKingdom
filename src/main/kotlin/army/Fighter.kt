package army

class Fighter (val specialization: Specialization){

    val type: String
    var weapon: String
    var strength: Int
    var dextirity: Int

    init {
        when (specialization) {

            Specialization.SWORDSMAN -> {
                type = "Archer"
                weapon = "Sword"
                strength = 20
                dextirity = 10
                }

            Specialization.ARCHER -> {
                type = "Archer"
                weapon = "Sword"
                strength = 10
                dextirity = 20
            }

        }
    }
}