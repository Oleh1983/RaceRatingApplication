package ua.com.foxminded.raceratingapplication;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ua.com.foxminded.racersorter.controller.RacerController;
import ua.com.foxminded.racersorter.domain.RacerItems;
import ua.com.foxminded.racersorter.service.RacerSorterService;

@ExtendWith(MockitoExtension.class)
class RacerControllerTest {

    @Mock
    private RacerSorterService racerSorterService;
    
    @InjectMocks
    private RacerController racersController;

    @Test
    @DisplayName("Method racersFormater return rating of racers as a table")
    void methodRacersFormater_ReturnRatingOfRacers() {
        List<RacerItems> racers = new ArrayList<>();

        long VBM = 11280;
        long SVF = 64415;

        RacerItems racer1 = new RacerItems();
        racer1.setKey("VBM");
        racer1.setRacers("Valtteri Bottas");
        racer1.setTeams("MERCEDES");
        racer1.setLapTime(VBM);
        racers.add(racer1);

        RacerItems racer2 = new RacerItems();
        racer2.setKey("SVF");
        racer2.setRacers("Sebastian Vettel");
        racer2.setTeams("FERRARI");
        racer2.setLapTime(SVF);
        racers.add(racer2);
        when(racerSorterService.prepareRacerData()).thenReturn(racers);
        
        List<String> racersList = racersController.racersFormater();

        List<String> racersListFake = new ArrayList<>();
        
         String fakeRacers1 = String.format("%s%n", 
      " 1. Valtteri Bottas   | MERCEDES                  | 0:11.280");
         racersListFake.add(fakeRacers1);
         
         String fakeRacers2 = String.format("%s%n", 
      " 2. Sebastian Vettel  | FERRARI                   | 1:04.415");
         racersListFake.add(fakeRacers2);
         
        assertEquals(racersList, racersListFake);
    }
    
    @Test
    @DisplayName("Method showListRacers return rating of racers as a table")
    void methodShowListRacers_ReturnRatingOfRacers() {
        
        List<RacerItems> racersTest = new ArrayList<>();
        
        long VBM = 11280;
        long SVF = 64415;

        RacerItems racer1 = new RacerItems();
        racer1.setKey("VBM");
        racer1.setRacers("Valtteri Bottas");
        racer1.setTeams("MERCEDES");
        racer1.setLapTime(VBM);
        racersTest.add(racer1);

        RacerItems racer2 = new RacerItems();
        racer2.setKey("SVF");
        racer2.setRacers("Sebastian Vettel");
        racer2.setTeams("FERRARI");
        racer2.setLapTime(SVF);
        racersTest.add(racer2);
        when(racerSorterService.prepareRacerData()).thenReturn(racersTest);
        
        String racers = racersController.showListRacers();
        StringBuilder builder = new StringBuilder();
        
        String fakeRacers = String.format("%s%n%s%n%s", 
                " 1. Valtteri Bottas   | MERCEDES                  | 0:11.280",
                " 2. Sebastian Vettel  | FERRARI                   | 1:04.415",
                "------------------------------------------------------------");
        
        builder.append(fakeRacers + "\n");
        
        assertEquals(racers.toString(), builder.toString());
    }

    @Test
    @DisplayName("Method racersFormater is not nuul")
    void methodRacersFormater_IsNotNuul() {
        
        List<RacerItems> racers = new ArrayList<>();

        long VBM = 11280;
        long SVF = 64415;

        RacerItems racer1 = new RacerItems();
        racer1.setKey("VBM");
        racer1.setRacers("Valtteri Bottas");
        racer1.setTeams("MERCEDES");
        racer1.setLapTime(VBM);
        racers.add(racer1);

        RacerItems racer2 = new RacerItems();
        racer2.setKey("SVF");
        racer2.setRacers("Sebastian Vettel");
        racer2.setTeams("FERRARI");
        racer2.setLapTime(SVF);
        racers.add(racer2);
        when(racerSorterService.prepareRacerData()).thenReturn(racers);
        
        List<String> racersList = racersController.racersFormater();
        
        assertNotNull(racersList);
    }
    
    @Test
    @DisplayName("Method showListRacers is not nuul")
    void methodShowListRacers_IsNotNuul() {

        String racers = racersController.showListRacers();
        
        assertNotNull(racers);
    }

    @Test
    @DisplayName("Method racersFormater is not empty")
    void methodRacersFormater_IsNotEmpty() {
        
        List<RacerItems> racers = new ArrayList<>();

        long SVF = 64415;

        RacerItems racer2 = new RacerItems();
        racer2.setKey("SVF");
        racer2.setRacers("Sebastian Vettel");
        racer2.setTeams("FERRARI");
        racer2.setLapTime(SVF);
        racers.add(racer2);
        when(racerSorterService.prepareRacerData()).thenReturn(racers);
        
        List<String> racersList = racersController.racersFormater();
        
        List<String> emtyRacers = new ArrayList<>();
        String fakeRacers = String.format("%s%n", 
                " 1.                   |                           | 0:00.000");
        emtyRacers.add(fakeRacers);
        
        assertNotEquals(emtyRacers, racersList);
    }
    @Test
    @DisplayName("Method showListRacers is not empty")
    void methodShowListRacers_IsNotEmpty() {

        List<RacerItems> racers = new ArrayList<>();

        long VBM = 11280;
        long SVF = 64415;

        RacerItems racer1 = new RacerItems();
        racer1.setKey("VBM");
        racer1.setRacers("Valtteri Bottas");
        racer1.setTeams("MERCEDES");
        racer1.setLapTime(VBM);
        racers.add(racer1);

        RacerItems racer2 = new RacerItems();
        racer2.setKey("SVF");
        racer2.setRacers("Sebastian Vettel");
        racer2.setTeams("FERRARI");
        racer2.setLapTime(SVF);
        racers.add(racer2);
        when(racerSorterService.prepareRacerData()).thenReturn(racers);
        
        String racersList = racersController.showListRacers();
        
        assertNotEquals("", racersList);
    }
}
