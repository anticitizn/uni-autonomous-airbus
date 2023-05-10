
import java.util.ArrayList;
import java.util.List;

public class Scenario03 extends BaseScenario {

    public Scenario03() {
        super();
    }

    public void start() {
        try {
            Storage storage = new Storage();
            List<Container> containers = new ArrayList<Container>();

            Human human = new Human();
            human.setContainers(containers);

            for (int i = 0; i < 10; i++)
            {
                containers.add(new Container());
            }

            airbusA350.getCentralUnit().LoadCargo(storage, containers);
            System.out.println("Human counted " + human.countContainerItems() + " items");
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
