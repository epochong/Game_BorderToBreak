package BorderToBreak;


import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


public class countydialog extends javax.swing.JDialog{
	
	Player player=null;
	public countydialog(Player player) {
		this.player=player;
		initComponents();
		
		this.setBounds(300, 50, 600, 700);
        this.setTitle("城镇画面");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setModal(true);
        this.setVisible(true);
	}
	
	private void initComponents() {
		javax.swing.JButton show = new javax.swing.JButton();
		javax.swing.JButton jButton2 = new javax.swing.JButton();
		javax.swing.JButton jButton3 = new javax.swing.JButton();
		javax.swing.JButton jButton4 = new javax.swing.JButton();
		javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JButton jButton5 = new javax.swing.JButton();
        javax.swing.JButton jButton6 = new javax.swing.JButton();
        javax.swing.JButton jButton7 = new javax.swing.JButton();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel("" , new ImageIcon("./util/长安.png") , SwingConstants.CENTER);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        
        show.setText("城镇概况");
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });
        
        jButton2.setText("万达客栈");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        
        jLabel1.setText("长安");
        
        jButton3.setText("武器店");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        
        jButton7.setText("药店");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        
        jButton4.setText("寺庙");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        
        jButton5.setText("独孤信墓");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        
        jButton6.setText("离开");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(show, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton2, jButton3, jButton4, jButton5, jButton7,jButton6, show});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(show)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)))
                .addGap(107, 107, 107))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, show});

        pack();
	}
	
	private void showActionPerformed(java.awt.event.ActionEvent evt) {
		new Filedialog();
	}
	
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		Choosedialog1 choose=new Choosedialog1(player) ;
		if(choose.getI()==1) {
			if(player.money-10<0) {
				new Textdialog("		客官，您的钱不够住宿，不好意思。");
				
				return ;
			}
			else {
				player.money-=10;
				player.hpp=player.hp;
				player.mpp=player.mp;
				player.attactt=player.attact;
				player.defencee=player.defence;
				player.speedd=player.speed;
				new Textdialog("		第二日");
				new Textdialog("	客官，对我们的服务还满意吗，期待您的下次光临");
				return ;
				
			}
		}
	}
	
	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}
	
	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		Choosedialog1 choose = new Choosedialog1();
		if(choose.getI()==1) {
			player.money-=50;
			if(player.money<10)player.money=10;
			new Textdialog("您损失50个经济点用于存档");
			player.save();
			new Textdialog("存档成功");
		}
	}
	
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		new Equipdialog(player);
	}
	
	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		new Itemdialog(player);
	}
	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		new Textdialog("小沙僧：这位施主，一直往上走，你会有所收获的");
		
	}
	
	 private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JButton jButton4;
	    private javax.swing.JButton jButton5;
	    private javax.swing.JButton jButton6;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JButton show;
}
