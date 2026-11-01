package ru.college.i923b;

import net.fabricmc.api.ModInitializer;

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

		LOGGER.info("Проект загружен успешно");
	}


	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
