package ru.otus.homework.shell;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework.BicycleStore;
import ru.otus.homework.model.Bicycle;
import ru.otus.homework.model.Part;
import ru.otus.homework.model.PartKit;
import ru.otus.homework.model.PartType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Slf4j
@ShellComponent
@RequiredArgsConstructor
public class ShellStartIntegrationService {

    private final BicycleStore store;
    private final static List<String> countries = List.of("RUSSIA", "GERMAN", "ITALY", "CHINA", "ENGLAND");
    private final static List<String> brands = List.of("Cube", "Giant", "Specialized", "Scott", "Cannondale");


    @ShellMethod(value = "startMethod", key = "start")
    public void start() throws InterruptedException {

        while (true) {
            Thread.sleep(2000);
            PartKit partKit = new PartKit();
            partKit.setParts(getParts());

            log.info("Part kit: {}", partKit);

            Collection<Bicycle> bicycles = store.process(partKit);

            log.info("Assembled bicycles: {}", bicycles);
        }
    }

    private List<Part> getParts() {
        List<Part> parts = new ArrayList<>();
        PartType[] values = PartType.values();

        for (PartType partType : values) {
            parts.add(
                    Part.builder()
                            .originCountry(countries.get(new Random().nextInt(countries.size())))
                            .brand(brands.get(new Random().nextInt(brands.size())))
                            .type(partType)
                            .build()
            );
        }

        return parts;
    }
}
