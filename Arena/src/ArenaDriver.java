import java.util.Scanner;

/**
 * Created by Joshua Steward on 12/5/2014.
 */
public class ArenaDriver
{
    public static void main( String [] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name of first combatant: ");
        String name1 = scan.next();
        System.out.println("Enter name of second combatant: ");
        String name2 = scan.next();
        
        System.out.println("Would you like to give the combatants, "
                + name1 + " and " + name2 + " a custom health value or use the default of 20?(custom/default)");
        String answer = scan.next();
        Combatant combatant1;
        Combatant combatant2;

        if (answer.equalsIgnoreCase("custom"))
        {
            System.out.print("Enter health for both combatants: ");
            int health = scan.nextInt();
            combatant1 = new Combatant(health, name1);
            combatant2 = new Combatant(health, name2);
        }
        else
        {
            combatant1 = new Combatant(name1);
            combatant2 = new Combatant(name2);
        }
        System.out.println();
        System.out.println("Combatants initialized. Ready yourselves for battle, "
                + combatant1.getName() + " and " + combatant2.getName() + "!");
        System.out.println();
        System.out.println("Rules: Hit enter after each rule to continue.");

        String next1 = scan.nextLine();
        System.out.println();
        System.out.println("There are 3 types of attacks: punch, kick, and headbutt. You may also choose to brace during your turn instead of attack.");
        String next2 = scan.nextLine();
        System.out.println("Punch will do the most damage, but will give the opposing combatant the chance to counter with an attack that has the ability to do almost as much damage.");
        String next3 = scan.nextLine();
        System.out.println("Kick will do a low to high amount of damage, give a possible low critical damage chance, and give the opponent the chance to counter with an attack with damage up to half as much damage.");
        String next4 = scan.nextLine();
        System.out.println("Headbutt will do the least amount of damage, most likely give a very small critical damage chance, and the opponent can not counter.");
        String next5 = scan.nextLine();
        System.out.println("Finally, bracing will allow you to gain a low to medium amount health during your turn but not attack.");
        System.out.println();

        while (combatant1.getHealth() > 0 && combatant2.getHealth() > 0)
        {


            System.out.println(combatant1.getName() + ", would you like to punch, kick, headbutt, or brace?");
            String move1 = scan.next();

            switch (move1.charAt(0)) {
                case 'p':
                case 'P':
                    combatant2.punch();
                    break;
                case 'k':
                case 'K':
                    combatant2.kick();
                    break;
                case 'h':
                case 'H':
                    combatant2.headbutt();
                    break;
                case 'b':
                case 'B':
                    combatant1.brace();
                    break;
                default:
                    System.out.println("No move selected. Default selected: Brace.");
                    combatant1.brace();
            }

            System.out.println(combatant2.getName() + ", would you like to punch, kick, headbutt, or brace?");
            String move2 = scan.next();

            switch (move2.charAt(0)) {
                case 'p':
                case 'P':
                    combatant1.punch();
                    break;
                case 'k':
                case 'K':
                    combatant1.kick();
                    break;
                case 'h':
                case 'H':
                    combatant1.headbutt();
                    break;
                case 'b':
                case 'B':
                    combatant2.brace();
                    break;
                default:
                    System.out.println("No move selected. Default selected: Brace.");
                    combatant2.brace();
            }
        }


        if (!(combatant1.getHealth() > 0))
        {
            System.out.println(combatant2.getName() + " wins!");
        }

        else
        {
            System.out.println(combatant2.getName() + " wins!");
        }


    }
}
