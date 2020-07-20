package co.id.mhanifmuhsin.demo.resource;

import co.id.mhanifmuhsin.demo.model.Student;
import co.id.mhanifmuhsin.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Class untuk menyediakan API
 */
@RestController
@RequestMapping("api/v1/students")
public class StudentResource {

    private final StudentService studentService;

    @Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Student student) {
        studentService.insertNewStudent(UUID.randomUUID(), student);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "{studentId}")
    public Student getStudentbyId(@PathVariable("studentId") UUID studentId){
        return studentService.selectStudentById(studentId);
    }

    @RequestMapping(method = RequestMethod.DELETE,path = "{studentId}")
    public void deleteStudentById(@PathVariable("studentId") UUID studentId){
        studentService.deleteStudentById(studentId);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") UUID studentId, @RequestBody Student student){
        studentService.updateStudentById(studentId, student);
    }
}
