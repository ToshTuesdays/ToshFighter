package toshfighter.jobs;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.Item;

import toshfighter.util.Data;
import toshfighter.util.Methods;

public class Eat extends Node {

	@Override
	public boolean activate() {
		return Data.initialized && Methods.needsToEat();
	}

	@Override
	public void execute() {
		Item food = Inventory.getItem(Data.foodId);
		Data.status = "Eating";
		
		if(food != null) {
			food.getWidgetChild().interact("Eat");
			Task.sleep(1250, 1500);
		}
		
	}

}
