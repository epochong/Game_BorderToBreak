package BorderToBreak;

public class Battle {
	String definition;
	String definition2=" ";
	
	int aim;//判断被攻击的怪物
	//初始化属性值
	public void battleBegin(Player player) {
		player.attactt=player.attact;
		player.defencee=player.defencee;
		player.speedd=player.speedd;
		player.state=0;
	}
	//结束后获得经验值和钱
	
	public void getExp(Monster monster,Monster monster2,Monster monster3,Player player) {
		int temp=(int)((monster.strength+monster.intelligence+monster.speed
				+monster2.strength+monster2.intelligence+monster2.speed
				+monster3.strength+monster3.intelligence+monster3.speed)*(Math.random()+0.5));
		player.xpp+=temp;
		int temp2=(int)((monster.strength+monster.intelligence+monster.speed
				+monster2.strength+monster2.intelligence+monster2.speed
				+monster3.strength+monster3.intelligence+monster3.speed)*(Math.random()+0.5));
		player.money+=temp2;
		new Textdialog(player.name + "获得经验" +temp+ "获得经济"+temp2);
	}
	public void getExp(Monster monster,Monster monster2,Player player) {
		int temp=(int)((monster.strength+monster.intelligence+monster.speed
				+monster2.strength+monster2.intelligence+monster2.speed)*(Math.random()+0.5));
		player.xpp+=temp;
		int temp2=(int)((monster.strength+monster.intelligence+monster.speed
				+monster2.strength+monster2.intelligence+monster2.speed)*(Math.random()+0.5));
		player.money+=temp2;
		new Textdialog(player.name + "获得经验" +temp+ "获得经济"+temp2);
	}
	public void getExp(Monster monster,Player player) {
		int temp=(int)((monster.strength+monster.intelligence+monster.speed)*(Math.random()+0.5));
		player.xpp+=temp;
		int temp2=(int)((monster.strength+monster.intelligence+monster.speed)*(Math.random()+0.5));
		player.money+=temp2;
		new Textdialog(player.name + "获得经验" +temp+ "获得经济"+temp2);
	}
	
	//判断战斗是否结束
	//判断角色生命值
	public int checkBattle(Player player,Player player2,Player player3){
        if(player.hpp==0&&player2.hpp==0&&player3.hpp==0)return 1;
        else return 0;   
   }
    public int checkBattle(Player player,Player player2){
        if(player.hpp==0&&player2.hpp==0)return 1;
        else return 0;   
   }
    public int checkBattle(Player player){
        if(player.hpp==0)return 1;
        else return 0;   
   }
    //判断敌人生命值
    public int checkBattle(Monster player,Monster player2,Monster player3){
        if(player.hpp==0&&player2.hpp==0&&player3.hpp==0)return 1;
        else return 0;   
   }
    public int checkBattle(Monster player,Monster player2){
        if(player.hpp==0&&player2.hpp==0)return 1;
        else return 0;   
   }
    public int checkBattle(Monster player){
        if(player.hpp==0)return 1;
        else return 0;   
   }
    
    //判断是否还有攻击的能力
    //通过魔法值来判断
    public int checkAction(Player player){
        if(player.hpp==0)return 1;
        return 0;
    }
     public int checkAction(Monster monster){
        if(monster.hpp==0)return 1;
        return 0;
    }
     //判断敌人是否被打倒
     public int checkHp(Player player){
         if(player.hpp<=0) {
             player.hpp = 0 ;
             definition2 = player.name + "体力不支退出战斗\n"; 
             new Textdialog(definition2);
             return 1;
         }
         else definition2="";return 0;
     }
     
     public int checkHp(Monster monster){
         if(monster.hpp <=0) {
             monster.hpp = 0 ;
             definition2 = monster.name + "被你打倒了\n";
             new Textdialog(definition2);
             return 1;
         }
         else definition2="";return 0;
     }
   //人物普攻 可能被怪物回避
     public void attracts(Player player,Monster monster){
         if(checkAction(player)==1){ new Textdialog("体力不支，快逃跑吧！");return ;}
        double temp=player.speedd-monster.speedd;
         if(temp <0&& Math.random()<0.7){ definition = monster.name+"躲避了"+player.name+"的攻击\n";
           new Textdialog(definition);return; 
         }
         if(temp >=0&& Math.random()>0.7){ definition = monster.name+"躲避了"+player.name+"的攻击\n";
           new Textdialog(definition);return;
         }
         int tmp = (int)(monster.attactt*1.5*(Math.random()+0.5)-player.defencee);
         if(tmp<=0)
        	 tmp=1;
         monster.hpp -= tmp;
         //new Music("攻击.au");
         definition = player.name + "对"+monster.name+"造成了  " + tmp +"  点伤害\n";
         
         new Textdialog(definition);    
          checkHp(monster);
     }
     //怪物攻击计算公式
     public void attracts(Monster monster , Player player){
         if(checkAction(monster)==1) return ;
        double temp=monster.speedd=player.speedd;
        
         if(temp <0&& Math.random()<0.7){ definition = player.name+"躲避了"+monster.name+"的攻击\n";
             new Textdialog(definition);return;
         }
         if(temp >=0&& Math.random()>0.7){ definition = player.name+"躲避了"+monster.name+"的攻击\n";
             new Textdialog(definition);return;
         }
         int tmp = (int)(monster.attact*1.5*(Math.random()+0.5)-monster.defencee);
         if(tmp<=0)
        	 tmp=1;
         player.hpp -= tmp;
         //new Music("攻击.au");
         definition = monster.name + "对"+player.name+"造成了  " + tmp +"  点伤害\n";
         new Textdialog(definition); 
         checkHp(player);
     } 
     //人物释放技能
     public void useskill(Skill skill ,Player player, Monster monster1 , int i){
         if(checkAction(player)==1) return ;
        if(skill.area==0){
          switch(i){
          case 1: skill.useSkill(monster1,player);definition = player.name + "使用" +skill.name + "  对"+ monster1.name+ "造成了:  "+skill.definition  ;break;
          
      }   
         new Textdialog(definition);
         checkHp(monster1);
          
       }
       if(skill.area==1){
        skill.useSkill(monster1, player);definition = player.name + "使用" +skill.name + "  对"+ monster1.name +"造成了:  " +skill.definition;
        new Textdialog(definition);
        checkHp(monster1);
        
       }
   }
     public void useskill(Skill skill ,Player player, Monster monster1 ,Monster monster2, int i){
         if(checkAction(player)==1) return ;
         if(skill.area==0){
             switch(i){
             case 1: skill.useSkill(monster1,player);definition = player.name + "使用" +skill.name + "  对"+ monster1.name +"造成了:  "+skill.definition  ;break;
             case 2: skill.useSkill(monster2,player);definition = player.name + "使用" +skill.name + "  对"+ monster2.name +"造成了:  "+skill.definition  ;break;
         }   
            new Textdialog(definition);
            checkHp(monster1);
            checkHp(monster2); 
          }
          if(skill.area==1){
           skill.useSkill(monster1, monster2, player);definition = player.name + "使用" +skill.name + "  对"+ monster1.name +"造成了:  " +skill.definition+ "  对"+ monster2.name +"造成了:  "+skill.definition ;
           new Textdialog(definition);
           checkHp(monster1);
           checkHp(monster2);
          }
     }
     public void useskill(Skill skill ,Player player, Monster monster1 ,Monster monster2 ,Monster monster3,int i){
         if(checkAction(player)==1) return ;
       if(skill.area==0){
             switch(i){
             case 1: skill.useSkill(monster1,player);definition = player.name + "使用" +skill.name + "  对"+ monster1.name +"造成了:  "+skill.definition  ;break;
             case 2: skill.useSkill(monster2,player);definition = player.name + "使用" +skill.name + "  对"+ monster2.name +"造成了:  "+skill.definition  ;break;
             case 3: skill.useSkill(monster3,player);definition = player.name + "使用" +skill.name + "  对"+ monster3.name +"造成了:  "+skill.definition  ;break;
         }    
        new Textdialog(definition);
        checkHp(monster1);
        checkHp(monster2);
        checkHp(monster3);
       }
       if(skill.area==1){
           skill.useSkill(monster1, monster2, monster3,player);definition = player.name + "使用" +skill.name + "  对"+ monster1.name +"造成了:  " +skill.definition+ "  对"+ monster2.name +"造成了:  " +skill.definition+ "  对"+ monster3.name +"造成了:  "+skill.definition;
        new Textdialog(definition);
        checkHp(monster1);
        checkHp(monster2);
        checkHp(monster3);
       }
     }
     //怪物释放技能
     public void useskill(Skill skill , Monster monster , Player player1 ,int i){
         if(checkAction(monster)==1) return ;
      if(skill.area==0){
        switch(i){
          case 1: skill.useSkill(player1,monster);definition = monster.name + "使用" +skill.name + "  对"+ player1.name +"造成了:  "+skill.definition  ;break;
          
        }     
       new Textdialog(definition);
       checkHp(player1);
    
      }
      if(skill.area==1){
          skill.useSkill(player1, monster);definition = monster.name + "使用" +skill.name + "  对"+ player1.name +"造成了:  " +skill.definition;
         
       new Textdialog(definition);
       checkHp(player1);
      
      }  
    
}
      public void useskill(Skill skill , Monster monster , Player player1 ,Player player2 ,Player player3,int i){
          if(checkAction(monster)==1) return ;
      if(skill.area==0){
        switch(i){
          case 1: skill.useSkill(player1,monster);definition = monster.name + "使用" +skill.name + "  对"+ player1.name +"造成了:  "+skill.definition  ;break;
          case 2: skill.useSkill(player2,monster);definition = monster.name + "使用" +skill.name + "  对"+ player2.name +"造成了:  "+skill.definition  ;break;
          case 3: skill.useSkill(player3,monster);definition = monster.name + "使用" +skill.name + "  对"+ player3.name +"造成了:  "+skill.definition  ;break;
        }     
       new Textdialog(definition);
       checkHp(player1);
       checkHp(player2);
       checkHp(player3);
      }
      if(skill.area==1){
          skill.useSkill(player1, player2, player3,monster);definition = monster.name + "使用" +skill.name + "  对"+ player1.name +"   造成了:    " +skill.definition+ "  对"+ player2.name +"造成了:  "+skill.definition + "  对"+ player3.name +"造成了:  "+skill.definition;
         
       new Textdialog(definition);
       checkHp(player1);
       checkHp(player2);
       checkHp(player3);
      }  
    
}
    public void useskill(Skill skill , Monster monster , Player player1 ,Player player2 ,int i){
        if(checkAction(monster)==1) return ;
      if(skill.area==0){
        switch(i){
          case 1: skill.useSkill(player1,monster);definition = monster.name + "使用" +skill.name + "  对"+ player1.name +"造成了:  "+skill.definition  ;break;
          case 2: skill.useSkill(player2,monster);definition = monster.name + "使用" +skill.name + "  对"+ player2.name +"造成了:  "+skill.definition  ;break;
          
        }     
       new Textdialog(definition);
       checkHp(player1);
       checkHp(player2);
       
      }
      if(skill.area==1){
          skill.useSkill(player1, player2, monster);definition = monster.name + "使用" +skill.name + "  对"+ player1.name +"造成了:  " +skill.definition+ "  对"+ player2.name +"造成了:  "+skill.definition ;
         
       new Textdialog(definition);
       checkHp(player1);
       checkHp(player2);
       
      }  
}
    //判断逃跑成功或失败
    public int runAway(Player player,Monster monster){
        
        double temp=(player.speedd-monster.speedd)*Math.random();
        if(temp<0&&Math.random()<0.7){ 
        	if(player.hpp<=0){
        		definition = "逃跑成功";
        		player.money-=50;
        		if(player.money<10)
        			player.money=10;
        		new Textdialog(definition+"损失经济50");
        		return 1;
        		}
        	definition = "逃跑失败";
        new Textdialog(definition);
        return 0; 
       }
       
        if(temp>=0&&Math.random()>0.7){
        	if(player.hpp<=0) {
        		definition="逃跑成功";
        		player.money-=50;
        		if(player.money<10)
        		player.money=10;
        	new Textdialog(definition+"损失经济50");
        	return 1;
        	}
        definition = "逃跑失败";
        new Textdialog(definition);
        return 0;
     }
        if(player.hpp<=0) {
        	player.money-=50;
        	if(player.money<10)
        		player.money=10;
        	new Textdialog("损失经济50");
        }
        definition="逃跑成功";
        new Textdialog(definition);
        return 1;
    }
    
    //速度比较
    public int checkSpeedd(Player player,Monster monster1,Monster monster2,Monster monster3) {
    	if(player.speedd>monster1.speedd&&player.speedd>=monster2.speedd&&player.speedd>=monster3.speedd)
    		return 1;
    	return 0;
    }
    
    public int checkSpeedd(Player player,Monster monster1,Monster monster2) {
    	if(player.speedd>monster1.speedd&&player.speedd>=monster2.speedd)
    		return 1;
    	return 0;
    }
    
    public int checkSpeedd(Player player,Monster monster1) {
    	if(player.speedd>monster1.speedd)
    		return 1;
    	return 0;
    }
    
    public int fallItem(Monster monster,Player player){
        if(Math.random()>=0.7){
             player.newItem(monster.fallItems[(int)(Math.random()*3+1)%3]);
        }
        return 0;
    }
    public int fallItem(Monster monster,Monster monster2,Player player){
        if(Math.random()>=0.7){
            player.newItem(monster.fallItems[(int)(Math.random()*3+1)%3]);
        }
        if(Math.random()>=0.7){
             player.newItem(monster.fallItems[(int)(Math.random()*3+1)%3]);
        }
        return 0;
    }
    public void fallItem(Monster monster,Monster monster2,Monster monster3,Player player){
        if(Math.random()>=0.7){
            player.newItem(monster.fallItems[(int)(Math.random()*3+1)%3]);
        }
         if(Math.random()>=0.7){
            player.newItem(monster.fallItems[(int)(Math.random()*3+1)%3]);
        }
         if(Math.random()>=0.7){
            player.newItem(monster.fallItems[(int)(Math.random()*3+1)%3]);
        }
        
    }
}
