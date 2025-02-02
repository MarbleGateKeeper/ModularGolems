package dev.xkmc.modulargolems.content.entity.common.mode;

import dev.xkmc.modulargolems.init.data.LangData;

import java.util.ArrayList;
import java.util.List;

public class GolemModes {

	static final List<GolemMode> LIST = new ArrayList<>();

	public static final GolemMode FOLLOW = new GolemMode(false, true, LangData.MODE_FOLLOWING);
	public static final GolemMode GUARD = new GolemMode(true, true, LangData.MODE_GUARDING);
	public static final GolemMode STAND = new GolemMode(true, false, LangData.MODE_STANDING);

	public static GolemMode get(int i) {
		return LIST.get(i);
	}

	public static GolemMode nextMode(GolemMode mode) {
		return get((mode.getID() + 1) % LIST.size());
	}

	public static void register() {

	}

}
