package Excel;
import Data.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by DevHyeon on 2020.11.14
 * */
public class ExcelUtils {

    public static void ExcelSave(String fileName, ArrayList<User> datas) {
        //Header
        SheetAHeader[] A_headers = SheetAHeader.values();
        SheetBHeader[] B_headers = SheetBHeader.values();

        Workbook workbook = null;
        FileOutputStream fos = null;
        try {
            workbook = new SXSSFWorkbook(); // Excel Workbook 생성

            Sheet sheetA = workbook.createSheet("All Data"); // Excel Sheet 생성
            Sheet sheetB = workbook.createSheet("ID Data"); // Excel Sheet 생성

            //Excel Write Header
            try {
                HeaderASetting(workbook,sheetA,A_headers);
                HeaderBSetting(workbook,sheetB,B_headers);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //Excel Write Body
            try {
                BodyASetting(workbook,sheetA,datas);
                BodyBSetting(workbook,sheetB,datas);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                String root = new File("").getPath();
                String path = root+"Excels"; //폴더 경로
                fos = new FileOutputStream(path+"/"+fileName+".xlsx"); // file 생성
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                workbook.write(fos); // excel 저장
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            if (fos != null) {
                try {
                    fos.close(); // file resource 반환
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (workbook != null) {
                try {
                    workbook.close(); // excel resource 반환
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void HeaderASetting(Workbook workbook, Sheet sheet, SheetAHeader[] sheetHeader) {
        /** Style Set */
        //Style
        CellStyle styleOfHeader = workbook.createCellStyle();
        //Align
        styleOfHeader.setAlignment(HorizontalAlignment.CENTER);
        styleOfHeader.setVerticalAlignment(VerticalAlignment.CENTER);
        //Border
        styleOfHeader.setBorderRight(BorderStyle.THIN);
        styleOfHeader.setBorderLeft(BorderStyle.THIN);
        styleOfHeader.setBorderTop(BorderStyle.THIN);
        styleOfHeader.setBorderBottom(BorderStyle.THIN);
        //Background
        styleOfHeader.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        styleOfHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        /**  [All Data] Header */
        Row row = sheet.createRow(0);       // Excel Row 생성
        for (int columnNum = 0; columnNum < sheetHeader.length; columnNum++) {
            Cell cell = row.createCell(columnNum); // cell 생성
            String headerName = sheetHeader[columnNum].columnName();
            cell.setCellStyle(styleOfHeader); //스타일 적용
            cell.setCellValue(headerName);

            //Width Dynamic Setting
            switch (headerName.length()) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    sheet.setColumnWidth(columnNum,2800);
                    break;
                case 5:
                    sheet.setColumnWidth(columnNum,3200);
                    break;
                case 6:
                    sheet.setColumnWidth(columnNum,4200);
                    break;
                case 7:
                    sheet.setColumnWidth(columnNum,4700);
                    break;
                case 8:
                    sheet.setColumnWidth(columnNum,5500);
                    break;
                case 9:
                    sheet.setColumnWidth(columnNum,6200);
                    break;
                default:
                    sheet.setColumnWidth(columnNum,7000);
                    break;
            }
        }
    }
    public static void HeaderBSetting(Workbook workbook, Sheet sheet, SheetBHeader[] sheetHeader) {
        /** Style Set */
        //Style
        CellStyle styleOfHeader = workbook.createCellStyle();
        //Align
        styleOfHeader.setAlignment(HorizontalAlignment.CENTER);
        styleOfHeader.setVerticalAlignment(VerticalAlignment.CENTER);
        //Border
        styleOfHeader.setBorderRight(BorderStyle.THIN);
        styleOfHeader.setBorderLeft(BorderStyle.THIN);
        styleOfHeader.setBorderTop(BorderStyle.THIN);
        styleOfHeader.setBorderBottom(BorderStyle.THIN);
        //Background
        styleOfHeader.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        styleOfHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        /**  [All Data] Header */
        Row row = sheet.createRow(0);       // Excel Row 생성
        for (int columnNum = 0; columnNum < sheetHeader.length; columnNum++) {
            Cell cell = row.createCell(columnNum); // cell 생성
            String headerName = sheetHeader[columnNum].columnName();
            cell.setCellStyle(styleOfHeader); //스타일 적용
            cell.setCellValue(headerName);

            //Width Dynamic Setting
            switch (headerName.length()) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    sheet.setColumnWidth(columnNum,2800);
                    break;
                case 5:
                    sheet.setColumnWidth(columnNum,3200);
                    break;
                case 6:
                    sheet.setColumnWidth(columnNum,4200);
                    break;
                case 7:
                    sheet.setColumnWidth(columnNum,4700);
                    break;
                case 8:
                    sheet.setColumnWidth(columnNum,5500);
                    break;
                case 9:
                    sheet.setColumnWidth(columnNum,6200);
                    break;
                default:
                    sheet.setColumnWidth(columnNum,7000);
                    break;
            }
        }
    }


    public static void BodyASetting(Workbook workbook, Sheet sheet, ArrayList<User> body) {
        /** 스타일 설정 */
        //스타일 설정
        CellStyle styleOfBody = workbook.createCellStyle();
        //정렬
        styleOfBody.setVerticalAlignment(VerticalAlignment.CENTER);
        //테두리 라인
        styleOfBody.setBorderRight(BorderStyle.THIN);
        styleOfBody.setBorderLeft(BorderStyle.THIN);
        styleOfBody.setBorderTop(BorderStyle.THIN);
        styleOfBody.setBorderBottom(BorderStyle.THIN);

        for (int rownum = 1; rownum < body.size(); rownum++) { // data row 개수 만큼 반복해서 처리
            Row row = sheet.createRow(rownum); // Excel Row 생성
            User user = body.get(rownum-1);
            int cellnum = 0;

            Cell cell = row.createCell(cellnum++);
            cell.setCellValue(user.getUserUnqId());
            cell = row.createCell(cellnum++);
            cell.setCellValue(user.getUserName());
            cell = row.createCell(cellnum++);
            cell.setCellValue(user.getUserAge());
            cell = row.createCell(cellnum++);
            cell.setCellValue(user.getUserGender());
            cell = row.createCell(cellnum++);
            cell.setCellValue(user.getUserBirth());

            for (int i=0; i<cellnum; i++) {
                Cell cell2 = row.getCell(i);
                cell2.setCellStyle(styleOfBody); //스타일 적용
            }
        }
    }
    public static void BodyBSetting(Workbook workbook, Sheet sheet, ArrayList<User> body) {
        /** 스타일 설정 */
        //스타일 설정
        CellStyle styleOfBody = workbook.createCellStyle();
        //정렬
        styleOfBody.setVerticalAlignment(VerticalAlignment.CENTER);
        //테두리 라인
        styleOfBody.setBorderRight(BorderStyle.THIN);
        styleOfBody.setBorderLeft(BorderStyle.THIN);
        styleOfBody.setBorderTop(BorderStyle.THIN);
        styleOfBody.setBorderBottom(BorderStyle.THIN);

        for (int rownum = 1; rownum < body.size(); rownum++) { // data row 개수 만큼 반복해서 처리
            Row row = sheet.createRow(rownum); // Excel Row 생성
            User user = body.get(rownum-1);
            int cellnum = 0;

            Cell cell = row.createCell(cellnum++);
            cell.setCellValue(user.getUserUnqId());
            cell = row.createCell(cellnum++);
            cell.setCellValue(user.getUserName());

            for (int i=0; i<cellnum; i++) {
                Cell cell2 = row.getCell(i);
                cell2.setCellStyle(styleOfBody); //스타일 적용
            }
        }
    }
}
