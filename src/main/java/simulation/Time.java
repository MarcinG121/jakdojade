package simulation;

import lombok.Getter;

@Getter
public class Time {

    private static final Integer START_CYCLE = 0;
    private static final Integer END_CYCLE = 100;
    private Integer time;

    public void createArrivalsTimes(Integer time){
        if (time > END_CYCLE || time < START_CYCLE) this.time = time;
    }

}
