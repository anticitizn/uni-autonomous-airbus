package application.scenario;

import application.cargo.Container;
import application.humans.Human;
import application.utils.Logger;
import application.cargo.Storage;

import java.util.ArrayList;
import java.util.List;

public class Scenario03 extends BaseScenario {

    public Scenario03() {
        super();
    }

    public Storage getStorage() {
        return storage;
    }

    public List<Container> getContainers() {
        return containers;
    }

    private Storage storage = new Storage();
    private List<Container> containers = new ArrayList<>();

    public void start() {
        try {
            Logger.setFilename("scenario_03.log");
            Logger.log("Item loading started");

            Human human = new Human();
            human.setContainers(containers);

            for (int i = 0; i < 10; i++)
            {
                containers.add(new Container());
            }

            airbusA350.getCentralUnit().LoadCargo(storage, containers);
            Logger.log("Human counted " + human.countContainerItems() + " items");
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
