package LMS.service.impl;

import LMS.db.Datebase;
import LMS.model.Group;
import LMS.model.Student;
import LMS.service.GroupService;

import java.util.List;

public class GroupServiceImpl implements GroupService {
    @Override
    public String addGroup(Group group) {
        Datebase.getgroups.add(group);
        return "Группа ийгиликтуу сакталды!";
    }

    @Override
    public Group getGroupByName(String groupName) {
        try {
            for (Group getgroup : Datebase.getgroups) {
                if (getgroup.getGroupName().equalsIgnoreCase(groupName)) {
                    return getgroup;
                }
            }
            throw  new Exception(groupName + " Мындай атта группа жок!");
        }catch (Exception e){
            System.out.println("Oshibka: "+e.getMessage());
        }
        return null;
    }

    @Override
    public String updateGroupName(String groupName,Group group) {
        try {
        for (Group getgroup : Datebase.getgroups) {
            if (getgroup.getGroupName().equals(groupName)) {
                getgroup.setGroupName(group.getGroupName());
                getgroup.setDescription(group.getDescription());
                return "Группа ийгиликтуу обновление болду!\n" + getgroup;
            }
        } throw new Exception(groupName+"  Мындай атта группа жок!");
        }catch (Exception e){
            System.out.println("Oshibka: "+e.getMessage());
        }
        return null;
    }

    @Override
    public List<Group> getAllGroups() {
        return Datebase.getgroups;
    }


    @Override
    public String deleteGroup(String groupName) {
        try {
        for (Group getgroup : Datebase.getgroups) {
            if (getgroup.getGroupName().equalsIgnoreCase(groupName)){
                getgroup.getLessons().clear();
                getgroup.getStudents().clear();
                Datebase.getgroups.remove(getgroup);
                return "Группа ийгиликтуу очурулду!";
            }
        }
        }catch (Exception e){
            System.out.println("Oshibka: "+e.getMessage());
        }
        return groupName+"  Мындай атта группа жок!" ;
    }
}
