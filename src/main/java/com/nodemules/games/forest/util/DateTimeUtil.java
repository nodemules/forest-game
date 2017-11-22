package com.nodemules.games.forest.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author brent
 * @since 11/19/17.
 */
public final class DateTimeUtil {

  private DateTimeUtil() {
    /* empty private constructor */
  }

  public static long elapsedTime(Date a, Date b) {
    Calendar calA = Calendar.getInstance();
    calA.setTime(a);
    Calendar calB = Calendar.getInstance();
    calB.setTime(b);
    return Math.abs(calA.getTimeInMillis() - calB.getTimeInMillis());
  }

}
