package project;

import java.util.*;

public class Index {

	protected int index;
	protected int classLimit;
	protected String venue;
	protected String week;
	protected String day;
	
	public Index(int index, int classLimit, String venue, String week, String day) {
		this.index = index;
		this.classLimit = classLimit;
		this.venue = venue;
		this.week = week;
		this.day = day;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getClassLimit() {
		return classLimit;
	}

	public void setClassLimit(int classLimit) {
		this.classLimit = classLimit;
	}
	
	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}
	
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
}
