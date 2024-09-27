import java.nio.file.Path

fun main() {

    //Instancia un lector de archivos
    val reader = FileReader()
    val writer = Output()

    // Crea las rutas necesarias
    val root = Path.of("src")
    val csvFilePath = root.resolve("main").resolve("resources").resolve("calificaciones.csv")

    try {
        // Lee el fichero y lo transforma a Lista
        var info = reader.getSubjectInfo(csvFilePath)

        // Añade las notas finales a la lista y las muestra
        info = writer.addFinalGrades(info)
        info.forEach { println(it) }

        // Crea las listas de aprobados y suspensos
        val (passed, failed) = writer.createPassedLists(info)

        // Imprime la lista de los aprobados
        println("Aprobados:")
        passed.forEach { println(it) }

        // Imprime la lista de los suspensos
        println("\nSuspensos:")
        failed.forEach { println(it) }
    } catch (e: Exception) {
        println("***ERROR*** ${e.message}")
    }

}