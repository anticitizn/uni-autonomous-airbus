package application.scenario;

import application.cargo.Container;
import application.cargo.Storage;
import application.humans.Human;
import application.utils.Logger;

import java.util.ArrayList;
import java.util.List;

public class Scenario03 extends BaseScenario {

    private final Storage storage = new Storage();
    private final List<Container> containers = new ArrayList<>();

    public Scenario03() {
        super();
    }

    public Storage getStorage() {
        return storage;
    }

    public List<Container> getContainers() {
        return containers;
    }

    public void start() {
        try {
            Logger.setFilename("scenario_03.log");
            Logger.log("Item loading started");

            Human human = new Human();
            human.setContainers(containers);

            for (int i = 0; i < 10; i++) {
                containers.add(new Container());
            }

            airbusA350.getCentralUnit().LoadCargo(storage, containers);
            Logger.log("Human counted " + human.countContainerItems() + " items");
            Logger.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
