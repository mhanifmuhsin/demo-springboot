package co.id.mhanifmuhsin.demo.dao;

import co.id.mhanifmuhsin.demo.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentDao {
    int insertNewStudent(UUID studentId, Student student);
    Student selectStudentById(UUID studentId);
    List<Student> selectAllStudent();
    int updateStudentById(UUID studentId, Student updateStudent);
    int deleteStudentById(UUID studentId);
}
