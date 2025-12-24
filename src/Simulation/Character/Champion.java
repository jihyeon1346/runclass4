package Simulation.Character;

public abstract class Champion
{
    private String name;
    private int level;
    private int hp;
    private int dmg;
    private int def;
    private int hpGrowth;
    private int dmgGrowth;
    private int defGrowth;

    public  Champion (String name, int level, int hp, int dmg, int def,
                     int hpGrowth, int dmgGrowth, int defGrowth)
    {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.dmg = dmg;
        this.def = def;
        this.hpGrowth = hpGrowth;
        this.dmgGrowth = dmgGrowth;
        this.defGrowth = defGrowth;

    }
    public String getName()
    {
        return this.name;
    }
    public int getLevel()
    {
        return this.level;
    }
    public int  getHp()
    {
        return this.hp;
    }

    public int getDef()
    {
        return def;
    }
    public int getDmg()
    {
        return dmg;
    }
    public void LevelUp()
    {
        level++;
        hp += hpGrowth;
        dmg += dmgGrowth;
        def += defGrowth;
        System.out.println(getName() + " Level Up!\n현재 Lv: " + getLevel() + "\n");
    }
    public boolean isAlive()
    {
        return hp > 0;
    }

    public void checkAlive()
    {
        if (hp <= 0)
        {
            throw new DeadChampionActionException(name +"(은)는 이미 사망했습니다!");
        }
    }

    public void takeDamage(int damage)
    {
        int actualDamage = damage - getDef();
        if(actualDamage < 0) actualDamage = 0;

        hp -= actualDamage;
        if (hp < 0) {
            hp = 0;
        }
        System.out.println(getName() + " (이)가 받은 데미지 " + actualDamage);
        System.out.println("남은 HP: " + getHp() + "\n");
    }

    public void BasicAttack(Champion defender)
    {
        checkAlive();
        defender.checkAlive();
        System.out.println(getName() + " (이)가 " + defender.getName() + "에게 기본공격");
        defender.takeDamage(getDmg());
    }

    public void SkillAttack(int skillDamage)
    {
        takeDamage(skillDamage);
    }

    public abstract void UseQ(Champion defender);
}
