package BorderToBreak;


import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * 使用技能会消耗魔法值，魔法值为0时释放不了技能，只能普攻
 * */
public class Character {
	Image image=(new ImageIcon("./util/主角头像.png")).getImage();
	//状态值
	String name;
	int level;//等级
	int attact;//攻击力
	int attactt;
	int strength;//力量
	int intelligence;
	int speed;
	int speedd;
	int defence;
	int defencee;
	int hp;//生命值
	int hpp;//当前状态生命值
	int mpp;//当前状态魔法值
	int mp;//魔法值
	int money;//经济
	
	//技能
	int[] ski=new int[3];
	Skill[] skill=new Skill[3];
	//装备
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
	//从文件中获取该生物的技能
	public void getSkill() {
		ski[0]=2;
		skill[0]=new Skill(ski[0]);
		for(int i=1;i<3;i++)
		{
			ski[i]=1;
			skill[i]=new Skill(ski[i]);
		}
	}
	
	 public void getEquipment(){ //从文件中获得该人物的装备
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
