package ua.com.foxminded.racersorter.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ua.com.foxminded.racersorter.domain.RacerItems;

public class DAO {

    DateTimeFormatter timeFormater = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public List<RacerItems> abbreviationsLoader() {

        String file = "abbreviations.txt";

        List<RacerItems> racers = new ArrayList<>();

        try (InputStreamReader abbreviationsFile = new InputStreamReader(
                DAO.class.getClassLoader().getResourceAsStream(file));
                BufferedReader stringsArray = new BufferedReader(abbreviationsFile);) {
            racers = stringsArray.lines().map(x -> x.split("_")).map(str -> {
                RacerItems racerItems = new RacerItems();
                racerItems.setKey(str[0]);
                racerItems.setRacers(str[1]);
                racerItems.setTeams(str[2]);
                return racerItems;
            }).collect(Collectors.toList());
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return racers;
    }

    public List<RacerItems> endLoader() {

        String file = "end.log";

        List<RacerItems> racers = new ArrayList<>();

        try (InputStreamReader abbreviationsFile = new InputStreamReader(
                DAO.class.getClassLoader().getResourceAsStream(file));
                BufferedReader stringsArray = new BufferedReader(abbreviationsFile);) {
            racers = stringsArray.lines().map(str -> {
                RacerItems racerItems = new RacerItems();
                racerItems.setKey(str.substring(0, 3));
                racerItems.setTimeEnd(LocalTime.parse(str.substring(14, 26), timeFormater));
                return racerItems;
            }).collect(Collectors.toList());

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return racers;
    }

    public List<RacerItems> startLoader() {

        String file = "start.log";

        List<RacerItems> racers = new ArrayList<>();

        try (InputStreamReader abbreviationsFile = new InputStreamReader(
                DAO.class.getClassLoader().getResourceAsStream(file));
                BufferedReader stringsArray = new BufferedReader(abbreviationsFile);) {
            racers = stringsArray.lines().map(str -> {
                RacerItems racerItems = new RacerItems();
                racerItems.setKey(str.substring(0, 3));
                racerItems.setTimeStart(LocalTime.parse(str.substring(14, 26), timeFormater));
                return racerItems;
            }).collect(Collectors.toList());

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return racers;
    }
}
