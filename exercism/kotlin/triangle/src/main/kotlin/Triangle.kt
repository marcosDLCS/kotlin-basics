class Triangle<out T : Number>(a: T, b: T, c: T) {
    private val unique = setOf(a, b, c)
    private val sides = listOf(a.toDouble(), b.toDouble(), c.toDouble())

    init {
        require(sides.sum() != 0.0)
        require(sides.all { sides.minus(it).sum() >= it })
    }

    val isEquilateral: Boolean = unique.size == 1
    val isIsosceles: Boolean = unique.size < 3
    val isScalene: Boolean = unique.size == 3
}
