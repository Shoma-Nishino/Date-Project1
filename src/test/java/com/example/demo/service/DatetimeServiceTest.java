package com.example.demo.service;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class DatetimeServiceTest {
	DatetimeService datetimeService = new DatetimeService();

	/*日時フォーマットのテスト*/
	/*責務としては、文字列をLocalDate型に変換して返すこと*/
	@Test
	public void convertToLocalDateTest() {
		LocalDate expected = LocalDate.of(2000, 10, 10);
		LocalDate actual = datetimeService.convertToLocalDate("20001010", "yyyyMMdd");
		assertThat(actual, is(expected));
	}
}
