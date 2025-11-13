package example.myapp.decor

fun makeDecoration() {
    val decoration1 = Decoration("granite")
    println(decoration1)
    val decoration2 = Decoration("slate")
    println(decoration2)
    val decoration3 = Decoration("slate")
    println(decoration3)

    println(decoration1.equals(decoration2))
    println(decoration3.equals(decoration2))
}
data class Decoration (val rocks: String) {
}

enum class Direction(val degrees: Int) {
    North(0), South(180), West(270), East(90);
}

fun main() {
    makeDecoration()

    println(Direction.East.name)
    println(Direction.East.ordinal)
    println(Direction.East.degrees)
}