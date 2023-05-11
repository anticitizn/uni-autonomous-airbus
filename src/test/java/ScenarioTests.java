import application.cargo.Container;
import application.plane.Engine;
import application.plane.Flap;
import application.plane.LandingGear;
import application.plane.Wing;
import application.scenario.*;
import application.utils.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScenarioTests {

    @Test
    public void TestScenario01()
    {
        Logger.setEnabled(false);

        Scenario01 scenario = new Scenario01();
        scenario.start();

        assertEquals(scenario.getAirbusA350().totalNumberOfPassengers.get(), 252);
    }

    // Scenario 02 has no defined end-state, so it cannot be tested

    @Test
    public void TestScenarioS03()
    {
        Logger.setEnabled(false);

        Scenario03 scenario = new Scenario03();
        scenario.start();

        assertTrue(scenario.getStorage().isEmpty());

        for (Container container : scenario.getContainers())
        {
            assertTrue(container.isFull());
        }
    }

    @Test
    public void TestScenario04()
    {
        Logger.setEnabled(false);

        Scenario04 scenario = new Scenario04();
        scenario.start();

        for (Engine engine : scenario.getAirbusA350().getEngines())
        {
            assertTrue(engine.isRunning());
        }
    }

    @Test
    public void TestScenario05()
    {
        Logger.setEnabled(false);

        Scenario05 scenario = new Scenario05();
        scenario.start();

        assertTrue(scenario.getAirbusA350().getCentralUnit().getCountMessageNormal() > 0);
        assertTrue(scenario.getAirbusA350().getCentralUnit().getCountMessageWarning() > 0);
        assertTrue(scenario.getAirbusA350().getCentralUnit().getCountMessageAlarm() > 0);
    }

    @Test
    public void TestScenario06() {
        Logger.setEnabled(false);

        Scenario06 scenario = new Scenario06();
        scenario.start();

        for (LandingGear landingGear : scenario.getAirbusA350().getLandingGears())
        {
            assertTrue(landingGear.isDown());
        }

        for (Wing wing : scenario.getAirbusA350().getWings())
        {
            for (Flap flap : wing.getFlaps())
            {
                assertTrue(flap.isDown());
            }
        }
    }

    @Test
    public void TestScenario07() {
        Logger.setEnabled(false);

        Scenario07 scenario = new Scenario07();
        scenario.start();

        assertTrue(scenario.getAirbusA350().getCentralUnit().getBirdCount() > 0);
        assertTrue(scenario.getAirbusA350().getCentralUnit().getAcknowledgedCount() > 0);
    }

    @Test
    public void TestScenario08() {
        Logger.setEnabled(false);

        Scenario08 scenario = new Scenario08();
        scenario.start();

        for (Engine engine : scenario.getAirbusA350().getEngines())
        {
            assertEquals(engine.getRpm(), 6000);
        }

    }

    // Scenario 09 has no defined end-state (el chapo might or might not be on board), so nothing to test
}
