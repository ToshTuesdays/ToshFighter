package toshfighter.util;

import java.awt.*;

public class Paint {
	
	private final static Color color1 = new Color(0, 0, 0, 180);
    private final static Color color2 = new Color(255, 153, 0);

    private final static BasicStroke stroke1 = new BasicStroke(1);

    private final static Font font1 = new Font("Tahoma", 1, 14);
    private final static Font font2 = new Font("Tahoma", 0, 11);

    public static void paintStuff(Graphics g1) {
    	Data.xpHour = (int) ((double) (Methods.getTotalXp() - Data.startXp) / Data.timer.getElapsed() * 3600000);
    	
        Graphics2D g = (Graphics2D)g1;
        
        g.setColor(color1);
        g.fillRect(15, 185, 160, 157);
        g.setColor(color2);
        g.setStroke(stroke1);
        g.drawRect(15, 185, 160, 157);
        g.setFont(font1);
        g.drawString("Tosh Fighter", 46, 206);
        g.drawLine(15, 216, 175, 216);
        g.setFont(font2);
        g.drawString("Time Running: " + Data.timer.toElapsedString(), 22, 241);
        g.drawString("Total xp gained: " + Methods.format((Methods.getTotalXp() - Data.startXp)), 22, 261);
        g.drawString("Xp / hour: " + Methods.format(Data.xpHour), 22, 281);
        g.drawString("Levels Gained: " + (Methods.getTotalLevel() - Data.startLevels), 22, 301);
        g.drawString("Status: " + Data.status, 22, 321);
    }


}
