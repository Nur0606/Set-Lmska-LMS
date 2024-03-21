package LMS.service.impl;

import LMS.db.Datebase;
import LMS.genericIc.GenericId;
import LMS.model.Group;
import LMS.model.Student;
import LMS.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {


    @Override
    public String addNewStudentToGroupName(String groupName, Student student) {
        try {
            for (Group getgroup : Datebase.getgroups) {
                if (getgroup.getGroupName().equalsIgnoreCase(groupName)) {
                    getgroup.getStudents().add(student);
                    return "Студент ийгиликтуу сакталды";
                }
            }
            throw new Exception("Группа табыл жок!");
        } catch (Exception e) {
            System.out.println("Oshibka: " + e.getMessage());
        }
        return null;
    }

    @Override
    public String updateStudent(String email, String password, Student newStudent) {
        try {
            for (Group getgroup : Datebase.getgroups) {
                for (Student student : getgroup.getStudents()) {
                    if (student.getEmail().equals(email)) {
                        if (student.getPassword().equals(password)) {
                            student.setFirstName(newStudent.getFirstName());
                            student.setLastName(newStudent.getLastName());
                            return "Сиздин студентиниздин аты-жону ийгиликтуу озгортулду! " + student;
                        }
                    }
                }
            }
            throw new Exception("Сиздин электронный почтаныз же паролунуз ката !");
        } catch (Exception e) {
            System.out.println("Oshibka: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Student findStudentByFirstName(String firstName) {
        try {
            for (Group getgroup : Datebase.getgroups) {
                for (Student student : getgroup.getStudents()) {
                    if (student.getFirstName().equals(firstName)) {
                        return student;
                    }
                }
            }
            throw new Exception(firstName + "  Мындай атта студент табылган жок !");
        } catch (Exception e) {
            System.out.println("Oshibka: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Student> getAllStudentBYGroupName(String groupName) {
        try {
        for (Group getgroup : Datebase.getgroups) {
            if (getgroup.getGroupName().equals(groupName)) {
                return getgroup.getStudents();
            }
        }throw new Exception(groupName + "  Мындай атта группа табылга жок!");
        }catch (Exception e){
            System.out.println("Oshibka: "+e.getMessage());
        }

        return null;
    }

    @Override
    public String deletedStudent(String email) {
        try {
        for (Group getgroup : Datebase.getgroups) {
            for (Student student : getgroup.getStudents()) {
                if (student.getEmail().equals(email)) {
                    getgroup.getStudents().remove(student);
                    return "Окуучу иййгиликтуу жок кылынды!";
                }
            }
        }throw new Exception(email + "  Мындай электронный почта табылган жок!");
        }catch (Exception e){
            System.out.println("Oshibka: "+e.getMessage());
        }
        return null;
    }
}
