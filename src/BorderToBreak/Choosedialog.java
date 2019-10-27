package BorderToBreak;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.WindowConstants;



@SuppressWarnings("serial")
public class Choosedialog extends JDialog implements ActionListener{
	JButton[] button = new JButton[30];
	JPanel panel=new JPanel();
	int i;
	int n=100;
	
	public Choosedialog(Monster monster[],int i) {
		this.i=i;
		panel.setLayout(new GridLayout(1,4));
		for(int j=0;j<i;j++) {
			button[j]=new JButton(monster[j].name);
			panel.add(button[j]);
			button[j].addActionListener(this);
		}
		
		panel.setBounds(0,0,400,400);
		this.add(panel);
        this.setLocation(300, 500);
        this.setSize(600 , 250);
        this.setTitle("选择要攻击的敌人");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setModal(true);
        this.setVisible(true);
	}
	
	public Choosedialog(Skill[] skill,int i) {
		this.i=i;
		panel.setLayout(new GridLayout(2,5));
		for(int j=0;j<i;j++) {
			button[j]=new JButton(skill[j].name);
			panel.add(button[j]);
			button[j].addActionListener(this);
		}
		
		panel.setBounds(0, 0, 300, 100);
        this.add(panel);
        this.setLocation(300, 500);
        this.setSize(600,250);
        this.setTitle("选择技能");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setModal(true);
        this.setVisible(true);
	}
	
	public  Choosedialog(Player player){
        this.i = 20;
        panel.setLayout(new GridLayout(4 , 6));
        for(int j = 0 ; j < i ; j++){
            button[j] = new JButton(player.item[j].name);
            panel.add(button[j]);
            button[j].addActionListener(this);
        }
        
        panel.setBounds(0, 0, 300, 100);
        this.add(panel);
        this.setLocation(300, 500);
        this.setSize(600,250);
        this.setTitle("选择要使用的物品");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setModal(true);
        this.setVisible(true);
        
    }
	/**Choosedialog(String[] string) {
        this.i = 0;
          panel.setLayout(new GridLayout(1 , 6));
          while(i<string.length){
              button[i] = new JButton(string[i]);
              panel.add(button[i]);
              button[i].addActionListener(this);
              i++;
          }
          
          panel.setBounds(0, 0, 300, 100);
          this.add(panel);
          this.setLocation(300, 500);
          this.setSize(600,200);
          this.setTitle("选择切磋武艺的人");
          this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
          this.setModal(true);
          this.setVisible(true);
    }*/
	
	public void actionPerformed(ActionEvent e) {
        for(int m = 0 ; m < i ; m++){
            if(e.getActionCommand().equals(button[m].getText())){
                n = m;
                this.dispose();
                return ;
            }
        }
    }
    public  int getN(){
        return n;
    }
}
