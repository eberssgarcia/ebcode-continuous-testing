package com.ebcode;

//import io.cucumber.datatable.DataTable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class UtilWeb {

    public static Logger logger(Class clase) {
        return Logger.getLogger(clase.getName());
    }
//
//    public static String getValueFromDataTable(DataTable dataTable, String title) {
//        List<Map<String, String>> data = dataTable.asMaps();
//        for (Map<String, String> row : data) {
//            if (row.containsKey(title)) {
//                return row.get(title);
//            }
//        }
//        return null; // or throw an exception if the title is not found
//    }

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
}

