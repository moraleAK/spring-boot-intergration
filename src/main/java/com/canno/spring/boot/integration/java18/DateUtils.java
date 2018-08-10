package com.canno.spring.boot.integration.java18;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance(Locale.getDefault(Locale.Category.FORMAT));

        System.out.println(Calendar.getInstance());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        System.out.println(sdf.format(new Date()));
        System.out.println(Locale.Category.FORMAT);
        System.out.println(Locale.getDefault(Locale.Category.FORMAT));
        System.out.println(calendar.getTime());
    }
}
