import java.util.ArrayList;

public class Schedule {
    protected String matricnumber;
    protected ArrayList<Index> registered;
    protected ArrayList<Lesson> timetable;
    protected ArrayList<Index> waiting;

    public Schedule(String matricnumber){
        this.matricnumber = matricnumber;
        registered = new ArrayList<Index>();
        timetable = new ArrayList<Lesson>();
        waiting = new ArrayList<Index>();
    }

    public Boolean addCourse(Index index_){
        registered.add(index_);
        ArrayList<Lesson> lessons = index_.getLessons();
        for (int i = 0; i < lessons.size(); i++){
            Lesson selected = lessons.get(i);
            for (int j = 0; j < timetable.size(); j++){
                if (checkClash(selected, timetable.get(j)) == false){
                    System.out.println("Error - there is a clash with another registered course");
                    return false;
                }
            }
            for (int k = 0; k < timetable.size(); k++){
                if (checkClash(selected, waiting.get(j)) == false){
                    System.out.println("Error - there is a clash with an index in your waitlist");
                    return false;
                }
            }    
        }
        for (int i = 0; i < lessons.size(); i++){
            timetable.add(lessons.get(i));
        }
        registered.add(index_);
        return true;
    }

    public void dropCourse(Index index_){
        registered.remove(index_);
        ArrayList<Lesson> lessons = index_.getLessons();
        for (int i = 0; i < lessons.size(); i++){
            this.timetable.remove(lessons.get(i));
        }
        registered.remove(index_);
    }

    private Boolean checkClash(Lesson new_, Lesson old_){
        if ((new_.week == old_.week) && (new_.day == old_.day)){
            if ((new_.startTime.isBefore(old_.endTime)) && (new_.endTime.isAfter(old_.startTime))){
                return false;
            }
        }
        return true;
    }
    
    public ArrayList<Index> getRegistered(){
        return this.registered;
    }
    
    public ArrayList<Index> getWaiting(){
        return this.waiting;
    }
    
    public void wait(Index index_){
        waiting.add(index_);
    }
    
    public void unwait(Index index_){
        waiting.remove(index_);
    }    
}
