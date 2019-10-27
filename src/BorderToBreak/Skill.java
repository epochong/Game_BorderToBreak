package BorderToBreak;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Skill {
	int serialnumber;
	String defi;
	String definition;
	String definitionhpp;
	String definitionmpp;
	String definitionspeedd;
	String definitiondefencee;
	String definitionattactt;
	String name;
	int hpp;
	int mpp;
	int attactt;
	int defencee;
	int speedd;
	int area;
	
	public Skill(int serialnumber) {
		skillParticular(serialnumber);
	}
	
	//���ļ��л�ȡ������Ϣ
	public void skillParticular(int serialnumber) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(new FileInputStream("./util/Skill.txt"),"UTF-8"));
			/**BufferedReader input;
			FileReader reader=null;
			reader =new FileReader("./util/Skill.txt");
			input = new BufferedReader(reader);*/
			for(int i=0;i<serialnumber;i++)input.readLine();
			
			StringTokenizer intro=new StringTokenizer(input.readLine());
			intro.nextToken();
			area=Integer.parseInt(intro.nextToken());
			name=intro.nextToken();
			hpp=Integer.parseInt(intro.nextToken());
			mpp=Integer.parseInt(intro.nextToken());
			speedd=Integer.parseInt(intro.nextToken());
			attactt=Integer.parseInt(intro.nextToken());
			defencee=Integer.parseInt(intro.nextToken());
			defi=intro.nextToken();
			//reader.close();
			input.close();
			}
		catch (FileNotFoundException ex) {
		}
		catch(IOException ex) {}
	}
	
	//������ܼ���
	public void Drawme(Monster monster,Player player) {
		monster.attact+=this.attactt;
		if(attactt<0)
			definitionattactt="����������"+this.attactt+"\n";
		else if(attactt>0)
			definitionattactt="����������"+this.attactt+"\n";
		else definitionattactt="";
		monster.defencee=this.defencee;
		
		if(defencee<0)
			definitiondefencee="��������С"+this.attactt+"\n";
		else if(defencee>0)
			definitiondefencee="����������"+this.attactt+"\n";
		else
			definitiondefencee="";
		
		if(hpp<0) {
			int temp=(int)(hpp*(Math.random()+0.5));
			monster.hpp+=temp;
			definitionhpp="HP����"+temp+"\n";
		}
		else if(hpp>0) {
			int temp=(int)(hpp*(Math.random()+0.5));
			monster.hpp+=temp;
			definitionhpp="HP�ָ�"+temp+"\n";
		}
		else
			definitionhpp="";
		
		player.mpp-=this.mpp ;
        if(mpp>0)
        	definitionmpp = "����MP  "+this.mpp + "\n";
        monster.speedd+=this.speedd;
        if(speedd<0)
        	definitionspeedd="�ٶȽ���"+this.attactt+"\n";
        else if(speedd>0)
        	definitionspeedd="�ٶ�����"+this.attactt+"\n";
        else
        	definitionspeedd="";
        definition = definitionattactt+"  "+definitiondefencee+" "+definitionspeedd+" "+  definitionhpp +"  "+ definitionmpp;
	}
	
	public void useSkill(Monster monster,Player player) {
		if(player.mpp<=mpp)
		{
			new Textdialog("ħ�����㣬��Ĺ�����Ч");
			definition="��Ч��";
			return;
		}
		Drawme(monster,player);
	}
	public void useSkill(Monster monster1,Monster monster2,Player player) {
		if(player.mpp<=mpp*2) {
			new Textdialog("ħ�����㣬��Ĺ�����Ч");
			definition="��Ч��";
			return;
		}
		Drawme(monster1,player);
		Drawme(monster2,player);
	}
	public void useSkill(Monster monster1,Monster monster2,Monster monster3,Player player) {
		if(player.mpp<=mpp*3) {
			new Textdialog("ħ�����㣬��Ĺ������");
			definition="��Ч��";
			return;
		}
		Drawme(monster1,player);
		Drawme(monster2,player);
		Drawme(monster3,player);
	}
	
	public void miss() {
		
	}
	
	//������ܼ���
	public void Drawme(Player player,Monster monster) {
		if(monster.mpp<mpp) {
			definition="��Ч��";
			return;
		}
		player.attact+=this.attactt;
		if(attactt<0)
			definitionattactt="����������"+this.attactt+"\n";
		else if(attactt>0)
			definitionattactt = "����������  "+this.attactt + "\n";
        else definitionattactt = "";
		player.defencee=this.defencee;
		
		if(defencee<0)
			definitiondefencee="��������С"+this.attactt+"\n";
		else if(defencee>0)
			definitiondefencee="����������"+this.attactt+"\n";
		else
			definitiondefencee="";
		if(hpp<0){
			int temp =(int)(hpp*(Math.random()+0.5));
		player.hpp+=temp;definitionhpp = "HP����  "+ temp + "\n"; 
		}
        else if(hpp>0)
        {
        	int temp =(int)(hpp*(Math.random()+0.5));
        	player.hpp+=temp;
        	definitionhpp = "HP�ָ�  "+ temp + "\n";
        	}
        else definitionhpp = "";
        monster.mpp-= this.mpp ;
        if(mpp<0)
        	definitionmpp = "����MP  "+this.mpp + "\n";
        player.speedd+=this.speedd;
        if(speedd<0)
        	definitionspeedd="�ٶȽ���"+this.attactt+"\n";
        else if(speedd>0)
        	definitionspeedd="�ٶ�����"+this.attactt+"\n";
        else
        	definitionspeedd="";
        definition = definitionattactt+"  "+definitiondefencee+" "+definitionspeedd+" "+  definitionhpp +"  "+ definitionmpp;
	}
	public void useSkill(Player player, Monster monster){
        Drawme(player,monster);
    }
    public void useSkill(Player player1,Player player2,Monster monster){
        Drawme(player1,monster);Drawme(player2,monster);
    }
    public void useSkill(Player player1,Player player2,Player player3,Monster monster){
        Drawme(player1,monster);Drawme(player2,monster);Drawme(player3,monster);
    }

}
