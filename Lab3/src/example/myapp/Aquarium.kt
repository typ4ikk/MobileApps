package example.myapp
import kotlin.math.PI
open class Aquarium (open var lenght: Int = 100, open var width: Int = 20, open var height: Int = 40)  {
    constructor(numberOfFish: Int) : this() {
        val tank = numberOfFish * 2000 * 1.1
    }
    open val shape = "rectangle"

    open var volume: Int
        get() = lenght * width * height / 1000
        set(value) {
            height = (value * 1000) / (lenght * width)
        }

    open var water: Double = 0.0
        get() = volume * 0.9
    init {
        println("Aquarium initialized")
    }

    fun printSize() {
        println("Width: $width cm " +
                "height: $height cm " +
                "lenght: $lenght cm ")
        println("Volume: $volume liters " + "Water: $water liters (${water /volume * 100.0}%  full)")
    }
}

class TowerTank(override var height: Int, var diameter: Int) : Aquarium(height = height, width = diameter) {
    override var volume: Int
        get() = (width/2 * lenght/2 * height / 1000 * PI).toInt()
        set (value) {
            height = ((value * 1000 / PI) / (width/2 * lenght/2)).toInt()
        }
    override var water = volume * 0.8
    override  val shape = "cylinder"
}