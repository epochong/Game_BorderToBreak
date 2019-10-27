package BorderToBreak;


import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;

public class Monster extends Character{
	int serialnumber=1;
	int[] fallItems=new int[3];
	Image image;
	
	public Monster() {
		image=(new ImageIcon("./util/"+serialnumber+".png")).getImage();
	}
	public Monster(int serialnumber) {
		monsterParticular(serialnumber);
		image=(new ImageIcon("./util/"+serialnumber+".png")).getImage();
		
	}
	
	public void monsterParticular(int serialnumber) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(new FileInputStream("./util/Monster.txt"),"UTF-8"));
			/**BufferedReader input;
			FileReader reader=null;
			reader=new FileReader("./util/Monster.txt");
			input=new BufferedReader(reader);*/
			for(int i=0;i<serialnumber;i++)
				input.readLine();
			StringTokenizer intro = new StringTokenizer(input.readLine()," ");//逗号前为需要分开的字符，逗号后的为定界符
			serialnumber=Integer.parseInt(intro.nextToken());
			this.name=intro.nextToken();
			this.level=Integer.parseInt(intro.nextToken());
			this.strength = Integer.parseInt(intro.nextToken());
			this.intelligence=Integer.parseInt(intro.nextToken());
			this.speed=Integer.parseInt(intro.nextToken());
			for(int i=0;i<3;i++) fallItems[i]=Integer.parseInt(intro.nextToken());
			for(int i=0;i<3;i++) ski[i]=Integer.parseInt(intro.nextToken());
			attact=(int)(strength * 1.5);
			attactt=attact;
			hp=30 + strength * 4;
			hpp=hp;
			mp=20 + intelligence * 3;
			mpp=mp;
			defence = (int)((strength + speed) * 0.5 );    
            defencee = defence ;
            speedd=speed;
			//reader.close();
			input.close();
		}
		catch (FileNotFoundException ex) {
		}
		catch(IOException ex) {
			
		}
		getSkill();
	}
	public void getSkill() {
		for(int i=0;i<3;i++) {
			skill[i]=new Skill(ski[i]);
		}
	}
}
