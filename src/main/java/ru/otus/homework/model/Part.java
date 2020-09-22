package ru.otus.homework.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Part {
    private String originCountry;
    private String brand;
    private PartType type;
}
