package generics

open class WaterSupply(var needProcessing: Boolean)

class TapWater: WaterSupply(true) {
    fun addChemicalCleaners() {
        needProcessing = false
    }
}

class FishWater: WaterSupply(false)

class LakeWater: WaterSupply(true) {
    fun filter() {
        needProcessing = false
    }
}

// class Aquarium<T: Any?>(val waterSupply: T)と同じ状態
// in: クラス内に通すことはできるけど、外に出すことはできない
// out: クラスの外に出すことだけできる(メソッドとして呼べる)
// Out and in are easy to remember:
// out types can be passed outward as return values, in types can be passed inward as arguments.
class Aquarium<out T: WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needProcessing) {
            cleaner.clean(waterSupply)
        }
        check(!waterSupply.needProcessing) { "water supply needs processing first" }
        println("adding water from $waterSupply")
    }
}

interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) = waterSupply.addChemicalCleaners()
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

fun <T: WaterSupply>isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean: ${aquarium.waterSupply.needProcessing}")
}

inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T

inline fun <reified R: WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R

fun genericsSample() {
    val cleaner = TapWaterCleaner()
    val aquarium = Aquarium<TapWater>(TapWater())
    addItemTo(aquarium)
    println("water needs processing: ${aquarium.waterSupply.needProcessing}")
    aquarium.waterSupply.addChemicalCleaners()
    println("water needs processing: ${aquarium.waterSupply.needProcessing}")
    aquarium.addWater(cleaner)
    isWaterClean(aquarium)
    println(aquarium.waterSupply.isOfType<TapWater>())
    println(aquarium.hasWaterSupplyOfType<TapWater>())

    /*
    val aquarium2 = Aquarium(null)
    if (aquarium2.waterSupply == null) {
        println("waterSupply is null")
    }
    */
    val aquarium2 = Aquarium(LakeWater())
    aquarium2.waterSupply.filter()
    //aquarium2.addWater()
}

fun main() {
    genericsSample()
}