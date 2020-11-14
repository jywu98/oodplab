import java.sql.Time;

public enum LessonType{TUTORIAL, LECTURE, LAB, SEMINAR};

public class Lesson{
    protected int index;
    protected String venue;
    protected LessonType type;
    protected String week;
    protected String day;
    protected Time startTime;
    protected Time endTime;

    public Lesson(int index, String venue, String type, String week, String day, Time startTime, Time endTime){
        this.index = index;
        this.venue = venue;
        this.type = LessonType.valueOf(type.toUpperCase());
        this.week = week;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
