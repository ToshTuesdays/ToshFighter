package toshfighter.util;

import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Skills;

import toshfighter.util.Data;

public class Methods {
	
	public static boolean needsToEat() {
		return Players.getLocal().getHpPercent() < Data.eatAt;
	}
	
	public static int getTotalXp() {
		int[] total = Skills.getExperiences();
        int totalExp = 0;
        for (int i : total) {
         totalExp += i;
        }
        return totalExp;
	}
	
	public static int getTotalLevel() {
		int[] total = Skills.getLevels();
        int totalLev = 0;
        for (int i : total) {
         totalLev += i;
        }
        return totalLev;
	}
	
	public static String format(final int number) {
		return number / 1000 + "K";
	}

}
