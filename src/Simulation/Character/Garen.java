package Simulation.Character;

public class Garen extends Champion
{
    public  Garen (String name, int level, int damage, int hp, int def,
                 int damageGrowth, int hpGrowth, int defGrowth)
    {
        super(name, level, damage, hp, def, damageGrowth, hpGrowth, defGrowth);
    }

    @Override
    public void UseQ(Champion defender)
    {
        checkAlive();
        defender.checkAlive();
        System.out.println(getName() + " (이)가 " + "휘두르기스킬사용");
        defender.SkillAttack(140);
    }
}
