package exercise10;

public class Ellipse extends Figure{

    public Ellipse() {
        super(new Point(0, 0), 1, 1);
    }

    public Ellipse(Point startPoint, double a, double b) {
        super(startPoint, a, b);
    }

    public Ellipse(Ellipse otherEllipse) {
        super(otherEllipse.startPoint, otherEllipse.side1, otherEllipse.side2);
    }

    @Override
    public double calculatePerimeter() {
        return Math.PI * (3.0 * (side1 + side2) - Math.sqrt((3.0 * side1 + side2) * (side1 + 3.0 * side2)));
    }

    @Override
    public double calculateArea() {
        return Math.PI * side1 * side2;
    }

    @Override
    public String getType() {
        return (side1 == side2) ? "Circle" : "Ellipse";
    }

    @Override
    public boolean equal(Figure otherFigure) {
        if(otherFigure instanceof Ellipse){
            return super.equal(otherFigure);
        }else {
            return false;
        }
    }

    public boolean containsClick(Point click) {
        return 1 >= Math.pow((click.getX() - startPoint.getX()), 2) / Math.pow(side1, 2) + Math.pow((click.getY() - startPoint.getY()), 2) / Math.pow(side2, 2);
    }
}