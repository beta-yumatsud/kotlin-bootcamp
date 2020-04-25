fun main(args: Array<String>) {
    println("Hello, ${args[0]}")

    val socialSecurityNumber = 999_99_9999L
    print(socialSecurityNumber)

    val fish = 50
    if (fish in 1..100) {
        println(fish)
    }

    val school = arrayOf("shark", "salmon", "minnow")
    for ((index, element) in school.withIndex()) {
        println("Item at $index is $element\n")
    }

    val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    val eager = decorations.filter { it[0] == 'p' }
    println("eager: $eager")
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")
    val newList = filtered.toList()
    println("new list: $newList")
    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }
    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")

    val lazyMap2 = decorations.asSequence().filter {it[0] == 'p'}.map {
        println("access: $it")
        it
    }
    println("-----")
    println("filtered: ${ lazyMap2.toList() }")

    val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
    println(updateDirty(30, waterFilter))

    val equipment = "fish net" to "catching fish"
    println("${equipment.first} used for ${equipment.second}")

    val numbers = Triple(7, 9, 100)
    println(numbers.toString())
    println(numbers.toList())
    val (n1, n2, n3) = numbers
    println("$n1 $n2 $n3")

    val list = listOf(1, 5, 3, 4)
    println(list.sum())
    println(list.subList(2, 4))
    val list2 = listOf("a", "bbb", "cc")
    println(list2.sumBy { it.length })
    for (s in list2.listIterator()) {
        println("$s ")
    }

    val cures = hashMapOf("white spots" to "Ich", "red sores" to "hole disease")
    println(cures.get("white spots"))
    println(cures.getOrDefault("hoge", "Roger"))
    println(cures.getOrElse("hoge"){"Roger"})
}

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}
