package ua.com.foxminded.racersorter.service;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import ua.com.foxminded.racersorter.dao.DAO;
import ua.com.foxminded.racersorter.domain.RacerItems;

public class RacerSorterService {

    DAO dao = new DAO();

    public List<RacerItems> prepareRacerData() {

        List<RacerItems> racers = dao.abbreviationsLoader();
        List<RacerItems> startTimes = dao.startLoader();
        List<RacerItems> finishTimes = dao.endLoader();

        return racers.stream()
                    .map(racerItems -> {
            RacerItems startTime = startTimes.stream()
                    .filter(start -> start.getKey().equals(racerItems.getKey()))
                    .findFirst().orElse(null);
            if (startTime.getTimeStart() != null) {
                racerItems.setTimeStart(startTime.getTimeStart());
            }
            return racerItems;
        })
                    .map(racerItems -> {
            RacerItems finishTime = finishTimes.stream()
                    .filter(finish -> finish.getKey().equals(racerItems.getKey()))
                    .findFirst().orElse(null);
            racerItems.setTimeEnd(finishTime.getTimeEnd());
            return racerItems;
        })
                    .map(racerItems -> {
            Long lapTime = Duration.between(racerItems.getTimeStart(), racerItems.getTimeEnd()).toMillis();
            racerItems.setLapTime(lapTime);
            return racerItems;
        })
                    .sorted(Comparator.comparing(RacerItems::getLapTime))
                    .collect(Collectors.toList());

    }
}
