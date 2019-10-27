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
		this.setTitle("Ȫˮ");
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setModal(true);
		this.setVisible(true);
	}
	
	private void initComponents() {
		ImageIcon icon=new ImageIcon("./util/Ȫˮ.png");
		jLabel1=new javax.swing.JLabel("",icon,SwingConstants.CENTER);
		jButton1=new javax.swing.JButton();
		jButton2=new javax.swing.JButton();
		jButton3=new javax.swing.JButton();
		jButton4=new javax.swing.JButton();
		jLabel2=new javax.swing.JLabel();
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		jLabel1.setText("");
		
		jButton1.setText("��Ϣ");
		jButton1.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		
		jLabel2.setFont(new java.awt.Font("����_GB2312",3,18));//java.awt.Font��������ʾ����
		jLabel2.setText("			Ȫˮ");
		
		jButton2.setText("����");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		jButton3.setText("����");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		
		jButton4.setText("�浵");
		jButton4.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});
		
		javax.swing.GroupLayout layout=new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);//�õ�һ���յĴ�����壬���Խ��в���
		layout.setHorizontalGroup(				//ָ�����ֵ�ˮƽ�飨ȷ������� X�� �����ϵ�λ�ã�
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)//����������
				.addGroup(layout.createSequentialGroup()//���������鰴˳����ָ������ˮƽ/��ֱ���������Ԫ�ؽ� Group ��ӵ��� Group
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
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,32,Short.MAX_VALUE)//���һ����ʾ�������֮����ѡ��϶��Ԫ��
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
			if(new Choosedialog1("�����и��ŷ⣬�Ƿ�򿪣�").getI()==1) {
				new Textdialog("������ˣ��ʵ���Ի��������������ļ�԰���ڱ��Ⱥ�����������������ͷ�컨ľ������ǰ���з���Ӫ����ɱ����");
				new Textdialog("��ľ����������Ϣ�����װ������һ��ȡ������������ͷ����������");
				i=0;
			}
		}
	}
		private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
			if(i==2) {
				player.i=i;
				this.dispose();
			}
			else new Textdialog("������δ�����ţ��������߰�");
		}
		
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
			if(new Choosedialog1("			�Ƿ���Ҫ��Ϣ").getI()==1) {
				player.hpp=player.hp;
				player.mpp=player.mp;
				new Textdialog("����ʱ������");
				new Textdialog("�о������˳�����־");
				new Textdialog("׼����ϣ���ʽ������");
				i=2;
				
			}
		}
		private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
			if(new Choosedialog1("�Ƿ���Ҫ�浵��").getI()==1) {
				player.i=i;
				player.save();
				new Textdialog("�浵�ɹ�");
			}
		}
		
		private javax.swing.JButton jButton1;
		private javax.swing.JButton jButton2;
		private javax.swing.JButton jButton3;
		private javax.swing.JButton jButton4;
		private javax.swing.JLabel jLabel1;
		private javax.swing.JLabel jLabel2;

}
