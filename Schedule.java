import java.util.ArrayList;

public class Schedule {
    protected String matricnumber;
    protected ArrayList<Index> registered;
    protected ArrayList<Lesson> timetable;

    public Schedule(String matricnumber){
        this.matricnumber = matricnumber;
        registered = new ArrayList<Index>();
        timetable = new ArrayList<Lesson>();
    }

    public Boolean addCourse(Index index_){
        registered.add(index_);
        ArrayList<Lesson> lessons = index_.getLessons();
        for (int i = 0; i < lessons.size(); i++){
            Lesson selected = lessons.get(i);
            for (int j = 0; j < timetable.size(); j++){
                if (checkClash(selected, timetable.get(j)) == false){
                    System.out.println("Error - there is a clash");
                    return false;
                }
            }
        }
        for (int i = 0; i < lessons.size(); i++){
            timetable.add(lessons.get(i));
        }
        return true;
    }

    public void dropCourse(Index index_){
        registered.remove(index_);
        ArrayList<Lesson> lessons = index_.getLessons();
        for (int i = 0; i < lessons.size(); i++){
            this.timetable.remove(lessons.get(i));
        }
    }

    private Boolean checkClash(Lesson new_, Lesson old_){
        if ((new_.week == old_.week) && (new_.day == old_.day)){
            if ((new_.startTime.isBefore(old_.endTime)) && (new_.endTime.isAfter(old_.startTime))){
                return false;
            }
        }
        return true;
    }
}
