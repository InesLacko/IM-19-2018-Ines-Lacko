package geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		Point p1 = new Point();
		p1.setX(20);
		Point p2 = new Point();
		System.out.println(p1.getX());
		System.out.println(p2.getX());

		p2.setX(21);
		p2.setY(30);
		p1.setY(22);
		
		
		System.out.println(p1.distance(p2));
		Line l1 = new Line();
		//Line l2 = new Line();
		l1.setStartPoint(p2);
		l1.setEndPoint(p1);
		System.out.println(l1.length());
		
		Rectangle r1 = new Rectangle();
		r1.setUpperLeft(p1);
		r1.setWidth(20);
		r1.setHeight(20);
		System.out.println(r1.area());
		System.out.println(r1.circumference());
		
		l1.getEndPoint().setY((int)r1.getUpperLeft().distance(r1.getUpperLeft())+ r1.area());
		System.out.println("Vrednost y kordinate krajne tacke linije l1 je:" +l1.getEndPoint().getY());
		
		Circle circle = new Circle();
		Point center = new Point(50,50,false);
		circle.setCenter(center);
		circle.setRadius(10);
		System.out.println(circle.getRadius());
		System.out.println(circle.area());
		
		Rectangle rect = new Rectangle();
		rect.setUpperLeft(p1);
		rect.setHeight(30);
		rect.setWidth(30);
		circle.getCenter().setY(circle.getRadius() - rect.getUpperLeft().getX());
		
		rect.getUpperLeft().setX((int)circle.area() - circle.getCenter().getY());
		
		
		//Vezbe 4
		Line l3 = new Line();
		System.out.println("Pocetna tacka linije l3 je: " +l3.getStartPoint() + 
				" a krajnja tacka linije l3 je :" + l3.getEndPoint());
		System.out.println(p1.toString());
		System.out.println(l1.toString());
		System.out.println(r1.toString());
		System.out.println(r1);
		System.out.println(circle);
		
		/*Vezbe URIS
		p1.setX(15);
		p1.setY(10);
		p2.setX(15);
		p2.setY(10);
		System.out.println(p1.equals(p2));
		l3.setStartPoint(p2);
		l3.setEndPoint(p1);
		System.out.println(l1.equals(l3));
		Rectangle r2 = new Rectangle(p1, 20, 20);
		System.out.println(r1==r2);
		System.out.println(r1.equals(r2));*/
		//Vezbe 5
		
		/*l1.setStartPoint(new Point(10,30));
		l1.setEndPoint(new Point(30,30));
		System.out.println(l1.length());
		System.out.println(l1.contains(20, 30));
		Circle c2 = new Circle(new Point(30,30), 15);
		System.out.println(c2.contains(50, 40));
		
		Donut d1 = new Donut(new Point(10,10), 10, 5);
		System.out.println(d1.toString());
		Donut d2 = new Donut(new Point(10,10), 10, 5);
		System.out.println(d1.equals(d2));
		System.out.println(d1.toString());*/
		
		//Vezbe 7
		Point p6 = new Point(60,60);
		System.out.println(p6.compareTo(new Point(70,80)));
		
		
		//Circle donut1 = new Donut(new Point(20,20), 10, 5);
		//System.out.println(donut1.area());
		
		/*int[] array = new int[10];
		System.out.println(array[0]); //int je primitivni tip podatka, kreira se niz �iji elementi imaju podrazumevanu vrednost int-a, 0
		array[0] = 3;
		System.out.println(array[0]);
		*/
		Point p5 = new Point(40,40);
		Point p7 = new Point(20,20);
		Point p8= new Point(30,30);
		Point[] pointArray = new Point[3];
		
		pointArray[0] = p5;
		pointArray[1] = p7;
		pointArray[2] = p8;
		for(int i=0; i<pointArray.length; i++) {
			System.out.println(pointArray[i]);
		}
		
		Arrays.sort(pointArray);
		for(int i=0; i<pointArray.length; i++) {
			System.out.println(pointArray[i]);
		}
		
		//Vezbe 8 OOIT i URIS
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Point(10,10));
		System.out.println("**************************");
		shapes.add(0, new Point(20,20));
		shapes.add(new Point(30,30));
		shapes.remove(0);
		shapes.add(2, new Point(40,40));
		shapes.remove(1);
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		HashMap<String, Shape> hashMap = new HashMap<String, Shape>();
		hashMap.put("Tacka 1", new Point(1,1));
		System.out.println();
		System.out.println(hashMap.get("Tacka 1"));
		hashMap.put("Tacka 1", new Point(2,2)); //overwrite, u hash mapi su vrednosti jedinstvenog kljuca
		System.out.println(hashMap.get("Tacka 1"));
		hashMap.remove("Tacka 1");
		hashMap.put("Tacka 1", new Point(3,3));
		for(Shape s: hashMap.values()) {
			System.out.println(s.toString());
		}
	}

}
