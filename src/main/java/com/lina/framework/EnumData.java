package com.lina.framework;

public enum EnumData {
  A("anilkulkarni.com"),
  G("google.com"),
  K("Kannada"),
  B("Bangalore"),
  C("Chess");

  private String nodeValue;

  public String getNodeValue() {
    return nodeValue;
  }

  EnumData(String nodeValue) {
    this.nodeValue = nodeValue;
  }
}
