package nbody;

import edu.princeton.cs.StdDraw;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;
import javax.sound.sampled.*;

/**
 * This class determines the position, velocity, mass, and other aspects of the
 * planets in the simulation.
 *
 *
 */
public class Body {

    private Vector r;      // position
    private Vector v;      // velocity
    private final double mass;   // mass
    private Color color;   // color
    private ArrayList<double[]> trail = new ArrayList<double[]>();  //Array for planet trail
    private double radius;       //radius of planets
    
/**
 * Creates local variables to use and change
 * @param r position of the planet 
 * @param v velocity of planet
 * @param mass mass of the radius
 * @param c color in RGB
 */
    public Body(Vector r, Vector v, double mass, int[] c) {
        this.r = r;
        this.v = v;
        this.mass = mass;
        this.color = new Color(c[0], c[1], c[2]);
    } // Body( Vector, Vector, double )

/**
 * This function gets the coordinates of the planets and sees if they are beyond 
 * the confines of the Universe, if they are functions in the vector class 
 * change their position so they go the other way. Also if they go beyond a 
 * sound is played.
 * @param scale uses the argument of the radius of the universe
 */
    public void bounce(double scale) {
        double xpos = r.cartesian(0);
        double ypos = r.cartesian(1);
        if (xpos >= scale) {
            v.xswitch();
            Universe.playSound("clack.wav");
        }
        if (ypos >= scale) {
            v.yswitch();
            Universe.playSound("clap.wav");
        }
        if (xpos <= -scale) {
            v.xswitch();
            Universe.playSound("clack.wav");
        }
        if (ypos <= -scale) {
            v.yswitch();
            Universe.playSound("pew.wav");
        }
    }
/**
 * Moves the planet by computing its velocity, mass, and radius.
 * @param f The vector f
 * @param dt the speed of the universe
 */
    public void move(Vector f, double dt) {
        Vector a = f.times(1 / mass);
        v = v.plus(a.times(dt));
        r = r.plus(v.times(dt));
        this.tail(r);
    } // move( Vector, double )
    
/**
 * Puts the coordinates of the planet in a list used to draw the tail
 * @param r The position of the planet 
 */
    // Making a tail
    public void tail(Vector r){
        double[] tail  = {r.cartesian(0), r.cartesian(1)};
        trail.add(0,tail);
        if(trail.size() > 50){
            trail.remove(trail.size() - 1);
        }
    }

/**
 * Takes the radius of the planets and draws a tail behind the planet using this
 * radius. It makes it smaller as it goes.
 */
    //Drawing tail
    public void drawnTail(){
       double trad = radius;
       for(int i = 0; i < trail.size() - 1; i ++){
           trad = trad * 0.9;
           double fir[] = trail.get(i);
           double sec[] = trail.get(i +1);
           StdDraw.setPenRadius(trad);
           StdDraw.line(fir[0], fir[1], sec[0], sec[1]);
       }
    }
/**
 * Figures out which way the planets go when they get close
 * @param b The planet it's interacting with.
 * @return Where it goes
 */
    public Vector forceFrom(Body b) {
        Body a = this;
        double G = 6.67e-11;
        Vector delta = b.r.minus(a.r);
        double dist = delta.magnitude();
        double F = (G * a.mass * b.mass) / (dist * dist);
        return delta.direction().times(F);
    } // forceFrom( Body )
/**
 * Draws the planets and draws tail
 */  
    public void draw() {
        this.radius = (mass/6.0e29);
        StdDraw.setPenRadius(radius);
        StdDraw.setPenColor(this.color);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
        this.drawnTail();
    } // draw()
/**
 * Only for changing the size of bodies 
 * @param penRadius The radius wanted
 */
    // this method is only needed if you want to change the size of the bodies
    public void draw(double penRadius) {
        StdDraw.setPenRadius(penRadius);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
    } // draw( double )
    
    public Vector getPosition(){
        return r;
    }

} // Body