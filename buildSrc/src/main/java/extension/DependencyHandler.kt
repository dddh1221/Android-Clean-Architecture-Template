package extension

import core.*
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementationLibs(libs: Libs) {
    libs.getDependencies().forEach { dependencyType ->
        when(dependencyType) {
            is DependencyType.Platform -> {
                add("implementation", platform(dependencyType.value))
            }
            else -> {
                val typeName = dependencyType.javaClass.simpleName.run {
                    replace(first(), first().toLowerCase())
                }
                add(typeName, dependencyType.value)
            }
        }
    }
}