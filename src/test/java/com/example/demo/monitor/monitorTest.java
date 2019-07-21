//package com.example.demo.monitor;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import com.codeborne.selenide.Configuration;
//import com.codeborne.selenide.Selenide;
//import com.codeborne.selenide.WebDriverRunner;
//
//public class monitorTest {
//  @BeforeClass
//  public static void beforeClass() {
//    // デフォルトではFireFoxを使うので、Chromeを使うよう設定している。
//    Configuration.browser = WebDriverRunner.CHROME;
//  }
//
//  @Test
//  public void testSample() {
//    // ページを開く
//    Selenide.open("http://localhost:8080/");
//    Selenide.$(".indexBtn").click();
//    Selenide.$(".dateName").val("サンプル");
//    Selenide.$(".dateStandart").val("20190101");
//    Selenide.$(".calulationYear").val("1");
//    Selenide.$(".calulationMonth").val("1");
//    Selenide.$(".calulationDay").val("1");
//    Selenide.$(".postBtn").click();
//  }
//}