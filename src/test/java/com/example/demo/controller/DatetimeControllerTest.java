package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.domain.Datetime;

public class DatetimeControllerTest {
	private DatetimeController datetimeController;
	private MockMvc mvc;

	Datetime datetime = new Datetime();

	@Before
	public void setUp() {
		datetimeController = new DatetimeController();
	}

    @Before
    public void before() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new DatetimeController()).build();
    }

	/*newのテスト*/
    /*責務としてはGETアクションがきてviewを返すこと*/
	@Test
	public void newGetTest() throws Exception  {
		mvc.perform(get("/new"))/*"/new"というパスにGETリクエストを送ったら*/
		.andExpect(status().isOk())/*OK=ステータスコード200なのか確認する*/
		.andExpect(view().name("datetime/new"));/*ビューが返ってくるか*/
	}

	/*POSTのテスト(バリデーションも含める)*/
	@Test
	public void postTest() throws Exception{
		mvc.perform(post("datetime")
				.flashAttr("datetime", datetime))
		        .andExpect(model().hasErrors())
		        .andExpect(model().attribute("datetime", datetime));
//		        .param("dateName", "test"));
	}

	/*テストをするためにテストしやすいコードを追記(本末転倒)*/
	@Test
	public void testMakeMessage() {
	    assertThat(datetimeController.makeMessage("world"), is("world"));
	}

}
