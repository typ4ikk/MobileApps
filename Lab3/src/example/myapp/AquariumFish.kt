package example.myapp

interface FishColor {
    val color: String
}

object GoldColor : FishColor {
    override val color = "gold"
}

object GrayColor : FishColor {
    override val color = "gray"
}

interface FishAction {
    fun eat()
}

class PrintingFishAction (val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}
class Shark (fishColor: FishColor = GrayColor) :
    FishAction by PrintingFishAction(food = "hunt and eat fish"),
    FishColor by fishColor

class Plecostomus (fishColor: FishColor = GoldColor) :
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor

