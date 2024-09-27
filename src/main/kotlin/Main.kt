import java.nio.file.Path

fun main() {

    //Instancia un lector de archivos
    val reader = FileReader()
    val writer = Output()

    // Crea las rutas necesarias
    val root = Path.of("src")
    val csvFilePath = root.resolve("main").resolve("resources").resolve("calificaciones.csv")

    // Lee el fichero y lo transforma a Lista
    var info = reader.getSubjectInfo(csvFilePath)

    info = writer.addFinalGrades(info)
    info.forEach { println(it) }

    val (passed, failed) = writer.createPassedLists(info)

    println("Aprobados:")
    passed.forEach { println(it) }

    println("\nSuspensos:")
    failed.forEach { println(it) }
}