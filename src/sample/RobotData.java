package sample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1153 on 3/28/2017.
 */
public class RobotData {
    public int robotNumber;

    public List<Integer> matchList;

    public int matches;

    public DataGroup totalSwitch;

    public DataGroup teleSwitch;
    public DataGroup autoSwitch;

    public DataGroup totalScale;

    public DataGroup teleScale;
    public DataGroup autoScale;

    public DataGroup autoCross;

    public DataGroup vault;

    public DataGroup climb;


    public RobotData() {
        robotNumber = 0;
        matches = 0;
        totalSwitch = new DataGroup();
        teleSwitch = new DataGroup();
        autoSwitch = new DataGroup();
        totalScale = new DataGroup();
        teleScale = new DataGroup();
        autoScale = new DataGroup();
        autoCross = new DataGroup();
        vault = new DataGroup();
        climb = new DataGroup();

        matchList = new ArrayList<Integer>();
    }
}

