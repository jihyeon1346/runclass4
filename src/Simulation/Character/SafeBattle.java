package Simulation.Character;

public class SafeBattle {
    private final BattleService battleService;


    public SafeBattle(BattleService battleService) {
        this.battleService = battleService;
    }


    public void teamBattle(Team<? extends Champion> team1, Team<? extends Champion> team2) {

            System.out.println("\n===== 팀 전투 시작 =====");
            System.out.println(team1.getName() + " vs " + team2.getName() + "\n");
        try {
            int maxSize = Math.max(team1.size(), team2.size());

            for (int i = 0; i < maxSize; i++) {
                if (i < team1.size() && i < team2.size()) {
                    Champion attacker = team1.getMembers().get(i);
                    Champion defender = team2.getMembers().get(i);
                    attacker.UseQ(defender);
                    defender.UseQ(attacker);
                }
            }
        } catch (DeadChampionActionException e)
        {
            System.out.println("\n팀 전투 종료 사망: " + e.getMessage());
        }
    }

}
