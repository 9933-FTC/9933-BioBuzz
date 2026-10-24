package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.JBDeliverySubsystem;
import org.firstinspires.ftc.teamcode.subsystems.JBIntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.JBShooterSubsystem;


public class TurtleOpMode extends OpMode {

    DriveSubsystem drive;
JBIntakeSubsystem Intake;
JBShooterSubsystem Shooter;
JBDeliverySubsystem Delivery;
    @Override
    public void init() {
        drive = new DriveSubsystem(telemetry, hardwareMap);
    Intake = new JBIntakeSubsystem(hardwareMap);
    Shooter = new JBShooterSubsystem(hardwareMap);
    Delivery = new JBDeliverySubsystem(hardwareMap);
    }

    @Override
    public void loop() {
        drive.populateTelemetry();
    }

}
