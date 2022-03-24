object Pangram {

    fun isPangram(input: String): Boolean {
        return input.lowercase().chars().filter { it in 97..122 }.distinct().count() == 26L;
    }
}
