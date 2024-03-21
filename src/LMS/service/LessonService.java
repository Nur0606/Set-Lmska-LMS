package LMS.service;

import LMS.model.Lesson;
import LMS.model.Student;

import java.util.List;

public interface LessonService {
    String addNewLessonToGroup(String groupName, Lesson lesson);
    Lesson getLessonByName(String lessonName);
    List<Lesson> getAllLessonByGroupName(String groupName);
    List<Lesson> getAllLessonsByStudentEmail(String email);

    String deleteLesson(String lessonName);

}
