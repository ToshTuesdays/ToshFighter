package toshfighter.jobs;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.wrappers.interactive.NPC;

import toshfighter.util.Data;
import toshfighter.util.Methods;

public class Fight extends Node {

	@Override
	public boolean activate() {
		return Data.initialized && !Methods.needsToEat();
	}

	@Override
	public void execute() {
		NPC monster = NPCs.getNearest(new Filter<NPC>() {
			@Override
			public boolean accept(NPC b) {
				return b.getId() == Data.monsterId && !b.isInCombat();
			}
		});
		
		if (Players.getLocal().getInteracting() == null) {
			if (monster != null) {
				if (!Players.getLocal().isMoving()) {
					if (monster.isOnScreen()) {
						Data.status = "Attacking monster";
						monster.interact("Attack");
						Task.sleep(300, 500);
					} else {
						Data.status = "Walking to monster";
						Walking.walk(monster);
						Task.sleep(300, 500);
					}
				}
			}
		}
		
	}

}
