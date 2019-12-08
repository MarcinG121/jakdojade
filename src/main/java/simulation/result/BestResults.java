package simulation.result;

import java.util.*;

public class BestResults {

    private static final Integer FIRST_ELEM = 1;

    private List<Result> results = new ArrayList<>();

    public void add(Result result) {
        this.results.add(result);
    }

    public Result findBestResult() {
        Optional<Result> max = this.results.stream().max(Comparator.comparing(Result::getCost));
        return max.orElseThrow(NoSuchElementException::new);
    }
}
