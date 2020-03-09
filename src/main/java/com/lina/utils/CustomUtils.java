package com.lina.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomUtils {
  public static void logList(List<String> list) {
    LogUtil.logStep(Arrays.toString(list.toArray()));
  }

  public static void logList(String message, List<String> list) {
    LogUtil.logStep(message + ": " + Arrays.toString(list.toArray()));
  }

  public static void logHashMap(HashMap<String, String> hashMap) {
    hashMap.forEach((k, v) -> LogUtil.logStep(k + "--> " + v));
  }

  public static void consolePrintHashMap(Map hashMap) {
    hashMap.forEach((k, v) -> System.out.println((k + "--> " + v)));
  }
}
