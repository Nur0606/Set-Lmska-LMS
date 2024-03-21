import LMS.db.Datebase;
import LMS.enums.Gender;
import LMS.genericIc.GenericId;
import LMS.model.Admin;
import LMS.model.Group;
import LMS.model.Lesson;
import LMS.model.Student;
import LMS.service.AdminService;
import LMS.service.GroupService;
import LMS.service.LessonService;
import LMS.service.StudentService;
import LMS.service.impl.AdminServiceImpl;
import LMS.service.impl.GroupServiceImpl;
import LMS.service.impl.LessonServiceImpl;
import LMS.service.impl.StudentServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin("nurmuhammed@gmail.com", "nurmuhammed");
        Scanner scanner = new Scanner(System.in);
        AdminService adminService = new AdminServiceImpl();
        List<Group> groupList = new ArrayList<>();
        Datebase.getgroups.addAll(groupList);
        Datebase.getAdmin.add(admin);
        StudentService studentService = new StudentServiceImpl();
        LessonService lessonService = new LessonServiceImpl();
        GroupService groupService = new GroupServiceImpl();
        System.out.println(LocalDate.now());
        try {
            boolean ww = true;
            while (ww) {
                System.out.println("""
                        Катталган болсонуз 1 басыныз , пароль унутуп , калып озгортуу учун 2 басыныз!
                           """);
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println("email жазыныз: ");
                        String email = scanner.next();
                        if (email.equals(admin.getEmail())) {
                            System.out.println("Пароль жазыныз: ");
                            String password = scanner.next();
                            if (password.equals(admin.getPassword())) {
                                System.out.println("  Кош келипсиз!  ");
                                boolean tt = true;
                                while (tt) {
                                    System.out.println("""
                                            1 ->Add new group
                                            2 ->Get group by name
                                            3 ->update group name
                                            4 ->Get all groups
                                            5 ->Add new Student to group name
                                            6 ->Update student
                                            7 ->Find student by first name
                                            8 ->Get all students by group name
                                            9 ->Delete student
                                            10 ->Add new lesson to group
                                            11 ->Get lesson by name
                                            12 ->Get all lesson by group name
                                            13 ->Get all student's lesson
                                            14 ->Delete lesson
                                            15 ->Delete group
                                            """);
                                    switch (scanner.nextInt()) {
                                        case 1 -> {
                                            Group group = new Group();
                                            group.setId(GenericId.genericGroupId());
                                            System.out.println("Группанын атын жазыныз: ");
                                            String name = scanner.next();
                                            group.setGroupName(name);
                                            System.out.println("Группага описание жазыныз: ");
                                            String opisanie = scanner.next();
                                            group.setDescription(opisanie);
                                            System.out.println(groupService.addGroup(group));
                                        }
                                        case 2 -> {
                                            System.out.println("Группанын атын жазыныз: ");
                                            String name = scanner.next();
                                            System.out.println(groupService.getGroupByName(name));
                                        }
                                        case 3 -> {
                                            Group group = new Group();
                                            System.out.println("Группанын атын жазыныз: ");
                                            String name = scanner.next();
                                            System.out.println("Группага жаны ат жазыныз: ");
                                            String nname = scanner.next();
                                            group.setGroupName(nname);
                                            System.out.println("Группага жаны описание жазыныз: ");
                                            String opppisanie = scanner.next();
                                            group.setDescription(opppisanie);
                                            System.out.println(groupService.updateGroupName(name, group));
                                        }
                                        case 4 -> System.out.println(groupService.getAllGroups());
                                        case 5 -> {
                                            Student student = new Student();
                                            System.out.println("Группаныын атын жызыныз: ");
                                            String name = scanner.next();
                                            student.setId(GenericId.genericStudentId());
                                            System.out.println("Студенттин атын жазыныз: ");
                                            String fname = scanner.next();
                                            student.setFirstName(fname);
                                            System.out.println("Студенттин жонун жазыныз: ");
                                            String lname = scanner.next();
                                            student.setLastName(lname);
                                            System.out.println("Студенттин электронный почтасын жазыныз: ");
                                            String emailo = scanner.next();
                                            if (emailo.contains("@gmail.com")) {
                                                student.setEmail(emailo);
                                                System.out.println("Студенттин парольюн жазыныз: ");
                                                String ps = scanner.next();
                                                if (ps.length() > 7) {
                                                    student.setPassword(ps);
                                                    System.out.println("Студенттин жынысын жазыныз:(male/female)");
                                                    Gender gender = Gender.valueOf(scanner.next());
                                                    student.setGender(gender);
                                                    System.out.println(studentService.addNewStudentToGroupName(name, student));
                                                } else
                                                    System.out.println("Пароль 7 ден коп болуш керек!");
                                            } else
                                                System.out.println("Электронный почтаныз @gmail.com камтыбай жатат!");
                                        }
                                        case 6 -> {
                                            Student student = new Student();
                                            System.out.println("Студенттин электронный почтасын жазыныз: ");
                                            String studentEmail = scanner.next();
                                            if (studentEmail.contains("@gmail.com")) {
                                                System.out.println("Студенттин паролюн жаз: ");
                                                String parool = scanner.next();
                                                if (parool.length() > 7) {
                                                    System.out.println("Студенттин жаны атын жазыныз: ");
                                                    String nname = scanner.next();
                                                    student.setFirstName(nname);
                                                    System.out.println("Студенттин жаны жонун жазыныз: ");
                                                    String lname = scanner.next();
                                                    student.setLastName(lname);
                                                    System.out.println(studentService.updateStudent(studentEmail, parool, student));
                                                } else
                                                    System.out.println("Пароль 7 ден коп болуш керек!");
                                            } else
                                                System.out.println("Электронный почтаныз @gmail.com камтыбай жатат!");
                                        }
                                        case 7 -> {
                                            System.out.println("Студенттин атын жазыныз издеш учун: ");
                                            String name = scanner.next();
                                            System.out.println(studentService.findStudentByFirstName(name));
                                        }
                                        case 8 -> {
                                            System.out.println("Группанын атын жазыныз: ");
                                            String grname = scanner.next();
                                            System.out.println(studentService.getAllStudentBYGroupName(grname));
                                        }
                                        case 9 -> {
                                            System.out.println("Студенттин электронный почтасн жазыныз: ");
                                            String pochta = scanner.next();
                                            if (pochta.contains("@gmail.com")) {
                                                System.out.println(studentService.deletedStudent(pochta));
                                            } else
                                                System.out.println("Электронный почтаныз @gmail.com камтыбай жатат!");
                                        }
                                        case 10 -> {
                                            Lesson lesson = new Lesson();
                                            System.out.println("Группанын атын жазыныз: ");
                                            String grName = scanner.next();
                                            lesson.setId(GenericId.genericLessonId());
                                            System.out.println("жыны Сабактын атын жазыныз: ");
                                            String l = scanner.next();
                                            lesson.setLessonName(l);
                                            System.out.println("Жаны сабакка тапшырманын описаниясын жазыныз: ");
                                            String des = scanner.next();
                                            lesson.setTaskDescription(des);
                                            System.out.println(lessonService.addNewLessonToGroup(grName, lesson));
                                        }
                                        case 11 -> {
                                            System.out.println("Сабактын атын жазыныз: ");
                                            String name = scanner.next();
                                            System.out.println(lessonService.getLessonByName(name));
                                        }
                                        case 12 -> {
                                            System.out.println("Группанын атын жазыныз: ");
                                            String grName = scanner.next();
                                            System.out.println(lessonService.getAllLessonByGroupName(grName));
                                        }
                                        case 13 -> {
                                            System.out.println("Студенттин электронный почтасын жазыныз! ");
                                            String posta = scanner.next();
                                            if (posta.contains("@gmail.com")) {
                                                System.out.println(lessonService.getAllLessonsByStudentEmail(posta));
                                            } else
                                                System.out.println("Электронный почтаныз @gmail.com камтыбай жатат!");
                                        }
                                        case 14 -> {
                                            System.out.println("Кайсы сабакты удалить етесин атын жаз: ");
                                            String name = scanner.next();
                                            System.out.println(lessonService.deleteLesson(name));
                                        }
                                        case 15 -> {
                                            System.out.println("Кайсы группаны удалить этесин атын жаз: ");
                                            String name = scanner.next();
                                            System.out.println(groupService.deleteGroup(name));
                                        }
                                        default -> System.out.println("Адаштын брат !");
                                    }
                                }
                            } else {
                                throw new Exception("Пароль же электрооный почтаныз ката!");
                            }
                        } else {
                            throw new Exception("Электронный потанызда @gmail.com Камтыш керек !");
                        }
                        break;
                    case 2:
                        System.out.println("Электронный почтанызды жазыныз: ");
                        String emaill = scanner.next();
                        admin.setEmail(emaill);
                        if (emaill.contains("@gmail.com")) {
                            System.out.println("парольунузду жазыныз: ");
                            String paroll = scanner.next();
                            admin.setPassword(paroll);
                            if (paroll.length() > 7) {
                                System.out.println(adminService.register(admin));
                            } else {
                                System.out.println("Пароль 7 ден коп болуш керек!");
                            }
                        } else {
                            System.out.println("Электронный потанызда @gmail.com Камтыш керек !");
                        }
                        break;
                    default:
                        System.out.println(" 1 жэ 2 танданыз");


                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());


        }
    }
}