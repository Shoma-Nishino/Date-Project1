package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Datetime;
import com.example.demo.service.DatetimeService;


/*RestController*/
@RestController
@RequestMapping("/api")
public class DatetimeRestController {

	@Autowired
	private DatetimeService datetimeService;

	/*一覧情報を取得する*/
	@GetMapping
	public List<Datetime> getDatetimeAll(){
		return datetimeService.findAll();
	}

	/*IDで個別のデータを取得する*/
	@GetMapping(value = "{dateId}")
	public Datetime getDatetime(@PathVariable("dateId") Long dateId) {
		return datetimeService.findOne(dateId);
	}

	/*POSTで入植された文字列をLocalDateにして返す*/
	@PostMapping(value = "{baseDate}")
	public LocalDate calulationDate(@PathVariable("baseDate") String baseDate){
		LocalDate date = datetimeService.convertToLocalDate(baseDate, "yyyyMMdd");
		return date;
	}


}
