fun isArray(value: Any) = value::class.simpleName?.contains("Array") ?: false

fun isAllArray(vararg value: Any) = value.all { isArray(it) }

fun Collection<Any>.get(vararg at: Int): Collection<Any> = at.map { get(it - if(it > 0) 1 else 0) }