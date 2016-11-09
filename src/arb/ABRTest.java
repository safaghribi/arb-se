package arb;
import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
public class ABRTest {

	@Test
	public void testIsEmpty() {
		ArrayList v= new ArrayList();
		ABR tree= new ABR(v);
		assertTrue(tree.isEmpty());
	}




@Test
public void testNbElements() {
	ArrayList v= new ArrayList();
	Point p=new Point(5);
	v.add(p);
	ABR tree= new ABR(v);
	assertEquals(tree.nbElements(),1);
}


@Test
public void testContains() {
	ArrayList v= new ArrayList();
	ABR tree= new ABR(v);
	assertTrue(tree.isEmpty());
}


@Test
public void testToList() {
	ArrayList v= new ArrayList();
	Point p= new Point (5);
	ABR tree= new ABR(v);
	java.util.List<java.lang.Integer> l;
	ArrayList m= new ArrayList();
	m.add(5);
	tree.toList(l);
	assertEquals(l,m);
}


}