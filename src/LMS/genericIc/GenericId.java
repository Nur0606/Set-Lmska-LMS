package LMS.genericIc;

public class GenericId {
    public static Long groupId = 0L;
    public static Long lessonId = 0L;
    public static Long studentId = 0L;
    public static long genericGroupId(){
        return ++groupId;
    }
    public static long genericLessonId(){
        return ++lessonId;
    }
    public static long genericStudentId(){
        return ++studentId;
    }
}
