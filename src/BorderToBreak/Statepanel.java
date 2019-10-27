package BorderToBreak;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
//��������״̬��
@SuppressWarnings("serial")
public class Statepanel extends JPanel{
	public Player player;
	Image image=(new ImageIcon("./util./����ͷ��.png")).getImage();//����ͷ������
	
	public Statepanel(Player player) {
		this.player=player;
		this.setSize(200,600);
	}
	
	//��������ʱ����
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0,0,200,600);//�������Ͻ����꼰���
		g.setColor(Color.BLACK);
		g.drawImage(image, 15, 0, this);
		g.drawString("���֣�"+player.name,10,150);
		g.drawString("�ȼ���"+player.level,10,200);
		g.drawString("���� : "+player.strength, 10, 250);
		g.drawString("��������"+player.attact,10,300);
		g.drawString("HP��"+player.hpp+"/"+player.hp,10,350);
		g.drawString("MP��"+player.mpp+"/"+player.mp,10,400);
		g.drawString("���ã�"+player.money,10,450);
		g.drawString("���飺"+player.xpp+"/"+player.xp, 10, 500);
	}
}
