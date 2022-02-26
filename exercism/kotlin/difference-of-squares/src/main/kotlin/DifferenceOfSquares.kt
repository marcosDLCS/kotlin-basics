import kotlin.math.pow

class Squares(private val num: Int) {

    fun sumOfSquares(): Int = (1..num).sumOf { it.toDouble().pow(2).toInt() }

    fun squareOfSum(): Int = (1..num).sum().toDouble().pow(2).toInt()

    fun difference(): Int = squareOfSum() - sumOfSquares()
}
