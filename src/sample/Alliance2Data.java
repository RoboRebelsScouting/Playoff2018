package sample;

/**
 * Created by 1153 on 4/2/2017.
 */
public class Alliance2Data {
    int robot1A2;
    int robot2A2;
    int robot3A2;

    // these numbers are combined averages for the alliance
    double avgAutoFuel2;
    double avgAutoGear2;
    double avgTeleFuel2;
    double avgTeleGear2;
    double avgTeleClimb2;

    // strength of alliance
    double alliance2Strength;

    // given the 5 factors, calculate a strength number
    public void calcStrength2() {
        double strength = 0.0;

        double totalGears2 = avgAutoGear2 + avgTeleGear2;
        int rotors = 0;
        int autoRotors = 0;

        if (avgAutoGear2 >= 1.0 && avgAutoGear2 < 3.0) {
            strength += 60;
            autoRotors = 1;
        } else if (avgAutoGear2 == 3.0) {
            strength += 120;
            autoRotors = 2;
        }

        // gears needed for rotors:
        // 1 gear = 1 rotor
        // 3 gears = 2 rotors
        // 7 gears = 3 rotors
        // 13 gears = 4 rotors
        //assume they get the free gear

        if (totalGears2 >= 12) {
            rotors = 4;
        } else if (totalGears2 >= 6) {
            rotors = 3;
        } else if (totalGears2 >= 2) {
            rotors = 2;
        } else if (totalGears2 >= 0) {
            rotors = 1;
        } else {
            rotors = 0;
        }

        int teleRotors = rotors - autoRotors;
        // 40 points for each rotor in tele
        strength += (teleRotors * 40);
        if (rotors == 4) {
            strength += 100;
        }
        strength += avgAutoFuel2;
        strength += avgTeleFuel2;
        if (avgAutoFuel2 + avgTeleFuel2 >= 40) {
            strength += 20;
        }
        int climbPoints2 = (int)(avgTeleClimb2) * 50;
        strength += climbPoints2;

        alliance2Strength = strength;
    }
}

