package Entity;

import java.awt.image.BufferedImage;
import java.awt.*;

import javax.imageio.ImageIO;

import GameState.LevelState;

public class HUD {
	
	private Macbeth player;
	private BufferedImage image;
	private BufferedImage imagem;
	private Font font;
	private LevelState level;
	private boolean normal = true;
	
	public HUD(Macbeth p, LevelState l) {
		player = p;
		level = l;
		try {
			image = ImageIO.read(getClass().getResource("/HUD/hud.gif"));
			imagem = ImageIO.read(getClass().getResource("/HUD/hudm.gif"));
			font = new Font("Arial", Font.PLAIN, 14);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g) {
		if(normal) {
			g.drawImage(image, 0, 10, null);
			g.setColor(Color.WHITE);
			g.setFont(font);
			g.drawString(player.getHealth() + "/" + player.getMaxHealth(), 40, 25);
			g.drawString(player.getM() + "", 40, 46);
			g.drawString(player.getNumKeys() + "", 40, 67);
		}
		else {
			g.drawImage(imagem, 0, 10, null);
			g.setColor(Color.BLACK);
			g.setFont(font);
			g.drawString(player.getHealth() + "/" + player.getMaxHealth(), 40, 25);
			g.drawString(level.getCountdown() * 10 / 60 / 10.0 + " secs", 40, 45);
			g.drawString(player.getNumKeys() + "", 40, 67);
		}
	}
	
	public void MMode() {
		normal = false;
	}
	public void normalMode() {
		normal = true;
	}
}
