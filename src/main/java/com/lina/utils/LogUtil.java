package com.lina.utils;

import io.qameta.allure.Step;

public final class LogUtil {
  private LogUtil() {}

  @Step("{0}")
  public static void log(final String message) {}

  @Step("{stepText}")
  public static String logStep(String stepText) {
    return stepText;
  }
}
