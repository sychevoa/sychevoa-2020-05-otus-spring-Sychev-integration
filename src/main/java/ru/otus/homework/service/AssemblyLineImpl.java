package ru.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.otus.homework.exception.FrameNotFoundException;
import ru.otus.homework.model.*;

import java.util.Collection;
import java.util.List;

import static ru.otus.homework.model.OriginType.DOMESTIC;
import static ru.otus.homework.model.OriginType.IMPORT;

@Service
public class AssemblyLineImpl implements AssemblyLine {
    private final static String DOMESTIC_COUNTRY = "RUSSIA";

    @Override
    public Bicycle assemble(PartKit partKit) {
        List<Part> parts = partKit.getParts();

        return Bicycle.builder()
                .brand(getFrameBrand(parts))
                .originType(calculateOriginType(parts))
                .classification(getRandomClassification())
                .build();
    }

    private OriginType calculateOriginType(Collection<Part> parts) {
        long domesticParts = parts.stream()
                .filter(p -> DOMESTIC_COUNTRY.equals(p.getOriginCountry()))
                .count();

        return domesticParts > 2 ? DOMESTIC : IMPORT;
    }

    private String getFrameBrand(Collection<Part> parts) {

        return parts.stream()
                .filter(p -> PartType.FRAME.equals(p.getType()))
                .map(Part::getBrand)
                .findFirst()
                .orElseThrow(FrameNotFoundException::new);
    }

    private Classification getRandomClassification() {

        return Classification.randomClassification();
    }
}
