package dev.xkmc.modulargolems.init.data;

import com.tterrag.registrate.providers.RegistrateLangProvider;
import dev.xkmc.modulargolems.compat.materials.common.CompatManager;
import dev.xkmc.modulargolems.compat.misc.PatchouliLang;
import dev.xkmc.modulargolems.content.entity.dog.DogGolemPartType;
import dev.xkmc.modulargolems.content.entity.humanoid.HumaniodGolemPartType;
import dev.xkmc.modulargolems.content.entity.metalgolem.MetalGolemPartType;
import dev.xkmc.modulargolems.init.ModularGolems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

import javax.annotation.Nullable;
import java.util.Locale;

public enum MGLangData {
	HEALTH("tooltip.health", "Health: %s/%s", 2, null),
	SLOT("tooltip.slot", "Remaining Upgrade Slot: %s", 1, null),
	SHIFT("tooltip.shift", "Press SHIFT to show modifier details", 0, ChatFormatting.GRAY),
	POTION_ATTACK("tooltip.potion_attack", "Inflict %s to enemies attacking or attacked.", 1, ChatFormatting.GREEN),
	POTION_DEFENSE("tooltip.potion_defense", "Golem gain %s.", 1, ChatFormatting.GREEN),

	MODE_FOLLOWING("tooltip.following", "Golem will follow you", 0, ChatFormatting.AQUA),
	MODE_GUARDING("tooltip.guarding", "Golem will wander around (%s, %s, %s)", 3, ChatFormatting.AQUA),
	MODE_STANDING("tooltip.standing", "Golem will stay at (%s, %s, %s)", 3, ChatFormatting.AQUA),

	WAND_RETRIEVE("wand.retrieve", "Right click to retrieve all your surrounding golems. Shift right click faraway golems to retrieve golem back into inventory.", 0, ChatFormatting.GRAY),
	WAND_COMMAND("wand.command", "Right click to switch modes for golems. Shift right click Humanoid golem to configure inventory. Attacking entity with this wand will call all your surrounding golems to switch target to it.", 0, ChatFormatting.GRAY),
	WAND_SUMMON("wand.summon", "Right click to summon one golem to a faraway position pointed by the wand. Shift right click to summon all golems from your inventory.", 0, ChatFormatting.GRAY),

	DESTROY_ITEM("msg.destroy_item", "Golem %s destroyed %s items because it finds no place to store.", 2, ChatFormatting.RED),
	DESTROY_EXP("msg.destroy_exp", "Golem %s destroyed %s experience because it finds no place to store.", 2, ChatFormatting.RED),
	;

	private final String key, def;
	private final int arg;
	private final ChatFormatting format;


	MGLangData(String key, String def, int arg, @Nullable ChatFormatting format) {
		this.key = ModularGolems.MODID + "." + key;
		this.def = def;
		this.arg = arg;
		this.format = format;
	}

	public static String asId(String name) {
		return name.toLowerCase(Locale.ROOT);
	}

	public static MutableComponent getTranslate(String s) {
		return Component.translatable(ModularGolems.MODID + "." + s);
	}

	public MutableComponent get(Object... args) {
		if (args.length != arg)
			throw new IllegalArgumentException("for " + name() + ": expect " + arg + " parameters, got " + args.length);
		MutableComponent ans = Component.translatable(key, args);
		if (format != null) {
			return ans.withStyle(format);
		}
		return ans;
	}

	public static void genLang(RegistrateLangProvider pvd) {
		for (MGLangData lang : MGLangData.values()) {
			pvd.add(lang.key, lang.def);
		}
		pvd.add("attribute.name.golem_regen", "Golem Regen");
		pvd.add("attribute.name.golem_sweep", "Sweep Range");

		pvd.add("golem_material." + ModularGolems.MODID + ".copper", "Copper");
		pvd.add("golem_material." + ModularGolems.MODID + ".iron", "Iron");
		pvd.add("golem_material." + ModularGolems.MODID + ".gold", "Gold");
		pvd.add("golem_material." + ModularGolems.MODID + ".netherite", "Netherite");
		pvd.add("golem_material." + ModularGolems.MODID + ".sculk", "Sculk");

		CompatManager.dispatchGenLang(pvd);

		for (var type : MetalGolemPartType.values()) {
			String name = type.name().toLowerCase(Locale.ROOT);
			pvd.add("golem_part.metal_golem." + name, RegistrateLangProvider.toEnglishName(name) + ": %s");
		}
		for (var type : HumaniodGolemPartType.values()) {
			String name = type.name().toLowerCase(Locale.ROOT);
			pvd.add("golem_part.humanoid_golem." + name, RegistrateLangProvider.toEnglishName(name) + ": %s");
		}
		for (var type : DogGolemPartType.values()) {
			String name = type.name().toLowerCase(Locale.ROOT);
			pvd.add("golem_part.dog_golem." + name, RegistrateLangProvider.toEnglishName(name) + ": %s");
		}

		PatchouliLang.genLang(pvd);

	}

}
