package com.example.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping({"/datetime", "/"})
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

	@PostMapping
	public String create(@Validated @ModelAttribute Datetime datetime, BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
			return "datetime/new";
		}
		calulation(datetime);
		datetimeService.save(datetime);
		return "redirect:/datetime";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @Validated @ModelAttribute Datetime datetime) {
		calulation(datetime);
		datetimeService.update(datetime);
		return "redirect:/datetime";
	}

	@DeleteMapping("{id}")
	public String destory(@PathVariable Long id) {
		datetimeService.delete(id);
		return "redirect:/datetime";
	}

	/*シンプルにLocalDate型に変換された日付を返却*/
	public static LocalDate convertToLocalDate(String date,String format) {
		return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
	}

	/*日時計算式*/
	public static void calulation(@ModelAttribute Datetime datetime) {
		LocalDate date = convertToLocalDate(datetime.getDateStandart(), "yyyyMMdd");
		datetime.setResultDate(date.plusYears(datetime.getCalulationYear()).plusMonths(datetime.getCalulationMonth()).plusDays(datetime.getCalulationDay()));
	}

}
