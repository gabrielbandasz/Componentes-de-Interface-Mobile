package br.ulbra.partevisual

data class Task(
    val id: Long = System.currentTimeMillis(),
    var title: String,
    var isCompleted: Boolean = false,
)
