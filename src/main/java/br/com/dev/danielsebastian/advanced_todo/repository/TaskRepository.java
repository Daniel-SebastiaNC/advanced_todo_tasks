package br.com.dev.danielsebastian.advanced_todo.repository;

import br.com.dev.danielsebastian.advanced_todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
