
package nbody;

import org.junit.Test;
import static org.junit.Assert.*;

public class VectorTest {
    
    public VectorTest() {
    }

    @Test
    public void testLength() {
        Vector instance = new Vector(5);
        int expResult = 5;
        int result = instance.length();
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of dot method, of class Vector.
//     */
//    @Test
//    public void testDot() {
//        System.out.println("dot");
//        Vector that = null;
//        Vector instance = null;
//        double expResult = 0.0;
//        double result = instance.dot(that);
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of magnitude method, of class Vector.
//     */
    @Test
    public void testMagnitude() {
        Vector instance = new Vector(new double[]{3});
        double expResult = 3.0;
        double result = instance.magnitude();
        assertEquals(expResult, result, 0.0);
    }
//
//    /**
//     * Test of xswitch method, of class Vector.
//     */
//    @Test
//    public void testXswitch() {
//        Vector instance = new Vector(new double[]{20});
//        Vector expResult = new Vector(new double[]{-19});
//        instance.xswitch();
//    }
//
//    /**
//     * Test of yswitch method, of class Vector.
//     */
//    @Test
//    public void testYswitch() {
//        System.out.println("yswitch");
//        Vector instance = null;
//        instance.yswitch();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of distanceTo method, of class Vector.
//     */
    @Test
    public void testDistanceTo() {
        Vector that = new Vector(new double[] {3,4});
        Vector instance = new Vector(new double[]{3,4});
        double expResult = 0.0;
        double result = instance.distanceTo(that);
        assertEquals(expResult, result, 0.0);
    }
//
    /**
     * Test of plus method, of class Vector.
     */
//    @Test
//    public void testPlus() {
//        Vector that = new Vector(new double[]{10.0, 5});
//        Vector instance = new Vector(new double[]{8.0, 8});
//        Vector expResult = new Vector(new double[]{18.0, 13});
//        Vector result = instance.plus(that);
//        assertEquals(expResult, result);
//    }

//    /**
//     * Test of minus method, of class Vector.
//     */
//    @Test
//    public void testMinus() {
//        Vector that = new Vector(new double[]{6});
//        Vector instance = new Vector(new double[]{3});
//        Vector expResult = new Vector(new double[]{-3});
//        Vector result = instance.minus(that);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of cartesian method, of class Vector.
//     */
    @Test
    public void testCartesian() {
        int i = 0;
        Vector instance = null;
        double expResult = 0.0;
        double result = instance.cartesian(i);
        assertEquals(expResult, result, 0.0);
    }
//
//    /**
//     * Test of times method, of class Vector.
//     */
//    @Test
//    public void testTimes() {
//        System.out.println("times");
//        double factor = 0.0;
//        Vector instance = null;
//        Vector expResult = null;
//        Vector result = instance.times(factor);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of direction method, of class Vector.
//     */
//    @Test
//    public void testDirection() {
//        System.out.println("direction");
//        Vector instance = null;
//        Vector expResult = null;
//        Vector result = instance.direction();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toString method, of class Vector.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Vector instance = null;
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of main method, of class Vector.
//     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        Vector.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
