package ru.pylaev.toDoProject.dataAccessLayer.dataBase;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.dataAccessLayer.DAO;
import ru.pylaev.toDoProject.dataAccessLayer.Task;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Primary
public class DataBaseTaskDAO implements DAO {
    private final TaskSpringRepository taskSpringRepository;
    private final UserSpringRepository userSpringRepository;

    @Override
    public synchronized List<Task> findByOwner(String owner) {
        return taskSpringRepository.findByOwner(owner);
    }

    @Override
    public synchronized void save(Task task) {
        taskSpringRepository.save(task);
    }

    @Override
    public synchronized Optional<Task> findById(long id) {
        return taskSpringRepository.findById(id);
    }
}
