package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private UUID uuid;
    private String name;
    private Boolean isAviable;
    private Integer orders;
    private Double totalProfit;


}
