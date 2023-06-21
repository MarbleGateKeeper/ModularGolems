package dev.xkmc.modulargolems.init.data;

import dev.xkmc.l2library.serial.config.ConfigDataProvider;
import dev.xkmc.modulargolems.content.config.GolemMaterialConfig;
import dev.xkmc.modulargolems.content.config.GolemPartConfig;
import dev.xkmc.modulargolems.content.core.StatFilterType;
import dev.xkmc.modulargolems.init.ModularGolems;
import dev.xkmc.modulargolems.init.registrate.GolemItems;
import dev.xkmc.modulargolems.init.registrate.GolemModifiers;
import dev.xkmc.modulargolems.init.registrate.GolemTypes;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class MGConfigGen extends ConfigDataProvider {

	public MGConfigGen(DataGenerator generator) {
		super(generator, "Golem Config");
	}

	@Override
	public void add(Collector map) {
		map.add(ModularGolems.MATERIALS, new ResourceLocation(ModularGolems.MODID, "vanilla"), new GolemMaterialConfig()
				.addMaterial(new ResourceLocation(ModularGolems.MODID, "copper"), Ingredient.of(Items.COPPER_INGOT))
				.addStat(GolemTypes.STAT_HEALTH.get(), 50)
				.addStat(GolemTypes.STAT_ATTACK.get(), 10)
				.addModifier(GolemModifiers.THUNDER_IMMUNE.get(), 1).end()

				.addMaterial(new ResourceLocation(ModularGolems.MODID, "iron"), Ingredient.of(Items.IRON_INGOT))
				.addStat(GolemTypes.STAT_HEALTH.get(), 100)
				.addStat(GolemTypes.STAT_ATTACK.get(), 15).end()

				.addMaterial(new ResourceLocation(ModularGolems.MODID, "gold"), Ingredient.of(Items.GOLD_INGOT))
				.addStat(GolemTypes.STAT_HEALTH.get(), 20)
				.addStat(GolemTypes.STAT_ATTACK.get(), 5)
				.addStat(GolemTypes.STAT_WEIGHT.get(), -0.4)
				.addStat(GolemTypes.STAT_REGEN.get(), 4).end()

				.addMaterial(new ResourceLocation(ModularGolems.MODID, "netherite"), Ingredient.of(Items.NETHERITE_INGOT))
				.addStat(GolemTypes.STAT_HEALTH.get(), 300)
				.addStat(GolemTypes.STAT_ATTACK.get(), 30)
				.addStat(GolemTypes.STAT_WEIGHT.get(), -0.4)
				.addStat(GolemTypes.STAT_SWEEP.get(), 2)
				.addModifier(GolemModifiers.FIRE_IMMUNE.get(), 1).end()

				.addMaterial(new ResourceLocation(ModularGolems.MODID, "sculk"), Ingredient.of(MGTagGen.SCULK_MATS))
				.addStat(GolemTypes.STAT_HEALTH.get(), 500)
				.addStat(GolemTypes.STAT_ATTACK.get(), 30)
				.addStat(GolemTypes.STAT_SPEED.get(), 0.5)
				.addModifier(GolemModifiers.SONIC.get(), 1)
				.addModifier(GolemModifiers.FIRE_IMMUNE.get(), 1).end()
		);

		// Choose which stat to use, and what percentage for the complete golem
		map.add(ModularGolems.PARTS, new ResourceLocation(ModularGolems.MODID, "default"), new GolemPartConfig()
				.addPart(GolemItems.GOLEM_BODY.get())
				.addFilter(StatFilterType.HEALTH, 0.5)
				.addFilter(StatFilterType.ATTACK, 0)
				.addFilter(StatFilterType.MOVEMENT, 0)
				.addFilter(StatFilterType.MASS, 0.3).end()

				.addPart(GolemItems.GOLEM_ARM.get())
				.addFilter(StatFilterType.HEALTH, 0)
				.addFilter(StatFilterType.ATTACK, 0.5)
				.addFilter(StatFilterType.MOVEMENT, 0)
				.addFilter(StatFilterType.MASS, 0.2).end()

				.addPart(GolemItems.GOLEM_LEGS.get())
				.addFilter(StatFilterType.HEALTH, 0.5)
				.addFilter(StatFilterType.ATTACK, 0)
				.addFilter(StatFilterType.MOVEMENT, 1)
				.addFilter(StatFilterType.MASS, 0.3).end()

				.addPart(GolemItems.HUMANOID_BODY.get())
				.addFilter(StatFilterType.HEALTH, 0.5)
				.addFilter(StatFilterType.ATTACK, 0)
				.addFilter(StatFilterType.MOVEMENT, 0)
				.addFilter(StatFilterType.MASS, 0.4).end()

				.addPart(GolemItems.HUMANOID_ARMS.get())
				.addFilter(StatFilterType.HEALTH, 0)
				.addFilter(StatFilterType.ATTACK, 1)
				.addFilter(StatFilterType.MOVEMENT, 0)
				.addFilter(StatFilterType.MASS, 0.3).end()

				.addPart(GolemItems.HUMANOID_LEGS.get())
				.addFilter(StatFilterType.HEALTH, 0.5)
				.addFilter(StatFilterType.ATTACK, 0)
				.addFilter(StatFilterType.MOVEMENT, 1)
				.addFilter(StatFilterType.MASS, 0.3).end()

				.addPart(GolemItems.DOG_BODY.get())
				.addFilter(StatFilterType.HEALTH, 0.7)
				.addFilter(StatFilterType.ATTACK, 1)
				.addFilter(StatFilterType.MOVEMENT, 0)
				.addFilter(StatFilterType.MASS, 0.7).end()

				.addPart(GolemItems.DOG_LEGS.get())
				.addFilter(StatFilterType.HEALTH, 0.3)
				.addFilter(StatFilterType.ATTACK, 0)
				.addFilter(StatFilterType.MOVEMENT, 1)
				.addFilter(StatFilterType.MASS, 0.3).end()

				.addEntity(GolemTypes.TYPE_GOLEM.get())
				.end()

				.addEntity(GolemTypes.TYPE_HUMANOID.get())
				.addFilter(GolemTypes.STAT_HEALTH.get(), 0.4)
				.addFilter(GolemTypes.STAT_ATTACK.get(), 0.3)
				.addFilter(GolemTypes.STAT_REGEN.get(), 0.5)
				.end()

				.addEntity(GolemTypes.TYPE_DOG.get())
				.addFilter(GolemTypes.STAT_HEALTH.get(), 0.2)
				.addFilter(GolemTypes.STAT_ATTACK.get(), 0.6)
				.addFilter(GolemTypes.STAT_REGEN.get(), 0.2)
				.addFilter(GolemTypes.STAT_SWEEP.get(), 0)
				.end()
		);
	}

}