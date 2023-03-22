package ru.pylaev.toDoProject.dataAccessLayer.dataBase;

import org.springframework.data.repository.CrudRepository;
import ru.pylaev.toDoProject.dataAccessLayer.Owner;

import java.util.List;

public interface OwnerSpringRepository extends CrudRepository<Owner, Long> {
    List<Owner> findByOwner(String owner);
}
