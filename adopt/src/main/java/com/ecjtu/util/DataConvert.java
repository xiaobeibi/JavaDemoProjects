package com.ecjtu.util;



import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 */
public class DataConvert implements Converter<String,Date> {

    @Override
    public Date convert(String source) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date=simpleDateFormat.parse(source);
        } catch (ParseException e) {
            date=null;
            e.getMessage();
        }
        return date;
    }
}
