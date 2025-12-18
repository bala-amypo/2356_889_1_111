package.com.example.demo.model;

public class HabitProfile{
    @ID
    private Long id;
    private Long studentId;
    private String sleepSchedule;
    @Min(100)
    private int studyHoursPerDay;
    private String cleanlinessLevel;
    private String noiseTolerance;
    private String socialPerference;
    private LocalDateTime updatedAt;
}