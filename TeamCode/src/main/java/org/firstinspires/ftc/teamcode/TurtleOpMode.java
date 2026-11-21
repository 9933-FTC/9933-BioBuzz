package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.JBDeliverySubsystem;
import org.firstinspires.ftc.teamcode.subsystems.JBFlowerSubSystem;
import org.firstinspires.ftc.teamcode.subsystems.JBIntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.JBShooterSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.LimeLightSubSystem;


public class TurtleOpMode extends OpMode {

    DriveSubsystem drive;
    JBIntakeSubsystem Intake;
    JBShooterSubsystem Shooter;
    JBDeliverySubsystem Delivery;
    LimeLightSubSystem LemonLight;
   JBFlowerSubSystem  Flowery;
    ElapsedTime timer = new ElapsedTime();

    @Override
    public void init() {
        drive = new DriveSubsystem(telemetry, hardwareMap);
        Intake = new JBIntakeSubsystem(hardwareMap);
        Shooter = new JBShooterSubsystem(hardwareMap, telemetry);
        Delivery = new JBDeliverySubsystem(hardwareMap);
        Flowery = new JBFlowerSubSystem(hardwareMap);
        LemonLight = new LimeLightSubSystem(telemetry, hardwareMap);
    }

    @Override
    public void loop() {
        Shooter.populateTelemetry();
        drive.populateTelemetry();
        LemonLight.populateTelemetry();
    }

}
