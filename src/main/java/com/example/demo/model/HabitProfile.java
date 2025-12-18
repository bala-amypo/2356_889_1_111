package.com.example.demo.model;

public class HabitProfile{
    @ID
    private Long id;
    private Long studentId;
    @Min(100)
    private int studyHoursPerDay;
    private LocalDateTime updatedAt;
}