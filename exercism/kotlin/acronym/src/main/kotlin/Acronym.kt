object Acronym {
    fun generate(phrase: String): String {
        return phrase
            .replace("_","")
            .split(" ", "-")
            .filter { it.isNotEmpty() }
            .joinToString("") { it[0].uppercase() };
    }
}
