package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class JBShooterSubsystem {
    DcMotorEx Shooter;
    Telemetry telemetry;



    public JBShooterSubsystem(HardwareMap hardwareMap, Telemetry telemetry){
        Shooter=hardwareMap.get(DcMotorEx.class,"Shooter");
        Shooter.setDirection(DcMotorSimple.Direction.REVERSE);
        this.telemetry = telemetry;
    }

    public void populateTelemetry() {
        telemetry.addData("Current Shoot Velo", getShootVelo());
    }

    public double getShootVelo() {
        return Shooter.getVelocity();
    }
    public void startShooter (double power){
        Shooter.setPower(power);


    }
    public void stopShooter (){
        Shooter.setPower(0);


    }

    public void setShooterVelocity(double speed) {
        Shooter.setVelocity(speed);
    }



}

