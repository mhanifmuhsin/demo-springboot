package co.id.mhanifmuhsin.demo.service;

import co.id.mhanifmuhsin.demo.dao.StudentDao;
import co.id.mhanifmuhsin.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Merupakan class yang berfungsi sebagai penyedia layanan yang nanti akan menggambil fungsi akses data dari DAO
 */
@Service
public class StudentService {
    private final StudentDao studentDao;
    @Autowired
    public StudentService(@Qualifier("fakeDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int insertNewStudent(UUID studentId, Student student){
        UUID studentUId = studentId == null ? UUID.randomUUID():studentId;
        student.setId(studentId);
        return studentDao.insertNewStudent(studentUId, student);
    };

    public Student selectStudentById(UUID studentId){
        return studentDao.selectStudentById(studentId);
    };

    public List<Student> getAllStudent(){
        return studentDao.selectAllStudent();
    };

    public int updateStudentById(UUID studentId, Student updateStudent){
        return studentDao.updateStudentById(studentId,updateStudent);
    };
    public int deleteStudentById(UUID studentId){
        return studentDao.deleteStudentById(studentId);
    };
}
