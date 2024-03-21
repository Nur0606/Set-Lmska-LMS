package LMS.service;

import LMS.model.Group;
import LMS.model.Student;

import java.util.List;

public interface GroupService {
    String  addGroup(Group group);
    Group getGroupByName(String groupName);
    String updateGroupName(String groupName,Group group);
    List<Group> getAllGroups();
    String deleteGroup(String groupName);

}
