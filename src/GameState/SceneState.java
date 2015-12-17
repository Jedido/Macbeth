package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Main.GamePanel;

public abstract class SceneState extends GameState{

	protected double transparency;
	protected double textappear;
	protected int titlex;
	
	protected int introx;
	protected String introTitle = "";
	protected int partNum;
	
	protected String[] story = getStory();
	protected int lineNum;
	protected final int LINE_HEIGHT = 40;
	protected final int PADDING_SIZE = 40; 
	public SceneState(GameStateManager gsm) {
		this.gsm = gsm;
		transparency = 0;
		lineNum = 0;
		init();
	}

	@Override
	public void init() {
		
	}

	@Override
	public void update() {
		if(transparency < 254)	transparency += 2;
		if(textappear < 252)	textappear += 7;
	}

	@Override
	public void draw(Graphics2D g) {
		
		// clear screen
		g.setColor(Color.BLACK);
		g.fillRect(0,  0,  GamePanel.WIDTH,  GamePanel.HEIGHT);
		g.setColor(new Color(10, 10, 10, (int) transparency));
		g.fillRect(PADDING_SIZE,  PADDING_SIZE,  GamePanel.WIDTH - PADDING_SIZE * 2,  GamePanel.HEIGHT - PADDING_SIZE * 2);
			
		// if part intro
		if(introTitle.length() > 1) {
			g.setColor(new Color(255, 255, 255, (int) transparency));
			g.setFont(new Font("Vivaldi", Font.ITALIC, 40));
			g.drawString("Part " + partNum, GamePanel.WIDTH/2 - 45, GamePanel.HEIGHT/2 - 40);
			
			g.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
			g.drawString(introTitle, GamePanel.WIDTH/2 - introx, GamePanel.HEIGHT/2 + 20);
			if(transparency >= 254) {
				introTitle = "";
				transparency = 0;
			}
			return;
		}
		
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
			else
				gsm.setState(nextState());
		}
	}

	@Override
	public void keyPressed(int k) {
		super.keyPressed(k);
		if(introTitle.length() == 0) {
			if(k == KeyEvent.VK_ENTER || k == KeyEvent.VK_SPACE) {
				textappear = 0;
				if(lineNum > 0) {
					lineNum++;
					while(lineNum < story.length && story[lineNum].equals(""))
						lineNum++;
				}
				else 
					lineNum = 9;
			}
		}
	}

	protected void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y+= 40);
    }
	
	@Override
	public void keyReleased(int k) {
	}
	
	public abstract int getIndex();
	public abstract int nextState();
	public abstract String[] getStory();
	
	@Override
	public void mouseMoved(MouseEvent e) {}
	
	public void mouseClicked(MouseEvent e) {
		if(introTitle.length() == 0) {
			textappear = 0;
			if(lineNum > 0) {
				lineNum++;
				while(lineNum < story.length && story[lineNum].equals(""))
					lineNum++;
			}
			else 
				lineNum = 9;
		}
	}
	
	public void setIntro(String s, int tx, int n) {
		introTitle = s;
		introx = tx;
		partNum = n;
	}
}
