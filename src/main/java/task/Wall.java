package task;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure{
    private final List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream().filter(n->n.getColor().equals(color)).findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream().filter(n->n.getMaterial().equals(material)).collect(Collectors.toList());
    }

    @Override
    public int count() {
        return blocks.stream().map(e -> 1).reduce(0, Integer::sum);
    }
}
