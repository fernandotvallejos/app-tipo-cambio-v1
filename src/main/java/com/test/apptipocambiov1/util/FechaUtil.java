package com.test.apptipocambiov1.util;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class FechaUtil {

    public static Date convertStringToDate(String cadenaFecha, String formato) {
        try {
            return  new SimpleDateFormat(formato).parse(cadenaFecha);
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }
    }

    public static String convertDateToString(Date fecha, String formato) {
        return new SimpleDateFormat(formato).format(fecha);
    }

}
