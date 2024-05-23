package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class EntityId {

    @GeneratedValue
    @Id
    private Long id;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntityId entityId)) return false;

        return Objects.equals(id, entityId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
