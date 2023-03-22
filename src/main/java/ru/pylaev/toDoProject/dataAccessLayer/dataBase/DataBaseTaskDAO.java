package ru.pylaev.toDoProject.dataAccessLayer.dataBase;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.dataAccessLayer.DAO;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.dataAccessLayer.Owner;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Primary
public class DataBaseTaskDAO implements DAO {
    private final TaskSpringRepository taskSpringRepository;
    private final OwnerSpringRepository ownerSpringRepository;

    @Override
    public synchronized List<Task> findByOwner(String owner) {
        List<Owner> owners = ownerSpringRepository.findByOwner(owner);
        Owner myOwner = (owners.isEmpty())?ownerSpringRepository.save(new Owner(owner)):owners.get(0);
        return taskSpringRepository.findByOwnerId(myOwner.getId());
    }

    @Override
    public synchronized void save(Task task, String owner) {
        List<Owner> owners = ownerSpringRepository.findByOwner(owner);
        task.setOwner(owners.get(0));
        taskSpringRepository.save(task);
    }

    @Override
    public synchronized Optional<Task> findById(long id) {
        return taskSpringRepository.findById(id);
    }
}
