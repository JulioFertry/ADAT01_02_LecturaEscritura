class GradeCalculator {

    /** Recibe un estudiante y sus notas y calcula la nota final
     *
     * @param studentInfo Estudiante con sus notas
     *
     * @return Nota final del estudiante
     */
    fun calculateFinalGrade(studentInfo: Map<String, List<Float>>): Float {
        val grades = studentInfo.values.first()

        val firstPartial = maxOf(grades[1], grades[3])
        val secondPartial = maxOf(grades[2], grades[4])
        val practiceExam = maxOf(grades[5], grades[6])

        return ((firstPartial * 0.3f) + (secondPartial * 0.3f) + (practiceExam * 0.4f))
    }


    /** Recibe un estudiante y dice si ha pasado la asignatura o no
     *
     * @param studentInfo Estudiante con sus notas
     *
     * @return Si ha pasado será true y si no ha pasado será false
     */
    fun hasPassed(studentInfo: Map<String, List<Float>>): Boolean {
        val grades = studentInfo.values.first()

        val assistency = grades[0]
        val firstPartial = maxOf(grades[1], grades[3])
        val secondPartial = maxOf(grades[2], grades[4])
        val practiceExam = maxOf(grades[5], grades[6])
        val finalGrade = grades[7]

        var passBool = true

        when {
            assistency < 75.0f -> passBool = false
            firstPartial < 4.0f -> passBool = false
            secondPartial < 4.0f -> passBool = false
            practiceExam < 4.0f -> passBool = false
            finalGrade < 5.0f -> passBool = false
        }

        return passBool
    }

}