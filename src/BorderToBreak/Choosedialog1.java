package BorderToBreak;

//import java.awt.event.ActionEvent;

import javax.swing.WindowConstants;

public class Choosedialog1 extends javax.swing.JDialog{
	
	int i=-1;
	
	public Choosedialog1(Player player) {
		initComponents();
		
		this.setLocation(300,400);
		this.setTitle("万达客栈");
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.setVisible(true);
	}
	
	public Choosedialog1() {
		initComponents();
		
		jLabel1.setText("我是伽罗的父亲独孤信，您是否要来找我？"+"\n"+"您是否要存档？");
        this.setLocation(300, 400);
        this.setSize(450,200);
        this.setTitle("独孤信墓");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setModal(true);
        this.setVisible(true);
	}
	public Choosedialog1( String string) {
		initComponents();

		jLabel1.setText(string);
		this.setLocation(300,400);
		this.setSize(550,200);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.setVisible(true);
	}
	
	private void initComponents() {
		jButton1=new javax.swing.JButton();
		jButton2=new javax.swing.JButton();
		jLabel1=new javax.swing.JLabel();
	
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		
		jButton1.setText("是");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		
		jButton2.setText("否");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		
		jLabel1.setText("客官，住店需要支付10个经济点。");
		javax.swing.GroupLayout layout=new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,layout.createSequentialGroup()
						.addGap(54,54,54)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel1,javax.swing.GroupLayout.Alignment.LEADING,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jButton1)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,138,Short.MAX_VALUE)
										.addComponent(jButton2)))
						.addGap(70,70,70))
				);
		
		layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addGap(22, 22, 22)
	                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jButton1)
	                    .addComponent(jButton2))
	                .addGap(35, 35, 35))
	        );
		pack();
	}
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
	
		i=0;
		this.dispose();
	}
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		//不够钱睡觉
		i=1;
		this.dispose();
	}
	
	public int getI() {
		return i;
	}
	
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;

}
