package geometry;
import java.awt.Graphics;


public class Donut extends Circle {
	private int innerRadius;
	
	public Donut() {
		
	}
	
	public Donut(int radius, Point center,int innerRadius) {
		super(radius, center);
		this.innerRadius = innerRadius;
		
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this( radius,center, innerRadius);
		this.selected = selected;
	}
	
	@Override
	public double area() {
		return super.area() - Math.PI * innerRadius * innerRadius;
	}
	
	@Override
	public boolean contains(int x, int y) {
		double dFromCenter = getCenter().distance(new Point(x,y));
		return dFromCenter >= this.innerRadius && dFromCenter <= getRadius();
	}
	
	public boolean contains(Point p) {
		double dFromCenter = getCenter().distance(p);
		return dFromCenter >= this.innerRadius && dFromCenter <= getRadius();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Donut) {
			Donut donut = (Donut) obj;
			if(getCenter().equals(donut.getCenter()) && getRadius() == donut.getRadius() && this.innerRadius == donut.innerRadius) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public String toString() {
		return "Center: ("+ getCenter().getX()+", "+getCenter().getY() +"), " + "outer radius = "+ getRadius()+ ", inner radius = " + this.innerRadius; 
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Donut) {
			return (int)((area() - ((Donut)o).area()));
		}
		return 0;
	}
	
	

	

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}

/*public double area() {
	return Math.PI * getRadius() * getRadius() - Math.PI * innerRadius * innerRadius;
}*/
	
	
	public void draw (Graphics g) {
		super.draw(g);
		g.drawOval(this.getCenter().getX() - this.innerRadius,this.getCenter().getY()-this.innerRadius,this.innerRadius*2,this.innerRadius*2);
		if(this.isSelected()) {
			g.drawRect(this.getCenter().getX() - this.innerRadius - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + this.innerRadius - 3, 6, 6);
			g.drawRect(this.getCenter().getX() + this.innerRadius - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - this.innerRadius - 3, 6, 6);
		}
	}
}
