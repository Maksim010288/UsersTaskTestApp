package com.example.UsersProject;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateFormat {
    private static SimpleDateFormat simpleDateFormat;


    public DateFormat(){}

    public static String getYear() {
        simpleDateFormat = new SimpleDateFormat("yyy");
        return simpleDateFormat.format(new Date());
    }

    public static String getDate() {
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyy");
        return simpleDateFormat.format(new Date());
    }
}
