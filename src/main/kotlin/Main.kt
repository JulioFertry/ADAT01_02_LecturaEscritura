package org.example

import java.nio.file.Path

fun main() {

    //Instancia un lector de archivos
    val reader = FileReader()

    // Crea las rutas necesarias
    val root = Path.of("src")
    val csvFilePath = root.resolve("main").resolve("resources").resolve("calificaciones.csv")

    val info = reader.getSubjectInfo(csvFilePath)
    info.forEach { println(it) }

}