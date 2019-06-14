package com.example.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Datetime;

@Service
public class CalculationService {

	public String calculate(CharSequence localDate, Datetime datetime) {
		LocalDate date = LocalDate.parse(localDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
		LocalDate calculatedDate = date.plusYears(datetime.getCalulationYear());
		return calculatedDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	}

}
