/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.wandingkeji.comm.utils.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 常用日期工具
 * <p>A suite of utilities surrounding the use of the
 * {@link Calendar} and {@link Date} object.</p>
 * 
 * <p>DateUtils contains a lot of common methods considering manipulations
 * of Dates or Calendars. Some methods require some extra explanation.
 * The truncate, ceiling and round methods could be considered the Math.floor(),
 * Math.ceil() or Math.round versions for dates
 * This way date-fields will be ignored in bottom-up order.
 * As a complement to these methods we've introduced some fragment-methods.
 * With these methods the Date-fields will be ignored in top-down order.
 * Since a date without a year is not a valid date, you have to decide in what
 * kind of date-field you want your result, for instance milliseconds or days.
 * </p>
 *   
 *   
 *
 * @author Apache Software Foundation
 * @author <a href="mailto:sergek@lokitech.com">Serge Knystautas</a>
 * @author Janek Bogucki
 * @author <a href="mailto:ggregory@seagullsw.com">Gary Gregory</a>
 * @author Phil Steitz
 * @author Robert Scholte
 * @since 2.0
 * @version $Id: DateUtils.java 911986 2010-02-19 21:19:05Z niallp $
 */
public class DateUtils {

    /**
     * 获取当前时间
     */
    public static  String getNowDate() throws ParseException {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * date To String
     * @param dateDate
     * @return
     */
    public static String dateToStr(Date dateDate) {
          SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String dateString = formatter.format(dateDate);
            return dateString;
         }

    /*** 判断时间是否在[startTime, endTime]区间，注意时间格式要一致
     * * @param nowTime
     * * @param startTime
     * * @param endTime
     * * @return*/
    public static boolean isEffectiveDate(String nowTime, String startTime, String endTime) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date nowDate = null;Date startDate = null;Date endDate = null;try {nowDate = df.parse(nowTime);startDate = df.parse(startTime);endDate = df.parse(endTime);} catch (ParseException e) {e.printStackTrace();}

        if (nowDate.getTime() == startDate.getTime()
                || nowDate.getTime() == endDate.getTime()) {
            return true;
        }
        Calendar date = Calendar.getInstance();
        date.setTime(nowDate);
        Calendar begin = Calendar.getInstance();
        begin.setTime(startDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }



    /**
     * 日期格式字符串转换成时间戳
     * @param date_str 字符串日期
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String date2TimeStamp(String date_str,String format){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime()/1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }


    /***
     * 时间字符串转date
     * @return
     */
    public static Date strToDate(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        Date time=null;
        try {
            time= sdf.parse(sdf.format(new Date()));

        } catch (ParseException e) {

            e.printStackTrace();
        }
        return time;
    }


    /**
     *
     */

    public static Date strToDate2(String time){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date_util = null; //转换为util.date
        java.sql.Date date_sql = null;
        try {
            date_util = sdf.parse(time);
             date_sql = new java.sql.Date(date_util.getTime());//转换为sql.date
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date_sql;

    }


    /**
     * 得到几天后的时间
     * @param d
     * @param day
     * @return
     */
    public static Date getDateAfter(Date d,int day){
        Calendar now =Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE,now.get(Calendar.DATE)+day);
        return now.getTime();
    }


    /**
     * 时间戳转Date类型
     * @param time
     * @return
     */
    public static Date strTimetoDate(String time) {
    	String timeStr = DateUtils.stampToDate(time);
    	return DateUtils.strToDate2(timeStr);
    }

    /**
     * @desc 字符串转时间戳
     * @param time
     * @example time="2019-04-19 00:00:00"
     **/
    public static  Long getTimestamp(String time) {
        Long timestamp = null;
        try {
            timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timestamp;
    }
    
    
    /**
    * 字符串转换成日期
    * @param str
    * @return date
    */
    public static Date strToDate(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


}
