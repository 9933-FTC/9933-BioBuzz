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

    Thousands Place = Major Step
    Tens Place = Minor Step
    Ones Place = Frantic Debug (At Comp Fixes, should be changed before the next event)

    Step 0000 = Start auto
        0000 = Zero Gyro
    Step 1000 = Shoot preloads
        1010 - Start Shooter
        1020 - Wait 1.5 Seconds
        1030 - Start Delivery
        1040 - Wait 3 Seconds
        1050 - Stop All Systems
    Step 2000 = Move to park


    */

    if (step == 0000) {
        drive.zeroGyro();
        step = 1010;

    } else if (step == 1010) {
        Shooter.setShooterVelocity(1265);
        timer.reset();
        step = 1020;

    } else if (step == 1020) {
        if (timer.seconds() >= 1.5) {
            step = 1030;
        }

    } else if (step == 1030) {
        Delivery.startDelivery();
        timer.reset();
        step = 1040;

    } else if (step == 1040) {
        if (timer.seconds() >= 3) {
            step = 1040;
        }

    } else if (step == 1050) {
        Shooter.stopShooter();
        Delivery.stopDelivery();
        step = 2010;

    } else if (step == 2010) {
        drive.autoMove(0, 0, 0);
        if (drive.isRobotAtTarget()) {
            timer.reset();
            step = 2020;
        }
    } else if (step == 2020) {
        // This is called a dwell timer, used to make sure systems stop and inputs updated before moving onto the next move
        if (timer.seconds() >= 0.5) {
            step = 3000;
        }
    }
}

}
