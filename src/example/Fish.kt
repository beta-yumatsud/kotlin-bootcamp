package example

data class Fish(var name: String)

fun fishExamples() {
    val fish = Fish("splashy")
    with(fish.name) {
        println(this.capitalize())
    }
    myWith(fish.name) {
        println(capitalize())
    }
    fish.run {
        name
    }
    val newFish = fish.apply {
        name = "sharky"
    }
    println(newFish.name)
    println(fish.let { it.name.capitalize() }
        .let { it + "fish" }
        .let { it.length }
        .let { it + 31 }
    )
}

fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}

fun main() {
    fishExamples()
}