package LMS.service;

import LMS.model.Lesson;
import LMS.model.Student;

import java.util.List;

public interface StudentService {
    String addNewStudentToGroupName(String groupName, Student student);
    String updateStudent(String email,String password,Student newStudent);
    Student findStudentByFirstName(String firstName);
    List<Student> getAllStudentBYGroupName(String groupName);
    String deletedStudent(String email);

}