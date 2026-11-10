package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class RightRedBlueAuto extends TurtleOpMode {
    int step = 0;

@Override
public void init(){
    super.init();
}
@Override
public void loop(){
    super.loop();
    telemetry.addLine("step:"+step);

    /*

    Step 0 = Start auto
        0 = Zero Gyro
    Step 100 = Shoot preloads
        100 - Start Shooter
        110 - Wait 1.5 Seconds
        120 - Start Delivery
        130 - Wait 3 Seconds
        140 - Stop All Systems
    Step 200 = Move to park


    */

    if (step == 0) {
        drive.zeroGyro();
        step = 100;

    } else if (step == 100) {
        Shooter.setShooterVelocity(1265);
        timer.reset();
        step = 110;

    } else if (step == 110) {
        if (timer.seconds() >= 1.5) {
            step = 120;
        }

    } else if (step == 120) {
        Delivery.startDelivery();
        timer.reset();
        step = 130;

    } else if (step == 130) {
        if (timer.seconds() >= 3) {
            step = 140;
        }

    } else if (step == 140) {
        Shooter.stopShooter();
        Delivery.stopDelivery();
        step = 200;

    } else if (step == 200) {
        drive.autoMove(0, 0, 0);
        if (drive.isRobotAtTarget()) {
            timer.reset();
            step = 210;
        }
    } else if (step == 210) {
        // This is called a dwell timer, used to make sure systems stop and inputs updated before moving onto the next move
        if (timer.seconds() >= 0.5) {
            step = 300;
        }
    }
}

}
