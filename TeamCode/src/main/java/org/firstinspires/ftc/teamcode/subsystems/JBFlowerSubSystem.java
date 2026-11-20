package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class JBFlowerSubSystem {


    private Servo Flowery;

    public JBFlowerSubSystem(HardwareMap hardwareMap){
        Flowery = hardwareMap.get(Servo.class, "FlowerServo");
    }

    public void startFlower () {
        Flowery.setPosition(1);
    }
    public void reverseFLower () {
        Flowery.setPosition(0.5);
    }
}
