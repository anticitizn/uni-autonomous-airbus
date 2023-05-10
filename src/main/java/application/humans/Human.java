package application.humans;

import application.cargo.Container;

import java.util.List;
import java.util.Random;

public class Human {
    Random rand = new Random();
    private List<Container> containers = null;
    public void setContainers(List<Container> containers) {
        this.containers = containers;
    }
    public int countContainerItems()
    {
        int containerIndex = rand.nextInt(containers.size());
        return containers.get(containerIndex).getItems().size();
    }
}
