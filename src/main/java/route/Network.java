package route;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Network {
    private List<List<Edge>> network;

    public List<Edge> getRow(Integer num) {
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
