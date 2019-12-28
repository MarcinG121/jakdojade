package simulation;

import lombok.Getter;

@Getter
public class Time {

    private static final Integer START_CYCLE = 0;
    private static final Integer END_CYCLE = 24*60;
    private Integer arrivalTime;
    private Integer departureTime;

    public Time(Integer arrivalTime, Integer departureTime) {
        if (isGoodTimeRange(arrivalTime) && isGoodTimeRange(departureTime)) {
            this.arrivalTime = arrivalTime;
            this.departureTime = departureTime;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    private boolean isGoodTimeRange(Integer time) {
        return time <= END_CYCLE && time >= START_CYCLE;
    }
}
