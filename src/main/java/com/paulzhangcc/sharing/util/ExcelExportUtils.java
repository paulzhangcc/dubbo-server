package com.paulzhangcc.sharing.util;


import com.paulzhangcc.sharing.SharingProperties;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 根据excel模板，将查询数据写入excel导出
 * @author: Paul Zhang
 * @date: 18:28 2017/12/27
 */
@Component
public class ExcelExportUtils {

    @Autowired
    private SharingProperties sharingProperties;

    public File export(String tplName, List<Map<String, Object>> data) {
        Objects.requireNonNull(data, "data must not be null");

        Workbook tpl = getTemplate(tplName);
        Row fields = getFieldRow(tpl);

        append(tpl, fields, data);

        File file = create(tplName);
        save(tpl, file);
        return file;
    }

    private void append(Workbook workbook, Row fields,
                        List<Map<String, Object>> data) {
        Sheet sheet = workbook.getSheetAt(0);
        int rowIndex = sheet.getLastRowNum() + 1;
        for (Map<String, Object> entry : data) {
            Row row = sheet.createRow(rowIndex++);
            for (Cell field : fields) {
                Cell cell = row.createCell(field.getColumnIndex());
                Object objectValue = entry.get(field.getStringCellValue());
                if (objectValue == null) {
                    cell.setCellValue((String) null);
                } else {
                    cell.setCellValue(objectValue.toString());
                }
            }
        }
    }

    /**
     * 根据名称获取模版文件
     *
     * @param name
     * @return
     */
    private Workbook getTemplate(String name) {
        InputStream is = getClass().getResourceAsStream("/excel/tpl/" + name);
        if (is == null) {
            throw new RuntimeException(MessageFormat.format("模版[{0}]没有找到", name));
        }

        try {
            Workbook workbook = null;
            if (name.endsWith(".xls")){
                workbook = new HSSFWorkbook(is);
            }else {
                throw new IllegalArgumentException("只支持excel格式:.xls");
            }

            if (workbook.getSheetAt(0).getPhysicalNumberOfRows() != 2) {
                throw new IllegalArgumentException("模版格式错误, 至少有两行数据");
            }

            return workbook;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 从模版文件中获取映射数据库字段行
     *
     * @param workbook
     * @return
     */
    private Row getFieldRow(Workbook workbook) {
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(1);
        sheet.removeRow(row);

        return row;
    }

    private File create(String template) {
        int dotLastIndex = template.lastIndexOf('.');
        String fileName = template;
        String suffix = ".xls";
        if (dotLastIndex != -1) {
            fileName = template.substring(0, dotLastIndex);
            suffix = template.substring(dotLastIndex);
        }

        String fileSystemRoot = sharingProperties.getFileSystemRoot();
        String prefix = null;
        if (fileSystemRoot.endsWith("/")){
            prefix = fileSystemRoot+"export/excel/";
        }else {
            prefix = fileSystemRoot+"/export/excel/";
        }
        File dir = new File( prefix
                + new SimpleDateFormat("yyyyMMdd").format(new Date()));
        try {
            FileUtils.forceMkdir(dir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // yyyyMMdd/xxx_HHmmss.xls
        File file = new File(dir, fileName + "_"
                + new SimpleDateFormat("HHmmss").format(new Date()) + suffix);
        try {
            FileUtils.forceMkdir(file.getParentFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    private void save(Workbook workbook, File file) {
        try (OutputStream os = new FileOutputStream(file)) {
            workbook.write(os);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
            }
        }
    }
}
