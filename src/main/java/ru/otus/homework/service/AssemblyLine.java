package ru.otus.homework.service;

import ru.otus.homework.model.Bicycle;
import ru.otus.homework.model.PartKit;

public interface AssemblyLine {
    Bicycle assemble(PartKit partKit);

}
