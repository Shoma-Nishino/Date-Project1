package com.example.demo.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Datetime {
	private Long id;
	private String dateId;
	private String dateName;
	private LocalDate dateStandart;
	private Long calulationYear;
	private Long calulationMonth;
	private Long calulationDay;

	public Long getId(){
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDateId() {
		return dateId;
	}

	public void setDateId(String dateId) {
		this.dateId = dateId;
	}

	public String getDateName() {
		return dateName;
	}

	public void setDateName(String dateName) {
		this.dateName = dateName;
	}

	public LocalDate getDateStandart(){
		return dateStandart;
	}

	public void setDateStandart(String dateStandart){
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate localDate = LocalDate.parse(dateStandart, f);
		this.dateStandart = localDate;
	}

	public Long getCalulationYear(){
		return calulationYear;
	}

	public void setCalulationYear(Long calulationYear) {
		this.calulationYear = calulationYear;
	}

	public Long getCalulationMonth(){
		return calulationMonth;
	}

	public void setCalulationMonth(Long calulationMonth) {
		this.calulationMonth = calulationMonth;
	}

	public Long getCalulationDay(){
		return calulationDay;
	}

	public void setCalulationDay(Long calulationDay) {
		this.calulationDay = calulationDay;
	}

}
