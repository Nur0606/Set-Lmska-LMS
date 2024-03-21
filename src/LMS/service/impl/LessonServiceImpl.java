package LMS.service.impl;

import LMS.db.Datebase;
import LMS.model.Group;
import LMS.model.Lesson;
import LMS.model.Student;
import LMS.service.LessonService;

import java.util.List;

public class LessonServiceImpl implements LessonService {
    @Override
    public String addNewLessonToGroup(String groupName, Lesson lesson) {
        try {
            for (Group getgroup : Datebase.getgroups) {
                if (getgroup.getGroupName().equals(groupName)) {
                    getgroup.getLessons().add(lesson);
                    return "Сабак ийгиликтуу сакталды!";
                }
            }
            throw new Exception(groupName+"Мындай атта группа табылган жок!");
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public Lesson getLessonByName(String lessonName) {
        try {
            for (Group getgroup : Datebase.getgroups) {
                for (Lesson lesson : getgroup.getLessons()) {
                    if (lesson.getLessonName().equals(lessonName)) {
                        return lesson;
                    }
                }
            }
            throw new Exception(lessonName + "  Мындай атта сабак табылган жок!");
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<Lesson> getAllLessonByGroupName(String groupName) {
        try {
            for (Group getgroup : Datebase.getgroups) {
                if (getgroup.getGroupName().equals(groupName)) {
                    return getgroup.getLessons();
                }
            }
            throw new Exception(groupName + "  Мындай атта группа табылган жок!");
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<Lesson> getAllLessonsByStudentEmail(String email) {
        try {
            for (Group getgroup : Datebase.getgroups) {
                for (Student student : getgroup.getStudents()) {
                    if (student.getEmail().equals(email)) {
                        return getgroup.getLessons();
                    }
                }
            }
            throw new Exception(email + "  Мындай студенттин электронный почтасында сабактар жок!");
        } catch (Exception e) {
            System.out.println("Oshibka: " + e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteLesson(String lessonName) {
        try {
            for (Group getgroup : Datebase.getgroups) {
                for (Lesson lesson : getgroup.getLessons()) {
                    if (lesson.getLessonName().equals(lessonName)) {
                        getgroup.getLessons().remove(lesson);
                        return "Сабак ийгиликтуу жок кылынды!";
                    }
                }
            }
            throw new Exception(lessonName + "  Мындай атта сабак табылган жок!");
        } catch (Exception e) {
            System.out.println("Oshibka: " + e.getMessage());
        }
        return null;
    }
}
