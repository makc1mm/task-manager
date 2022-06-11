package org.makc1mm.taskmanager.controller

import org.makc1mm.taskmanager.model.Task
import org.makc1mm.taskmanager.model.dto.TaskDTO
import org.makc1mm.taskmanager.service.TaskService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = ["*"])
class TaskController(private val service: TaskService) {

    @PostMapping("/create")
    fun createTask(@RequestBody taskDTO: TaskDTO): Task {
        return service.createTask(taskDTO)
    }

    @GetMapping("/actual")
    fun getActualTasks(): List<Task> {
        return service.getActualTasks()
    }

    @PutMapping("/complete/{id}")
    fun completeTask(@PathVariable id: Long): Task {
        return service.completeTask(id)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteTask(@PathVariable id: Long): Task {
        return service.deleteTask(id)
    }

    @PutMapping("/update/{id}")
    fun updateTask(@PathVariable id: Long, @RequestBody taskDTO: TaskDTO): Task {
        return service.updateTaskInfo(id, taskDTO)
    }
}