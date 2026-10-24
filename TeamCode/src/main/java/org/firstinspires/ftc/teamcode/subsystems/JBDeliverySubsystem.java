package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class JBDeliverySubsystem {


    private CRServo DeliveryServo;

    public JBDeliverySubsystem(HardwareMap hardwareMap){
        DeliveryServo = hardwareMap.get(CRServo.class, "Feeder");
    }

    public void startDelivery () {
        DeliveryServo.setPower(-1);
    }
    public void reverseDelivery () {
        DeliveryServo.setPower(1);
    }

    public void stopDelivery () {
        DeliveryServo.setPower(0);
    }
}