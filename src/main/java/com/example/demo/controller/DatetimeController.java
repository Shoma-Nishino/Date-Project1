package com.example.demo.controller;

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
	public String newDatetime(@Validated Datetime datetime, Model model) {
		model.addAttribute("datetime");
		return "datetime/new";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("datetime", datetimeService.findOne(id));
		return "datetime/edit";
	}

	@PostMapping
	public String create(@ModelAttribute @Validated Datetime datetime, BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
			return "datetime/new";
		}
		datetimeService.calulation(datetime);
		datetimeService.save(datetime);
		return "redirect:/datetime";
	}

	@PutMapping("{id}")
	public String update(@ModelAttribute @Validated Datetime datetime, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "datetime/edit";
		}
		datetimeService.calulation(datetime);
		datetimeService.update(datetime);
		return "redirect:/datetime";
	}

	@DeleteMapping("{id}")
	public String destory(@PathVariable Long id) {
		datetimeService.delete(id);
		return "redirect:/datetime";
	}



	/*テストをするためにテストしやすいコードを追記(本末転倒)*/
    public String makeMessage(String message) {
        return message;
    }

}
