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
        drive.autoMove(0, 6, 0);
        if (drive.isRobotAtTarget()) {
            timer.reset();
            step = 1020;
        }
    } else if (step == 1020) {
        // This is called a dwell timer, used to make sure systems stop and inputs updated before moving onto the next move
        if (timer.seconds() >= 0.5) {
            step = 2010;
        }

    } else if (step == 2010) {
        Shooter.setShooterVelocity(1250);
        timer.reset();
        step = 2020;

    } else if (step == 2020) {
        if (timer.seconds() >= 5) {
            step = 2030;
        }

    } else if (step == 2030) {
        Delivery.startDelivery();
        timer.reset();
        step = 2040;

    } else if (step == 2040) {
        if (timer.seconds() >= 8) {
            step = 2050;
        }

    } else if (step == 2050) {
        Shooter.stopShooter();
        Delivery.stopDelivery();
        step = 3010;

    } else if (step == 3010) {
        drive.autoMove(-28, 0, 0);
        if (drive.isRobotAtTarget()) {
            timer.reset();
            step = 3020;
        }
    } else if (step == 3020) {
        // This is called a dwell timer, used to make sure systems stop and inputs updated before moving onto the next move
        if (timer.seconds() >= 0.5) {
            step = 3030;
        }
    } else if (step == 3030) {
        drive.autoMove(0, 80, 0);
        if (drive.isRobotAtTarget()) {
            timer.reset();
            step = 3040;
        }
    } else if (step == 3040) {
        // This is called a dwell timer, used to make sure systems stop and inputs updated before moving onto the next move
        if (timer.seconds() >= 0.5) {
            step = 3050;
        }
    } else if (step == 3050) {
        drive.autoMove(-10, 0, 0);
        if (drive.isRobotAtTarget()) {
            timer.reset();
            step = 3060;
        }
    } else if (step == 3060) {
        // This is called a dwell timer, used to make sure systems stop and inputs updated before moving onto the next move
        if (timer.seconds() >= 0.5) {
            step = 4000;
        }
    }
}

}
