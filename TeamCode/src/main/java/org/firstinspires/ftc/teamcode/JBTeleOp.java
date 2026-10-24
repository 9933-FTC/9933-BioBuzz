package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp
public class JBTeleOp extends TurtleOpMode {

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void loop() {
        super.loop();
        drive.fieldCentricDrive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);


        if (gamepad1.back) {
            drive.zeroGyro();
        }

        if (gamepad1.left_bumper) {
            Intake.startIntake();
        } else {
            Intake.stopIntake();
        }
        if (gamepad1.dpad_up) {
            Delivery.startDelivery();
        } else if (gamepad1.dpad_down) {
            Delivery.reverseDelivery();
        } else {
            Delivery.stopDelivery();
        }
        telemetry.addData("Clean Up", gamepad1.a);
        if (gamepad1.a) {
            telemetry.addLine("Clean Up");
            Shooter.startShooter(0.5);
        } else if (gamepad1.b) {
            Shooter.startShooter(0.35);
        } else if (gamepad1.right_bumper) {
            Shooter.startShooter(0.45);
        }else{
            Shooter.stopShooter();
        }

    }
}

