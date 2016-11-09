package arb;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public  class ABR extends java.lang.Object{
	
	
	
	public class Point{
		int filsg;
		int filsd;
		int pos;
		
		Point(int pos){
			this.pos=pos;
		}
		
		 Point(int pos,int filsg,int filsd){
			 this.pos=pos;
			 this.filsg=filsg;
			 this.filsd=filsd;
		 }
	}
	public ArrayList<Point> v;
	
	/*
	* Constructs an empty ABR
	*/
	public void ABR(ArrayList<Point> points){
		this.v=points;
		buildTree(points);
	}
	
	private Point buildTree(ArrayList<Point> points){
		Collections.sort(points,new Comparator<Point>() {
				@Override
				public int compare(Point p1, Point p2) {
					return p1.pos - p2.pos;
				}
		});
		  Point b1=buildTree((ArrayList)points.subList(0, (points.size()/2)-1));
		  Point b2=buildTree((ArrayList)points.subList((points.size()/2)+1,points.size()-1));
		  return new Point((points.get(points.size()/2)).pos,b1.pos,b2.pos);
	}

	
	 /*
	 * Returns true if this ABR contains no elements
	 */
	public boolean isEmpty(){
		return(v.size()==0);
	}
	
	
	/*
	* Adds the specified element to this ABR if it is not already present
	*/
	public void insert(int value){
		
		Point p= new Point(value);
		v.add(p);
		ABR(v);
		
	}
	
	/*
	* Returns the number of element in this ABR
	*/
	public int nbElements(){
		return(v.size());
		
	}
	
	
	/*
	*Returns true if this ABR contains the specified element
	*/
	public boolean contains(int value){
		boolean test=false;
		int i=0;
		while((test==false) && (i<v.size()) ){
			test=((value)==(v.get(i).pos));
			i=i+1;
		}
		return(test);
	}
	
	
	/*
	*Fill a list with the elements in this ABR in ascending order.
	*/
	public void toList(java.util.List<java.lang.Integer> l){
		Collections.sort(v,new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				return p1.pos - p2.pos;
			}
	});
		for(Point e:v){
			l.add(e.pos);
		}
	}

}
