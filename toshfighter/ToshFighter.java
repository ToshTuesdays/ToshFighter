import java.awt.EventQueue;
import java.awt.Graphics;

import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Random;

import toshfighter.jobs.Antiban;
import toshfighter.jobs.Eat;
import toshfighter.jobs.Fight;
import toshfighter.util.Data;
import toshfighter.util.GUI;
import toshfighter.util.Methods;
import toshfighter.util.Paint;

@Manifest(authors = { "ToshTuesdays" }, name = "Tosh Fighter", description = "Kills any monster for you", version = 1.0)
public class ToshFighter extends ActiveScript implements PaintListener {

	private Tree jobs = null;

	@Override
	public int loop() {
		if (jobs == null) {
			jobs = new Tree(
					new Node[] { new Antiban(), new Eat(), new Fight() });
		}
		final Node job = jobs.state();
		if (job != null) {
			jobs.set(job);
			getContainer().submit(job);
			job.join();
			return Random.nextInt(200, 300);
		}
		return Random.nextInt(200, 300);
	}

	@Override
	public void onStart() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		Data.startXp = Methods.getTotalXp();
		Data.startLevels = Methods.getTotalLevel();
	}

	@Override
	public void onRepaint(Graphics g1) {
		if (Data.initialized) {
			Paint.paintStuff(g1);
		}
	}

}
