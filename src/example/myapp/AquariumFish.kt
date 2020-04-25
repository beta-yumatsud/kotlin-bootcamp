package example.myapp

/*
abstract class AquariumFish: FishAction {
    abstract val color: String
    override fun eat() = println("yum")
}
*/

interface FishColor {
    val color: String
}
interface FishAction {
    fun eat()
    fun swim()  {
        println("swim")
    }
}

object GoldColor : FishColor {
    override val color = "gold"
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

class Shark: /*AquariumFish()*/FishAction, FishColor {
    override val color = "blue"
    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus(fishColor: FishColor = GoldColor): /*AquariumFish()*/
    FishAction by PrintingFishAction("eat eagle"),
    FishColor by fishColor

val Shark.isBlue: Boolean
    get() = color == "blue"
