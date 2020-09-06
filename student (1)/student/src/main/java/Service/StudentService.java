package Service;
import java.util.ArrayList;
import java.util.List;

import Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Repository.StudentRepository;

@Service

public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public List<Student> getAllStudents()
    {
        List<Student> student = new ArrayList<>();
        student.addAll(studentRepository.findAll());
        return student;
    }
    public Student getStudentById(int id)
    {
        return studentRepository.findById(id).get();
    }
    public void saveOrUpdate(final Student student)
    {
        studentRepository.save(student);
    }
    public void delete(int id)
    {
        studentRepository.deleteById(id);
    }
    public void update(Student student, int id)
    {
        studentRepository.save(student);
    }
}
