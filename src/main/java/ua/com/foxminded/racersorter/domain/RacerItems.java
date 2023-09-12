package ua.com.foxminded.racersorter.domain;

import java.time.LocalTime;

public class RacerItems {
    private String key;
    private String racers;
    private String teams;
    private Long lapTime;
    private LocalTime timeStart;
    private LocalTime timeEnd;




    public Long getLapTime() {
        return lapTime;
    }

    public void setLapTime(Long lapTime) {
        this.lapTime = lapTime;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRacers() {
        return racers;
    }

    public void setRacers(String racers) {
        this.racers = racers;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    public LocalTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalTime timeEnd) {
        this.timeEnd = timeEnd;
    }

}
