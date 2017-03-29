/** Auto class
 * Used by Joshua Steward
  * Created by Anderson, Franceschi
  */
import java.text.DecimalFormat;

public class Auto
{
  // instance variables
  private String model;          //  model of auto
  private int milesDriven;       //  number of miles driven
  private double gallonsOfGas;   //  number of gallons of gas
  
  // Constructors:
  //  initializes model to "unknown";
  //  milesDriven to 0
  //        and gallonsOfGas to 0.0
  public Auto()
  {
    this.model = "unknown";
    this.milesDriven = 0;
    this.gallonsOfGas = 0.0;
  }
  
  // allows client to set beginning values for
  //   model, milesDriven, and gallonsOfGas.
  public Auto(String startModel,
              int startMilesDriven,
              double startGallonsOfGas)
  {
    this.model = startModel;
    setMilesDriven(startMilesDriven);
    setGallonsOfGas(startGallonsOfGas);
  }
  
  // Accessor Methods:
  // returns current value of model
  public String getModel()
  {
    return this.model;
  }
  
  // returns current value of milesDriven
  public int getMilesDriven()
  {
    return this.milesDriven;
  }
  
  // returns current value of gallonsOfGas
  public double getGallonsOfGas()
  {
    return this.gallonsOfGas;
  }
  
  // Mutator Methods:
  // allows client to set model
  public void setModel(String newModel)
  {
    this.model = newModel;
  }
  
  // allows client to set value of milesDriven
  // prints an error message if new value is less than 0
  public void setMilesDriven(int newMilesDriven)
  {
    if (newMilesDriven >= 0)
      this.milesDriven = newMilesDriven;
    else
    {
      System.err.println("Miles driven cannot be negative.");
      System.err.println("Value not changed.");
    }
  }
  
  // allows client to set value of gallonsOfGas;
  // prints an error message if new value is less than 0.0
  public void setGallonsOfGas(double newGallonsOfGas)
  {
    if (newGallonsOfGas >= 0.0)
      this.gallonsOfGas = newGallonsOfGas;
    else
    {
      System.err.println("Gallons of gas cannot be negative.");
      System.err.println("Value not changed.");
    }
  }
  
  // Calculates miles per gallon.
  //  if no gallons of gas have been used, returns 0.0;
  //  otherwise, returns miles per gallon
  //        as milesDriven / gallonsOfGas
  public double calculateMilesPerGallon()
  bgfv{
    if (this.gallonsOfGas != 0.0)
      return this.milesDriven / this.gallonsOfGas;
    else
      return 0.0;
  }
  
  // toString: returns a String of instance variable values
  public String toString()
  {
    DecimalFormat gallonsFormat = new DecimalFormat("#0.0");
    return "Model: " + this.model
      + "; miles driven: " + this.milesDriven
      + "; gallons of gas: " + gallonsFormat.format(this.gallonsOfGas);
  }
  
  // equals: returns true if fields of parameter other Auto object
  //         are equal to fields in this object
  public boolean equals(Auto other)
  {
    if (this.model.equals(other.model)
          && this.milesDriven == other.milesDriven
          && Math.abs(this.gallonsOfGas - other.gallonsOfGas)
          < 0.0001)
      return true;
    else
      return false;
  }
}