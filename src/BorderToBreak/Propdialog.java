package BorderToBreak;


import java.awt.Color;
import javax.swing.JDialog;
//import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class Propdialog extends JDialog{
	
	Character player;
	public Propdialog(Character player) {
		this.player=player;
	}
	
	public static class Proppanel extends JPanel implements ListSelectionListener{
		Character player;
		JList jlist;
		
		public Proppanel(Character player){
            this.player = player;
            
            //�������
        jlist = new JList(new String[] {"ˮ��" , "�·�" , "��Ь"});
        jlist.setForeground(Color.RED);
        jlist.setBackground(Color.WHITE);
        jlist.setSelectionForeground(Color.PINK);
        jlist.setSelectionBackground(Color.BLACK);
        jlist.setVisibleRowCount(10);
        
        //JLabel string = new JLabel("������");
        //this.add(string);
        //string.setBounds(0, 0, 50, 50);
        
        JScrollPane scrollpane = new JScrollPane(jlist);
        jlist.addListSelectionListener(this);
        this.add(scrollpane);
        scrollpane.setBounds(0, 0, 200, 450);
        
        this.setSize(200, 450);
        
        }

        public void valueChanged(ListSelectionEvent e) {
            System.out.println("��ʾ��Ʒ����");
            e.equals("���ϰ�ҩ");
            
            
        }
	}

}
