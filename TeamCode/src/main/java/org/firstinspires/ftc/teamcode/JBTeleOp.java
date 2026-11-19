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
        if (gamepad1.right_bumper){
            drive.fieldCentricDrive(-gamepad1.left_stick_y* 0.3, gamepad1.left_stick_x * 0.3, greenthinglight.txValue()* 0.03);
        }

        else {
            drive.fieldCentricDrive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
        }



        if (gamepad1.back) {
            drive.zeroGyro();
        }

        if (gamepad2.left_bumper) {
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
         if (gamepad2.right_bumper) {
            //Shooter.startShooter(0.45);
            Shooter.setShooterVelocity(1250);
        }else{
            Shooter.stopShooter();
        }

    }
}

