package org.firstinspires.ftc.teamcode.Auto;

import static android.os.SystemClock.sleep;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.TurtleOpMode;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.JBDeliverySubsystem;
import org.firstinspires.ftc.teamcode.subsystems.JBIntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.JBShooterSubsystem;

@Autonomous
public class RightRedBlueAuto extends TurtleOpMode {
    DriveSubsystem drive;
    JBIntakeSubsystem Intake;
    JBShooterSubsystem Shooter;
    JBDeliverySubsystem Delivery;
    int step = 0;

@Override
public void init(){
    drive = new DriveSubsystem(telemetry, hardwareMap);
    Intake = new JBIntakeSubsystem(hardwareMap);
    Shooter = new JBShooterSubsystem(hardwareMap);
    Delivery = new JBDeliverySubsystem(hardwareMap);
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
