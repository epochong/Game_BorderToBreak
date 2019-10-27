package BorderToBreak;



public class incident {
	//3个不同遇敌概率
    public static Monster getMonter(){
        Monster monster = new Monster((int)(Math.random()*31+1));
        return monster;
    }
}
