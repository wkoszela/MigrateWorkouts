package org.wkoszela;

import java.io.InputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class WorkoutReader {
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

