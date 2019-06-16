package com.example.demo.domain;

import java.time.LocalDate;

public class Datetime {
	private Long id;
	private String dateId;
	private String dateName;
	private String dateStandart;
	private int calulationYear;
	private int calulationMonth;
	private int calulationDay;
	private LocalDate resultDate;

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

	public String getDateStandart(){
		return dateStandart;
	}

	public void setDateStandart(String dateStandart){
		this.dateStandart = dateStandart;
	}

	public int getCalulationYear(){
		return calulationYear;
	}

	public void setCalulationYear(int calulationYear) {
		this.calulationYear = calulationYear;
	}

	public int getCalulationMonth(){
		return calulationMonth;
	}

	public void setCalulationMonth(int calulationMonth) {
		this.calulationMonth = calulationMonth;
	}

	public int getCalulationDay(){
		return calulationDay;
	}

	public void setCalulationDay(int calulationDay) {
		this.calulationDay = calulationDay;
	}

	public LocalDate getResultDate(){
		return resultDate;
	}

	public void setResultDate(LocalDate localDate) {
		this.resultDate = localDate;
	}

}
