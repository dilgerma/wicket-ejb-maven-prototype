/**
 * 
 */
package de.md.project.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Class that handles ID-Checking transparently and sets a new ID if none is
 * available. Only in MOCK-Data!!
 * 
 * @author dilgerma
 * 
 */
public class IDChecker {

    private Object o;
   
    private IDChecker(Object o) {
	this.o = o;
    }

    public static IDChecker WithObject(Object o) {
	return new IDChecker(o);
    }

    public IDChecker WithNewIdIfNull(long id) {
	Field f = getIdField(o);
	if(f == null)
	    return this;
	try {
	    f.set(o, new Long(id));
	} catch (Exception e) {
	    throw new IllegalArgumentException(e);
	}
	return this;
    }

    private Field getIdField(Object o) {
	try {
	    Field f = o.getClass().getDeclaredField("id");
	    f.setAccessible(true);
	    if ((Long.valueOf((Long)f.get(o)) == 0)) {
		return f;
	    } else {
		return null;
	    }
	} catch (Exception e) {

	    throw new IllegalStateException("no id available", e);

	}
    }
}
