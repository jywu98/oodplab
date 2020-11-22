public class Registration{
	private boolean checkClash(Lesson new_, Lesson old_){
        	if ((new_.week == old_.week) && (new_.day == old_.day)){
            		if ((new_.startTime.isBefore(old_.endTime)) && (new_.endTime.isAfter(old_.startTime))){
                	return false;
            		}
        	}
        return true;
    	}
	
	public boolean registerCourse(Student student, Index index){
		Schedule schedule = student.getSchedule();
		ArrayList<Lesson> lessons = index.getLessons();
		ArrayList<Lesson> timetable = schedule.getTimetable();
		Lesson selected = lessons.get(i);
        for (int j = 0; j < timetable.size(); j++){
        	if (checkClash(selected, timetable.get(j)) == false){
            	System.out.println("Error - there is a clash with another registered course");
            	return false;
            }
        }
		for (int i = 0; i < lessons.size(); i++){
            timetable.add(lessons.get(i));
        }
        schedule.getRegistered().add(index);
		index.registerStudent(student);
        return true;
	}
	
	public boolean waitCourse(Student student, Index index){
		Schedule schedule = student.getSchedule();
		schedule.wait(index);
		index.waitStudent(student);
		return true;
	}
	
	public void dropCourse(Student student, Index index){
		Schedule schedule = student.getSchedule();
        ArrayList<Lesson> lessons = index.getLessons();
		ArrayList<Lesson> timetable = schedule.getTimetable();
        for (int i = 0; i < lessons.size(); i++){
            timetable.remove(lessons.get(i));
        }
        schedule.getRegistered().remove(index);
		index.dropStudent(student);
	}
	
	public boolean unwaitCourse(Student student, Index index){
		Schedule schedule = student.getSchedule();
		schedule.unwait(index);
		index.unwaitStudent(student);
		return true;
	}
	
	public boolean changeIndex(Student student, Index oldIndex, Index newIndex){
		this.dropCourse(student, oldIndex);
		boolean valid = this.registerCourse(student, newIndex);
		if (valid == false){
			boolean revert = this.registerCourse(student, oldIndex);
			return false;
		}
		oldIndex.dropStudent(student);
		newIndex.registerStudent(student);
		return true;
	}
	
	public boolean swapIndex(Student user, Student friend, Index userIndex, Index friendIndex){
		boolean uservalid = this.changeIndex(user, userIndex, friendIndex);
		if (uservalid == false){
			return false;
		}
		Boolean friendvalid = this.changeIndex(friend, friendIndex, userIndex);
		if (friendvalid == false){
			uservalid = this.changeIndex(user, friendIndex, userIndex);
			return false;
		}
		userIndex.swapStudent(friend, student);
		friendIndex.swapStudent(student, friend);
		return true;
	}	
}
