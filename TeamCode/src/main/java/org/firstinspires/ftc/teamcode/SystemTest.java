package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Utility;

import org.firstinspires.ftc.teamcode.subsystems.JBShooterSubsystem;

@Utility
public class SystemTest extends TurtleOpMode {

    @Override
    public void init() {

        super.init();
    }

    @Override
    public void loop() {
        super.loop();

        telemetry.addLine("X = Front Left");
        if (gamepad1.x) {
            drive.setFrontLeftSpeed(0.2);
        } else {
            drive.setFrontLeftSpeed(0);
        }

        telemetry.addLine("Y = Front Right");
        if (gamepad1.y) {
            drive.setFrontRightSpeed(0.2);
        } else {
            drive.setFrontRightSpeed(0);
        }

        telemetry.addLine("A = Rear Left");
        if (gamepad1.a) {
            drive.setRearLeftSpeed(0.2);
        } else {
            drive.setRearLeftSpeed(0);
        }

        telemetry.addLine("B = Front Left");
        if (gamepad1.b) {
            drive.setRearRightSpeed(0.2);
        } else {
            drive.setRearRightSpeed(0);
        }
        telemetry.addLine("Left bumper = Intake");
          if (gamepad1.left_bumper) {
          Intake.startIntake();
          }else{
          Intake.stopIntake();
         }

        telemetry.addLine("Right bumper = Shooter");
        if (gamepad1.right_bumper) {
            Shooter.startShooter(0.45);
        }else{
            Shooter.stopShooter();
        }

        telemetry.addLine("Dpad_up = Feeder");
        if (gamepad1.dpad_up) {
            Delivery.startDelivery();
        }else{
            Delivery.stopDelivery();
        }

    }

}
