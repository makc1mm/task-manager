package org.makc1mm.taskmanager.service

import org.makc1mm.taskmanager.model.Task
import org.makc1mm.taskmanager.model.dto.TaskDTO
import org.makc1mm.taskmanager.model.entity.TaskEntity
import org.makc1mm.taskmanager.repository.TaskRepository
import org.springframework.stereotype.Service

interface TaskService {
    fun createTask(taskDTO: TaskDTO): Task
    fun getActualTasks(): List<Task>
    fun completeTask(id: Long): Task
    fun deleteTask(id: Long): Task
    fun updateTaskInfo(id: Long, taskDTO: TaskDTO): Task
}

@Service
class TaskServiceImpl(private val repository: TaskRepository) : TaskService {

    override fun createTask(taskDTO: TaskDTO): Task {
        return repository.save(taskDTO.convertToTaskEntity()).convertToTask()

    }

    override fun getActualTasks(): List<Task> {
        return repository.getNotDeleted().map { it.convertToTask() }
    }

    override fun completeTask(id: Long): Task {
        return repository.findById(id).get().also {
            repository.save(
                it.copy(completed = !it.completed)
            )
        }.convertToTask()
    }

    override fun deleteTask(id: Long): Task {
        return repository.findById(id).get().also {
            repository.save(
                it.copy(deleted = true)
            )
        }.convertToTask()
    }

    override fun updateTaskInfo(id: Long, taskDTO: TaskDTO): Task {
        return repository.findById(id).get().also {
            repository.save(
                it.copy(
                    name = taskDTO.name,
                    description = taskDTO.description
                )
            )
        }.convertToTask()
    }

    private fun TaskDTO.convertToTaskEntity() = TaskEntity(
        name = name,
        description = description,
        completed = false,
        deleted = false
    )

    private fun TaskEntity.convertToTask() = Task(
        id = id,
        name = name,
        description = description,
        completed = completed,
        deleted = deleted
    )
}