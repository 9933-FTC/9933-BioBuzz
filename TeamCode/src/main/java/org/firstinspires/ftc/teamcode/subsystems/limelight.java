package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class limelight {
    Telemetry telemetry;
    private Limelight3A lemonlight;
    LLResult result;
     public limelight (Telemetry telemetry, HardwareMap hardwareMap){
         this.telemetry = telemetry;
         lemonlight = hardwareMap.get(Limelight3A.class, "limelight");
         lemonlight.pipelineSwitch(0);
         lemonlight.start();
     }
     public double txValue(){
         result = lemonlight.getLatestResult();
      return result.getTx();
     }
     public void populateTelemetry(){
     telemetry.addData("txValue", txValue());
     }
}
