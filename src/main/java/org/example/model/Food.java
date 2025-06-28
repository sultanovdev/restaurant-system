package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    private UUID uuid;
    private String name;
    private Double price;


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Food food)) return false;
        return Objects.equals(name, food.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
