object Raindrops {

    fun convert(input: Int): String {
        var output = "";
        input
            .apply { if (this % 3 == 0) output += "Pling" }
            .apply { if (this % 5 == 0) output += "Plang" }
            .apply { if (this % 7 == 0) output += "Plong" }
            .apply { if (output == "") output = this.toString() }
        return output;
    }
}
