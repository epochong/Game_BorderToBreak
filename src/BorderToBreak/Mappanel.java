package BorderToBreak;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

//��ͼ��
public class Mappanel extends JPanel implements KeyListener{
	int m=(int)(Math.random()*10+5);//�������˵Ĳ���
	int[][] map=new int[20][20];//��ͼ����
	String face="��";//����ķ���
	
	int mapnumber=0;//��ͼ���
	int nextright=1;//����һ�ŵ�ͼ�����ļ�λ��
	int nextleft=1;//����һ�ŵ�ͼ�����ļ�λ��
	int nextup=1;//����һ�ŵ�ͼ�����ļ�λ��
	int nextdown=1;//����һ�ŵ�ͼ�����ļ�λ��
	
	Image image  = (new ImageIcon("./util/"+"����"+face+".png")).getImage();
	Image image0 = (new ImageIcon("./util/�ݵ�.png")).getImage();
    Image image1 = (new ImageIcon("./util/��ľ.png")).getImage();
    Image image2 = (new ImageIcon("./util/����.png")).getImage();
    Image image3 = (new ImageIcon("./util/ʯͷ.png")).getImage();
    Image image4 = (new ImageIcon("./util/����2.png")).getImage();
    Image image5 = (new ImageIcon("./util/����.png")).getImage();
    Image image6 = (new ImageIcon("./util/ʯ��.png")).getImage();
    Image image7 = (new ImageIcon("./util/����.png")).getImage();
    Image image8 = (new ImageIcon("./util/դ��.png")).getImage();
    Image image10 = (new ImageIcon("./util/����.png")).getImage();
    
    int x=1,y=11;//����ͼ�������
    
    Statepanel statepanel;
    Player player;
    
    public Mappanel(Statepanel statepanel,Player player) {
    	this.player=player;
    	x=player.x;
    	y=player.y;
    	mapnumber=player.mapnumber;
    	map=this.getMap(player.mapnumber);
    	
    	setLocation();//ȷ����������
    	this.statepanel=statepanel;
    	this.setBounds(0,0,600,600);//���ô��ڴ�С
    	
    }
    
    public void paintComponent(Graphics g) {
    	for(int i = 0 ; i < 20 ; i++)
            for(int j = 0 ;j < 20 ; j++)
                switch(map[i][j]){
                    case 0 : g.drawImage(image0, i*30, j*30, this);break;//���ص�ͼ��,���ϽǺ����꣬�ң����½������꣬�ң�����
                    case 1 : g.drawImage(image1, i*30, j*30, this);break;
                    case 2 : g.drawImage(image2, i*30, j*30, this);break;
                    case 3 : g.drawImage(image3, i*30, j*30, this);break;
                    case 4 : g.drawImage(image4, i*30, j*30, this);break;
                    case 5 : g.drawImage(image5, i*30, j*30, this);break;
                    case 6 : g.drawImage(image6, i*30, j*30, this);break;
                    case 7 : g.drawImage(image7, i*30, j*30, this);break;
                    case 8 : g.drawImage(image8, i*30, j*30, this);break;
                    case 10 : g.drawImage(image10, i*30, j*30, this);break;
                }
    	g.drawImage(image,x*image.getWidth(this),y*(image.getHeight(this)-30)-30,this);
    }


	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
        case KeyEvent.VK_DOWN:
        	y++;
        	if(y*(image.getHeight(this)-30)>570){
                   if(nextdown!=0){
                	   y-=20;
                	   face = "��";
                	   image = (new ImageIcon("./util/"+"����"+face+".png")).getImage();
                	   map = this.getMap(nextdown);
                	   }//����ͼ
                   else y--;
                }
        	else if(map[x][y]!=0&&map[x][y]!=5&&map[x][y]!=6&&map[x][y]!=10) {
        		y--; break;
        		}
        	else {
        		m--;
        		face = "��";
        		image = (new ImageIcon("./util/"+"����"+face+".png")).getImage();
        		}
        	if( m == 0) {
        		this.repaint();
        		m = (int)(Math.random()*10+15);
        		Fightdialog fight =  new Fightdialog(player);
        		statepanel.repaint();
        		break;
        		}
        	break;
        	case KeyEvent.VK_UP: 
                y--; if(y<0){
                    if(nextup!=0) {y+=20; face ="��"; image = (new ImageIcon("./util/"+"����"+face+".png")).getImage(); map = this.getMap(nextup);}//����ͼ
                    else y++;
                }
                else if(map[x][y]!=0&&map[x][y]!=5&&map[x][y]!=6&&map[x][y]!=10) {
                	y++;
                	break;
                	} 
                else {
                	m--;
                	face = "��"; 
                	image = (new ImageIcon("./util/"+"����"+face+".png")).getImage();
                	}  
                if( m == 0) {
                	this.repaint();
                	m = (int)(Math.random()*10+15); 
                	Fightdialog fight =  new Fightdialog(player);
                	statepanel.repaint(); 
                	break;
                	}
                break;
                
                case KeyEvent.VK_RIGHT: 
                	x++;
                	if(x*image.getWidth(this)>570){
                		if(nextright!=0){
                			x-=20;
                			face = "��";
                			image = (new ImageIcon("./util/"+"����"+face+".png")).getImage();
                			map = this.getMap(nextright);
                			}//����ͼ
                		else x--;
                }
                else if(map[x][y]!=0&&map[x][y]!=5&&map[x][y]!=6&&map[x][y]!=10) {
                	x--;  
                	break;
                	}
                else {
                	m--;
                	face = "��";
                	image = (new ImageIcon("./util/"+"����"+face+".png")).getImage();
                	}    
                if( m == 0) {
                	this.repaint();
                	m = (int)(Math.random()*10+15);
                	Fightdialog fight =  new Fightdialog(player);
                	statepanel.repaint();
                	break;
                	}
                break;
                
                case KeyEvent.VK_LEFT:
                x--; if(x<0){
                    if(nextleft!=0) {
                    	x+=20; 
                    	face = "��"; 
                    	image = (new ImageIcon("./util/"+"����"+face+".png")).getImage();
                    	map = this.getMap(nextleft);
                    	}//����ͼ
                    else x++;
                }
                else if(map[x][y]!=0&&map[x][y]!=5&&map[x][y]!=6&&map[x][y]!=10) {
                	x++;  
                	break;
                	}
                else {
                	m--;
                	face = "��";
                	image = (new ImageIcon("./util/"+"����"+face+".png")).getImage();
                	}   
                if( m == 0) {
                	this.repaint();
                	m = (int)(Math.random()*10+15);
                	Fightdialog fight =  new Fightdialog(player);
                	statepanel.repaint(); 
                break;
                }
                break;
                
                case KeyEvent.VK_ENTER: setEnter();
                
        }
        
        setLocation();
        this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void setEnter() {
    	System.out.println(player.j);
    	switch(map[x][y]) {
    	case 10:player.newEquip((int)(Math.random()*5+1));map[x][y]=0;break;//�򿪱���
    	case 5:System.out.println(this.mapnumber);
    	if(this.mapnumber==4)new countydialog(player);statepanel.repaint();//������
    	if(this.mapnumber==1)new Homedialog(player);statepanel.repaint();//Ȫˮ
    	if(this.mapnumber==8) new Bigbossdialog(player);statepanel.repaint();//����
    	break;
    	case 0:
    		new Statedialog(player);statepanel.repaint();break;
    	case 6:			//ʯ��ָ·
    		if(mapnumber==1) {
    			new Textdialog("���ߣ�����");break;
    		}
    		if(mapnumber==3) {
    			new Textdialog("�������߾ͻ���뱻�о����Ƶķ�Χ�ˣ����С��");break;
    		}
    	}
    }
   
    public void setLocation(){
        this.player.x = x;
        this.player.y = y;
        this.player.mapnumber = mapnumber;
    }
    
    public  int[][] getMap(int i) {//�õ���һ�ŵ�ͼ�ķ���
        int[][] maps = new int[20][20];
        int n = 1;
        BufferedReader reader;
        
     try {
         reader = new BufferedReader(new FileReader("./util/map.txt"));
    
        String stringmap = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(stringmap);
        
        while(!stringmap.equals("")){
        if(i==Integer.parseInt(tokenizer.nextToken())){n=0;break;}
        stringmap = reader.readLine();
        tokenizer = new StringTokenizer(stringmap);
        }
        try {
         reader.close();
     } catch (IOException ex) {
         Logger.getLogger(Mappanel.class.getName()).log(Level.SEVERE, null, ex);
     }
        
        if(n == 0){
            mapnumber = i;
            nextup = Integer.parseInt(tokenizer.nextToken());
            nextdown = Integer.parseInt(tokenizer.nextToken());
            nextleft = Integer.parseInt(tokenizer.nextToken());
            nextright = Integer.parseInt(tokenizer.nextToken());
                 for(int w = 0 ; w < 20 ; w++)
                    for(int j = 0 ;j < 20 ; j++){
                        maps[j][w] = Integer.parseInt(tokenizer.nextToken());
                    }
            
        return  maps;
        }
        else {
            for(int w = 0 ; w < 20 ; w++)
                    for(int j = 0 ;j < 20 ; j++)
                        maps[j][w] = 0;
            return maps;
        }
        
    }
            catch (FileNotFoundException ex) {
         Logger.getLogger(Mappanel.class.getName()).log(Level.SEVERE, null, ex);
     }
     catch (IOException ex) {
         Logger.getLogger(Mappanel.class.getName()).log(Level.SEVERE, null, ex);
     } 
     for(int w = 0 ; w < 20 ; w++)
                    for(int j = 0 ;j < 20 ; j++)
                        maps[j][w] = 0;
            return maps;
         
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



 }

