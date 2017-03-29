/* Airport class
   Joshua Steward
*/

public class Airport
{
  // 1. ***** Define the instance variables  *****
  //  airportCode is a String
  //  gates is an integer
    private String airportCode;
    private int gates;



  // 2. ***** Write this method *****
  // Default constructor:
  // method name: Airport
  // return value:  none
  // parameters: none
  // function: sets the airportCode to an empty String
  //           sets gates to 0
    public Airport()
    {
        airportCode = "";
        gates = 0;
    }


  // 3. ***** Write this method *****
  // Overloaded constructor:
  // method name: Airport
  // return value: none
  // parameters:  a String startAirportCode and an int startGates
  // function:
  //      calls the the setAirportCode method,
  //      passing startAirportCode parameter;
  //      calls the setGates method, passing startGates parameter
    public Airport(String startAirportCode,
                   int startGates)
    {
        setAirportCode(startAirportCode);
        setGates(startGates);

    }



  // 4. ***** Write this method *****
  // Accessor method for the airportCode instance variable
  // method name: getAirportCode
  // return value: String
  // parameters: none
  // function: returns airportCode
    public String getAirportCode()
    {
        return airportCode;
    }


  // 5. ***** Write this method *****
  // Accessor method for the gates instance variable
  // method name: getGates
  // return value: int
  // parameters: none
  // function: returns gates
    public int getGates()
    {
        return gates;
    }



  // 6. ***** Write this method *****
  // Mutator method for the airportCode instance variable
  // method name: setAirportCode
  // return value: void
  // parameters: String newAirportCode
  // function: assigns airportCode the value of the
  //       newAirportCode parameter
    public void setAirportCode(String newAirportCode)
    {
        airportCode = newAirportCode;
    }


  // 7. ***** Write this method *****
  // Mutator method for the gates instance variable
  // method name: setGates
  // return value:  void
  // parameters: int newGates
  // function: validates the newGates parameter.
  //   if newGates is greater than or equal to 0,
  //       sets gates to newGates;
  //       otherwise, prints an error message to System.err
  //       and does not change value of gates
    public void setGates(int newGates)
    {
        if (newGates >= 0)
        {
            gates = newGates;

        }
        else
        {
            System.err.println("The value cannot be negative!");
        }
    }



 }
