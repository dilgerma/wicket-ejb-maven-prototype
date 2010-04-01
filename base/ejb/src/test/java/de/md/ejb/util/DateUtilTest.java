/**
 * 
 */
package de.md.ejb.util;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;


/**
 * @author dilgerma
 *
 */
public class DateUtilTest {

    @Test
    public void testClearFieldsDate_seconds() {

	
	Calendar cal = Calendar.getInstance();
	cal.set(Calendar.SECOND, 23);
	cal.set(Calendar.MILLISECOND,455);
	cal.set(Calendar.MINUTE,23);
	
	Date date = cal.getTime();
	
	assertFalse(cal.get(Calendar.SECOND) == 0);
	assertFalse(cal.get(Calendar.MILLISECOND) == 0);
	assertFalse(cal.get(Calendar.MINUTE) == 0);
	
	Date resetted = DateUtil.clearFieldsDate(date, Calendar.SECOND, Calendar.MILLISECOND);
	
	Calendar resetCal = Calendar.getInstance();
	resetCal.setTime(resetted);
	assertEquals(0, resetCal.get(Calendar.SECOND));
	assertEquals(0, resetCal.get(Calendar.MILLISECOND));
	assertEquals(23, resetCal.get(Calendar.MINUTE));
    }

}
