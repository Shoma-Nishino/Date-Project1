package com.example.demo.controller;

import org.junit.Before;
import org.junit.Test;

public class DatetimeControllerTest {
	private DatetimeController datetimeController;

	@Before
	public void setUp() {
		datetimeController = new DatetimeController();
	}

	@Test
	public void calulation_値がないとき() {
		assertThat(datetimeController.calulation(null), is("値がありません"));
	}

}
