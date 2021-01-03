package com.mojang.ld22.item.resource;

import com.mojang.ld22.entity.Player;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.level.tile.Tile;

public class PowerUpResource extends Resource {
    private static final int MAX_INCREMENTABLE_HEALTH = 20;
    private static final int MAX_INCREMENTABLE_STAMINA = 20;
    private int _increment; // the amount of health the food heals you for.
    private PowerUpType _type;

    public PowerUpResource(String name, int sprite, int color, int increment, PowerUpType type) {
	    super(name, sprite, color);
	    _increment = increment;
	    _type = type;
    }

	/** What happens when the players uses the item on a tile */
	public boolean interactOn(Tile tile, Level level, int xt, int yt, Player player, int attackDir) {
	    switch (_type){
		case HEALTH:
		    if (player.maxHealth + _increment > MAX_INCREMENTABLE_HEALTH){
		        return false;
		    }
		    player.maxHealth += _increment;
		    break;
		case STAMINA:
		    if (player.maxStamina + _increment > MAX_INCREMENTABLE_STAMINA){
			return false;
		    }
		    player.maxStamina += _increment;
		    break;
	    }
	    return true;
	}
}