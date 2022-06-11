package org.makc1mm.taskmanager.repository

import org.makc1mm.taskmanager.model.entity.TaskEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TaskRepository : JpaRepository<TaskEntity, Long> {

    @Query(value = "SELECT * FROM task WHERE deleted = false ORDER BY id", nativeQuery = true)
    fun getNotDeleted(): List<TaskEntity>

}
