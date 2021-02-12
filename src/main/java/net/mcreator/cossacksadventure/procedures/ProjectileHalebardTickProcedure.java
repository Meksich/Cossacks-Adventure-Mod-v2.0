package net.mcreator.cossacksadventure.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.cossacksadventure.CossacksAdventureModElements;

import java.util.Map;

@CossacksAdventureModElements.ModElement.Tag
public class ProjectileHalebardTickProcedure extends CossacksAdventureModElements.ModElement {
	public ProjectileHalebardTickProcedure(CossacksAdventureModElements instance) {
		super(instance, 5);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ProjectileHalebardTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("FlyTime", ((entity.getPersistentData().getDouble("FlyTime")) + 1));
		if (((entity.getPersistentData().getDouble("FlyTime")) == 3)) {
			if (!entity.world.isRemote)
				entity.remove();
		}
	}
}
