package co.id.mhanifmuhsin.demo.dao;

import co.id.mhanifmuhsin.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Merupakan implementasi dari interface StudentDao, yang berfungsi sebagai tempat untuk menyimpan codingan akses
 * data
 */
@Repository("fakeDao")
public class FakeStudentDaoImpl implements StudentDao {
    private final Map<UUID, Student> database;

    public FakeStudentDaoImpl() {
       database = new HashMap<>();
       UUID studentId = UUID.randomUUID();
       database.put(studentId, new Student(studentId,28,"Muhamad Hanif","Muhsin","Spring Boot"));

    }

    @Override
    public int insertNewStudent(UUID studentId, Student student) {
        database.put(studentId, student);
        return 1;
    }

    @Override
    public Student selectStudentById(UUID studentId) {
        return database.get(studentId);
    }

    @Override
    public List<Student> selectAllStudent() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int updateStudentById(UUID studentId, Student updateStudent) {
        database.put(studentId,updateStudent);
        return 1;
    }

    @Override
    public int deleteStudentById(UUID studentId) {
        database.remove(studentId);
        return 1;
    }
}
