package.com.example.demo.model;

public class HabitProfile{
    @ID
    private Long id;
    private Long studentId;
    private String sleepSchedule;
    @Min(100)
    private int studyHoursPerDay;
    private String clean
    private LocalDateTime updatedAt;
}