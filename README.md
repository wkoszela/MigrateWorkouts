# MigrateWorkouts (MapMyFitness)

## Overview

This project is a simple workout downloader that retrieves workout URLs from an Excel file and downloads each workout. It utilizes Selenium WebDriver and Apache POI for Excel file processing.

**Note:** This project is designed as a workaround for downloading workout data due to the lack of access to the MapMyFitness API.
<img width="795" alt="image" src="https://github.com/wkoszela/MigrateWorkouts/assets/29572491/79016918-fb0a-424a-bf80-ccc9ae4ccfc5">


## Prerequisites

- Java 8 or higher
- Maven (for building the project)
- ChromeDriver (for running Selenium WebDriver with Chrome)
- XLSX Workouts (you can download it from MapMyFitness)

## How to Run

1. Clone the repository:

    ```bash
    git clone https://github.com/wkoszela/MigrateWorkouts.git
    ```

2. Navigate to the project directory:

    ```bash
    cd MigrateWorkouts
    ```

3. Build the project:

    ```bash
    mvn clean install
    ```

4. Run the application:

    ```bash
    java -jar target/MigrateWorkouts-1.0-RELEASE.jar
    ```

## Configuration

- Ensure that ChromeDriver is installed and its path is available in the system's PATH. Download Your workouts XLSX from MapMyFitness and move under the /src/main/resources
