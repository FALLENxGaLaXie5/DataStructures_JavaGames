/** Garage class
  *  @author YOUR NAME
  *  @version 11/06/2014
  */

import java.util.ArrayList;

public class Garage
{
  /**
   * instance variable called cars which is an ArrayList of Auto objects
   */
  
  private ArrayList<Auto> cars;
  public static final int FULL = 100;
  public static final int NORMAL = 25;
  /**
   * Default constructor:
   * 
   * Instantiates the ArrayList this.cars  by calling the ArrayList default constructor, so the size
   * of the garage will be 0
   */
  public Garage()
  {
    this.cars = new ArrayList<Auto>();
  }
  
  /**
   * getCars accessor method
   *
   * @return the copy of this.cars 
   *   NOTE that the new Auto objects that are copies of the original objects are added:
   *     temp.add(new Auto(car.getModel(), car.getMilesDriven(), car.getGallonsOfGas()));
   */
  public ArrayList<Auto> getCars()
  {
    ArrayList<Auto> temp = new ArrayList<Auto>();
    for (Auto temporaryCars : this.cars )
    {
        temp.add(temporaryCars);
    }
    return temp;
  }
  
  /**
   * Mutator method
   * 
   * copies all the Auto objects from newCars and adds them 
   * in this.cars - please note that Auto objects MUST be copied as well
   *
   * @param newCars the new ArrayList with cars
   */
  public void setCars(ArrayList<Auto> newCars)
  {
    this.cars.clear();  
    for (Auto currentCar : newCars)
    {
        this.cars.add(currentCar);
    }
  }
  
  /**
   * toString
   *
   * @return elements of cars one line per car
   *         elements within a line are separated by a space
   */
  public String toString()
  {
    String returnString = "";
    for ( Auto tempAuto : cars)
    {
        returnString += tempAuto.toString() + "\n";
    }
    
    return returnString;
  }
  
  /**
   * equals
   *
   * @param other Garage object
   * @return return true if elements of this.cars are equal to
   *         corresponding elements in other.cars
   *         and both ArrayLists have the same size
   */

  public boolean equals(Garage other)
  {
    boolean same = true;
    if (this.cars.size() != other.cars.size())
    {
        same = false;
    }

    for (int c = 0; c < this.cars.size(); c++)
    {
        if(!this.cars.get(c).equals(other.cars.get(c)))
            same = false;

    }

    return same;
  }






  
  /**
   *  returns number of cars in the this.cars
   */
  public int numberOfCars()
  {
    int count = 0;
    for (Auto currentCar: this.cars)
    {
        count++;
    }
    return count;
  }
  
  /**
   * occupancy method
   * Computes a description of the occupancy of the garage
   *
   * @return a String: "full" if the number of cars is 100 or more,
   *         "minimum" if it is less than 25,
   *         "normal" load otherwise
   */
  public String occupancy()
  {
    int count = 0;
    String occupancy = "";
    for (Auto currentCar : this.cars)
    {
        count++;
    }
    if (count >= 100)
    {
        occupancy = "full";
    }
    else if (count < 25)
    {
        occupancy = "minimum";
    }
    else
    {
        occupancy = "normal";
    }
    return occupancy;
  }
  
  /**
   * averageMiles method
   * Computes the average number of miles driven for all cars
   *
   * @return a double, the average number of miles driven for all cars
   */
  public double averageMiles()
  {
      double sum = 0.0;
      int count = 0;
      for (int i = 0; i < this.cars.size(); i++)
      {
          sum += cars.get(i).getMilesDriven();
          count ++;
      }
      return sum/(double)count;
  }
  
  /**
   * totalGallons method
   * Computes the sum of all the gallons of gas for all cars in the garage
   *
   * @return a double, the sum of all the gallons of gas for all cars in the garage
   */
  public double totalGallons()
  {
    double sumGallons = 0;
    for (Auto currentCar : this.cars)
    {
        sumGallons += currentCar.getGallonsOfGas();
    }
    return sumGallons;
  }
  
  /**
   * addCar method
   * Adds a Car object to the list of cars representing the garage
   */
  public void addCar(Auto car)
  {
    cars.add(car);
  }
  
  /**
   * withMilesDrivenBelow method
   * finds all the cars than have milesDriven below the given limit and returns
   * ArrayList of such objects
   */
  public ArrayList<Auto> withMilesDrivenBelow (int limit)
  {
    ArrayList<Auto> newCars = new ArrayList<Auto>();
    for (Auto currentCar : this.cars)
    {
        if (currentCar.getMilesDriven() < limit)
        {
            newCars.add(currentCar);
        }
    }
    return newCars;
  }
  
  /**
   * oldestCar method
   * finds the car with the highest miles driven and returns this object
   */
  public Auto oldestCar()
  {
    Auto oldestCar = cars.get(0);
    for (int i = 1; i < this.cars.size(); i++)
    {
        if (this.cars.get(i).getMilesDriven() > oldestCar.getMilesDriven())
        {
            oldestCar = this.cars.get(i);
        }
    }
    return oldestCar;
  }    
}