package ua.com.foxminded.racersorter.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import ua.com.foxminded.racersorter.domain.RacerItems;
import ua.com.foxminded.racersorter.service.RacerSorterService;

public class RacerController {

    RacerSorterService racerSorterService = new RacerSorterService();

    public List<String> racersFormater() {

        AtomicInteger count = new AtomicInteger(1);

        List<RacerItems> racers = racerSorterService.prepareRacerData();

        return racers.stream()
                .map(str -> String.format("%2d. %-17s | %-25s | %01d:%02d.%03d%n", count.getAndAdd(1), str.getRacers(),
                        str.getTeams(), (str.getLapTime() / 1000) / 60, (str.getLapTime() / 1000) % 60,
                        str.getLapTime() % 1000))
                .collect(Collectors.toList());

    }

    public String showListRacers() {

        StringBuilder builder = new StringBuilder();
        List<String> racers = racersFormater();

        builder.append(racers.stream()
                         .limit(15)
                         .collect(Collectors.joining()))
               .append(racers.stream()
                         .limit(1)
                         .map(str -> str = "-".repeat(str.length() - 2) + "\n")
                         .collect(Collectors.joining()))
               .append(racers.stream()
                         .skip(15)
                         .collect(Collectors.joining()));
        return builder.toString();
    }
}
