class Matrix(matrixAsString: String) {

    private val rows: Map<Int, List<Int>> = matrixAsString
        .split("\n")
        .mapIndexed { i, s -> Pair(i + 1, cleanRow(s).split(" ").map { n -> Integer.valueOf(n) }.toList()) }
        .toMap()

    fun column(colNr: Int): List<Int> {
        return rows.map { i -> i.value[colNr - 1] }.toList()
    }

    fun row(rowNr: Int): List<Int> {
        return rows[rowNr]!!
    }

    private fun cleanRow(s: String): String {
        return s.replace(Regex(" +"), " ").trim()
    }
}
