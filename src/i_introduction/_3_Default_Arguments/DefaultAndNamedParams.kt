package i_introduction._3_Default_Arguments

import util.*

fun todoTask3(): Nothing = TODO(
    """
        Task 3.
        Several overloads of 'JavaCode2.foo()' can be replaced with one function in Kotlin.
        Change the declaration of the function 'foo' in a way that makes the code using 'foo' compile.
        You have to add parameters and replace 'todoTask3()' with a real body.
        Uncomment the commented code and make it compile.
    """,
    documentation = doc2(),
    references = { name: String -> JavaCode2().foo(name); foo(name) }
)

val defaultNumber = 42

fun foo(name: String): String {
    return foo(name, defaultNumber)
}

fun foo(name: String, number: Int): String {
    return foo(name, number, false)
}

fun foo(name: String, number: Int, toUpperCase: Boolean): String {
    return (if (toUpperCase) name.toUpperCase() else name) + number
}

fun foo(name: String, toUpperCase: Boolean): String {
    return foo(name, defaultNumber, toUpperCase)
}


fun task3(): String {
    return (foo("a") +
            foo("b", number = 1) +
            foo("c", toUpperCase = true) +
            foo(name = "d", number = 2, toUpperCase = true))
}
