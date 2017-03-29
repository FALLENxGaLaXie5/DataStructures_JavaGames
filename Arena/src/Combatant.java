import java.util.Random;

/**
 * Created by Joshua Steward on 12/5/2014.
 */
public class Combatant
{
    private int health;
    private String name;
    private boolean dead;
    private final int death = 0;
    private final int defaultHealthValue = 20;
    public Combatant(int newHealth, String newName)
    {
        this.health = newHealth;
        this.name = newName;
    }

    public Combatant(String newName)
    {
        this.health = defaultHealthValue;
        this.name = newName;
    }

    public void punch()
    {
        Random random = new Random();
        int damage = random.nextInt(2) + 4;
        this.health -= damage;
        System.out.println(this.name + " took " + damage + " damage.");
        System.out.println(this.name + " has " + this.health + " left.");
        System.out.println();
    }

    public void kick()
    {
        Random random = new Random();
        int damage = random.nextInt(2) + 2;
        int critChance = random.nextInt(4);
        int critDamage = 0;
        if (critChance <= 1)
        {
            critDamage = random.nextInt(4) + 2;
        }
        else
        {
            System.out.println("Kick did not critically hit.");
            System.out.println();
        }

        this.health -= damage;
        this.health -= critDamage;
        System.out.println(this.name + " took " + damage + " damage and was critically hit for "
                + critDamage + ".");
        System.out.println(this.name + " has " + this.health + " left.");

        System.out.println();
    }

    public void headbutt()
    {
        Random random = new Random();
        int damage = random.nextInt(3);
        int critChance = random.nextInt(4);
        int critDamage = 0;
        if (critChance <= 2)
        {
            critDamage = random.nextInt(3) + 4;
        }
        else
        {
            System.out.println("Headbutt did not critically hit.");
            System.out.println();
        }
        if (damage > 0)
        {
            this.health -= damage;
            this.health -= critDamage;
            System.out.println(this.name + " took " + damage
                    + " damage and was critically hit for " + critDamage + ".");
            System.out.println(this.name + " has " + this.health + " left.");
        }
        else
        {
            System.out.println(this.name + " took no damage; crit does not apply.");
            System.out.println(this.name + " has " + this.health + " left.");
        }
        System.out.println();
    }

    public void brace()
    {
        Random random = new Random();
        int damage = random.nextInt(3) + 2;
        this.health += damage;
        System.out.println(this.name + " now has " + this.health + " health.");
        System.out.println();
    }

    public int getHealth()
    {
        return this.health;
    }

    public String getName()
    {
        return this.name;
    }
}
