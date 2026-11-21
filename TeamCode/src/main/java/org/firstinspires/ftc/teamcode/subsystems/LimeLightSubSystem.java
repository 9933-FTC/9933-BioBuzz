package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class LimeLightSubSystem {
    Telemetry telemetry;
    private Limelight3A LemonLight;
    LLResult result;

    public LimeLightSubSystem(Telemetry telemetry, HardwareMap hardwareMap) {
        this.telemetry = telemetry;
        LemonLight = hardwareMap.get(Limelight3A.class, "limelight");
    }

    public double txValue() {
        result = LemonLight.getLatestResult();
        return result.getTx();
    }

    public void populateTelemetry() {
        telemetry.addData("txValue", txValue());
    }

    public void SetAllianceColor(boolean IsRedAlliance) {
        if (IsRedAlliance) {
            LemonLight.pipelineSwitch(0);

        } else {
            LemonLight.pipelineSwitch(1);
        }

        LemonLight.start();


    }

}

