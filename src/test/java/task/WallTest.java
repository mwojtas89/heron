package task;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {
    private static List<Block> blockList = new ArrayList<>();


    @BeforeAll
    static void fillBlockList() {
        for(int i =0; i < 10; i++) {
            blockList.add(new CompositeBlock("color" + i, "material" + i));
        }
    }

    @Test
    void findBlockByColor() {
        //Given
        Wall wall = new Wall(blockList);

        //When
        Block block = wall.findBlockByColor("color1").orElse(null);
        Block block1 = wall.findBlockByColor("colorrrrr").orElse(null);

        //Then
        assertEquals(block, blockList.get(1));
        assertNull(block1);
    }

    @Test
    void findBlocksByMaterial() {
        //Given
        Wall wall = new Wall(blockList);

        //When
        List<Block> testList = wall.findBlocksByMaterial("material0");
        List<Block> testList1 = wall.findBlocksByMaterial("madasdasdas");

        //Then
        assertEquals(0, testList1.size());
        assertEquals(1, testList.size());
    }

    @Test
    void count() {
        //Given, When
        Wall wall = new Wall(blockList);
        int size = wall.count();

        //Then
        assertEquals(10, size);
    }
}