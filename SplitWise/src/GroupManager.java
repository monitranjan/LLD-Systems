import java.util.ArrayList;
import java.util.List;

public class GroupManager {
    List<Group> groupList;

    public GroupManager(){
        groupList = new ArrayList<>();
    }

    public void createGroup(String groupId, String groupName,User createdByUser){
        Group group = new Group();
        group.setGroupId(groupId);
        group.setGroupName(groupName);
        group.addMember(createdByUser);
        groupList.add(group);
    }

    public Group getGroup(String groupId){
        return groupList.stream().filter(group -> group.getGroupId().equals(groupId)).findFirst().orElse(null);
    }
}
