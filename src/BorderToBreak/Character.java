package BorderToBreak;


import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * ʹ�ü��ܻ�����ħ��ֵ��ħ��ֵΪ0ʱ�ͷŲ��˼��ܣ�ֻ���չ�
 * */
public class Character {
	Image image=(new ImageIcon("./util/����ͷ��.png")).getImage();
	//״ֵ̬
	String name;
	int level;//�ȼ�
	int attact;//������
	int attactt;
	int strength;//����
	int intelligence;
	int speed;
	int speedd;
	int defence;
	int defencee;
	int hp;//����ֵ
	int hpp;//��ǰ״̬����ֵ
	int mpp;//��ǰ״̬ħ��ֵ
	int mp;//ħ��ֵ
	int money;//����
	
	//����
	int[] ski=new int[3];
	Skill[] skill=new Skill[3];
	//װ��
	int[] equip=new int[6];
	Equipment[] equipment =new Equipment[6];
	int[] ite=new int[20];
	Item[] item=new Item[30];
	
	int state;
	
	public Character() {
		
	}
	
	public Character(String name,int level) {
		this.level=level;
		this.name=name;
		strength = 10+level*3;
		intelligence=5+level*2;
		speed=5+level*2;
		attact=(int)(strength*1.5);
		attactt=attact;
		hp=30+strength*4;
		mp=20+intelligence*3;
		hpp=hp;
		mpp=mp;
		defence=(int)((strength+speed)*0.5);
		defencee=defence;
		getSkill();
		getEquipment();
	}
	//���ļ��л�ȡ������ļ���
	public void getSkill() {
		ski[0]=2;
		skill[0]=new Skill(ski[0]);
		for(int i=1;i<3;i++)
		{
			ski[i]=1;
			skill[i]=new Skill(ski[i]);
		}
	}
	
	 public void getEquipment(){ //���ļ��л�ø������װ��
         for(int i = 0; i < 6 ; i++){
           equip[i]=1;
           equipment[i] = new Equipment(equip[i]);
         
  }
 }  
	 public void getItem() {
		 for(int i=0;i<20;i++) {
			 ite[i]=1;
			 item[i]=new Item(ite[i]);
		 }
	 }
}
