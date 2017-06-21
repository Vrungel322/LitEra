package com.example.vrungel.litera.utils;

import android.net.Uri;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by Vrungel on 13.04.2017.
 */

public final class Converters {

  public static String dateNow() {
    String dateResult;
    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", java.util.Locale.getDefault());
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    calendar.getTimeInMillis();
    dateResult = formatter.format(calendar.getTime());
    return dateResult;
  }

  public static String timeFromMilliseconds(String date) {
    if (!date.equals("")) {
      String dateResult;
      SimpleDateFormat formatter = new SimpleDateFormat("HH:mm", java.util.Locale.getDefault());
      Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
      long d = Long.valueOf(date);
      calendar.setTimeInMillis(d);
      dateResult = formatter.format(calendar.getTime());

      return dateResult;
    }
    return "";
  }

  public static String timeFromSeconds(String date) {
    if (!date.equals("")) {
      String dateResult;
      SimpleDateFormat formatter = new SimpleDateFormat("HH:mm", java.util.Locale.getDefault());
      Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
      long d = Long.valueOf(date) * 1000L;
      calendar.setTimeInMillis(d);
      dateResult = formatter.format(calendar.getTime());

      return dateResult;
    }
    return "";
  }

  public static String dateFromSeconds(String date) {
    if (!date.equals("")) {
      String dateResult;
      SimpleDateFormat formatter =
          new SimpleDateFormat("dd.MM.yyyy", java.util.Locale.getDefault());
      Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
      long d = Long.valueOf(date) * 1000L;
      calendar.setTimeInMillis(d);
      dateResult = formatter.format(calendar.getTime());

      return dateResult;
    }
    return "";
  }

  public static String fullDateWithTimeFromSeconds(String date) {
    if (!date.equals("")) {
      String dateResult;
      SimpleDateFormat formatter =
          new SimpleDateFormat("dd.MM.yyyy (HH:mm)", java.util.Locale.getDefault());
      Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
      long d = Long.valueOf(date) * 1000L;
      calendar.setTimeInMillis(d);
      dateResult = formatter.format(calendar.getTime());

      return dateResult;
    }
    return "";
  }

  public static String dayFromSeconds(String date) {
    if (!date.equals("")) {
      String dateResult;
      SimpleDateFormat formatter = new SimpleDateFormat("dd EEE", java.util.Locale.getDefault());
      Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
      long d = Long.valueOf(date) * 1000L;
      calendar.setTimeInMillis(d);
      dateResult = formatter.format(calendar.getTime());

      return dateResult;
    }
    return "";
  }

  public static String detailDayFromSeconds(String date) {
    if (!date.equals("")) {
      String dateResult;
      SimpleDateFormat formatter =
          new SimpleDateFormat("dd MMMM (E)", java.util.Locale.getDefault());
      Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
      long d = Long.valueOf(date) * 1000L;
      calendar.setTimeInMillis(d);
      dateResult = formatter.format(calendar.getTime());

      return dateResult;
    }
    return "";
  }

  public static String getUrl(int res) {
    return Uri.parse("android.resource://com.apps.twelve.floor.salon/" + res).toString();
  }

  public static String md5(String s) {
    try {
      // Create MD5 Hash
      MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
      digest.update(s.getBytes());
      byte messageDigest[] = digest.digest();

      // Create Hex String
      StringBuffer hexString = new StringBuffer();
      for (int i=0; i<messageDigest.length; i++)
        hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
      return hexString.toString();

    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return "";
  }
}
