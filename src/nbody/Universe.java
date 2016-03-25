package nbody;

import edu.princeton.cs.In;
import edu.princeton.cs.StdDraw;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import sun.applet.Main;

/**
 * In this class the radius of the universe is set, the number of planets is
 * defined, the forces of the planets is made, and then the universe is
 * simulated.
 */
public class Universe {

    private final double radius;     // radius of universe
    private final int N;             // number of bodies
    private final Body[] orbs;       // array of N bodies
    
/**
 * Reads in a file to create the universe. Sets scale for the universe and reads
 * in the bodies
 * @param fileName 
 */
    // read universe from file
    public Universe(String fileName) {

        // the authors' version reads from standard input
        // our version reads from a file
        In inputStream = new In(fileName);

        // number of bodies
        N = inputStream.readInt();

        // the set scale for drawing on screen
        radius = inputStream.readDouble();
        StdDraw.setXscale(-radius, +radius);
        StdDraw.setYscale(-radius, +radius);

        // read in the N bodies
        orbs = new Body[N];
        for (int i = 0; i < N; i++) {
            double rx = inputStream.readDouble();
            double ry = inputStream.readDouble();
            double vx = inputStream.readDouble();
            double vy = inputStream.readDouble();
            double mass = inputStream.readDouble();
            int red = inputStream.readInt();
            int green = inputStream.readInt();
            int blue = inputStream.readInt();
            int c[] = {red, green, blue};
            double[] position = {rx, ry};
            double[] velocity = {vx, vy};
            Vector r = new Vector(position);
            Vector v = new Vector(velocity);
            orbs[i] = new Body(r, v, mass, c);
        } // for
    } // Universe()
/**
 * Loops a beat or song
 * @param url A Wav file stored in resources
 */
    public static void playCont(String url) {
    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(url).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    } catch(Exception ex) {
        System.out.println("Error with playing sound.");
        ex.printStackTrace();
    }
}
/**
 * Plays a sound once.
 * @param url Wav file
 */
  public static void playSound(String url) {
    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(url).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    } catch(Exception ex) {
        System.out.println("Error with playing sound.");
        ex.printStackTrace();
    }
}
  /**
   * Reads in the time the universe is played at, computes the forces,and moves
   * the bodies.
   * @param dt The speed of the universe.
   */
    // increment time by dt units, assume forces are constant in given interval
    public void increaseTime(double dt) {

        // initialize the forces to zero
        Vector[] f = new Vector[N];
        for (int i = 0; i < N; i++) {
            f[i] = new Vector(new double[2]);
        } // for

        // compute the forces
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    f[i] = f[i].plus(orbs[i].forceFrom(orbs[j]));
                } // if
            } // for
        } // for

        // move the bodies
        for (int i = 0; i < N; i++) {
            orbs[i].move(f[i], dt);
            orbs[i].bounce(radius);
        } // for
    } // increaseTime( double )
/**
 * Draws the planets for amount N.
 */
    // draw the N bodies
    public void draw() {
        for (int i = 0; i < N; i++) {
            orbs[i].draw();
        } // for
    } // draw()

    public void drawStar(){
        for (int i = 0; i < 50; i++){
            double x = Math.random() * this.radius ;
            double y = Math.random() * this.radius ;
            double r = .001 + Math.random() * .004;
            StdDraw.setPenRadius(r);
            StdDraw.setPenColor(Color.WHITE);
            StdDraw.point(x, y);
            StdDraw.point(-x, -y);
            StdDraw.point(-x, y);
            StdDraw.point(x, -y);  
        }
    }
/**
 * Executes functions needed to simulate the Universe
 * @param args The text files
 */
    // client to simulate a universe
    public static void main(String[] args) {
        Universe.playCont("techkich.wav");
        Universe newton = new Universe(args[1]);
        double dt = Double.parseDouble(args[0]);
        while (true) {
            StdDraw.clear(StdDraw.BLACK);
            newton.increaseTime(dt);
            newton.draw();
            newton.drawStar();
            StdDraw.show(10);
        } // while
    } // main( String [] )
} // Universe