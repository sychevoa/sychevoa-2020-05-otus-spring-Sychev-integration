package ru.otus.homework;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.otus.homework.model.Bicycle;
import ru.otus.homework.model.PartKit;

import java.util.Collection;

@MessagingGateway
public interface BicycleStore {

    @Gateway(requestChannel = "partsChannel", replyChannel = "bicycleChannel")
    Collection<Bicycle> process(PartKit partKit);
}