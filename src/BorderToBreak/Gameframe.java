package BorderToBreak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


//��Ϸ�������

@SuppressWarnings("serial")
public class Gameframe extends JFrame implements ActionListener{
	public Player player = new Player("��ľ��");//������������
	
	Mappanel mappanel;
	Statepanel statepanel=new Statepanel(player);
	JButton close=new JButton("�뿪��Ϸ");
	//Music music;
	
	public Gameframe() {
	
		//music=new Music("./util/��Ϸ����.au");
		Choosedialog1 choose=new Choosedialog1("             �Ƿ�Ҫ���ϴδ浵�ĵط�������ʼ��");
		if(choose.getI()==-1)
			this.dispose();
		else {
			if(choose.getI()==1)
				player.load();
			
			mappanel=new Mappanel(statepanel,player);
			if(choose.getI()==0)
		        {new Textdialog("���ǣ����಻���ĳ��ǣ���ب�ڱ������Ļ�Į��.\n"+
		        				"��ڸ���˴�ɳ�����ػ��ű���Ķ����۹�");
		         new Textdialog("��񶫷��۹�������ѣ�ǿ������׾�������һ�����ݻ���������ң�\n" +
		                 "��ʱ������������");
		         
		         new Textdialog(player.name+"��Ϊ���������������䣬��Ҫȥ��ɱ����������\n");
		         new Textdialog("ȫ��������\n");
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
		new Textdialog("��Ϸ�ر�");
		//music.Close();
        this.dispose();
	}
}
	


