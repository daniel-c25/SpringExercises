package testcrud.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student getStudent(Long id) {
        Optional<Student> student = studentRepo.findById(id);
        if (student.isEmpty()) {
            throw new RuntimeException("student is not present");
        }

        return student.get();
    }

    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    public Student updateStudent(Long id, Student student) {
        studentRepo.updateStudent(id, student.getName(), student.getSurname(), student.isWorking());
        return getStudent(id);
    }

    public Student updateIsWorking(Long id) {
        Student student = studentRepo.getReferenceById(id);
        student.setWorking(!student.isWorking());
        return studentRepo.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
}