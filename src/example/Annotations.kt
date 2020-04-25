package example

import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.findAnnotation

annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet
@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

@ImAPlant class Plant {
    @get:OnGet
    val isGrowing: Boolean = true

    @set:OnSet
    var needsFood: Boolean = false

    fun trim(){}
    fun fertilize(){}
}

fun testAnnotations() {
    val classObj = Plant::class
    for (m in classObj.declaredMemberFunctions) {
        println(m.name)
    }
    for (a in classObj.annotations) {
        println(a.annotationClass.simpleName)
    }
    println(classObj.findAnnotation<ImAPlant>())
}

fun main() {
    testAnnotations()
}