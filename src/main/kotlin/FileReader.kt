package org.example

import java.io.BufferedReader
import java.nio.file.Files
import java.nio.file.Path

class FileReader {

    /** Lee un fichero csv con la información de un curso y devuelve una lista con la información mapeada
     *
     * @param csvPath Ruta del fichero csv
     *
     * @return Lista de la información del curso
     */
    fun getSubjectInfo(csvPath: Path): List<Map<String, List<Float>>> {
        if (Files.notExists(csvPath)) {
            throw IllegalArgumentException(" - No existe el archivo")
        }

        val subjectMappedInfo = mutableListOf<Map<String, List<Float>>>()
        val br: BufferedReader = Files.newBufferedReader(csvPath)

        var isFirstLine = true
        br.use { reader ->
            reader.forEachLine { line ->
                if (isFirstLine) {
                    isFirstLine = false
                } else {
                    val values = line.split(";")
                    val studentName = "${values[0]}, ${values[1]}"

                    val onlyNumericValues = values.drop(2).map {
                        it
                            .replace(",", ".")
                            .replace("%", "")
                    }

                    val studentData = onlyNumericValues.map { value ->
                        if (value.isEmpty()) {
                            0.0f
                        } else {
                            value.toFloat()
                        }
                    }

                    val dictionary = mapOf(studentName to studentData)
                    subjectMappedInfo.add(dictionary)
                }
            }
        }

        return subjectMappedInfo.sortedBy { dictionary -> dictionary.keys.first() }
    }

}