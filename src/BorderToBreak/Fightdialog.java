package BorderToBreak;


import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class Fightdialog extends JDialog implements ActionListener{
	JDialog jdialog=new JDialog();
	Player player = new Player();
	int first;
	int second;
	int temp;
	Monster[] monster;
	Battle battle;
	
	JPanel1 panel1;
	JPanel2 panel2;
	JPanel panel3;
	
	JButton attack=new JButton("攻击");
	JButton prop = new JButton("物品");
	JButton leave=new JButton("逃跑");
	JButton skill=new JButton("技能");
	
	//地图随机遇怪的构造方法
	Fightdialog(Player palyer){
		temp=(int)(Math.random()*10+4)/4;//随机生成敌人序号
		monster=new Monster[temp];
		//this.player=player;
		for(int j=0;j<temp;j++) {
			monster[j]=incident.getMonter();
		}
		battle=new Battle();
		battle.battleBegin(palyer);
		
		panel1=new JPanel1(player);//主角面板
		panel1.setBounds(0,0,300,400);
		
		panel2=new JPanel2(monster);//怪物面板
		panel2.setBounds(300, 0, 300, 400);
		
		panel3=new JPanel();//按钮面板
		panel3.setBounds(0, 400, 600, 200);
		
		panel3.setLayout(new GridLayout(2,2));
		panel3.add(attack);
		panel3.add(prop);
		panel3.add(skill);
		panel3.add(leave);
		
		this.setBounds(300, 100, 605, 635);
		this.setLayout(null);
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		
		attack.addActionListener(this);
		prop.addActionListener(this);
		skill.addActionListener(this);
		leave.addActionListener(this);
		
		this.setTitle("战斗画面");
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setModal(true);
		this.setVisible(true);
	}
	
	//指定战斗的对象的构造方法
	Fightdialog(Player player,Monster[] monster){
		temp=1;
		this.player=player;
		this.monster=monster;
		
		battle=new Battle();
		battle.battleBegin(player);
		
		panel1=new JPanel1(player);//角色面板
		panel1.setBounds(0,0,300,400);
		
		panel2=new JPanel2(monster);//怪物面板
		panel2.setBounds(300,0,300,400);
		
		panel3=new JPanel();//按钮面板
		panel3.setBounds(0,400,600,200);
		
		panel3.setLayout(new GridLayout(2,2));
		panel3.add(attack);
		panel3.add(prop);
		panel3.add(skill);
		panel3.add(leave);
		
		this.setBounds(300,100,605,635);
		this.setLayout(null);
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		
		attack.addActionListener(this);
		prop.addActionListener(this);
		skill.addActionListener(this);
		leave.addActionListener(this);
		
		this.setTitle("战斗画面");
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setModal(true);
		this.setVisible(true);
		
	}
	
	//内部类
	//主角面板
	
	public class JPanel1 extends JPanel{
		Player player = new Player();
		public JPanel1(Player player) {
			this.player=player;
		}
		protected void paintComponent(Graphics g) {
			g.drawImage(player.image, 0, 0, this);
			g.drawString("名字："+player.name, 50, 120);
			g.drawString("等级："+player.level, 50, 140);
			g.drawString("生命值："+player.hpp+"/"+player.hp, 50,160);
			g.drawString("魔法值："+player.mpp+"/"+player.mp, 50, 180);
			g.drawString("攻击力："+player.attactt, 50, 200);
			g.drawString("防御力："+player.defencee,50,220);
		}
	}
	
	//怪物面板
	public class JPanel2 extends JPanel{
		Monster player[];
		public JPanel2(Monster player[]) {
			this.player=player;
		}
		
		protected void paintComponent(Graphics g) {
			for(int i=0;i<temp;i++) {
				g.drawImage(player[i].image,0+(i%2*150),0+(i/2)*200,this);//名字
				g.drawString("名字："+player[i].name, 50+(i%2*150), 110+(i/2)*200);
				g.drawString("等级："+player[i].level, 50+(i%2*150), 130+(i/2)*200);
				g.drawString("生命值："+player[i].hpp+"/"+player[i].hp, 50+(i%2*150),150+(i/2)*200);
				g.drawString("攻击力："+player[i].attactt, 50+(i%2*150), 170+(i/2)*200);
				g.drawString("防御力："+player[i].defencee,50+(i%2*150),190+(i/2)*200);
			}
			
			switch(temp) {
			case 1:second=battle.checkBattle(monster[0]);break;
			case 2:second=battle.checkBattle(monster[0],monster[1]);break;
			case 3:second=battle.checkBattle(monster[0],monster[1],monster[2]);break;
			}
			if(second==1) {
				for(int i=0;i<temp;i++) {
					g.drawImage(player[i].image,0+(i%2*150),0+(i/2)*200,this);//名字
					g.drawString("名字："+player[i].name, 50+(i%2*150), 110+(i/2)*200);
					g.drawString("等级："+player[i].level, 50+(i%2*150), 130+(i/2)*200);
					g.drawString("生命值："+0+"/"+player[i].hp, 50+(i%2*150),150+(i/2)*200);
					g.drawString("魔法值："+player[i].mpp+"/"+player[i].mp, 50+(i%2*150), 170+(i/2)*200);
					g.drawString("攻击力："+player[i].attactt, 50+(i%2*150), 190+(i/2)*200);
					g.drawString("防御力："+player[i].defencee,50+(i%2*150),210+(i/2)*200);
				}
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("攻击")) {
			Choosedialog choose=new Choosedialog(monster,temp);
			if(choose.getN()==100)return;
			if(temp==3&&battle.checkSpeedd(player,monster[0],monster[1],monster[2])==1)first=2;
			if(temp==2&&battle.checkSpeedd(player,monster[0],monster[1])==1)first=1;
			if(temp==1&&battle.checkSpeedd(player,monster[0])==1)first=0;
			
			if(first==1||first==2||first==0) {
				battle.attracts(player, monster[choose.getN()]);
				if(temp==1) {
					battle.attracts(monster[temp-1], player);
					repaint();
				}
				if(temp==2) {
					battle.attracts(monster[temp-2], player);
					repaint();
					battle.attracts(monster[temp-1], player);
					repaint();
				}
				if(temp==3) {
					battle.attracts(monster[temp-3], player);
					repaint();
					battle.attracts(monster[temp-2], player);
					repaint();
					battle.attracts(monster[temp-1], player);
					repaint();
				}
				this.repaint();
			}
			else {
				if(temp==1) {
					battle.attracts(monster[temp-1], player);
					repaint();
				}
				if(temp==2) {
					battle.attracts(monster[temp-2], player);
					repaint();
					battle.attracts(monster[temp-1], player);
					repaint();
				}
				if(temp==3) {
					battle.attracts(monster[temp-3], player);
					repaint();
					battle.attracts(monster[temp-2], player);
					repaint();
					battle.attracts(monster[temp-1], player);
					repaint();
				}
				battle.attracts(player, monster[choose.getN()]);
			}
			
			this.repaint();
			this.repaint();
			this.repaint();
			switch(temp) {
			case 1:second=battle.checkBattle(monster[0]);break;
			case 2:second=battle.checkBattle(monster[0],monster[1]);break;
			case 3:second=battle.checkBattle(monster[0],monster[1],monster[2]);
			}
			
			if(second!=1)second=battle.checkBattle(player);
			if(second==1&&player.hpp!=0) {
				switch(temp) {
				case 1:battle.getExp(monster[0], player);break;
				case 2:battle.getExp(monster[0],monster[1], player);break;
				case 3:battle.getExp(monster[0],monster[1],monster[2], player);
				}
				this.repaint();
				switch(temp) {
				case 1:battle.fallItem(monster[0], player);break;
				case 2:battle.fallItem(monster[0],monster[1], player);break;
				case 3:battle.fallItem(monster[0],monster[1],monster[2], player);
				}
				new Textdialog("战斗结束");
				for(int i=0;i<3;i++) {
					if(player.xpp>=player.xp)
						new Textdialog(player.levelup(player.xp, player.xpp));
				}
				this.dispose();
			}
		}
		
		if(e.getActionCommand().equals("物品")){
            Choosedialog choose = new Choosedialog(player);
            if(choose.getN()==100){return;}
             if(temp==3&&battle.checkSpeedd(player,monster[0],monster[1],monster[2])==1)first=2;
             if(temp==2&&battle.checkSpeedd(player,monster[0],monster[1])==1)first=1;
             if(temp==1&&battle.checkSpeedd(player,monster[0])==1)first=0;
             if(first==1||first==2||first==0){
             player.item[choose.getN()].useItem(player);
                if(temp==1){
                         battle.attracts(monster[temp-1], player);
                         repaint();
                     }
                     if(temp==2){
                         battle.attracts(monster[temp-2], player);
                         repaint();
                         battle.attracts(monster[temp-1], player);
                         repaint();
                     }
                     if(temp==3){
                         battle.attracts(monster[temp-3], player);
                         repaint();
                         battle.attracts(monster[temp-2], player);
                         repaint();
                         battle.attracts(monster[temp-1], player);
                         repaint();
                     }
                     this.repaint();
             repaint();}
             else{
                   if(temp==1){
                         battle.attracts(monster[temp-1], player);
                         repaint();
                     }
                     if(temp==2){
                         battle.attracts(monster[temp-2], player);
                         repaint();
                         battle.attracts(monster[temp-1], player);
                         repaint();
                     }
                     if(temp==3){
                         battle.attracts(monster[temp-3], player);
                         repaint();
                         battle.attracts(monster[temp-2], player);
                         repaint();
                         battle.attracts(monster[temp-1], player);
                         repaint();
                     }
                     this.repaint();
                     player.item[choose.getN()].useItem(player);  
             }
		}
		
		if(e.getActionCommand().equals("技能")) {
			Choosedialog choose=new Choosedialog(player.skill,3);//注意这里的10
			if(choose.getN()==100)return;
			Choosedialog choose1=new Choosedialog(monster,temp);
			if(choose1.getN()==100)return;
			
			if(temp==3&&battle.checkSpeedd(player,monster[0],monster[1],monster[2])==1)first=2;
			if(temp==2&&battle.checkSpeedd(player,monster[0],monster[1])==1)first=1;
			if(temp==1&&battle.checkSpeedd(player,monster[0])==1)first=0;
			
			if(first==1||first==2||first==0) {
				if(temp==1)battle.useskill(player.skill[choose.getN()],player, monster[0], choose1.getN()+1);
				if(temp==2)battle.useskill(player.skill[choose.getN()], player,monster[0], monster[1],choose1.getN()+1);
				if(temp==3)battle.useskill(player.skill[choose.getN()], player,monster[0], monster[1],monster[2],choose1.getN()+1);
				
				this.repaint();
				if(temp==1) {
					battle.attracts(monster[temp-1], player);
					repaint();
				}
				if(temp==2) {
					battle.attracts(monster[temp-2], player);
					repaint();
					battle.attracts(monster[temp-1], player);
					repaint();
				}
				if(temp==3) {
					battle.attracts(monster[temp-3], player);
					repaint();
					battle.attracts(monster[temp-2], player);
					repaint();
					battle.attracts(monster[temp-1], player);
					repaint();
				}
				this.repaint();
			}
			else {
				if(temp==1) {
					battle.attracts(monster[temp-1], player);
					repaint();
				}
				if(temp==2) {
					battle.attracts(monster[temp-2], player);
					repaint();
					battle.attracts(monster[temp-1], player);
					repaint();
				}
				if(temp==3) {
					battle.attracts(monster[temp-3], player);
					repaint();
					battle.attracts(monster[temp-2], player);
					repaint();
					battle.attracts(monster[temp-1], player);
					repaint();
				}
				this.repaint();
				if(temp==1)battle.useskill(player.skill[choose.getN()], player,monster[0],choose1.getN()+1);
				if(temp==2)battle.useskill(player.skill[choose.getN()], player,monster[0], monster[1],choose1.getN()+1);
				if(temp==3)battle.useskill(player.skill[choose.getN()], player,monster[0], monster[1],monster[2],choose1.getN()+1);
				
				this.repaint();
			}
			
			switch(temp) {
			case 1:second=battle.checkBattle(monster[0]);break;
			case 2:second=battle.checkBattle(monster[0],monster[1]);break;
			case 3:second=battle.checkBattle(monster[0],monster[1],monster[2]);
			}
			
			
			
			if(second!=1)second=battle.checkBattle(player);
			if(second==1&&player.hpp!=0) {
				switch(temp) {
				case 1:battle.getExp(monster[0], player);break;
				case 2:battle.getExp(monster[0],monster[1], player);break;
				case 3:battle.getExp(monster[0],monster[1],monster[2], player);
				}
				panel1.repaint();
				panel2.repaint();
				switch(temp) {
				case 1:battle.fallItem(monster[0], player);break;
				case 2:battle.fallItem(monster[0],monster[1], player);break;
				case 3:battle.fallItem(monster[0],monster[1],monster[2], player);
				}
				new Textdialog("战斗结束");
                for(int i = 0;i<3;i++){
                    if(player.xpp>=player.xp)
                    new Textdialog(player.levelup(player.xp, player.xpp));
                }
                this.dispose();
			}
		}
		
		if(e.getActionCommand().equals("逃跑")) {
			if(temp==3&&battle.checkSpeedd(player,monster[0],monster[1],monster[2])==1)first=2;
			if(temp==2&&battle.checkSpeedd(player,monster[0],monster[1])==1)first=1;
			if(temp==1&&battle.checkSpeedd(player,monster[0])==1)first=0;
			
			if(first==1||first==2||first==0) {
				if(battle.runAway(player, monster[0])==1) {
					second=1;
					this.dispose();
				}
				else {
					if(temp==1) {
						battle.attracts(monster[temp-1], player);
						repaint();
					}
					if(temp==2) {
						battle.attracts(monster[temp-2], player);
						repaint();
						battle.attracts(monster[temp-1], player);
						repaint();
					}
					if(temp==3) {
						battle.attracts(monster[temp-3], player);
						repaint();
						battle.attracts(monster[temp-2], player);
						repaint();
						battle.attracts(monster[temp-1], player);
						repaint();
					}
				}
			}
			
			else {
				if(temp==1) {
					battle.attracts(monster[temp-1], player);
					repaint();
				}
				if(temp==2) {
					battle.attracts(monster[temp-2], player);
					repaint();
					battle.attracts(monster[temp-1], player);
					repaint();
				}
				if(temp==3) {
					battle.attracts(monster[temp-3], player);
					repaint();
					battle.attracts(monster[temp-2], player);
					repaint();
					battle.attracts(monster[temp-1], player);
					repaint();
				}
				if(battle.runAway(player, monster[0])==1) {
					second=1;
					this.dispose();
				}
			}
		}
	}
	
	public int getSecond() {
		return second;
	}
}
