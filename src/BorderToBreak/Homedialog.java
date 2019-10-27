package BorderToBreak;


import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


@SuppressWarnings("serial")
public class Homedialog extends javax.swing.JDialog{
	Player player;
	int i=-1;
	
	public Homedialog(Player player) {
		this.player=player;
		i=player.i;
		initComponents();
		
		this.setLocation(300, 200);
		this.setTitle("泉水");
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setModal(true);
		this.setVisible(true);
	}
	
	private void initComponents() {
		ImageIcon icon=new ImageIcon("./util/泉水.png");
		jLabel1=new javax.swing.JLabel("",icon,SwingConstants.CENTER);
		jButton1=new javax.swing.JButton();
		jButton2=new javax.swing.JButton();
		jButton3=new javax.swing.JButton();
		jButton4=new javax.swing.JButton();
		jLabel2=new javax.swing.JLabel();
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		jLabel1.setText("");
		
		jButton1.setText("休息");
		jButton1.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		
		jLabel2.setFont(new java.awt.Font("楷体_GB2312",3,18));//java.awt.Font类用来表示字体
		jLabel2.setText("			泉水");
		
		jButton2.setText("出发");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		jButton3.setText("信箱");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		
		jButton4.setText("存档");
		jButton4.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});
		
		javax.swing.GroupLayout layout=new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);//得到一个空的窗体面板，可以进行布局
		layout.setHorizontalGroup(				//指定布局的水平组（确定组件在 X轴 方向上的位置）
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)//创建并行组
				.addGroup(layout.createSequentialGroup()//创建串行组按顺序沿指定方向（水平/垂直）逐个放置元素将 Group 添加到此 Group
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel1,javax.swing.GroupLayout.PREFERRED_SIZE,169,javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(83,83,83)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jButton3,javax.swing.GroupLayout.DEFAULT_SIZE,125,Short.MAX_VALUE)
												.addComponent(jButton2,javax.swing.GroupLayout.DEFAULT_SIZE,125,Short.MAX_VALUE)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
														.addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))))
								.addGroup(layout.createSequentialGroup()
										.addGap(97,97,97)
										.addComponent(jLabel2,javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(63, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel2,javax.swing.GroupLayout.PREFERRED_SIZE,63,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,32,Short.MAX_VALUE)//添加一个表示两个组件之间首选间隙的元素
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jButton1)
										.addGap(27,27,27)
										.addComponent(jButton2)
										.addGap(26,26,26)
										.addComponent(jButton3)
										.addGap(28,28,28)
										.addComponent(jButton4))
								.addComponent(jLabel1,javax.swing.GroupLayout.PREFERRED_SIZE,257,javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(20,20,20))
				);
		pack();
	}
	
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		if(i==-1) {
			if(new Choosedialog1("这里有个信封，是否打开？").getI()==1) {
				new Textdialog("奉天呈运，皇帝召曰：我们赖以生存的家园正在被迫害，特命长城守卫军头领花木兰秘密前往敌方军营，击杀主宰");
				new Textdialog("花木兰：待我休息完毕整装出发，一定取得主宰项上人头回来领命！");
				i=0;
			}
		}
	}
		private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
			if(i==2) {
				player.i=i;
				this.dispose();
			}
			else new Textdialog("信箱有未读的信，看看再走吧");
		}
		
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
			if(new Choosedialog1("			是否需要休息").getI()==1) {
				player.hpp=player.hp;
				player.mpp=player.mp;
				new Textdialog("几个时辰过后");
				new Textdialog("感觉整个人充满斗志");
				new Textdialog("准备完毕，正式出发！");
				i=2;
				
			}
		}
		private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
			if(new Choosedialog1("是否需要存档？").getI()==1) {
				player.i=i;
				player.save();
				new Textdialog("存档成功");
			}
		}
		
		private javax.swing.JButton jButton1;
		private javax.swing.JButton jButton2;
		private javax.swing.JButton jButton3;
		private javax.swing.JButton jButton4;
		private javax.swing.JLabel jLabel1;
		private javax.swing.JLabel jLabel2;

}
