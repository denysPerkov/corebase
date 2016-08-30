package com.epam.perkovdenys.task3.part2.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static boolean hasDateInRange(long base, String start, String finish){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String baseBefore = sdf.format(base);

        Date baseDate = null;
        Date startDate = null;
        Date finishDate = null;
        try {
            baseDate = sdf.parse(baseBefore);
            startDate = sdf.parse(start);
            finishDate = sdf.parse(finish);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return baseDate.getTime() > startDate.getTime() && baseDate.getTime() < finishDate.getTime();
    }
}
