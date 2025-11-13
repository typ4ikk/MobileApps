package example.myapp
import kotlin.math.PI

fun buildAquarium() {
    println("Aquarium №1")
    val aquarium1 = Aquarium()
    aquarium1.printSize()
    println("Aquarium №2")
    val aquarium2 = Aquarium(width = 100, height = 100)
    aquarium2.printSize()
    println("Aquarium №3")
    val aquarium3 = Aquarium(width = 100, height = 100, lenght = 120)
    aquarium3.printSize()
    println("Aquarium №4")
    val aquarium4 = Aquarium(numberOfFish = 29)
    aquarium4.printSize()
    aquarium4.volume = 70
    aquarium4.printSize()
    println("Aquarium №5")
    val aquarium5 = Aquarium(lenght = 25, width = 25, height = 40)
    aquarium5.printSize()
    println("My Tower Tank")
    val MyTower = TowerTank(diameter = 25, height = 40)
    MyTower.printSize()
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color}")
    shark.eat()
    println("Pleco: ${pleco.color}")
    pleco.eat()
}

fun main() {
    buildAquarium()
    makeFish()
}