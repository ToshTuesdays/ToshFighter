package toshfighter.jobs;

import java.awt.Point;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

import toshfighter.util.Data;

public class Antiban extends Node {
	private Timer antiBanTimer;

	private int minTime = (20 * 1000);
	private int maxTime = (120 * 1000);

	public Antiban() {
		antiBanTimer = new Timer(Random.nextInt(minTime, maxTime));
	}

	@Override
	public boolean activate() {
		return !antiBanTimer.isRunning() && Data.initialized;
	}

	@Override
	public void execute() {
		int whatdo = Random.nextInt(0, 10);
		Data.status = "Antiban";
		
		switch (whatdo) {

		case 0:
			int randomSkill = Random.nextInt(0, 24);
			Tabs.STATS.open();
			WidgetChild randStat = Skills.getWidgetChild(randomSkill);
			Point randStatPoint = randStat.getAbsoluteLocation();
			randStatPoint.x += Random.nextInt(-10, 10);
			randStatPoint.y += Random.nextInt(-10, 10);
			Mouse.move(randStatPoint);
			break;
		case 1:
			int randomX = (Random.nextInt(-15, 15) + Mouse.getX());
			int randomY = (Random.nextInt(-15, 15) + Mouse.getY());

			Mouse.move(randomX, randomY);
			break;

		case 2:
			if (Players.getLocal().getInteracting() != null) {
				Camera.turnTo(Players.getLocal().getInteracting());
				int currentPitch = Camera.getPitch();
				int currentYaw = Camera.getYaw();
				Camera.setPitch(currentPitch + Random.nextInt(-13, 13));
				Camera.setAngle(currentYaw + Random.nextInt(-25, 25));
			} else {
				int currentPitch = Camera.getPitch();
				int currentYaw = Camera.getYaw();
				Camera.setPitch(currentPitch + Random.nextInt(-50, 50));
				Camera.setAngle(currentYaw + Random.nextInt(-70, 70));
			}
			break;
		}
		resetAntiBanTime();
	}

	private void resetAntiBanTime() {
		antiBanTimer.setEndIn(Random.nextInt(minTime, maxTime));
	}

}
