package org.makc1mm.taskmanager.model

data class Task(
    val id: Long,
    val name: String,
    val description: String,
    val completed: Boolean,
    val deleted: Boolean
)
