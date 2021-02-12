package net.mcreator.cossacksadventure.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.cossacksadventure.CossacksAdventureModElements;

import java.util.Map;

@CossacksAdventureModElements.ModElement.Tag
public class MaceToolInHandTickDebuffProcedure extends CossacksAdventureModElements.ModElement {
	public MaceToolInHandTickDebuffProcedure(CossacksAdventureModElements instance) {
		super(instance, 3);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure MaceToolInHandTickDebuff!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setMotion(((entity.getMotion().getX()) + 0.75), ((entity.getMotion().getY()) + 0.75), ((entity.getMotion().getZ()) + 0.75));
	}
}
