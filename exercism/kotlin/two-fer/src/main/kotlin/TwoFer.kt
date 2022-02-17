internal fun twofer(name: String = "you"): String {
    return name.let {
        "One for $it, one for me."
    }
}
