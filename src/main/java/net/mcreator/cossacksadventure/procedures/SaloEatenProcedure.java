package net.mcreator.cossacksadventure.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.cossacksadventure.CossacksAdventureModElements;

import java.util.Map;

@CossacksAdventureModElements.ModElement.Tag
public class SaloEatenProcedure extends CossacksAdventureModElements.ModElement {
	public SaloEatenProcedure(CossacksAdventureModElements instance) {
		super(instance, 1);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SaloEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Mmm, saaaaalooooo..."), (true));
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).addExperienceLevel((int) 2);
	}
}
