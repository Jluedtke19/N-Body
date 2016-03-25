
package nbody;

import org.junit.Test;
import static org.junit.Assert.*;

public class BodyTest {
    
    public BodyTest() {
    }

//    @Test
//    public void testBounce() {
//        double scale = 0.0;
//        Body instance = null;
//        instance.bounce(scale);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of move method, of class Body.
     */
    @Test
    public void testMove() {
        Vector f = new Vector(new double[]{5,0});
        double dt = 1.0;
        Body instance = new Body(
            new Vector(new double[]{0.0,0.0}),
            new Vector(new double[]{0.0,0.0}),
            0.02,
            new int[]{255,150,250});
        instance.move(f, dt);
        Vector expResult = new Vector(new double[]{250.0, 0});
        Vector result = instance.getPosition();
        assertEquals(result.cartesian(0), expResult.cartesian(0), 0.0000001);
        assertEquals(result.cartesian(1), expResult.cartesian(1), 0.0000001);
    }
//
//    /**
//     * Test of tail method, of class Body.
//     */
//    @Test
//    public void testTail() {
//        System.out.println("tail");
//        Vector r = null;
//        Body instance = null;
//        instance.tail(r);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of drawnTail method, of class Body.
//     */
//    @Test
//    public void testDrawnTail() {
//        System.out.println("drawnTail");
//        Body instance = null;
//        instance.drawnTail();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of forceFrom method, of class Body.
//     */
//    @Test
//    public void testForceFrom() {
//        System.out.println("forceFrom");
//        Body b = null;
//        Body instance = null;
//        Vector expResult = null;
//        Vector result = instance.forceFrom(b);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of draw method, of class Body.
//     */
//    @Test
//    public void testDraw_0args() {
//        System.out.println("draw");
//        Body instance = null;
//        instance.draw();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of draw method, of class Body.
//     */
//    @Test
//    public void testDraw_double() {
//        System.out.println("draw");
//        double penRadius = 0.0;
//        Body instance = null;
//        instance.draw(penRadius);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
