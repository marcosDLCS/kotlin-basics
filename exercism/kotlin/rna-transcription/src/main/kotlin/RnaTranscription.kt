fun transcribeToRna(dna: String): String = dna.split("").joinToString("") {
    when (it) {
        "G" -> "C"
        "C" -> "G"
        "T" -> "A"
        "A" -> "U"
        else -> ""
    }
}