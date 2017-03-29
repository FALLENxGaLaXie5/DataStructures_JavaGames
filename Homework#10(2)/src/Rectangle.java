import org.w3c.dom.css.Rect;

/**
 * Created by Joshua Steward on 11/19/2014.
 */
public class Rectangle extends Shape
{
    private double width;
    private double height;

    public Rectangle(double newWidth, double newHeight)
    {
        setWidth(newWidth);
        setHeight(newHeight);
    }

    public double calculatePerimeter()
    {
        return (getHeight() * (double)2) + (getWidth() * (double)2);
    }

    public double calculateArea()
    {
        return (getHeight() * getWidth());
    }

    public double getWidth()
    {
        return this.width;
    }

    public void setWidth(double newWidth)
    {
        this.width = newWidth;
    }

    public double getHeight()
    {
        return this.height;
    }

    public void setHeight(double newHeight)
    {
        this.height = newHeight;
    }

    public String toString()
    {
        return "width: " + getWidth() + "\nheight: " + getHeight();
    }

    public String toString()

}
