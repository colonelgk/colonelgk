/**
* Lab 1: A class that tests Fraction.java
*
* @author	Christian Roos
* @version 	August 26th, 2019
*/
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;



public class FractionTest {
	
	Fraction f1;
	Fraction f2;
	Fraction f3;
	Fraction f4;
	Fraction f5;
	Fraction f6;
	Fraction f7;
	Fraction f8;
	Fraction f9;
	Fraction f10;
	Fraction f11;
	Fraction f12;
	Fraction f13;
	Fraction f14;
	Fraction f15;
	Fraction f16;
	Fraction f17;
	Fraction f18;
	Fraction f19;	
	Fraction f20;
	Fraction f21;
	Fraction f22;
	
	@Before
	public void setUp() {            // instantiates Fractions of various types p=positive n=negative 0=zero
		
	f1 =  new Fraction(1,2);         //p,p
	f2 =  new Fraction(6,-5);        //p,n
	f3 =  new Fraction(5,-7);        //p,n
	f4 =  new Fraction(-2,3);        //n,p
	f5 =  new Fraction(-7,-8);       //n,n
	f6 =  new Fraction(3,4);         //p,p
	f7 =  new Fraction(2,0);         // p,0
	f8 =  new Fraction(-8,0);        //n,0
	f9 =  new Fraction(0,9);         // 0,p
	f10 = new Fraction(0,-6);        //0,n
	f11 = new Fraction(-9,2);        //n,p
	f12 = new Fraction(-14,-21);     //n,n
	f13 = new Fraction(21,7);        //p,p
	f14 = new Fraction(8,0);         // p,0
	f15 = new Fraction(-14,0);       //n,0
	f16 = new Fraction(90,-60);      //p,n
	f17 = new Fraction(48,-84);      //p,n
	f18 = new Fraction(1,1);         //p,p 
	f19 = new Fraction(12,15);       //p,p
	f20 = new Fraction(25,35);       //p,p
	f21 = new Fraction(42,-49);	     //p,n
	f22 = new Fraction(5,4);         //p,n 
		
	}	
	@Rule 
	public ExpectedException error = ExpectedException.none();
	
	@Test(expected = ArithmeticException.class) 
	public void constructorExceptionTest() {
		Fraction attempt = new Fraction(10,5);			
		Assert.assertTrue(attempt instanceof Fraction);  
		int a = 5;
		int b = 0;
		int c =5/0; // check for error message expected
		error.expectMessage("What number is it?");
		throw new ArithmeticException("What number is it?");
	}	
	@Test // test the numerator getter method
	public void testGetNumerator() {
		Assert.assertEquals(1,f1.getNumerator());
		Assert.assertEquals(-2,f4.getNumerator());
		Assert.assertEquals(-8,f8.getNumerator());
		Assert.assertEquals(-14,f12.getNumerator());
		Assert.assertEquals(90,f16.getNumerator());
	}	
	@Test  // test the denominator getter method
	public void testGetDenominator() {
		Assert.assertEquals(-5,f2.getDenominator());
		Assert.assertEquals(4,f6.getDenominator());
		Assert.assertEquals(-6,f10.getDenominator());
		Assert.assertEquals(0,f14.getDenominator());
		Assert.assertEquals(1,f18.getDenominator());
	}	
	@Test // test the add method
	public void testAdd() {
		Fraction test11 = new Fraction(-1,6);
		Assert.assertEquals(test11.toString(),f1.add(f4).toString());
		Fraction test12 = new Fraction(7,8);
		Assert.assertEquals(test12.toString(),f5.add(f9).toString());
		Fraction test13 = new Fraction(-23,6);
		Assert.assertEquals(test13.toString(),f11.add(f12).toString());
		Fraction test14 = new Fraction(3,2);
		Assert.assertEquals(test14.toString(),f13.add(f16).toString());
		Fraction test15 = new Fraction(1,7);
		Assert.assertEquals(test15.toString(),f17.add(f20).toString());		
	}	
	@Test // test the subtract method
	public void testSubtract() {
		Fraction test16 =new Fraction(-11,7);
		Assert.assertEquals(test16.toString(),f21.subtract(f20).toString());
		Fraction test17 =new Fraction(-13,14);
		Assert.assertEquals(test17.toString(),f16.subtract(f17).toString());
		Fraction test18 =new Fraction(1,8);
		Assert.assertEquals(test18.toString(),f5.subtract(f6).toString());
		Fraction test19 =new Fraction(-33,10);
		Assert.assertEquals(test19.toString(),f11.subtract(f2).toString());
		Fraction test20 =new Fraction(-5,24);
		Assert.assertEquals(test20.toString(),f12.subtract(f5).toString());		
	}	
	@Test // test the multiply method
	public void testMultiply() { 
		String test1 = f1.multiply(f2).toString();
		Assert.assertEquals("(3/-5)",test1);
		String test2 = f12.multiply(f13).toString();
		Assert.assertEquals("(-2/-1)",test2);
		String test3 = f9.multiply(f16).toString();
		Assert.assertEquals("(0/-540)",test3);
		String test4 = f6.multiply(f18).toString();
		Assert.assertEquals("(3/4)",test4);
		String test5 = f2.multiply(f2).toString();
		Assert.assertEquals("(36/25)",test5);		
	}	
	@Test(expected = ArithmeticException.class)
	public void testDivisionByZero() {  // test the divide method in that it throws the appropriate error message
		Assert.assertEquals("not allowed",f6.divide(f8));		
		Assert.assertEquals("not allowed",f16.divide(f7));
		Assert.assertEquals("not allowed",f16.divide(f14));
		Assert.assertEquals("not allowed",f16.divide(f15));
	//	Assert.expectMessage("not allowed",f16.divide(f15).toString());
	}	
	@Test(expected = ArithmeticException.class)
	public void testDivide() {	// test the divide method
		Fraction test6 = new Fraction(-21,5);
		Assert.assertEquals(test6.toString(),f13.divide(f3).toString());
		Fraction test7 = new Fraction(-7,-6);
		Assert.assertEquals(test7.toString(),f5.divide(f6).toString());
		Fraction test8 = new Fraction(3,1);
		Assert.assertEquals(test8.toString(),f11.divide(f16).toString());
		Fraction test9 = new Fraction(-5,2);
		Assert.assertEquals(test9.toString(),f13.divide(f2).toString());
		Fraction test10 = new Fraction(-21,-8);
		Assert.assertEquals(test10.toString(),f16.divide(f17).toString());
		Assert.assertEquals("not allowed",f16.divide(f15));		
	}	
	@Test // test the toString method
	public void testToString() {
		Assert.assertEquals("(1/2)",f1.toString());
		Assert.assertEquals("(5/-7)",f3.toString());
		Assert.assertEquals("(3/4)",f6.toString());
		Assert.assertEquals("(0/9)",f9.toString());
		Assert.assertEquals("(-14/-21)",f12.toString());
	}	
	@Test // test the simplify method that each fraction is fully simplified
	public void testSimplify() {
		Assert.assertEquals("(-2/-3)",f12.simplify().toString());
		Assert.assertEquals("(3/-2)",f16.simplify().toString());
		Assert.assertEquals("(4/-7)",f17.simplify().toString());
		Assert.assertEquals("(1/1)",f18.simplify().toString());
		Assert.assertEquals("(4/5)",f19.simplify().toString());		
	}	
	@Test  // test for greatest common factor
	public void testGCF() {
		Assert.assertEquals(30,f16.gcf(f16.getNumerator(),f16.getDenominator()));
		Assert.assertEquals(12,f17.gcf(f17.getNumerator(),f17.getDenominator()));
		Assert.assertEquals(-7,f21.gcf(f21.getNumerator(),f21.getDenominator()));
		Assert.assertEquals(3,f19.gcf(f19.getNumerator(),f19.getDenominator()));
		Assert.assertEquals(5,f20.gcf(f20.getNumerator(),f20.getDenominator()));
		Assert.assertEquals(-1,f5.gcf(f5.getNumerator(),f5.getDenominator()));
	}
	@Test  // test for lowest common denominator
	public void testlcd() {
		Assert.assertEquals(2,f1.lcd(f1.getNumerator(),f1.getDenominator()));
		Assert.assertEquals(12,f6.lcd(f6.getNumerator(),f6.getDenominator()));
		Assert.assertEquals(42,f12.lcd(f12.getNumerator(),f12.getDenominator()));
		Assert.assertEquals(21,f13.lcd(f13.getNumerator(),f13.getDenominator()));
		Assert.assertEquals(180,f16.lcd(f16.getNumerator(),f16.getDenominator()));		
	}	
}//End class FractionTest.