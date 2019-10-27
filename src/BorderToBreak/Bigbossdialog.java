package BorderToBreak;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class Bigbossdialog extends javax.swing.JDialog{
	Player player;
	
	public Bigbossdialog(Player player) {
		this.player=player;
		initComponents();
		
		this.setBounds(100,100,600,600);
		this.setTitle("主宰");
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.setVisible(true);
	}
	
	private void initComponents() {
		ImageIcon icon=new ImageIcon("./util/主宰.png");
		jLabel1=new javax.swing.JLabel("",icon,SwingConstants.CENTER);
		jButton1=new javax.swing.JButton();
		jButton2=new javax.swing.JButton();
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		jLabel1.setText("");
		jButton1.setText("战斗");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
			jButton1ActionPerformed(evt);
			}
		});
		jButton2.setText("离开");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
			jButton2ActionPerformed(evt);
			}
		});
		
		javax.swing.GroupLayout layout=new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jLabel1,javax.swing.GroupLayout.PREFERRED_SIZE,267,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(43,43,43)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jButton2)
								.addComponent(jButton1,javax.swing.GroupLayout.PREFERRED_SIZE,81,javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(64,Short.MAX_VALUE))
				);
		
		layout.linkSize(javax.swing.SwingConstants.HORIZONTAL,new java.awt.Component[] {jButton1,jButton2});
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jButton1)
						.addGap(80,80,80)
						.addComponent(jButton2))
				);
		pack();
	}
	
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt){
		this.dispose();
	}
	
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		Choosedialog1 choose =new Choosedialog1("是否攻击主宰？");
		if(choose.getI()==1) {
			Monster[] monster=new Monster[1];
			monster[0]=new Monster(34);
			new Fightdialog(player,monster);
			if(monster[0].hpp<=0)
				new Textdialog("恭喜你成功击败主宰，完成任务！");
		}
	}
	
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;

}
