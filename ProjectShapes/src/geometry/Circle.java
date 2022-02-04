package geometry;
import java.awt.Graphics;

public class Circle extends Shape {
	private int radius;
	private Point center;
	//private boolean selected;
	
	public Circle () {
		
	}
	
	public Circle(int radius, Point center) {
		this.radius = radius;
		this.center = center;
	}
	
	public Circle( int radius,Point center, boolean selected) {
		this(radius,center);
		this.selected = selected;
	}
	
	public double area () {
		return radius * radius * Math.PI;
	}
	
	public double circumference() {
		return radius*2*Math.PI;
	}
	
	@Override
	public String toString() {
		return "Center: (" +this.center.getX() + ", " +this.center.getY() + "), radius = " + this.radius;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Circle temp = (Circle) obj;
			if(this.center.equals(temp.center) && this.radius == temp.radius) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void moveOn(int x, int y) {
		center.moveOn(x, y);
		
	}

	@Override
	public void moveBy(int dx, int dy) {
		center.moveBy(dx, dy);
		
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Circle) {
		return (int) (area() - ((Circle)o).area());
	}
		return 0;
	}

	@Override
	public boolean contains(int x, int y) {
		return this.center.distance(new Point(x,y)) <= radius;
	}
	
	public boolean contains(Point p) {
		return contains (p.getX(),p.getY());
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
	
	public void draw (Graphics g) {
		g.drawOval (this.getCenter().getX() - this.radius,this.getCenter().getY() -this.radius,this.radius*2,this.radius*2);
		if(this.isSelected()) {
			g.drawRect(this.getCenter().getX() - this.radius - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + this.radius - 3, 6, 6);
			g.drawRect(this.getCenter().getX() + this.radius - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - this.radius - 3, 6, 6);
		}
	}

	
	
	

}
