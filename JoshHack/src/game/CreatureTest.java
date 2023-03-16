package game;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreatureTest {
	StuffFactory factory;
	Creature zombie;
	World world;

	@Before
	public void setUp() throws Exception {
		world = new WorldBuilder(90,32,5).makeCaves().build();
		factory = new StuffFactory(world);
		zombie = factory.newZombie(2, zombie);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGainXp() {
		zombie.gainXp(zombie);
		assertEquals(2,zombie.level());
	}

}
