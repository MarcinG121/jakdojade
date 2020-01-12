package route;

import lombok.AllArgsConstructor;
import lombok.Data;
import sun.nio.ch.Net;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Network {
    private List<List<Edge>> network;

    public Network(Network original) {
        List<List<Edge>> result = new ArrayList<>();
        for (List<Edge> row : original.getNetwork()) {
            result.add(new ArrayList<>(row));
        }
        this.network = result;
    }

    public List<Edge> getRow(Integer num) throws NoSuchElementException {
        return this.network.stream()
                .filter(row -> row.get(0).getFromNode().getId().equals(num))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Node> getAllNodes() {
        return this.network.stream().map(r -> r.get(0).getFromNode()).collect(Collectors.toList());
    }

    public List<Node> findDirectlyConnected(Node source){
        List<Edge> row = getRow(source.getId());
        return row.stream().map(Edge::getToNode).collect(Collectors.toList());
    }
}
