package com.lina.utils;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {


  public static Map<Integer, List<String>> readExcel(String filePath, String sheetName)
      throws IOException {
    FileInputStream file = new FileInputStream(new File(filePath));
    Workbook workbook = new XSSFWorkbook(file);
    Sheet sheet = workbook.getSheet(sheetName);
    Map<Integer, List<String>> data = new HashMap<>();
    int i = 0;
    for (Row row : sheet) {
      data.put(i, new ArrayList<String>());
      for (Cell cell : row) {

        switch (cell.getCellType()) {
          case STRING:
            data.get(i).add(cell.getRichStringCellValue().getString());
            break;
          case NUMERIC:
            if (DateUtil.isCellDateFormatted(cell)) {
              data.get(i).add(cell.getDateCellValue() + "");
            } else {
              data.get(i)
                  .add(
                      new BigDecimal(cell.getNumericCellValue())
                              .setScale(0, RoundingMode.HALF_UP)
                              .intValue()
                          + "");
            }
            break;
          case BOOLEAN:
            data.get(i).add(cell.getBooleanCellValue() + "");

          case FORMULA:
            data.get(i).add(cell.getCellFormula() + "");
          case BLANK:
            break;
          default:
            data.get(i).add(" ");
            break;
        }
      }
      i++;
    }
    workbook.close();
    return data;
  }

  public static void writetoExcel(
      String fullFilePath, String sheetName, Map<Integer, List<String>> map) throws IOException {
    FileInputStream inputStream = new FileInputStream(new File(fullFilePath));
    Workbook workbook = new XSSFWorkbook(inputStream);
    Sheet sheet = workbook.getSheet(sheetName);
    int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
    for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
      System.out.println(entry.getKey());
      for (int i = 0; i < entry.getValue().size(); i++) {
        if (sheet.getRow(entry.getKey()).getCell(i) == null) {
          sheet.getRow(entry.getKey()).createCell(i);
          sheet.getRow(entry.getKey()).getCell(i).setCellValue(entry.getValue().get(i));
        }
      }
    }

    inputStream.close();
    FileOutputStream outputStream = new FileOutputStream(fullFilePath);
    workbook.write(outputStream);
    workbook.close();
  }
}
