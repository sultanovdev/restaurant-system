package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stole {
    private UUID uuid;
    private Integer numberStole;
    private Boolean isAviable;
}
