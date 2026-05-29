fun String.capital(): String {
    val result = split(". ").map { it.replaceFirstChar(Char::titlecase) }
    return result.joinToString(if (contains(". ")) ". " else "")
}