package com.example.demo.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

	public static void main(String[] args) throws ParseException{

        // DateFormat
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        // 2014/08/01でDateオブジェクト作成
        Date dt = (Date) df.parse("2014-08-01");

        // カレンダークラスのインスタンスを取得
        Calendar cal = Calendar.getInstance();

        // 現在時刻を設定
        cal.setTime(dt);

        // 150日を加算
        cal.add(Calendar.DATE, 150);
        // 結果を表示
        System.out.println(df.format(cal.getTime()));

        // ２カ月を加算
        cal.add(Calendar.MONTH, 2);
        // 結果を表示
        System.out.println(df.format(cal.getTime()));

        // １年を減算
        cal.add(Calendar.YEAR, -1);
        // 結果を表示
        System.out.println(df.format(cal.getTime()));

    }

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
	public String create(@ModelAttribute Datetime datetime) {
		datetimeService.save(datetime);
		return "redirect:/datetime";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Datetime datetime) {
		datetime.setId(id);
		datetimeService.update(datetime);
		return "redirect:/datetime";
	}

	@DeleteMapping("{id}")
	public String destory(@PathVariable Long id) {
		datetimeService.delete(id);
		return "redirect:/datetime";
	}

}
