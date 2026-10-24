package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class JBShooterSubsystem {
    DcMotor Shooter;



    public JBShooterSubsystem(HardwareMap hardwareMap){
        Shooter=hardwareMap.get(DcMotor.class,"Shooter");
        Shooter.setDirection(DcMotorSimple.Direction.REVERSE);

    }
    public void startShooter (double power){
        Shooter.setPower(power);


    }
    public void stopShooter (){
        Shooter.setPower(0);


    }


}

