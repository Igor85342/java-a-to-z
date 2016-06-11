package zanaytie3;

public class Point {

	public double x;
	public double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double distanceTo(Point pointB) {

		double value =	(pointB.x - x)*(pointB.x - x) + (pointB.y - y)*(pointB.y - y);
		return value = Math.sqrt(value);
		
		
 	
	}

}