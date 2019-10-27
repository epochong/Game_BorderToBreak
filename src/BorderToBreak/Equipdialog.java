package BorderToBreak;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class Equipdialog extends javax.swing.JDialog{
	Equipment[] equipment;
	Player player;
	
	public Equipdialog(Player player) {
		this.player=player;
		equipment=new Equipment[4];
		equipment[0]=new Equipment(2);
		equipment[1]=new Equipment(3);
		equipment[2]=new Equipment(4);
		equipment[3]=new Equipment(5);
		initComponents();
		
		this.setLocation(250, 100);
        this.setTitle("武器店");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setModal(true);
        this.setVisible(true);
	}
	
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponents() {
		 jLabel1 = new javax.swing.JLabel();
		 ImageIcon icon = new ImageIcon("./util/武器店.png");
		 jLabel2 = new javax.swing.JLabel("" , icon , SwingConstants.CENTER );
		 jLabel3 = new javax.swing.JLabel();
		 jScrollPane1 = new javax.swing.JScrollPane();
	     jList1 = new javax.swing.JList<String>();
	     jButton1 = new javax.swing.JButton();
	     jButton2 = new javax.swing.JButton();
	     jScrollPane2 = new javax.swing.JScrollPane();
	     jTextArea1 = new javax.swing.JTextArea();

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

	        jLabel1.setFont(new java.awt.Font("楷体_GB2312", 1, 24));
	        jLabel1.setText("              武器店");

	        jLabel2.setText(null);

	        jLabel3.setText("    物品名单");

	        jList1.setModel(new javax.swing.AbstractListModel() {
	            String[] strings = {equipment[0].name, equipment[1].name, equipment[2].name};
	            public int getSize() { return strings.length; }
	            public Object getElementAt(int i) { 
	            	return strings[i]; 
	            	}
	        });
	        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
	            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
	                jList1ValueChanged(evt);
	            }
	        });
	        jScrollPane1.setViewportView(jList1);

	        jButton1.setText("离开");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        jButton2.setText("购买");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });

	        jTextArea1.setColumns(20);
	        jTextArea1.setRows(5);
	        jScrollPane2.setViewportView(jTextArea1);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(100, 100, 100)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabel3)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(10, 10, 10)
	                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(80, 80, 80)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)))
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(50, 50, 50)
	                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(107, 107, 107)
	                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap(47, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(35, 35, 35)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jLabel3)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jButton1)
	                                .addGap(43, 43, 43)
	                                .addComponent(jButton2)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
	                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))))
	                .addGap(72, 72, 72))
	        );

	        pack();
	    }
	 
	 private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {

		    if(jList1.getSelectedIndex()==-1)return;
		    jTextArea1.setText(equipment[jList1.getSelectedIndex()].definition+"\n"
		            +"加攻击力"+equipment[jList1.getSelectedIndex()].attact+"\n"
		            +"加防御力"+player.equipment[jList1.getSelectedIndex()].defence+"\n"
	                +"加速度"+player.equipment[jList1.getSelectedIndex()].speed);
		}
	 private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		    this.dispose();
		}
	 
	 private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		      Choosedialog1 choose =  new Choosedialog1("您的经济现在有"+player.money+" 。  该物品价格是 "+equipment[jList1.getSelectedIndex()].price +"您是否要买？");
		      if(choose.getI()==1){
		          if(player.money>=equipment[jList1.getSelectedIndex()].price){
		              player.money-=equipment[jList1.getSelectedIndex()].price;
		              player.newEquip(equipment[jList1.getSelectedIndex()].serialnumber);
		              new Textdialog("购买成功！谢谢。");
		          }
		          else{new Textdialog("你的经济不足,无法购买");}
		      }
		}
	 private javax.swing.JButton jButton1;
	 private javax.swing.JButton jButton2;
	 private javax.swing.JLabel jLabel1;
	 private javax.swing.JLabel jLabel2;
	 private javax.swing.JLabel jLabel3;
	 private javax.swing.JList<String> jList1;
	 private javax.swing.JScrollPane jScrollPane1;
	 private javax.swing.JScrollPane jScrollPane2;
	 private javax.swing.JTextArea jTextArea1;

}
