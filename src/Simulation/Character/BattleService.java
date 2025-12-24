package Simulation.Character;

import java.util.Optional;

public class BattleService {

    public boolean useSkillQ(Champion attacker, Champion defender) {
        try {
            attacker.UseQ(defender);
            return true;
        } catch (DeadChampionActionException e) {
            System.out.println("공격 실패 " + e.getMessage());
            return false;
        }
    }

    public boolean levelUp(Champion champion) {
        try {
            champion.checkAlive();
            champion.LevelUp();
            return true;
        } catch (DeadChampionActionException e) {
            System.out.println("레벨업 실패 " + e.getMessage());
            return false;
        }
    }

    public Optional<Champion> findAliveTarget(Team<? extends Champion> team) {
        for (Champion member : team.getMembers()) {
            if (member.isAlive()) {
                return Optional.of(member);
            }
        }
        return Optional.empty();
    }

    public Optional<Champion> findChampionByName(Team<? extends Champion> team, String name) {
        for (Champion member : team.getMembers()) {
            if (member.getName().equals(name)) {
                return Optional.of(member);
            }
        }
        return Optional.empty();
    }


}
