package controller;

import java.util.List;
import java.util.Optional;
import Model.Student;
import com.example.student.StudentNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import Service.StudentService;

@RestController
public class StudentResource {

    @Autowired
    StudentService studentService;


    @GetMapping(value = "/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student retrieveStudent(@PathVariable("id") int id) {
        Optional<Student> student = Optional.ofNullable(studentService.getStudentById(id));

        if (!student.isPresent())
            throw new StudentNotFound("id-" + id);

        return studentService.getStudentById(id);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.delete(id);
    }

    @PostMapping("/students")
    public int createStudent(@RequestBody Student student, int id) {
        studentService.saveOrUpdate(student);
        return student.getId();

    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@RequestBody Student student) {
        studentService.saveOrUpdate(student);
        return student;
    }
}
