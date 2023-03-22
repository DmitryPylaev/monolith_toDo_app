package ru.pylaev.toDoProject.dataAccessLayer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "owner")
@Getter
@NoArgsConstructor
public class Owner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_generator")
    @Setter private long id;

    @Column(name = "owner", unique = true)
    private String owner;

    public Owner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString () { return  owner; }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner task = (Owner) o;
        return Objects.equals(owner, task.owner);
    }

    @Override
    public int hashCode ( ) {
        return owner.hashCode();
    }
}

