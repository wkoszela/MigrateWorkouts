package org.wkoszela;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The {@code DownloadWorkout} class handles the downloading of workouts from the MapMyFitness website using Selenium WebDriver.
 * Workouts are loaded from an Excel file and then downloaded one by one.
 *
 * @author WKOSZELA
 */
public class DownloadWorkout {
    public static void main(String[] args) throws InterruptedException {

        WorkoutReader workoutReader = new WorkoutReader();
        List<String> workouts = workoutReader.readAllWorkouts("workouts.xlsx");

        WebDriver driver = new ChromeDriver();
        String loginPage = "https://www.mapmyfitness.com/auth/login/?next=%2F";

        driver.get(loginPage);

        // Provide login and password after when the page loaded
        Thread.sleep(30000);
        AtomicInteger counter = new AtomicInteger(1); // Counter do śledzenia indeksów

        workouts.forEach(workout -> {

            try {
                driver.get(workout);
                Thread.sleep(100);
                System.out.printf("Workout[%d]/[%d] has been downloaded: %s%n", counter.getAndIncrement(), workouts.size(), workout);
            } catch (Exception e) {
                System.out.println("Failed during downloading");
            }
        });
        driver.quit();

    }

}
