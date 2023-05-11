package application.robot;

import application.cargo.Container;
import application.cargo.Storage;

import java.util.List;

public class CargoRobot extends AbstractRobot {
    private Storage storage = null;
    private List<Container> containers = null;

    public void takeItemAndLoad() {
        for (Container container : containers) {
            if (!storage.isEmpty()) {
                var item = this.storage.getItem();
                if (!container.isFull()) {
                    container.insertItem(item);
                } else {
                    storage.putItem(item);
                }
            }
        }
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void setContainers(List<Container> containers) {
        this.containers = containers;
    }

    public void load() {
        while (!storage.isEmpty()) {
            takeItemAndLoad();
        }
    }


}
