package BorderToBreak;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Item {
	String name;
	String definition;
	int hp;
	int mp;
	int serialNumber;
	int price;
	
	public Item() {
		
	}
	public Item(int serialNumber) {
		getItem(serialNumber);
	}
	
	public void setItem(int serialNumber) {
		
	}
	
	public void getItem(int serialNumber) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(new FileInputStream("./util/Item.txt"),"UTF-8"));
			/**BufferedReader input;
			FileReader reader =null;
			reader =new FileReader("./util/Item.txt");
			input=new BufferedReader(reader);*/
			for(int i=0;i<serialNumber;i++)
				input.readLine();
			StringTokenizer intro=new StringTokenizer(input.readLine()," ");
			intro.nextToken();
			name=intro.nextToken();
			hp=Integer.parseInt(intro.nextToken());
			mp=Integer.parseInt(intro.nextToken());
			price=Integer.parseInt(intro.nextToken());
			definition=intro.nextToken();
			
			input.close();
		}catch(FileNotFoundException ex) {
		}catch(IOException ex) {}
		this.serialNumber=serialNumber;
	}
	
	public void useItem(Player player) {
		if(player.hpp<=0) {
			new Textdialog("体力不支回去休息吧！");
			return;
			
		}
		player.hpp+=this.hp;
		if(player.hpp>player.hp)player.hpp=player.hp;
		player.mpp+=this.mp;
		if(player.mpp>player.mp)player.mpp=player.mp;
		if(player.hpp<0)player.hpp=0;
		if(player.mpp<0)player.mpp=0;
		serialNumber=1;
		getItem(1);
	}
}
