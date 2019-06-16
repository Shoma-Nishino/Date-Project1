package com.example.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Datetime;
import com.example.demo.service.DatetimeService;

@Controller
@RequestMapping("/datetime")
public class DatetimeController {
	@Autowired
	private DatetimeService datetimeService;

	@GetMapping
	public String index(Model model) {
		model.addAttribute("datetime", datetimeService.findAll());
		return "datetime/index";
	}

	@GetMapping("new")
	public String newDatetime() {
		return "datetime/new";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("datetime", datetimeService.findOne(id));
		return "datetime/edit";
	}

	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("datetime", datetimeService.findOne(id));
		return "datetime/show";
	}

	@PostMapping
	public String create(@ModelAttribute Datetime datetime, Model model){
		//datetime.setResultDate(datetime.getDateStandart() + datetime.getCalulationYear() + datetime.getCalulationMonth() + datetime.getCalulationDay());
		//datetime.setResultDate(convertToLocalDate(datetime.getDateStandart(), "yyyyMMdd"));
		LocalDate date = convertToLocalDate(datetime.getDateStandart(), "yyyyMMdd");
		datetime.setResultDate(date.plusYears(datetime.getCalulationYear()).plusMonths(datetime.getCalulationMonth()).plusDays(datetime.getCalulationDay()));
		datetimeService.save(datetime);
		return "redirect:/datetime";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Datetime datetime) {
		datetime.setId(id);
		LocalDate date = convertToLocalDate(datetime.getDateStandart(), "yyyyMMdd");
		datetime.setResultDate(date.plusYears(datetime.getCalulationYear()).plusMonths(datetime.getCalulationMonth()).plusDays(datetime.getCalulationDay()));
		datetimeService.update(datetime);
		return "redirect:/datetime";
	}

	@DeleteMapping("{id}")
	public String destory(@PathVariable Long id) {
		datetimeService.delete(id);
		return "redirect:/datetime";
	}

	public static LocalDate convertToLocalDate(String date,String format) {
        // シンプルにLocalDate型に変換された日付を返却
		return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
	}

}
