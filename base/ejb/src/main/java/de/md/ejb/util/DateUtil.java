/**
 * 
 */
package de.md.ejb.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Ugly Util Class for Date-Stuff.
 * 
 * @author dilgerma
 *
 */
public class DateUtil {

    /**
     * Method used to reset certain fields of a date.
     * ATTENTION: Method aquires a new {@link Calendar}-Instance on every call,
     * so this is expensive, use with care!
     * 
     * @param d the Date to reset Fields from
     * @param fields fields of Type {@link Calendar} like {@link Calendar#SECOND}
     * @return new Date Object with resettet fields
     * */
    public static Date clearFieldsDate(Date d, int... fields){
	Calendar cal = Calendar.getInstance();
	cal.setTime(d);
	for(int field : fields){
	    cal.clear(field);
	}
	return cal.getTime();
    }
}
