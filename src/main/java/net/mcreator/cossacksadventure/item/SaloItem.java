
package net.mcreator.cossacksadventure.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.cossacksadventure.procedures.SaloEatenProcedure;
import net.mcreator.cossacksadventure.CossacksAdventureModElements;

import java.util.Map;
import java.util.HashMap;

@CossacksAdventureModElements.ModElement.Tag
public class SaloItem extends CossacksAdventureModElements.ModElement {
	@ObjectHolder("cossacks_adventure:salo")
	public static final Item block = null;
	public SaloItem(CossacksAdventureModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(20).saturation(20f).meat().build()));
			setRegistryName("salo");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 60;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				SaloEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
