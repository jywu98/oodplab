import java.time.LocalTime;

public class Lesson{
    protected int index;
    protected String venue;
    protected LessonType type;
    protected String week;
    protected String day;
    protected LocalTime startTime;
    protected LocalTime endTime;

    public Lesson(int index, String venue, String type, String week, String day, LocalTime startTime, LocalTime endTime){
        this.index = index;
        this.venue = venue;
        this.type = LessonType.valueOf(type.toUpperCase());
        this.week = week;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
