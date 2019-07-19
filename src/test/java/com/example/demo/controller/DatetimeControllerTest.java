package com.example.demo.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.mapper.DatetimeMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DatetimeControllerTest {
	private MockMvc mvc;

	 @MockBean /*Mockitoが作成される*/
     DatetimeMapper datetimeMapper;

    @Before
    public void before() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new DatetimeController()).build();
    }

	/*newのテスト*/
    /*責務としては、GETアクションがきてviewを返すこと*/
	@Test
	public void newGetTest() throws Exception  {
		mvc.perform(get("/new"))/*"/new"というパスにGETリクエストを送ったら*/
		.andExpect(status().isOk())/*OK=ステータスコード200なのか確認する*/
		.andExpect(view().name("datetime/new"));/*ビューが返ってくるか*/
	}

	public void postTest() throws Exception{
		mvc.perform(post("/datetime")
		.param("dateName", "テスト")
        .param("dateStandart", "20200101")
        .param("calulationYear", "1")
        .param("calulationMonth", "1")
        .param("calulationDay", "1"))
		.andExpect(model().hasNoErrors())/*バリデーション*/
		.andExpect(redirectedUrl("/datetime"));/*リダイレクト*/

		/*saveが1回呼び出されて、saveの引数に入ってくるDatetimeオブジェクトの内容確認*/
	    verify(datetimeMapper, times(1))
	        .save(ArgumentMatchers.argThat(d -> d.getDateName().equals("テスト")
	            && d.getDateStandart().equals("20200101")
	            && d.getCalulationYear() == 1
	            && d.getCalulationMonth() == 1
	            && d.getCalulationDay() == 1
	            && d.getResultDate().equals(LocalDate.of(2021, 02, 02))));
	}

	 @Test
	  public void postTestValidationError() throws Exception {
	    mvc.perform(post("/datetime")
	        .param("dateName", "テスト")
	        .param("dateStandart", "2019/07/04")/*この部分がバリデートされる*/
	        .param("calulationYear", "1")
	        .param("calulationMonth", "2")
	        .param("calulationDay", "3"))
	        .andExpect(model().hasErrors())
	        .andExpect(model().attributeHasFieldErrors("datetime", "dateStandart"))
	        .andExpect(view().name("datetime/new"));

	    // DatetimeMapper#save()は呼ばれないこと
	    verify(datetimeMapper, never()).save(any());
	  }

}
