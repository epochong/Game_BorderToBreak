package BorderToBreak;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
//主角属性状态类
@SuppressWarnings("serial")
public class Statepanel extends JPanel{
	public Player player;
	Image image=(new ImageIcon("./util./主角头像.png")).getImage();//人物头像坐标
	
	public Statepanel(Player player) {
		this.player=player;
		this.setSize(200,600);
	}
	
	//设置行走时画面
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0,0,200,600);//画面左上角坐标及宽高
		g.setColor(Color.BLACK);
		g.drawImage(image, 15, 0, this);
		g.drawString("名字："+player.name,10,150);
		g.drawString("等级："+player.level,10,200);
		g.drawString("力量 : "+player.strength, 10, 250);
		g.drawString("攻击力："+player.attact,10,300);
		g.drawString("HP："+player.hpp+"/"+player.hp,10,350);
		g.drawString("MP："+player.mpp+"/"+player.mp,10,400);
		g.drawString("经济："+player.money,10,450);
		g.drawString("经验："+player.xpp+"/"+player.xp, 10, 500);
	}
}
