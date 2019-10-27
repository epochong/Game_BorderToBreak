package BorderToBreak;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Equipment {
	String name;
	String definition;
	int attact;
	int serialnumber;
	int speed;
	int defence;
	int body;
	int price;
	
	public Equipment(int serialnumber) {
		equipmentParticular(serialnumber);
	}
	
	public void useEquipment(Player player,int i){
        
        player.attact-=player.equipment[body].attact;
        player.defence-=player.equipment[body].defence;
        player.speed-=player.equipment[body].speed;
        player.equipment[body].equipmentParticular(player.equip[i]);
        player.attact+=player.equipment[body].attact;
        player.defence+=player.equipment[body].defence;
        player.speed+=player.equipment[body].speed;
        player.equip[body]=player.equip[i];
        
     }
	public void equipmentParticular(int serialnumber){
        try{
        	BufferedReader input=new BufferedReader(new InputStreamReader(new FileInputStream("./util/Equipment.txt"),"UTF-8"));
             /**BufferedReader input;
             FileReader reader=null;
             reader = new FileReader("./util/Equipment.txt");
             input=new BufferedReader(reader);*/
             for(int i=0;i<serialnumber;i++){input.readLine();}
             StringTokenizer intro = new StringTokenizer(input.readLine()," ");
             intro.nextToken();
             name = intro.nextToken();
             attact = Integer.parseInt(intro.nextToken());
             defence=Integer.parseInt(intro.nextToken());
             speed=Integer.parseInt(intro.nextToken());
             body = Integer.parseInt(intro.nextToken());
             price = Integer.parseInt(intro.nextToken());
             definition = intro.nextToken();
             //reader.close();
             input.close(); 
              }catch (FileNotFoundException ex) {
              }catch (IOException ex) {}
              this.serialnumber = serialnumber ;
}
    
}
