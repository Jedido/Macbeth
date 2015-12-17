package GameState.Part3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import GameState.*;
import Main.GamePanel;

public class PrologueState extends SceneState {

	public PrologueState(GameStateManager gsm) {
		super(gsm);
		titlex = 125;
	}

	public int getIndex() {
		return GameStateManager.EPILOGUESTATE;
	}
	
	public int nextState() {
		return GameStateManager.MENUSTATE;
	}
	
	@Override
	public void draw(Graphics2D g) {
		
		// clear screen
		g.setColor(new Color(0, 0, 0, (int) transparency));
		g.fillRect(0,  0,  GamePanel.WIDTH,  GamePanel.HEIGHT);
		g.setColor(new Color(10, 10, 10, (int) transparency));
		g.fillRect(PADDING_SIZE,  PADDING_SIZE,  GamePanel.WIDTH - PADDING_SIZE * 2,  GamePanel.HEIGHT - PADDING_SIZE * 2);
				
		// draw title
		if(lineNum == 0) {
			g.setColor(new Color(255, 255, 255, (int) transparency));
			g.setFont(new Font("Trebuchet MS", Font.ITALIC, 40));
			
			g.drawString(story[0], GamePanel.WIDTH/2 - 80, GamePanel.HEIGHT/2 - 60);
			g.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
			g.drawString(story[1], GamePanel.WIDTH/2 - 36, GamePanel.HEIGHT/2 - 20);
			
			g.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
			g.drawString(story[2], GamePanel.WIDTH/2 - titlex, GamePanel.HEIGHT/2 + 110);
		}
		
		// draw normal text
		else{
			g.setColor(new Color(255, 255, 255));
			g.setFont(new Font("Arial", Font.PLAIN, 20));
			if(story.length > lineNum) {
				for(int i = lineNum / 9 * 9; i <= lineNum - 1; i++) {
					this.drawString(g, story[i], PADDING_SIZE + 20, (i % 9) * LINE_HEIGHT + PADDING_SIZE);
				}
				g.setColor(new Color(255, 255, 255, (int) textappear));
				this.drawString(g, story[lineNum], PADDING_SIZE + 20, (lineNum % 9) * LINE_HEIGHT + PADDING_SIZE);
			}
			else {
				try {
					BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/Backgrounds/fin.gif"));
					g.drawImage(image, 0, 0, null);
					g.setColor(new Color(0, 0, 0, (int)transparency));
					if(transparency > 4)
						transparency -= 5;
					g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public String[] getStory() {
		String[] a =  {
				"", "Epilogue", "", "", "", "", "", "", "", 
				"Will I...die?",
				"After losing everything?",
				"But nothing was mine to begin with.",
				"",
				"Did my power fail me?",
				"No, it did not.",
				"From the beginning, I knew what it was.",
				"I had never wished for the death of anyone.",
				"Each murder just brought me closer to the truth.",
				"M never meant Macbeth.",
				"It was factor M,",
				"the state of madness."
		};
		return a;
	}

	@Override
	public String getMusic() {
		return "/Music/menu.mp3";
	}
}
