package arb;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public  class ABR {
	
	
	
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

	
	 
	public boolean isEmpty(){
		return(v.size()==0);
	}
	
	public void insert(int value){
		
		Point p= new Point(value);
		v.add(p);
		ABR(v);
		
	}
	
	public int nbElements(){
		return(v.size());
		
	}
	
	public boolean contains(int value){
		boolean test=false;
		int i=0;
		while((test==false) && (i<v.size()) ){
			test=((value)==(v.get(i).pos));
			i=i+1;
		}
		return(test);
	}
	
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
