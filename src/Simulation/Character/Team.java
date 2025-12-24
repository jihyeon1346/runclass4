package Simulation.Character;

import java.util.ArrayList;
import java.util.List;

public class Team<T extends Champion> {

    private String name;
    private List<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addMember(T champion) {
        members.add(champion);
        System.out.println(champion.getName() + "이(가) " + name + " 팀에 합류!");
    }

    public List<T> getMembers() {
        return members;
    }

    public String getName() {
        return name;
    }


    public int size() {
        return members.size();
    }
}
