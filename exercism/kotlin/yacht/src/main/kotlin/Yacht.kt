object Yacht {

    fun solve(category: YachtCategory, vararg dices: Int): Int? {
        return when (category) {
            YachtCategory.YACHT -> if (dices.toMutableSet().size == 1) 50 else 0
            YachtCategory.ONES -> numbers(dices, 1)
            YachtCategory.TWOS -> numbers(dices, 2)
            YachtCategory.THREES -> numbers(dices, 3)
            YachtCategory.FOURS -> numbers(dices, 4)
            YachtCategory.FIVES -> numbers(dices, 5)
            YachtCategory.SIXES -> numbers(dices, 6)
            YachtCategory.FULL_HOUSE -> fullHouse(dices)
            YachtCategory.FOUR_OF_A_KIND -> fourOfAKind(dices)
            YachtCategory.LITTLE_STRAIGHT -> straight(dices, 1, 5)
            YachtCategory.BIG_STRAIGHT -> straight(dices, 2, 6)
            YachtCategory.CHOICE -> dices.sum()
        }
    }

    private fun numbers(dices: IntArray, factor: Int): Int {
        return dices.filter { it == factor }.sum()
    }

    private fun fullHouse(dices: IntArray): Int {
        val groups = dices.groupBy { it }
        val first = groups.values.first()
        return if (groups.size <= 2 && (first.size in 2..3)) dices.sum() else 0
    }

    private fun fourOfAKind(dices: IntArray): Int? {
        val groups = dices.groupBy { it }
        val first = groups.values.first()
        return if (groups.size <= 2 && (first.size == 1 || first.size >= 4)) groups.values.maxByOrNull { it.size }
            ?.get(0)?.times(4) else 0
    }

    private fun straight(dices: IntArray, min: Int, max: Int): Int {
        return if (dices.distinct().size == 5 && dices.toList().minOf { it } == min && dices.toList()
                .maxOf { it } == max
        ) 30 else 0
    }
}
