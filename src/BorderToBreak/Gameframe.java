package BorderToBreak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


//游戏主面板类

@SuppressWarnings("serial")
public class Gameframe extends JFrame implements ActionListener{
	public Player player = new Player("花木兰");//输入主角名字
	
	Mappanel mappanel;
	Statepanel statepanel=new Statepanel(player);
	JButton close=new JButton("离开游戏");
	//Music music;
	
	public Gameframe() {
	
		//music=new Music("./util/游戏配乐.au");
		Choosedialog1 choose=new Choosedialog1("             是否要从上次存档的地方继续开始？");
		if(choose.getI()==-1)
			this.dispose();
		else {
			if(choose.getI()==1)
				player.load();
			
			mappanel=new Mappanel(statepanel,player);
			if(choose.getI()==0)
		        {new Textdialog("长城，连绵不绝的长城，横亘在北方广大的荒漠上.\n"+
		        				"坚壁割断了大沙海，守护着背后的东方帝国");
		         new Textdialog("如今东方帝国陷入分裂，强大的主宰军团正在一步步摧毁着这个国家，\n" +
		                 "是时候做出反击了");
		         
		         new Textdialog(player.name+"作为长城守卫军的领袖，正要去击杀敌人主将。\n");
		         new Textdialog("全军出击！\n");
		         new Homedialog(player);
		        }
			 this.setLayout(null);
			 this.setBounds(300, 100, 605+200, 635);
			 this.add(mappanel);
			 this.add(statepanel);
			 statepanel.setBounds(600, 0, 200, 550);
			 this.add(close);
			 close.setBounds(625 ,560 , 150 , 30);
			 close.addActionListener(this);
    
			 this.addKeyListener(mappanel);
			 this.setFocusable(true);
			 this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			 this.setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new Textdialog("游戏关闭");
		//music.Close();
        this.dispose();
	}
}
	


