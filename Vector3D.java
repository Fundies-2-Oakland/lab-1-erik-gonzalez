public class Vector3D {
    double x;
    double y;
    double z;

    public Vector3D(double X, double Y, double Z){
        this.x = X;
        this.y = Y;
        this.z = Z;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getZ(){
        return z;
    }

    public String toString(){
        String newX = String.format("%.2f", getX());
        String newY = String.format("%.2f", getY());
        String newZ = String.format("%.2f", getZ());
        return "(" + newX + " " + newY + " " + newZ + ")";
    }

    public double magnitude(){
        double mag = Math.sqrt((Math.pow(getX(), 2) + Math.pow(getY(), 2) + Math.pow(getZ(), 2)));
        return mag;
    }

    public Vector3D normalize(){
        double mag = magnitude();
        if(mag == 0){
            return null;
        }
        Vector3D newVect = new Vector3D((getX()/mag), (getY()/mag), (getZ()/mag));
        return newVect;

    }

    public Vector3D add(Vector3D vect1){
        double newX = this.getX() + vect1.getX();
        double newY = this.getY() + vect1.getY();
        double newZ = this.getZ() + vect1.getZ();
        Vector3D newVect = new Vector3D(newX, newY, newZ);

        return newVect;
    }

    public Vector3D multiply(double constant){
        double newX = this.getX() * constant;
        double newY = this.getY() * constant;
        double newZ = this.getZ() * constant;
        Vector3D newVect = new Vector3D(newX, newY, newZ);

        return newVect;
    }

    public double dotProduct(Vector3D vect1){
        double newX = this.getX() * vect1.getX();
        double newY = this.getY() * vect1.getY();
        double newZ = this.getZ() * vect1.getZ();
        double endProduct = newX + newY + newZ;

        return endProduct;
    }

    public double angleBetween(Vector3D vect1, Vector3D vect2){
        double top = vect1.dotProduct(vect2);
        double bottom = Math.abs(vect1.dotProduct(vect2));
        double result = top/bottom;

        return result;
    }

    public Vector3D crossProduct(Vector3D vect1){
        double ux = (this.getY() * vect1.getZ()) - (this.getZ() * vect1.getY());
        double uy = (this.getZ() * vect1.getX()) - (this.getX() * vect1.getZ());
        double uz = (this.getX() * vect1.getY()) - (this.getY() * vect1.getX());
        Vector3D product = new Vector3D(ux, uy, uz);

        return product;
    }

    public static void main(String[] args){
        Vector3D newVect = new Vector3D(12, 14, 33);
        Vector3D newVect1 = new Vector3D(10, 20, 13);
        System.out.println(newVect.toString());
        System.out.println(newVect.dotProduct(newVect1));
        System.out.println(newVect.multiply(3).toString());


    }
}
