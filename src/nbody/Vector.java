package nbody;

/******************************************************************************
 *  The vector class is the part of the package that creates the position of the 
 * planets and has tests in it to make sure everything is working well.
 ******************************************************************************/

public class Vector { 

    private final int N;         // length of the vector
    private final double[] data;       // array of vector's components

/**
 * Creates a vector of length n.
 * @param N Length of the vector
 */
    // create the zero vector of length N
    public Vector(int N) {
        this.N = N;
        this.data = new double[N];
    } // Vector( int )
/**
 * Creates the vector from an array
 * @param data Array data
 */
    // create a vector from an array
    public Vector(double[] data) {
        N = data.length;

        // defensive copy so that client can't alter our copy of data[]
        this.data = new double[N];
        for (int i = 0; i < N; i++) {
            this.data[i] = data[i];
        } // for
    } // Vector( double [] )

    // create a vector from either an array or a vararg list
    // this constructor uses Java's vararg syntax to support
    // a constructor that takes a variable number of arguments, such as
    // Vector x = new Vector(1.0, 2.0, 3.0, 4.0);
    // Vector y = new Vector(5.0, 2.0, 4.0, 1.0);
/*
    public Vector(double... data) {
        N = data.length;

        // defensive copy so that client can't alter our copy of data[]
        this.data = new double[N];
        for (int i = 0; i < N; i++)
            this.data[i] = data[i];
    }
*/

/**
 * Returns the length of the vector.
 * @return Returns length N.
 */
    // return the length of the vector
    public int length() {
        return N;
    } // length()
/**
 * Makes sure the vector is correct and returns the product of Vector a and b.
 * @param that Calls on the vector being worked with
 * @return Returns the sum
 */
    // return the inner product of this Vector a and b
    public double dot(Vector that) {
        if (this.N != that.N) {
            throw new RuntimeException("Dimensions don't agree");
        } // if
        
        double sum = 0.0;
        for (int i = 0; i < N; i++)
            sum = sum + (this.data[i] * that.data[i]);
        return sum;
    } // dot( Vector )
/**
 * Returns the Euclidean norm of the Vector
 * @return The Euclidean norm
 */
    // return the Euclidean norm of this Vector
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    } // magnitude()
/**
 * Function used to change the planets x position
 */
    public void xswitch(){
        data[0] = data[0] * -.95;
    }
/**
 * Function used to change the planets y position
 */
    public void yswitch(){
        data[1] = data[1] * -.95;
    }
/**
 * Returns the distance between the the compared arrays
 * @param that The vector being worked on.
 * @return The Euclidean distance
 */
// return the Euclidean distance between this and that
    public double distanceTo(Vector that) {
        if (this.N != that.N) {
            throw new RuntimeException("Dimensions don't agree");
        } // if
        
        return this.minus(that).magnitude();
    } // distanceTo( Vector )

/**
 * Returns the original array and the one worked on.
 * @param that The vector worked on
 * @return The sum of both arrays
 */
    // return this + that
    public Vector plus(Vector that) {
        if (this.N != that.N) {
            throw new RuntimeException("Dimensions don't agree");
        } // if
        
        Vector c = new Vector(N);
        for (int i = 0; i < N; i++)
            c.data[i] = this.data[i] + that.data[i];
        return c;
    } // plus( Vector )
/**
 * Returns the difference between the arrays.
 * @param that Array worked on.
 * @return Difference between the arrays.
 */
    // return this - that
    public Vector minus(Vector that) {
        if (this.N != that.N) {
            throw new RuntimeException("Dimensions don't agree");
        } // if
        
        Vector c = new Vector(N);
        for (int i = 0; i < N; i++)
            c.data[i] = this.data[i] - that.data[i];
        return c;
    } // minus( Vector )
/**
 * Gives the coordinate of a body
 * @param i Number used to index the array list
 * @return Returns the where the planet is
 */
    // return the corresponding coordinate
    public double cartesian(int i) {
        return data[i];
    } // cartesian( int )
/**
 * Creates and returns a new object whose value is this * factor
 * @param factor A variable to multiply this by
 * @return The product
 */
    // create and return a new object whose value is (this * factor)
    public Vector times(double factor) {
        Vector c = new Vector(N);
        for (int i = 0; i < N; i++)
            c.data[i] = factor * data[i];
        return c;
    } // times( double )

/**
 * Returns the corresponding unit vector
 * @return Unit vector
 */
    // return the corresponding unit vector
    public Vector direction() {
        if (this.magnitude() == 0.0) {
            throw new RuntimeException("Zero-vector has no direction");
        } // if
        
        return this.times(1.0 / this.magnitude());
    } // direction()
/**
 * String representation of a vector
 * @return Returns the representation of a vector
 */
    // return a string representation of the vector
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("(");
        for (int i = 0; i < N; i++) {
            s.append(data[i]);
            if (i < N-1) s.append(", ");
        } // for
        s.append(")");
        return s.toString();
    } // toString()

/**
 * Test to see if the functions defined work
 * @param args No arguments
 */
    // test client
    public static void main(String[] args) {
        double[] xdata = { 1.0, 2.0, 3.0, 4.0 };
        double[] ydata = { 5.0, 2.0, 4.0, 1.0 };

        Vector x = new Vector(xdata);
        Vector y = new Vector(ydata);

        System.out.println("x        =  " + x);
        System.out.println("y        =  " + y);
        System.out.println("x + y    =  " + x.plus(y));
        System.out.println("10x      =  " + x.times(10.0));
        System.out.println("|x|      =  " + x.magnitude());
        System.out.println("<x, y>   =  " + x.dot(y));
        System.out.println("|x - y|  =  " + x.minus(y).magnitude());
    } // main( String [] )
} // Vector
