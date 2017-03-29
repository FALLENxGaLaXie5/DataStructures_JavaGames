/** Garage client
  *  @author Joshua Steward
  *  @version 11/10/2014
  */

import java.util.ArrayList;

public class GarageClient
{
  public static void main(String[] args)
  {
    Garage g1 = new Garage();
    g1.addCar(new Auto("BMW", 10, 25));
    g1.addCar(new Auto("BMW", 20, 35));
    System.out.println("Cars in garage1: \n" + g1);
    
    Garage g2 = new Garage();
    g2.addCar(new Auto("Volvo", 100, 25));
    g2.addCar(new Auto("Ford", 200, 35));
    System.out.println("Cars in garage2: \n" + g2);
    
    if (g1.equals(g2))
      System.out.println("The garages are equal - INCORRECT");
    else
      System.out.println("The garages are not equal - CORRECT");
    
    System.out.println("\nAverage number of miles per car in garage1: " + g1.averageMiles());
    System.out.println("\nTotal gallons used by cars in garage1: " + g1.totalGallons());
    
    ArrayList<Auto> temp = g2.getCars();
    g1.setCars(temp);
    System.out.println("\nAfter changing, cars in garage1: \n" + g1);
    if (g1.equals(g2))
      System.out.println("The garages are now equal - CORRECT");
    else
      System.out.println("The garages are now not equal - INCORRECT");
    
    // test add method
    System.out.println("\nAdding new car to garage1");
    g1.addCar(new Auto("Nissan", 80, 25));
    System.out.println("Cars in garage1: \n" + g1);
    System.out.println("Cars in garage2: \n" + g2);
    
    //test withMilesDrivenBelow method
    int testMilesDriven = 150;
    ArrayList<Auto> carsBelow = g1.withMilesDrivenBelow(testMilesDriven);
    if (carsBelow.size() > 0)
    {
      System.out.println("The following cars in garage1 have mileage below " + testMilesDriven + " :");
      for (Auto car : carsBelow)
        System.out.println(car);
    }
    else
      System.out.println("There are no cars with mileage below " + testMilesDriven + " in garage1");
    
    // test oldestCar method
    System.out.println("\nThe oldest car in garage2 is: " + g2.oldestCar());
    
    // the occupancy should be "below minimum"
    System.out.println("\nWith " + g1.numberOfCars() + " cars, garage occupancy is: " + g1.occupancy());
    
    // add cars to test occupancy method
    for (int i = 0; i < Garage.NORMAL; i++)
      g1.addCar(new Auto());
    // the occupancy should be "normal load"
    System.out.println("With " + g1.numberOfCars() + " cars, garage occupancy is: " + g1.occupancy());
    
    for (int i = 0; i < Garage.FULL; i++)
      g1.addCar(new Auto());
    // the occupancy should be "full"
    System.out.println("With " + g1.numberOfCars() + " cars, garage occupancy is: " + g1.occupancy());
  }
}