package ru.college.i923b;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemGroups;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrystalLight implements ModInitializer {
	public static final String MOD_ID = "crystallight";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.initialize();
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
				.register(entries -> entries.add(ModBlocks.GLOWING_CRYSTAL_ITEM));
		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
			if (hand != Hand.MAIN_HAND || player.isSneaking()) {
				return ActionResult.PASS;
			}

			BlockState state = world.getBlockState(hitResult.getBlockPos());
			if (!state.isOf(ModBlocks.GLOWING_CRYSTAL)) {
				return ActionResult.PASS;
			}

			if (!world.isClient()) {
				player.sendMessage(
						Text.literal("Светящийся кристалл тихо мерцает."), true);
			}
			return ActionResult.SUCCESS;
		});


		LOGGER.info("Проект загружен успешно");
	}


	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
