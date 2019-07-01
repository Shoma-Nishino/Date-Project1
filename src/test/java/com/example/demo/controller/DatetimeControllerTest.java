package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class DatetimeControllerTest {
	private DatetimeController datetimeController;
	private MockMvc mvc;

	@Before
	public void setUp() {
		datetimeController = new DatetimeController();
	}

    @Before
    public void before() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new DatetimeController()).build();
    }

	/*newのgetアクションのテスト*/
	@Test
	public void newGetTest() throws Exception  {
		mvc.perform(get("/new"))
		.andExpect(status().isOk());
	}

	/*テストをするためにテストしやすいコードを追記(本末転倒)*/
	@Test
	public void testMakeMessage() {
	    assertThat(datetimeController.makeMessage("world"), is("world"));
	}

}
