package simulation;

import lombok.Getter;

@Getter
public class Time {

    private static final Integer TIME_BEGIN = 0;
    private static Time timeInstance = null;
    private Integer actualTime;

    private Time(){
        this.actualTime = TIME_BEGIN;
    }

    public static Time getInstance(){
        if (timeInstance == null) timeInstance = new Time();
        return timeInstance;
    }

    public void start(){
        this.actualTime = TIME_BEGIN;
    }

    public Integer next(){
        return actualTime += 1;
    }
}
