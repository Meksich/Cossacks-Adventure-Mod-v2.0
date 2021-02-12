
package net.mcreator.cossacksadventure.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.cossacksadventure.CossacksAdventureModElements;

@CossacksAdventureModElements.ModElement.Tag
public class MaceItem extends CossacksAdventureModElements.ModElement {
	@ObjectHolder("cossacks_adventure:mace")
	public static final Item block = null;
	public MaceItem(CossacksAdventureModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1500;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3.3f, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("mace"));
	}
}
