fun Char.operate(vararg numbers: Any): Number {
    var divider = 0.0
    var numbersInString = numbers.map { it.toString() }
    if (numbersInString.any { it.contains('.') }) {
        divider = numbersInString.maxOf { if (it.contains('.')) it.split('.')[1].length.toDouble() else 0.0 }
        numbersInString = numbersInString.map {
            it.replace(".", "") + "0".repeat(
                (divider - if (!it.contains('.')) 0.0 else it.split('.')[1].length.toDouble()).toInt()
            )
        }
    }
    return numbersInString.map { it.toInt() }.reduce { acc, value ->
        when (this) {
            '+' -> acc + value
            '-' -> acc - value
            '*' -> acc * value
            '/' -> acc / value
            '%' -> acc % value
            else -> throw UnsupportedOperationException("Operator $this tidak valid / belum didukung.")
        }
    } / (10 * divider)
}

fun operation(operationInString: String) {
    val cleanedOperation = operationInString.replace("/[^1-9 ()^%/*-+]/g".toRegex(), "")
    var divider = cleanedOperation.split("/[1-9]+/g".toRegex()).maxOf {
        val numbers = it.split('.')
        if (numbers.size == 2) numbers[1].length else if (numbers.size == 1) 0 else throw NumberFormatException("Format angka tidak valid")
    }
    var result = 0.0



    fun doOperation(value: String) {
        val (startIndex, endIndex) = Pair(value.indexOf('('), value.indexOf(')'))
        val toOperated = if(startIndex == -1) value.slice(startIndex + 1..<endIndex) else value
        return if (toOperated.contains('(')) doOperation(toOperated) else
    }

    doOperation(operationInString)
}