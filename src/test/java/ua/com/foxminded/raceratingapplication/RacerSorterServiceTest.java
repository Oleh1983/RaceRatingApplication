package ua.com.foxminded.raceratingapplication;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ua.com.foxminded.racersorter.dao.DAO;
import ua.com.foxminded.racersorter.domain.RacerItems;
import ua.com.foxminded.racersorter.service.RacerSorterService;

@ExtendWith(MockitoExtension.class)
class RacerSorterServiceTest {
    
    @Mock
    private DAO dao;
    
    @InjectMocks
    private RacerSorterService racerSorterService;
    
    @BeforeEach
    void init() {
        DateTimeFormatter timeFormater = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        
        List<RacerItems> racers = new ArrayList<>();
        RacerItems racer1 = new RacerItems();
        racer1.setKey("VBM");
        racer1.setRacers("Valtteri Bottas");
        racer1.setTeams("MERCEDES");
        racers.add(racer1);
      
        RacerItems racer2 = new RacerItems();
        racer2.setKey("SVF");
        racer2.setRacers("Sebastian Vettel");
        racer2.setTeams("FERRARI");
        racers.add(racer2);
        
        List<RacerItems> startTimes = new ArrayList<>();
        RacerItems startTime1 = new RacerItems();
        startTime1.setKey("VBM");
        startTime1.setTimeStart(LocalTime.parse("12:02:58.917", timeFormater));
        startTimes.add(startTime1);
        
        RacerItems startTime2 = new RacerItems();
        startTime2.setKey("SVF");
        startTime2.setTimeStart(LocalTime.parse("12:01:01.154", timeFormater));
        startTimes.add(startTime2);

        List<RacerItems> finishTimes = new ArrayList<>();
        RacerItems finishTime1 = new RacerItems();
        finishTime1.setKey("VBM");
        finishTime1.setTimeEnd(LocalTime.parse("12:04:03.332", timeFormater));
        finishTimes.add(finishTime1);
        
        RacerItems finishTime2 = new RacerItems();
        finishTime2.setKey("SVF");
        finishTime2.setTimeEnd(LocalTime.parse("12:01:12.434", timeFormater));
        finishTimes.add(finishTime2);
        
        when(dao.abbreviationsLoader()).thenReturn(racers);
        when(dao.startLoader()).thenReturn(startTimes);
        when(dao.endLoader()).thenReturn(finishTimes);
    }
    
    @Test
    @DisplayName("Method prepareRacerData return handled time")
    void methodPrepareRacerData_ReturnHandledTime() {
    
       List<RacerItems> result = racerSorterService.prepareRacerData();
        
        assertEquals(11280, result.get(0).getLapTime());
        assertEquals(64415, result.get(1).getLapTime());
    }
    
    @Test
    @DisplayName("Method prepareRacerData return sorted data")
    void methodPrepareRacerData_ReturnSortedData() {
        
        long SVF = 11280;
        long VBM = 64415;
        
        List<RacerItems> result = racerSorterService.prepareRacerData();
        
        List<Long> resultLapTime = new ArrayList<>();
        resultLapTime.add(SVF);
        resultLapTime.add(VBM);
        
        assertEquals(resultLapTime, result.stream().map(str -> str.getLapTime()).collect(Collectors.toList()));
    }

    @Test
    @DisplayName("Method prepareRacerData has the same size")
    void methodPrepareRacerData_HasTheSameSize() {
        
        List<RacerItems> result = racerSorterService.prepareRacerData();

        assertEquals(2, result.size());
    }

       @Test
       @DisplayName("Method prepareRacerData is not nuul")
       void methodPrepareRacerData_IsNotNuul() {
           assertNotNull( racerSorterService.prepareRacerData());
    }
       
       @Test
       @DisplayName("Method prepareRacerData is not empty")
       void methodPrepareRacerData_IsNotEmpty() {
           
           DateTimeFormatter timeFormater = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
           
           List<RacerItems> racers = new ArrayList<>();
           RacerItems racer = new RacerItems();
           racer.setKey("");
           racer.setRacers("");
           racer.setTeams("");
           racer.setTimeStart(LocalTime.parse("00:00:00.000", timeFormater));
           racer.setTimeEnd(LocalTime.parse("00:00:00.000", timeFormater));
           racers.add(racer);
           
           assertNotEquals( racers, racerSorterService.prepareRacerData());
       }
       
    @Test
    @DisplayName("Method prepareRacerData return handled names and teams")
    void methodPrepareRacerData_returnHandledNamesAndTeams() {
    
       List<RacerItems> result = racerSorterService.prepareRacerData();
       

       assertEquals("Sebastian Vettel", result.get(0).getRacers());
       assertEquals("MERCEDES", result.get(1).getTeams());       
    }
}
