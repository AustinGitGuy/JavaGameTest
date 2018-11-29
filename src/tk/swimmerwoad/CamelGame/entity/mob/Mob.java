package tk.swimmerwoad.CamelGame.entity.mob;

import java.awt.Graphics;

import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion.Setting;

import tk.swimmerwoad.CamelGame.Game;
import tk.swimmerwoad.CamelGame.casino.SlotMachine;
import tk.swimmerwoad.CamelGame.dialogue.BarGuyTalk;
import tk.swimmerwoad.CamelGame.dialogue.HouseManagerTalk;
import tk.swimmerwoad.CamelGame.entity.Entity;
import tk.swimmerwoad.CamelGame.graphics.Screen;
import tk.swimmerwoad.CamelGame.graphics.Sprite;
import tk.swimmerwoad.CamelGame.level.Level;
import tk.swimmerwoad.CamelGame.level.MapCoordinates;
import tk.swimmerwoad.CamelGame.level.tile.Tile;
import tk.swimmerwoad.CamelGame.quest.PCouncil1;
import tk.swimmerwoad.CamelGame.quest.PraiseCthulu;
import tk.swimmerwoad.CamelGame.quest.Quest;
import tk.swimmerwoad.CamelGame.quest.TutQuest;

@SuppressWarnings("unused")
public abstract class Mob extends Entity {
	
	protected Sprite sprite;
	protected int dir = 2; //0 = North/Up, 3 = West/Left
	public static boolean walking = false;
	public int fTx = 0; //First Town Location from Spawn
	public int fTy = 14; //First Town Location from Spawn
	public int sx = 63; //Spawn Location from First Town
	public int sy = 14; //Spawn Location from First Town
	public int fTTx = 33; //First Town Tavern
	public int fTTy = 12; //First Town Tavern
	public int fTHx = 6; //First Town Location From Houses
	public int fTHy = 14; //First Town Location From Houses
	public int fTCx = 53; //First Town Casino
	public int fTCy = 12; //First Town Casino
	public int fTPx = 43; //First Town Player-Owned Housing
	public int fTPy = 12; //First Town Player-Owned Housing
	
	private double xt;
	private double yt;
	private boolean solid = false;
	
	public Mob(){
		
	}
	
	public void move(int xa, int ya){
			if(xa > 0) dir = 1;
			if(xa < 0) dir = 3;
			if(ya > 0) dir = 2;
			if(ya < 0) dir = 0;
			if(!collision(xa, 0)){
				x += xa;
			}
			
			if(!collision(0, ya)){
				y += ya;
			}
	}
	
	protected boolean collision(int xa, int ya){
		solid = false;
		for (int c = 0; c  < 4; c++){
			xt = ((x + xa) + c % 2 * 14 - 8) / 16; //Bug Report: Tiles not colliding correctly - Solved
			yt = ((y + ya) + c / 2 * 16 - 10) / 16;
			if (level.getTile((int)xt, (int)yt).solid()) {
					if(Game.level != Level.Map) solid = true;
					if(xt <= 0 || xt >= Level.Map.getWidth()) solid = true;
					if(yt <= 0 || yt >= Level.Map.getHeight()) solid = true;
			}
			
			if(Game.level == Level.Map){
				if(xt >= MapCoordinates.Parisx - 1 && xt <= MapCoordinates.Parisx + 1){
					if(yt >= MapCoordinates.Parisy - 1 && yt <= MapCoordinates.Parisy + 1){
						MapCoordinates.Paris = true;
						if(MapCoordinates.MapEnter){
							Game.level = Level.Paris;
							x = (int) MapCoordinates.Eiffelx * 16;
							y = (int) MapCoordinates.Eiffely * 16;
							level = Level.Paris;
							MapCoordinates.Paris = false;
							MapCoordinates.MapEnter = false;
						}
					}
					else MapCoordinates.Paris = false;
				} else MapCoordinates.Paris = false;
				if(xt >= MapCoordinates.Toursx - 1 && xt <= MapCoordinates.Toursx + 1){
					if(yt >= MapCoordinates.Toursy - 1 && yt <= MapCoordinates.Toursy + 1){
						MapCoordinates.Tours = true;
						if(MapCoordinates.MapEnter){
							Game.level = Level.Tours;
							x = (int) MapCoordinates.Victoryx * 16;
							y = (int) MapCoordinates.Victoryy * 16;
							level = Level.Tours;
							MapCoordinates.Tours = false;
							MapCoordinates.MapEnter = false;
						}
					} else MapCoordinates.Tours = false;
				} else MapCoordinates.Tours = false;
			}
			
			if(Game.level == Level.PCthulu){
				if(xt < CthuluCultist.getX() + 1 && xt >= CthuluCultist.getX() - 0.5){
					if(yt < CthuluCultist.getY() + 1 && yt >= CthuluCultist.getY() - 1){
						solid = true;
						if((!PraiseCthulu.questDone && !PraiseCthulu.questAlt) && !PraiseCthulu.questInit){
							PraiseCthulu.questStart();
						}
					}
				}
			}
			
			if(Game.level == Level.PP){
				if(xt <= PCouncil.getX() && xt >= PCouncil.getX() - 1){
					if(yt <= PCouncil.getY() && yt >= PCouncil.getY() - 1){
						solid = true;
						if(!PCouncil1.questInit && !PCouncil1.questDone)
						PCouncil1.questStart();
					}
				}
			}
			
			if(Game.level == Level.Map){
				if(xt != MapCoordinates.Parisx && xt != MapCoordinates.Parisx + 1 && xt != 
						MapCoordinates.Parisx - 1){
					if(yt != MapCoordinates.Parisy && yt != MapCoordinates.Parisy + 1 && yt != 
							MapCoordinates.Parisy - 1){
						MapCoordinates.Paris = false;
					}
				}
			}
			if(Game.level == Level.PCards){
				if(xt < 3 && xt >= 2){
					if(yt < 3 && yt >= 1){
						if(!SlotMachine.temp){
							SlotMachine.enter = true;
						}
					}
				}
			}
			
			if(Game.level == Level.Tours){
				if(xt >= 20 && xt <= 33){
					if(yt >= 39 && yt <= 49){
						MapCoordinates.Victory = true;
					}
					else {
						MapCoordinates.Victory = false;
					}
				}
				else {
					MapCoordinates.Victory = false;
				}
			}
			
			npcCollision(Level.PCthulu, CthuluCultist.getX(), CthuluCultist.getY());
			npcCollision(Level.PHouse, WilliamShatner.getX(), WilliamShatner.getY());
			npcCollision(Level.PHouse, FDR.getX(), FDR.getY());
			npcCollision(Level.PHouse, Trotsky.getX(), Trotsky.getY());
			npcCollision(Level.PHouse, Obama.getX(), Obama.getY());
			npcCollision(Level.PHouse, JFK.getX(), JFK.getY());
			npcCollision(Level.PHouse, LHO.getX(), LHO.getY());
			npcCollision(Level.PP, PCouncil.getX(), PCouncil.getY());
			westHouse(Level.Paris, Level.PCthulu, MapCoordinates.PCthulux, MapCoordinates.PCthuluy, 112, 192);
			westHouse(Level.Paris, Level.PCards, MapCoordinates.PCx, MapCoordinates.PCy, 112, 192);
			eastHouse(Level.Paris, Level.PHouse, MapCoordinates.PHousex, MapCoordinates.PHousey, 112, 192);
			southHouse(Level.Paris, Level.PP, MapCoordinates.PPx, MapCoordinates.PPy, 352, 32);
			northHouse(Level.PP, Level.Paris, 22, 0, MapCoordinates.PPx * 16, (MapCoordinates.PPy - 1) * 16);
			houseReturn(Level.PHouse, Level.Paris, MapCoordinates.PHousex, MapCoordinates.PHousey);
			houseReturn(Level.PCthulu, Level.Paris, MapCoordinates.PCthulux, MapCoordinates.PCthuluy);
			houseReturn(Level.PCards, Level.Paris, MapCoordinates.PCx, MapCoordinates.PCy);
			MapCoordinates.PAirport = mapNames(MapCoordinates.PAirportx, MapCoordinates.PAirporty, Level.Paris);
			MapCoordinates.PCthulu = mapNames(MapCoordinates.PCthulux, MapCoordinates.PCthuluy, Level.Paris);
			MapCoordinates.PHouse = mapNames(MapCoordinates.PHousex, MapCoordinates.PHousey, Level.Paris);
			MapCoordinates.Eiffel = mapNames(MapCoordinates.Eiffelx, MapCoordinates.Eiffely, Level.Paris);
			MapCoordinates.PCards = mapNames(MapCoordinates.PCx, MapCoordinates.PCy, Level.Paris);
			MapCoordinates.PP = mapNames(MapCoordinates.PPx, MapCoordinates.PPy, Level.Paris);
			//oldStuff();
		}
		return solid;
	}

	public void render(Screen screen, Graphics g){
		
	}
	
	protected void shoot(int x, int y, double dir){
		
	}
	
	public void npcCollision(Level level, int x, int y){ //YEAH FIXED COLLISIONS!!!!
		if(Game.level == level){
			if(xt <= x && xt >= x - 1){
				if(yt <= y && yt >= y - 1){
					solid = true;
				}
			}
		}
	}
	
	public boolean mapNames(double mapx, double Mapy, Level level) {
		if(Game.level == level){
			if(xt == mapx || xt == mapx + 1 || xt == mapx - 1){
				if(yt == Mapy || yt == Mapy + 1 || yt == Mapy - 1){
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	public void houseReturn(Level level1, Level level2, double x, double y){
		if(Game.level == level1){
			if(xt >= 6 && xt < 8){
				if(yt == 14){
					this.x = (int)x * 16;
					this.y = (int)y * 16;
					Game.level = level2;
					level = level2;
				}
			}	
		}
	}
	
	public void westHouse(Level level1, Level level2, double x, double y, int a, int b){
		if(Game.level == level1){
			if(xt >= x - 3 && xt < x - 2){
				if(yt >= y - 1 && yt < y + 1){
					this.x = a;
					this.y = b;
					Game.level = level2;
					level = level2;
				}
			}	
		}
	}
	
	public void eastHouse(Level level1, Level level2, double x, double y, int a, int b){
		if(Game.level == level1){
			if(xt >= x + 2.5 && xt < x + 4){
				if(yt >= y - 1 && yt < y + 1){
					this.x = a;
					this.y = b;
					Game.level = level2;
					level = level2;
				}
			}
		}
	}
	
	public void southHouse(Level level1, Level level2, double x, double y, int a, int b){
		if(Game.level == level1){
			if(xt >= x - 1 && xt < x + 1){
				if(yt >= y + 1 && yt <= y + 1){
					this.x = a;
					this.y = b;
					Game.level = level2;
					level = level2;
				}
			}
		}
	}
	
	public void northHouse(Level level1, Level level2, double x, double y, double a, double b){
		if(Game.level == level1){
			if(xt >= x - 1 && xt < x + 1){
				if(yt >= y && yt <= y){
					this.x = (int)a;
					this.y = (int)b;
					Game.level = level2;
					level = level2;
				}
			}
		}
	}
	
	/*public void oldStuff(){
		
		if(xt >= fTx && xt < (fTx + 0.5) && Game.level == Level.Start){
			if(yt >= fTy && yt < (fTy + 0.5) && Game.level == Level.Start){
				x = 992;
				y = 224;
				level = Level.FirstTown;
				Game.level = Level.FirstTown;
			}
		}
		else if(xt >= sx && xt < (sx + 0.5) && Game.level == Level.FirstTown){
			if(yt >= sy && yt < (sy + 2.5) && Game.level == Level.FirstTown){
				x = 32;
				y = 224;
				level = Level.Start;
				Game.level = Level.Start;
			}
		}
		else if(xt >= fTHx && xt < (fTHx + 2.5) && Game.level == Level.FTTavern){
			if(yt >= fTHy && yt < (fTHy + 0.5) && Game.level == Level.FTTavern){
				x = fTTx * 16;
				y = (fTTy + 2) * 16;
				level = Level.FirstTown;
				Game.level = Level.FirstTown;
			}
			
		}
		else if(xt >= fTHx && xt < (fTHx + 2.5) && Game.level == Level.FTCasino){
			if(yt >= fTHy && yt < (fTHy + 0.5) && Game.level == Level.FTCasino){
				x = (fTCx) * 16;
				y = (fTCy + 2) * 16;
				level = Level.FirstTown;
				Game.level = Level.FirstTown;
			}
			
		}
		else if(xt >= fTHx && xt < (fTHx + 2.5) && Game.level == Level.FTHouse){
			if(yt >= fTHy && yt < (fTHy + 0.5) && Game.level == Level.FTHouse){
				x = (fTPx) * 16;
				y = (fTPy + 2) * 16;
				level = Level.FirstTown;
				Game.level = Level.FirstTown;
			}
			
		}
		if(xt >= fTTx && xt < (fTTx + 2.5) && Game.level == Level.FirstTown){
			if(yt >= fTTy && yt < (fTTy + 0.5) && Game.level == Level.FirstTown){
				x = 32;
				y = 32;
				level = Level.FTTavern;
				Game.level = Level.FTTavern;
			}
		}
		if(xt >= fTCx && xt < (fTCx + 2.5) && Game.level == Level.FirstTown){
			if(yt >= fTCy && yt < (fTCy + 0.5) && Game.level == Level.FirstTown){
				x = 32;
				y = 32;
				level = Level.FTCasino;
				Game.level = Level.FTCasino;
			}
		}
		if(xt >= fTPx && xt < (fTPx + 2.5) && Game.level == Level.FirstTown){
			if(yt >= fTPy && yt < (fTPy + 0.5) && Game.level == Level.FirstTown){
				x = 32;
				y = 32;
				level = Level.FTHouse;
				Game.level = Level.FTHouse;
			}
		}
		if(!Skeleton.dead){
			if(Game.level == Level.Start || Game.level == Level.TutLevel){
				if(xt < Skeleton.getX() + 1 && xt >= Skeleton.getX() - 1){
					if(yt < Skeleton.getY() + 1 && yt >= Skeleton.getY() - 1){
						solid = true;
						Skeleton.dead = true;
						Player.BashStat++;
						if(TutQuest.questPhase2){
							TutQuest.quest2();
						}
					}
				}
			}
		}
		if(Game.level == Level.Start){
			if(xt < TutorialQuestGuy.getX() + 1 && xt >= TutorialQuestGuy.getX() - 1){
				if(yt < TutorialQuestGuy.getY() + 1 && yt >= TutorialQuestGuy.getY() - 1){
					solid = true;
					if(!TutQuest.questDone && !Quest.questInit){
						TutQuest.questStart();
					}
				}
			}
		}
		if(Game.level == Level.Start || Game.level == Level.TutLevel){
			if(xt < TutorialQuestGuy.getX() + 1 && xt >= TutorialQuestGuy.getX() - 1){
				if(yt < TutorialQuestGuy.getY() + 1 && yt >= TutorialQuestGuy.getY() - 1){
					solid = true;
				}
			}
		}
		if(Game.level == Level.FTTavern){
			if(xt < BarGuy.getX() + 1 && xt >= BarGuy.getX() - 1){
				if(yt < BarGuy.getY() + 1 && yt >= BarGuy.getY() - 1){
					solid = true;
					BarGuyTalk.buyDrink();
				}
			}
		}
		if(Game.level == Level.FirstTown){
			if(xt < HouseManager.getX() + 1 && xt >= HouseManager.getX() - 1){
				if(yt < HouseManager.getY() + 1 && yt >= HouseManager.getY() - 1){
					solid = true;
					if(HouseManagerTalk.managed){
						HouseManagerTalk.buy();
					}
					else {
						HouseManagerTalk.StartManaging();
					}
				}
			}
		}
	}*/
}
