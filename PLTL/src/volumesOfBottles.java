/**
 * Created by Joshua on 9/19/2014.
 */
public class volumesOfBottles
{
    public static void main( String [] args )
    {
        final double r1 = 1;
        final double r2 = 2;
        final double h1 = 10;
        final double h2 = 2;
        final double h3 = 4;
        double vCyl = (int)(Math.PI * Math.pow(r1, 2) * h1);
        double vT = (((Math.pow(r1, 2) + r1 * r2 + Math.pow(r2, 2)) * h3)/3);
        double vCsec = (int)(Math.PI * vT);
        double VtopCyl = (int)(Math.PI * Math.pow(r2, 2) * h2);
        double vBottle = vCyl + vCsec + VtopCyl;

        System.out.println("The volume of the cylinder is " + (int)vCyl + " and the volume of the cone section is " + (int)vCsec + ".");
        System.out.println("The volume of the enter bottle is " + (int)vBottle + ".");
    }
}
