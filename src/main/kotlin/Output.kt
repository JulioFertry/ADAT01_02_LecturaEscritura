class Output {

    private val gradeCalculator = GradeCalculator()


    /** Recibe la información de los estudiantes sin notas finales y devuelve la información con las notas finales
     *
     * @param studentsInfo Información de los estudiantes sin notas finales
     *
     * @return Información de los estudiantes con notas finales
     */
    fun addFinalGrades(studentsInfo: List<Map<String, List<Float>>>): List<Map<String, List<Float>>> {
        val studentsCompletedInfo = mutableListOf<Map<String, List<Float>>>()

        studentsInfo.forEach { dictionary ->
            val student = dictionary.keys.first()
            val grades = dictionary.values.first().toMutableList()

            val finalGrade = gradeCalculator.calculateFinalGrade(dictionary)
            grades.add(finalGrade)

            val studentsUpdatedInfo = mapOf(student to grades)
            studentsCompletedInfo.add(studentsUpdatedInfo)
        }

        return studentsCompletedInfo
    }


    /** Con la información de los estudiantes completa crea una lista de alumnos aprobados y otra de suspensos
     *
     * @param studentsInfo Información de los estudiantes completa
     *
     * @return Listas de aprobados y de suspensos
     */
    fun createPassedLists(studentsInfo: List<Map<String, List<Float>>>): Pair<List<String>, List<String>> {
        val passed = mutableListOf<String>()
        val failed = mutableListOf<String>()

        studentsInfo.forEach { dictionary ->
            val studentName = dictionary.keys.first()
            if (gradeCalculator.hasPassed(dictionary)) {
                passed.add(studentName)
            } else {
                failed.add(studentName)
            }
        }

        return Pair(passed, failed)
    }

}