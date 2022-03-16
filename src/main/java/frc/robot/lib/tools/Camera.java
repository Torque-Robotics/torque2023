package frc.robot.lib.tools;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


public class Camera
{
    private NetworkTable table;
    private NetworkTableEntry tx, ty, ta; //x and y angle offset, ta: area of the screen the target takes up
    private final double mountAngle[]; //Angle the camera is mounted at. DOUBLE CHECK THIS IS ACCURATE
    private final double mountPosition[];
    private final double horizontalFOV = 27;
    private final double verticalFOV = 20.5;
    /**
     * Intializes vision
     * @param mountAngle angle of the lens from straight forward
     * @param mountPosition position of the lens from middle of front
     */
    public Camera(double mountAngle[], double mountPosition[])
    {
        this.mountAngle = mountAngle;
        this.mountPosition = mountPosition;

        this.table = NetworkTableInstance.getDefault().getTable("limelight");
    }

    /**
     * update tx, ty, ta
     */
    public void update(){
        this.tx = table.getEntry("tx");
        this.ty = table.getEntry("ty");
        this.ta = table.getEntry("ta");
    }
    
    /**
     * changes modes between teleop and autonomous for camera
     * @param isDriving true - teleop, false - autonomous
     */
    public void setDriverMode(boolean isDriving)
    {
        if(isDriving)
        {
            this.table.getEntry("camMode").setNumber(1); // normal camera
            this.table.getEntry("ledMode").setNumber(1); // no limelight
        }
        else
        {
            this.table.getEntry("camMode").setNumber(0); // low exposure to only see reflection
            this.table.getEntry("ledMode").setNumber(3); // limelight
        }
    }

    /**
     * @return x and y (left-right and up-down) orientation relative to reflective tape
     */
    public double[] getOrient()
    {
        double orient[] = {this.tx.getDouble(0), this.ty.getDouble(0)};
        return orient;
    }

    /**
     * @param referenceY height of the reflective tape
     * @return horizontal distance to reflective tape
     */
    public double YGetZ(double referenceY)
    {
        double yDist = referenceY - mountPosition[1];
        double yOrient = getOrient()[1] + mountAngle[1];
        return (yDist / Math.tan(Math.toRadians(yOrient)));
        // opposite ÷ (opposite÷adjacent) = adjacent
    }

    /**
     * @param referenceX height of the reflective tape
     * @return horizontal distance to reflective tape
     */
    public double XGetZ(double referenceX)
    {
        double xDist = referenceX - mountPosition[0];
        double xOrient = getOrient()[0] + mountAngle[0];
        return (xDist / Math.tan(Math.toRadians(xOrient)));
        // opposite ÷ (opposite÷adjacent) = adjacent
    }

    /**
     * @param unit area of reflection from unit distance in percentage of image
     * @return number of units in distance
     */
    public double AGetZ(double unit)
    {
        double avgFOV = Math.sqrt(this.horizontalFOV*this.verticalFOV);
        double unitAngle = Math.sqrt(unit)*avgFOV;
        double reflAngle = Math.sqrt(this.ta.getDouble(0.0))*avgFOV;
        return Math.tan(unitAngle)/Math.tan(reflAngle);
    }
}