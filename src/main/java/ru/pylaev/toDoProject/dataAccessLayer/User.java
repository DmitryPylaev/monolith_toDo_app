package ru.pylaev.toDoProject.dataAccessLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @Setter private long id;

    @Column(name = "name")
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString () { return name; }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User task = (User) o;
        return Objects.equals(name, task.name);
    }

    @Override
    public int hashCode ( ) {
        return name != null ? name.hashCode() : 0;
    }
}

