package com.example.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.domain.Datetime;
import com.example.demo.mapper.DatetimeMapper;

@Service
public class DatetimeService {
	@Autowired
	private DatetimeMapper datetimeMapper;

	@Transactional
	public List<Datetime> findAll(){
		return datetimeMapper.findAll();
	}

	@Transactional
	public Datetime findOne(Long id) {
		return datetimeMapper.findOne(id);
	}

	@Transactional
	public void save(Datetime datetime) {
		datetimeMapper.save(datetime);
	}

	@Transactional
	public void update(Datetime datetime) {
		datetimeMapper.update(datetime);
	}

	@Transactional
	public void delete(Long id) {
		datetimeMapper.delete(id);
	}

	/*シンプルにLocalDate型に変換された日付を返却*/
	public LocalDate convertToLocalDate(String date,String format) {
		return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
	}

	/*日時計算式*/
	public void calulation(@ModelAttribute Datetime datetime) {
		LocalDate date = convertToLocalDate(datetime.getDateStandart(), "yyyyMMdd");
		datetime.setResultDate(date.plusYears(datetime.getCalulationYear()).plusMonths(datetime.getCalulationMonth()).plusDays(datetime.getCalulationDay()));
	}
}
