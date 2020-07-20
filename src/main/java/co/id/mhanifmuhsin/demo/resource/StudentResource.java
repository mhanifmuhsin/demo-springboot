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
 * @RequestMapping : Request ke HTTTP
 * @RestController : untuk menginisialisasi rest
 * @Autowired : Dependency Injection
 * @RequestBody : Untuk menmpung request
 * @ResponeBody : untuk menampilkan respon
 * @PathVariable : Bagian dari pemetaan URI dapat diikat ke variable melalui anotasi ini eg. http://localhost:8080/api/v1/students/71b8f282-3c3a-4625-8b73-517d8515c82b
 * @Get Mapping and @RequestParam : Untuk pemetaan parameter URL dengan mudah eg.
 * http://localhost:8080/api/v1/students/studentId/?id=263fe96f-a7a3-49ba-ad53-2e440a0219cc
 * @DeleteMapping : Request delete eg. http://localhost:8080/api/v1/students/416bb370-6ccf-4008-9bfc-7f71f24ef9b8
 * @GetMapping : Request mengambil data e.g http://localhost:8080/api/v1/students
 * @PutMapping : Update data eg. http://localhost:8080/api/v1/students
 */
@RestController
@RequestMapping("api/v1/students")
public class StudentResource {

    private final StudentService studentService;

    @Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

//    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }

//    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public void insertStudent(@RequestBody Student student) {
        studentService.insertNewStudent(UUID.randomUUID(), student);
    }

//    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "{studentId}")
    @GetMapping("/studentId")
    public Student getStudentbyId(@RequestParam("id") UUID studentId){
        return studentService.selectStudentById(studentId);
    }

//    @RequestMapping(method = RequestMethod.DELETE,path = "{studentId}")
    @DeleteMapping("/{studentId}")
    public void deleteStudentById(@PathVariable("studentId") UUID studentId){
        studentService.deleteStudentById(studentId);
    }

//    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,path = "{studentId}")
    @PutMapping("/{studentId}")
    public void updateStudent(@PathVariable("studentId") UUID studentId, @RequestBody Student student){
        studentService.updateStudentById(studentId, student);
    }
}
