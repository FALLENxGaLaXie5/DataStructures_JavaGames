/**
 * Created by Joshua Steward on 11/19/2014.
 */
public class Circle extends Shape
{
    private double radius;
    public Circle(double newRadius)
    {
        setRadius(newRadius);
    }
    public double calculatePerimeter()
    {
        return (double)(2) * (Math.PI * getRadius());
    }

    public double calculateArea()
    {
        return Math.PI * Math.pow(getRadius(), 2);
    }

    public double getRadius()
    {
        return this.radius;
    }

    public void setRadius(double newRadius)
    {
        this.radius = newRadius;
    }

    public String toString()
    {
        return "radius: " + getRadius();
    }
}
