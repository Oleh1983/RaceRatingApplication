package ua.com.foxminded.racersorter;

import ua.com.foxminded.racersorter.controller.RacerController;

public class RacerRatingApplication {

    public static void main(String[] args) {

        RacerController racerController = new RacerController();
        System.out.println(racerController.showListRacers());

    }
}
