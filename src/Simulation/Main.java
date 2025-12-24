package Simulation;

import Simulation.Character.*;

import java.util.Optional;

public class Main
{
    public static void main(String[] args)
    {
        Champion ashe = new Ashe ("애쉬",
                GameConstants.asheLevel, GameConstants.asheHp,
                GameConstants.asheDmg, GameConstants.asheDef,
                GameConstants.asheHpGrowth, GameConstants.asheDmgGrowth,
                GameConstants.asheDefGrowth);
        Champion garen = new Garen("가렌",
                GameConstants.garenLevel, GameConstants.garenHp,
                GameConstants.garenDmg, GameConstants.garenDef,
                GameConstants.garenHpGrowth, GameConstants.garenDmgGrowth,
                GameConstants.garenDefGrowth);
        Champion lux = new Lux("럭스",
                GameConstants.luxLevel, GameConstants.luxHp,
                GameConstants.luxDmg, GameConstants.luxDef,
                GameConstants.luxHpGrowth, GameConstants.luxDmgGrowth,
                GameConstants.luxDefGrowth);
        Champion annie = new Annie("애니",
                GameConstants.annieLevel, GameConstants.annieHp,
                GameConstants.annieDmg, GameConstants.annieDef,
                GameConstants.annieHpGrowth, GameConstants.annieDmgGrowth,
                GameConstants.annieDefGrowth);



        Team<Champion> blue = new Team<>("블루");
        Team<Champion> red = new Team<>("레드");

        blue.addMember(ashe);
        blue.addMember(annie);

        red.addMember(garen);
        red.addMember(lux);

        System.out.println();

        BattleService battleService = new BattleService();
        SafeBattle safeBattle = new SafeBattle(battleService);

        battleService.levelUp(ashe);
        battleService.levelUp(garen);

        safeBattle.teamBattle(blue, red);

        battleService.useSkillQ(annie, garen);
        battleService.levelUp(annie);



        System.out.println("애쉬 Lv: " + ashe.getLevel() + " | 남은HP: " + ashe.getHp());
        System.out.println("애니 Lv: " + annie.getLevel() + " | 남은HP: " + annie.getHp());
        System.out.println("럭스 Lv: " + lux.getLevel() + " | 남은HP: " + lux.getHp());
        System.out.println("가렌 Lv: " + garen.getLevel() + " | 남은HP: " + garen.getHp());

        // 살아있는 타겟 찾기
        System.out.println("\n블루팀에서 살아있는 챔피언 찾기");
        Optional<Champion> aliveTarget = battleService.findAliveTarget(blue);

        aliveTarget.ifPresent(target -> {
            System.out.println("찾은 타겟: " + target.getName());
            System.out.println("HP: " + target.getHp());
        });

        // 이름으로 챔피언 찾기
        System.out.println("\n레드팀에서 가렌 찾기");
        battleService.findChampionByName(red, "가렌")
                .ifPresentOrElse(
                        champion -> System.out.println("찾음: " + champion.getName() + "\nHP: " + champion.getHp()),
                        () -> System.out.println("챔피언을 찾을 수 없습니다.")
                );

        // 없는 챔피언 찾기
        System.out.println("\n레드팀에서 티모 찾기");
        battleService.findChampionByName(red, "티모")
                .ifPresentOrElse(
                        champion -> System.out.println("찾음: " + champion.getName()),
                        () -> System.out.println("챔피언을 찾을 수 없습니다.")
                );


    }
}
