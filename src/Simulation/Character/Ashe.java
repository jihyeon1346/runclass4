package Simulation.Character;

public class Ashe extends Champion
{
    public  Ashe(String name, int level, int damage, int hp, int def,
                 int damageGrowth, int hpGrowth, int defGrowth)
    {
        super(name, level, damage, hp, def, damageGrowth, hpGrowth, defGrowth);
    }

    @Override
    public void UseQ(Champion defender)
    {
        checkAlive();
        defender.checkAlive();
        System.out.println(getName() + " (이)가 " + "난사스킬사용");
        defender.SkillAttack(120);
    }

}
