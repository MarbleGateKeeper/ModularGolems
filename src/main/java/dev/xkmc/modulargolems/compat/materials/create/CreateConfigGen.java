package dev.xkmc.modulargolems.compat.materials.create;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.AllTags;
import dev.xkmc.l2library.serial.network.BaseConfig;
import dev.xkmc.l2library.serial.network.ConfigDataProvider;
import dev.xkmc.modulargolems.content.config.GolemMaterialConfig;
import dev.xkmc.modulargolems.init.registrate.GolemModifierRegistry;
import dev.xkmc.modulargolems.init.registrate.GolemTypeRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITagManager;

import java.util.Map;
import java.util.Objects;

public class CreateConfigGen extends ConfigDataProvider {

	public CreateConfigGen(DataGenerator generator) {
		super(generator, "data/" + CreateDispatch.MODID + "/golem_config/", "Golem Config for Create");
	}

	public void add(Map<String, BaseConfig> map) {
		ITagManager<Item> manager = Objects.requireNonNull(ForgeRegistries.ITEMS.tags());

		map.put("materials/" + CreateDispatch.MODID, new GolemMaterialConfig()
				.addMaterial(new ResourceLocation(CreateDispatch.MODID, "zinc"),
						Ingredient.of(AllItems.ZINC_INGOT.get()))
				.addStat(GolemTypeRegistry.STAT_HEALTH.get(), 20)
				.addStat(GolemTypeRegistry.STAT_ATTACK.get(), 5).end()

				.addMaterial(new ResourceLocation(CreateDispatch.MODID, "andesite_alloy"),
						Ingredient.of(AllItems.ANDESITE_ALLOY.get()))
				.addStat(GolemTypeRegistry.STAT_HEALTH.get(), 20)
				.addStat(GolemTypeRegistry.STAT_ATTACK.get(), 5)
				.addStat(GolemTypeRegistry.STAT_SPEED.get(), 0.1)
				.addModifier(GolemModifierRegistry.MAGIC_RES.get(), 1).end()

				.addMaterial(new ResourceLocation(CreateDispatch.MODID, "brass"),
						Ingredient.of(AllItems.BRASS_INGOT.get()))
				.addStat(GolemTypeRegistry.STAT_HEALTH.get(), 160)
				.addStat(GolemTypeRegistry.STAT_ATTACK.get(), 16)
				.addStat(GolemTypeRegistry.STAT_SPEED.get(), 0.2)
				.addModifier(GolemModifierRegistry.MAGIC_RES.get(), 2).end()

				.addMaterial(new ResourceLocation(CreateDispatch.MODID, "railway"),
						Ingredient.of(AllBlocks.RAILWAY_CASING.get()))
				.addStat(GolemTypeRegistry.STAT_HEALTH.get(), 320)
				.addStat(GolemTypeRegistry.STAT_ATTACK.get(), 16)
				.addStat(GolemTypeRegistry.STAT_SPEED.get(), 0.4)
				.addStat(GolemTypeRegistry.STAT_SWEEP.get(), 1)
				.addStat(GolemTypeRegistry.STAT_ATKKB.get(), 1)
				.addModifier(GolemModifierRegistry.MAGIC_RES.get(), 2)
				.addModifier(GolemModifierRegistry.FIRE_IMMUNE.get(), 1).end()

		);
	}

}