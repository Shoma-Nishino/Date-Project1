package com.example.demo.monitor;

import org.junit.BeforeClass;
import org.junit.Test;

import com.codeborne.selenide.Configuration;
//import static com.codeborne.selenide.Condition.*;//static importしても良い。
import com.codeborne.selenide.Selenide;
//import static com.codeborne.selenide.Selenide.*;//static importしても良い。
import com.codeborne.selenide.WebDriverRunner;

public class monitorTest {
    @BeforeClass
    public static void beforeClass() {
        // デフォルトではFireFoxを使うので、Chromeを使うよう設定している。
        Configuration.browser = WebDriverRunner.CHROME;

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
    }

	@Test
	public void test1() {
		// ページを開く
		Selenide.open("https://www.yahoo.co.jp/");
	}
}
