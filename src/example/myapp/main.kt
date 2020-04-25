package example.myapp

import example.myapp.decor.Color
import example.myapp.decor.Decoration

fun buildAquarium() {
    val myAquarium = Aquarium()
    myAquarium.printSize()

    val aquarium6 = Aquarium(numberOfFish = 29)
    aquarium6.printSize()
    aquarium6.volume = 70
    aquarium6.printSize()

    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}

fun makeDecorations() {
    val decoration1 = Decoration("granite", "wood", "diver")
    println(decoration1)
    val (rock, wood, diver) = decoration1
    println(rock)
    println(wood)
    println(diver)

    println(Color.BLUE.name)
    println(Color.BLUE.ordinal)
    println(Color.BLUE.rgb)
}

fun main() {
    buildAquarium()

    makeFish()

    makeDecorations()
}
