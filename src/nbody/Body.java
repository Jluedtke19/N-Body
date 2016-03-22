package nbody;

import edu.princeton.cs.StdDraw;
import java.awt.Color;
import java.io.*;
import javax.sound.sampled.*;

/**
 * ****************************************************************************
 * This class determines the position, velocity, mass, and other aspects of the
 * planets in the simulation.
 *
 *
 *****************************************************************************
 */
public class Body {

    private Vector r;      // position
    private Vector v;      // velocity
    private final double mass;   // mass

    public Body(Vector r, Vector v, double mass) {
        this.r = r;
        this.v = v;
        this.mass = mass;
    } // Body( Vector, Vector, double )

    public void play(File file) {
        try {
            File;
            AudioInputStream stream;
            AudioFormat format;
            DataLine.Info info;
            Clip clip;

            stream = AudioSystem.getAudioInputStream();
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
        } catch (Exception e) {
            //whatevers
        }
    }

    public void bounce(double scale) {
        double xpos = r.cartesian(0);
        double ypos = r.cartesian(1);
        if (xpos >= scale) {
            v.xswitch();
        }
        if (ypos >= scale) {
            v.yswitch();
        }
        if (xpos <= -scale) {
            v.xswitch();
        }
        if (ypos <= -scale) {
            v.yswitch();
        }
    }

    public void move(Vector f, double dt) {
        Vector a = f.times(1 / mass);
        v = v.plus(a.times(dt));
        r = r.plus(v.times(dt));
    } // move( Vector, double )

    public Vector forceFrom(Body b) {
        Body a = this;
        double G = 6.67e-11;
        Vector delta = b.r.minus(a.r);
        double dist = delta.magnitude();
        double F = (G * a.mass * b.mass) / (dist * dist);
        return delta.direction().times(F);
    } // forceFrom( Body )

    public void draw() {
        StdDraw.setPenRadius(mass / 6.0e29);
        StdDraw.setPenColor(Color.RED);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
    } // draw()

    // this method is only needed if you want to change the size of the bodies
    public void draw(double penRadius) {
        StdDraw.setPenRadius(penRadius);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
    } // draw( double )

} // Body
