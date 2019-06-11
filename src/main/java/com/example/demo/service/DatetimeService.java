package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
