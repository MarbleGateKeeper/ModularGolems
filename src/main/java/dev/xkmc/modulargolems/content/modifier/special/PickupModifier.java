package dev.xkmc.modulargolems.content.modifier.special;

import dev.xkmc.modulargolems.content.core.StatFilterType;
import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import dev.xkmc.modulargolems.content.modifier.base.GolemModifier;
import dev.xkmc.modulargolems.init.data.MGConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.List;
import java.util.function.BiConsumer;

public class PickupModifier extends GolemModifier {

	public PickupModifier() {
		super(StatFilterType.HEALTH, 3);
	}

	@Override
	public void onRegisterGoals(AbstractGolemEntity<?, ?> entity, int lv, BiConsumer<Integer, Goal> addGoal) {
		addGoal.accept(0, new PickupGoal(entity, lv));
	}

	@Override
	public List<MutableComponent> getDetail(int v) {
		int range = MGConfig.COMMON.basePickupRange.get() * v;
		return List.of(Component.translatable(getDescriptionId() + ".desc", range).withStyle(ChatFormatting.GREEN));
	}
}
