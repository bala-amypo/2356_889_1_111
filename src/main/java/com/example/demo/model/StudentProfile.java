package.com.example.demo.model;

import jakarta.persistence.Id;

public class StudentProfile{
    @Id
    private Long id;
    private String studentId;
    private String fullName;
    private String email;
    private String department;
    private int yearlevel;
    private boolean active;
    private LocalDateTime createdAt;

}