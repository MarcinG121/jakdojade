package simulation.result;

import lombok.Data;

import java.util.*;

@Data
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ROZWIAZANIE : \n");
        for (Result result : this.results) {
            builder.append(String.format("%s \n", result.toString()));
        }
        return builder.toString();
    }
}
