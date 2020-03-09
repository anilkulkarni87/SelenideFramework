package com.lina.pageObject;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import com.lina.framework.EnumData;
import com.lina.utils.LogUtil;
import org.openqa.selenium.By;

public final class HomePage {
  private static final SelenideElement INPUT_SEARCH = $(By.xpath("//input[@title='Search']"));
  private static final SelenideElement BTN_SEARCH = $(By.xpath("//input[@name='btnK']"));
  private static final SelenideElement BTN_SERACH_2 = $(By.xpath("//button[@type='submit']"));

  public static void searchGoogle(String searchCriteria) {
    INPUT_SEARCH.clear();
    INPUT_SEARCH.click();
    LogUtil.logStep("Searching for : " + EnumData.valueOf(searchCriteria).getNodeValue());
    INPUT_SEARCH.sendKeys(EnumData.valueOf(searchCriteria).getNodeValue());
    if (BTN_SEARCH.exists()) {
      BTN_SEARCH.click();
    } else {
      BTN_SERACH_2.click();
    }
  }
}
