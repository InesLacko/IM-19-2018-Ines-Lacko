package geometry;

import java.awt.Graphics;
public class Line extends Shape {
	
private Point startPoint;
private Point endPoint;
//private boolean selected;

public Line() {
	
}

public Line(Point startPoint,Point endPoint) {
	this.startPoint = startPoint;
	this.endPoint = endPoint;
}

public Line(Point startPoint,Point endPoint,boolean selected) {
	this(startPoint,endPoint);
	this.selected = selected;
}

public double length() {
	return startPoint.distance(endPoint);
}

@Override
public String toString() {
	return "(" + this.startPoint.getX() + " , " + this.endPoint.getY() + ")" + " --> (" + this.endPoint.getX() + " , " + this.startPoint.getY() +")";
}

@Override
public boolean equals(Object obj) {
	if (obj instanceof Line) {
		Line temp = (Line) obj;
		if(this.startPoint.equals(temp.startPoint) && this.endPoint.equals(temp.endPoint)) {
			return true;
		}
	}
	return false;
}
@Override
public void moveOn(int x, int y) {
	
}

@Override
public void moveBy(int dx, int dy) {
	startPoint.moveBy(dx, dy);
	endPoint.moveBy(dx, dy);
	
}

@Override
public int compareTo(Object o) {
	if(o instanceof Line) {
		return (int) (length() - ((Line)o).length());
	}
	return 0;
}

@Override
public boolean contains(int x, int y) {
	Point klik = new Point(x,y);
	return (this.startPoint.distance(klik) + this.endPoint.distance(klik) - length()) <=2;
}


public Point getStartPoint() {
	return startPoint;
}

public void setStartPoint(Point startPoint) {
	this.startPoint = startPoint;
}

public Point getEndPoint() {
	return endPoint;
}

public void setEndPoint(Point endPoint) {
	this.endPoint = endPoint;
}

public boolean isSelected() {
	return selected;
}

public void setSelected(boolean selected) {
	this.selected = selected;
}

public void draw (Graphics g) {
g.drawLine(this.getStartPoint().getX(),this.startPoint.getY(),this.getEndPoint().getX(),this.getEndPoint().getY());
if (selected) {
	g.drawRect(getStartPoint().getX()-3,getStartPoint().getY() -3,6,6);
	g.drawRect(getEndPoint().getX()-3,getEndPoint().getY()-3,6,6);
}
}



}