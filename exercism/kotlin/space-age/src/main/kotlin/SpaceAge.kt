import java.math.BigDecimal
import java.math.RoundingMode

private const val ONE_EARTH_YEAR_SECONDS = 31557600

class SpaceAge(private val input: Long) {

    fun onEarth(): Double = calculate(1.0)

    fun onMercury(): Double = calculate(0.2408467)

    fun onVenus(): Double = calculate(0.61519726)

    fun onMars(): Double = calculate(1.8808158)

    fun onJupiter(): Double = calculate(11.862615)

    fun onSaturn(): Double = calculate(29.447498)

    fun onUranus(): Double = calculate(84.016846)

    fun onNeptune(): Double = calculate(164.79132)

    private fun calculate(factor: Double) =
        BigDecimal(input)
            .divide(BigDecimal(ONE_EARTH_YEAR_SECONDS).multiply(BigDecimal(factor)), 2, RoundingMode.HALF_UP)
            .toDouble()

}
