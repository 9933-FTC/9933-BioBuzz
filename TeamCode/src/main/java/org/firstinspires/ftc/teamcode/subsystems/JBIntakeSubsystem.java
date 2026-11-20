package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class JBIntakeSubsystem {
    DcMotor Intake;



    public JBIntakeSubsystem(HardwareMap hardwareMap){
        Intake=hardwareMap.get(DcMotor.class,"Intake");

    }
    public void startIntake (){
        Intake.setPower(-0.8);


    }
    public void stopIntake (){
        Intake.setPower(0);


    }
public void lessIntake (){
        Intake.setPower(-0.5);

}
public void OutTake(){
        Intake.setPower(0.8);
    }
}
