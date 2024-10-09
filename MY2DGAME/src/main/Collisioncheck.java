package main;

import entity.Entity;

public class Collisioncheck {
	Gamepanel gp;
	public Collisioncheck (Gamepanel gp) {
		this.gp = gp;
	}
	// method để check colli của entity
	
	public void checkTile(Entity entity) {
		int entityleftworldx = entity.worldx + entity.solidarea.x;
		int entityrightwordx = entity.worldx + entity.solidarea.x + entity.solidarea.width;
		int entitytopworldy = entity.worldy + entity.solidarea.y;
		int entitybotworldy = entity.worldy + entity.solidarea.y+ entity.solidarea.height;
		
		int entityleftcol = entityleftworldx / gp.tilesize;
		int entityrightcol = entityrightwordx / gp.tilesize;
		int entitytoprow = entitytopworldy / gp.tilesize;
		int entitybotrow = entitybotworldy / gp.tilesize;
		
		int tilenum1, tilenum2;
		switch(entity.direction) {
		case "up":
			entitytoprow = (entitytopworldy-entity.speed)/gp.tilesize;
			tilenum1 = gp.tileM.maptilenum[entityleftcol][entitytoprow];
			tilenum2 = gp.tileM.maptilenum[entityrightcol][entitytoprow];
			if (gp.tileM.tile[tilenum1].collision== true || gp.tileM.tile[tilenum2].collision== true) {
				entity.collisionon = true;
			}
			break;
		case "down":
			entitybotrow = (entitytopworldy+entity.speed)/gp.tilesize;
			tilenum1 = gp.tileM.maptilenum[entityleftcol][entitybotrow];
			tilenum2 = gp.tileM.maptilenum[entityrightcol][entitybotrow];
			if (gp.tileM.tile[tilenum1].collision== true || gp.tileM.tile[tilenum2].collision== true) {
				entity.collisionon = true;
			}
			break;
		case "left":
			entityleftcol = (entityleftworldx - entity.speed)/gp.tilesize;
			tilenum1 = gp.tileM.maptilenum[entityleftcol][entitytoprow];
			tilenum2 = gp.tileM.maptilenum[entityleftcol][entitybotrow];
			if (gp.tileM.tile[tilenum1].collision== true || gp.tileM.tile[tilenum2].collision== true) {
				entity.collisionon = true;
			}
			break;
		case "right":
			entityrightcol = (entityrightwordx +entity.speed)/gp.tilesize;
			tilenum1 = gp.tileM.maptilenum[entityrightcol][entitytoprow];
			tilenum2 = gp.tileM.maptilenum[entityrightcol][entitybotrow];
			if (gp.tileM.tile[tilenum1].collision== true || gp.tileM.tile[tilenum2].collision== true) {
				entity.collisionon = true;
			}
			break;
		    	
		
		}
	}

}
