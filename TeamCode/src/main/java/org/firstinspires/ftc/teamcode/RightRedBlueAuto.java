package org.firstinspires.ftc.teamcode;

import static android.os.SystemClock.sleep;

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

    if (step == 0) {
        drive.zeroGyro();
        step = 10;
    } else if (step == 10) {
        Shooter.setShooterVelocity(1265);
        sleep(1500);
        Delivery.startDelivery();
        sleep(3000);
        step = 20;
    } else if (step == 20) {
        Shooter.stopShooter();
        Delivery.stopDelivery();
        step = 30;
    } else if (step == 30) {
        drive.autoMove(-1, -1, 180);
    }
}

}
