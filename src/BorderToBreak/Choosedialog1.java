package BorderToBreak;

//import java.awt.event.ActionEvent;

import javax.swing.WindowConstants;

public class Choosedialog1 extends javax.swing.JDialog{
	
	int i=-1;
	
	public Choosedialog1(Player player) {
		initComponents();
		
		this.setLocation(300,400);
		this.setTitle("����ջ");
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.setVisible(true);
	}
	
	public Choosedialog1() {
		initComponents();
		
		jLabel1.setText("����٤�޵ĸ��׶����ţ����Ƿ�Ҫ�����ң�"+"\n"+"���Ƿ�Ҫ�浵��");
        this.setLocation(300, 400);
        this.setSize(450,200);
        this.setTitle("������Ĺ");
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
		
		jButton1.setText("��");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		
		jButton2.setText("��");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		
		jLabel1.setText("�͹٣�ס����Ҫ֧��10�����õ㡣");
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
		//����Ǯ˯��
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
