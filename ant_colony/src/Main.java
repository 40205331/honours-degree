
public class Main {

	public static void main(String[] args) throws InterruptedException {
		Ant[] ants = new Ant[50];
		SpacePosition[] food = new SpacePosition[1];

		Space space = new Space(50, 50, 0.000007);
		food[0] = space.position(10, 10);
		SpacePosition nest = space.position(45, 30);

		for (int i = 0; i < ants.length; i++)
			ants[i] = new Ant(nest, space, food[0], false);

		boolean running = true;

		OpenglClass.start(50, 50, ants, food, space);
		Thread.sleep(1000);

		while (running) {
			for (int i = 0; i < ants.length; i++) {
				if (ants[i].randomstep()) {
					if (ants[i].goal == nest)
						ants[i].goal = food[0];
					else
						ants[i].goal = nest;

				}

			}

			space.time++;

			if (space.time % 1 == 0) {
				OpenglClass.draw();
				System.out.println(space.maxpheromone.getPheromone());
			}
			 Thread.sleep(100);
		}
	}

}
