package sample;

import static java.lang.Math.round;

/**
 * Created by 1153 on 3/28/2017.
 */
public class AllianceData {
    int robot1;
    int robot2;
    int robot3;
    int allianceNumber;

    // these numbers are combined averages for the alliance
    double avgAutoScale;
    double avgAutoSwitch;
    double avgTeleScale;
    double avgTeleSwitch;
    double avgVault;
    double avgClimbs;
    double totalSwitch;
    double totalScale;

    // strength of alliance
    double allianceLowStrength;
    double allianceRawStrength;
    double allianceHighStrength;

    // given the 5 factors, calculate a strength number
    public void calcStrength() {
        double lowStrength = 0.0;
        double highStrength = 0.0;
        double rawStrength = 0.0;

        int climbPoints = (int)(avgClimbs) * 30;
        lowStrength += climbPoints;

        climbPoints = (int) (round (avgClimbs)) *30;
        highStrength += climbPoints;

        climbPoints = (int) (avgClimbs*30);
        rawStrength += climbPoints;

        double switchPoints = (int) ((avgAutoSwitch) * 2) + (avgTeleSwitch);
        lowStrength += switchPoints;

        switchPoints = (int) (( round (avgAutoSwitch)) * 2) + (avgTeleSwitch);
        highStrength += switchPoints;

        switchPoints = (int) (avgAutoSwitch*2) + (avgTeleSwitch);
        rawStrength += switchPoints;

        double scalePoints = (int) ((avgAutoScale) * 2) + (avgTeleScale);
        lowStrength += scalePoints;

        scalePoints = (int) (( round (avgAutoScale)) * 2) + (avgTeleScale);
        highStrength += scalePoints;

        scalePoints = (int) (avgAutoScale*2) + (avgTeleScale);
        rawStrength += scalePoints;

        int vaultPoints = (int)(avgVault) * 5;
        lowStrength += vaultPoints;

        vaultPoints = (int) (round (avgVault)) *5;
        highStrength += vaultPoints;

        vaultPoints = (int) (avgVault*5);
        rawStrength += vaultPoints;

        allianceLowStrength = lowStrength;
        allianceHighStrength = highStrength;
        allianceRawStrength = rawStrength;
    }
}
