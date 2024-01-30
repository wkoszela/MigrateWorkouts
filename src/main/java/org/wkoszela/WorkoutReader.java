package org.wkoszela;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The {@code WorkoutReader} class is responsible for reading workouts from an Excel file.
 *
 * @author WKOSZELA
 */
public class WorkoutReader {

    /**
     * Reads all workouts from the specified Excel file.
     *
     * @param path The path to the Excel file.
     * @return A list of workout URLs, where each URL is appended with "/tcx".
     */
    public List<String> readAllWorkouts(String path) {

        Sheet sheet = null;
        try (InputStream inputStream = WorkoutReader.class.getClassLoader().getResourceAsStream(path);
             // open
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            sheet = workbook.getSheetAt(0);

        } catch (IOException e) {
            e.printStackTrace();
        }
        assert sheet != null;
        return readColumnA(sheet);
    }

    /**
     * Reads the content of column A from the given Excel sheet.
     *
     * @param sheet The Excel sheet.
     * @return A list of workout URLs, where each URL is appended with "/tcx"!
     */
    private static List<String> readColumnA(Sheet sheet) {
        List<String> columnData = new ArrayList<>();

        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Cell cell = row.getCell(0);

            if (cell != null) {
                columnData.add(cell.getStringCellValue() + "/tcx");
            }
        }

        return columnData;
    }
}

