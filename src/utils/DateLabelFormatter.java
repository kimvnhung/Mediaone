/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class DateLabelFormatter {

    private String datePattern = "dd/MM/yyyy";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    private String time ;
    private long miliTime;
    
    public static final long ONE_DAY = 86400000;//miliseconds
    
    public DateLabelFormatter() {
        miliTime = new Date().getTime();
        time = dateFormatter.format(miliTime);
    }

    public DateLabelFormatter(String timeInFormat) throws ParseException{
        miliTime = dateFormatter.parse(timeInFormat).getTime();
        time = dateFormatter.format(miliTime);
    }
    
    public DateLabelFormatter(long miliTime){
        this.miliTime = miliTime;
        time = dateFormatter.format(miliTime);
    }
    
    public String getTime() {
        return time;
    }

    public long getMiliTime() {
        return miliTime;
    }
    
    public String getNextDayTime(){
        return new DateLabelFormatter(miliTime+ONE_DAY).getTime();
    }
    
    public String getPreviousDayTime(){
        return new DateLabelFormatter(miliTime-ONE_DAY).getTime();
    }
    
    
    
    
    

	
}
