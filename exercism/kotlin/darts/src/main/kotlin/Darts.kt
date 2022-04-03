import kotlin.math.pow

object Darts {

    fun score(x: Number, y: Number): Int {

        val xD: Double = x.toDouble()
        val yD: Double = y.toDouble()

        if (isInside(1.0, xD, yD)) return 10
        if (isInside(5.0, xD, yD)) return 5
        if (isInside(10.0, xD, yD)) return 1

        return 0
    }

    private fun isInside(rad: Double, x: Double, y: Double): Boolean {
        return (x - 0.0).pow(2) + (y - 0.0).pow(2) <= rad.pow(2)
    }
}
