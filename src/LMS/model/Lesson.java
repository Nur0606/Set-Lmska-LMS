package LMS.model;

public class Lesson {
    private Long id;
    private String lessonName;
    private String taskDescription;

    public Lesson() {
    }

    public Lesson(Long id, String lessonName, String taskDescription) {
        this.id = id;
        this.lessonName = lessonName;
        this.taskDescription = taskDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public String toString() {
        return "Lesson:" +"\n"+
               "id=              " + id +",\n" +
               "lessonName=     '" + lessonName +",\n"+
               "taskDescription='" + taskDescription ;
    }
}
