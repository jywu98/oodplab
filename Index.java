package project;

import java.util.ArrayList;

public class Index {
	protected int index;
	protected int classLimit;
	protected ArrayList<Lesson> indexLessons;
	
	public Index(int index, int classLimit) {
		this.index = index;
		this.classLimit = classLimit;
		indexLessons = new ArrayList<Lesson>();
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
	
	public ArrayList<Lesson> getLessons(){
		return indexLessons;
	}
	
	public void addLesson(Lesson lesson){
		indexLessons.add(lesson);
	}	
}
