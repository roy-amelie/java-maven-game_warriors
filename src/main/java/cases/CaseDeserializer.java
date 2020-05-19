package cases;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import cases.bonus.potion.BigLifePotion;
import cases.bonus.potion.LifePotion;
import cases.bonus.potion.LittleLifePotion;
import cases.bonus.spell.FireBall;
import cases.bonus.spell.Flash;
import cases.bonus.weapon.Arc;
import cases.bonus.weapon.Epee;
import cases.bonus.weapon.Massue;
import cases.empty.CaseEmpty;
import cases.enemy.Dragon;
import cases.enemy.Goblin;
import cases.enemy.Witcher;

public class CaseDeserializer implements JsonDeserializer<Cases> {

	@Override
	public Cases deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		JsonObject jsonObject = json.getAsJsonObject();
		JsonElement name = jsonObject.get("name");
		if (name != null) {
			switch (name.getAsString()) {
			case "BigPotion":
				return context.deserialize(jsonObject, BigLifePotion.class);
			case "MiddlePotion":
				return context.deserialize(jsonObject, LifePotion.class);
			case "LittlePotion":
				return context.deserialize(jsonObject, LittleLifePotion.class);
			case "FireBall":
				return context.deserialize(jsonObject, FireBall.class);
			case "Flash":
				return context.deserialize(jsonObject, Flash.class);
			case "Arc":
				return context.deserialize(jsonObject, Arc.class);
			case "Epee":
				return context.deserialize(jsonObject, Epee.class);
			case "Massue":
				return context.deserialize(jsonObject, Massue.class);
			case "Empty":
				return context.deserialize(jsonObject, CaseEmpty.class);
			case "Dragon":
				return context.deserialize(jsonObject, Dragon.class);
			case "Goblin":
				return context.deserialize(jsonObject, Goblin.class);
			case "Witcher":
				return context.deserialize(jsonObject, Witcher.class);
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

}
