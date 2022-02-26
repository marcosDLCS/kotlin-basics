object HandshakeCalculator {
    fun calculateHandshake(number: Int): List<Signal> = when {
        number >= 16 -> calculateHandshake(number - 16).reversed()
        number >= 8 -> calculateHandshake(number - 8) + listOf(Signal.JUMP)
        number >= 4 -> calculateHandshake(number - 4) + listOf(Signal.CLOSE_YOUR_EYES)
        number >= 2 -> calculateHandshake(number - 2) + listOf(Signal.DOUBLE_BLINK)
        number >= 1 -> listOf(Signal.WINK)
        else -> emptyList()
    }
}
