package LMS.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
   private Long id;
   private String groupName;
   private String description;
   private List<Lesson> lessons = new ArrayList<>();
   private List<Student> students = new ArrayList<>();

   public Group() {
   }

   public Group(List<Lesson> lessons, List<Student> students) {
      this.lessons = lessons;
      this.students = students;
   }

   public Group(Long id, String groupName, String description, List<Lesson> lessons, List<Student> students) {
      this.id = id;
      this.groupName = groupName;
      this.description = description;
      this.lessons = lessons;
      this.students = students;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getGroupName() {
      return groupName;
   }

   public void setGroupName(String groupName) {
      this.groupName = groupName;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public List<Lesson> getLessons() {
      return lessons;
   }

   public void setLessons(List<Lesson> lessons) {
      this.lessons = lessons;
   }

   public List<Student> getStudents() {
      return students;
   }

   public void setStudents(List<Student> students) {
      this.students = students;
   }

   @Override
   public String toString() {
      return "Group: "+"\n"+
             "id=          " + id +",\n"+
             "groupName=   " + groupName + ",\n"+
             "description= " + description+",\n"+
             "lessons=     " + lessons +",\n"+
             "students=    " + students;
   }
}
