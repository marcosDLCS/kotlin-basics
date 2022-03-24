data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(input: List<List<Int>>) {

    val saddlePoints = maxRowSP(input).intersect(minColSP(input))

    private fun getColumn(m: List<List<Int>>, indexColumn: Int): List<Int> = m.map { row -> row[indexColumn] }

    private fun indexesFnAp(l: List<Int>, f: (arrayValues: List<Int>) -> Int?): List<Int> =
        l.mapIndexed { index, value -> if (value == f(l)) index else -1 }.filter { it != -1 }

    private fun idxMin(c: List<Int>): List<Int> = indexesFnAp(c, List<Int>::minOrNull)

    private fun idxMax(r: List<Int>): List<Int> = indexesFnAp(r, List<Int>::maxOrNull)

    private fun maxRowSP(m: List<List<Int>>): Set<MatrixCoordinate> {
        return m.mapIndexed { indexRow, row ->
            idxMax(row).map { indexColumn ->
                MatrixCoordinate(
                    row = indexRow + 1,
                    col = indexColumn + 1
                )
            }
        }.flatten().toSet()
    }

    private fun minColSP(m: List<List<Int>>): Set<MatrixCoordinate> {
        return List(m[0].size) { indexCol ->
            idxMin(getColumn(m, indexCol)).map { indexRow ->
                MatrixCoordinate(
                    row = indexRow + 1,
                    col = indexCol + 1
                )
            }
        }.flatten().toSet()
    }
}

// Kudos: SanchezPickle's