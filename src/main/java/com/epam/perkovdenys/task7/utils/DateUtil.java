package com.epam.perkovdenys.task7.utils;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static void main(String[] args) {
        System.out.println(stringToDate("2010-10-10 23:23"));
    }

    public static boolean compareDates(Date key, String start, String finish){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s = formatter.format(key);
            Date base = sdf.parse(s);
            Date date1 = sdf.parse(start);
            Date date2 = sdf.parse(finish);

            if((base.compareTo(date1) >= 0) && (base.compareTo(date2) <= 0)){
                return true;
            }
        }catch(ParseException ex){
            ex.printStackTrace();
        }

        return false;
    }

    public static long differeceDates(Date date1, String date2){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        long diff = 0;

        try {
            Date d1 = date1;
            Date d2 = format.parse(date2);
            diff = d2.getTime() - d1.getTime();

            return Math.abs(diff);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return diff;
    }

    public static Date stringToDate(String str){
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
             return date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
