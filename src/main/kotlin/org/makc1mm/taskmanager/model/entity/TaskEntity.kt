package org.makc1mm.taskmanager.model.entity

import javax.persistence.*

@Entity
@Table(name = "task")
data class TaskEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    val name: String,
    val description: String,
    val completed: Boolean,
    val deleted: Boolean
)
