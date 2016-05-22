package zanaytie3;

public class Point {

	public double x;
	public double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void distanceTo(Point a,Point b) {
		double value;
		value =	(b.x - a.x)*(b.x - a.x) + (b.y - a.y)*(b.y - a.y);
		value = Math.sqrt(value);
 		System.out.println(value);
	

	}

}