package frc.robot.lib.tools;

import com.ctre.phoenix.sensors.CANCoder;

public class Coder extends CANCoder{
    public Coder(int deviceNumber) {
        super(deviceNumber);
    }

    public void zero(){
        this.setPosition(0);
    }
    
}
