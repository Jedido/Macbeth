package GameState.Part1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

import GameState.*;
import Main.GamePanel;

import java.awt.image.*;

public class Scene5State extends SceneState {

	public Scene5State(GameStateManager gsm) {
		super(gsm);
		titlex = 125;
	}

	public int getIndex() {
		return GameStateManager.SCENE5STATE;
	}
	
	public int nextState() {
		return GameStateManager.SCENE6STATE;
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
			if(story.length > lineNum && lineNum != 18) {
				for(int i = lineNum / 9 * 9; i <= lineNum - 1; i++) {
					this.drawString(g, story[i], PADDING_SIZE + 20, (i % 9) * LINE_HEIGHT + PADDING_SIZE);
				}
				g.setColor(new Color(255, 255, 255, (int) textappear));
				this.drawString(g, story[lineNum], PADDING_SIZE + 20, (lineNum % 9) * LINE_HEIGHT + PADDING_SIZE);
			}
			else {
				try {
					BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/Backgrounds/event.gif"));
					g.drawImage(image, 0, 0, null);
					g.setColor(new Color(0, 0, 0, (int)transparency));
					if(transparency > 4)
						transparency -= 5;
					g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
					if(story.length <= lineNum)
						gsm.setState(GameStateManager.SCENE6STATE);
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
				"", "Scene 5", "\"Sleep and Murder\"", "", "", "", "", "", "", 
				"Was that a dagger in front of me?",
				"A dagger of the mind, a false creation?",
				"I saw it, nonetheless, in form as palpable as the one by\n"
				+ "my side.",
				"",
				"I had to have courage. Factor M helped, but it wasn't enough.",
				"The bell rang again. It's an invitation.",
				"An invitation to meet King Duncan.",
				"I hope you hear it not, Duncan, for it is a knell\n"
				+ "That summons thee to heaven or to hell.",
				"",
				"...",
				"What happened after was trivial. Lies, murder, and fear were \n"
				+ "all that filled me. I had murdered King Duncan and framed his \n"
				+ "servants, murdering them as well. It is over.",
				"",
				"",
				"",
				"",
				"",
				"",
				"I am king."
		};
		return a;
	}

	@Override
	public String getMusic() {
		return "/Music/darkness.mp3";
	}
}
