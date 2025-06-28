package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private UUID uuid;
    private List<Food> foodsName;
    private Double totalPrice;
    private String waiterName;
}
