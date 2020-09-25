package ru.otus.homework.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Bicycle {
    private String brand;
    private OriginType originType;
    private Classification classification;

}
