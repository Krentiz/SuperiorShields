package dev.epicsquid.superiorshields.registry

import dev.epicsquid.squidink.utils.forgeTag
import dev.epicsquid.superiorshields.SuperiorShields
import dev.epicsquid.superiorshields.compat.ArsCompat
import dev.epicsquid.superiorshields.compat.BotaniaCompat
import dev.epicsquid.superiorshields.compat.MalumCompat
import dev.epicsquid.superiorshields.compat.ThermalCompat
import dev.epicsquid.superiorshields.config.Config
import dev.epicsquid.superiorshields.config.SuperiorShieldStats
import dev.epicsquid.superiorshields.data.SuperiorShieldsItemTags
import dev.epicsquid.superiorshields.item.EnergySuperiorShieldItem
import dev.epicsquid.superiorshields.item.FireNovaSuperiorShieldItem
import dev.epicsquid.superiorshields.item.SuperiorShieldItem
import dev.epicsquid.superiorshields.shield.DurabilitySuperiorShield
import dev.epicsquid.superiorshields.shield.EnergySuperiorShield
import net.minecraft.core.registries.Registries
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.item.Item.Properties
import net.minecraft.world.item.Tiers
import net.minecraft.world.item.crafting.Ingredient
import net.minecraftforge.common.Tags
import net.minecraftforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.forge.registerObject

object ItemRegistry {

	val REGISTRY = DeferredRegister.create(Registries.ITEM, SuperiorShields.MODID)

	val ironShield by REGISTRY.registerObject("iron_shield") {
		durabilityShieldItem(
			Config.SHIELDS_CONFIG.ironShield,
			Tiers.IRON.enchantmentValue,
			Tiers.IRON.uses,
			Tags.Items.INGOTS_IRON
		)
	}

	val goldenShield by REGISTRY.registerObject("golden_shield") {
		durabilityShieldItem(
			Config.SHIELDS_CONFIG.goldShield,
			Tiers.GOLD.enchantmentValue,
			Tiers.GOLD.uses,
			Tags.Items.INGOTS_GOLD
		)
	}

	val copperShield by REGISTRY.registerObject("copper_shield") {
		durabilityShieldItem(
			Config.SHIELDS_CONFIG.copperShield,
			9,
			160,
			Tags.Items.INGOTS_COPPER
		)
	}

	val diamondShield by REGISTRY.registerObject("diamond_shield") {
		durabilityShieldItem(
			Config.SHIELDS_CONFIG.diamondShield,
			Tiers.DIAMOND.enchantmentValue,
			Tiers.DIAMOND.uses,
			Tags.Items.GEMS_DIAMOND
		)
	}

	// Metal Shields
	val tinShield by REGISTRY.registerObject("tin_shield") {
		durabilityShieldItem(
			Config.SHIELDS_CONFIG.tinShield,
			18,
			32,
			"ingots/tin".forgeTag
		)
	}

	val leadShield by REGISTRY.registerObject("lead_shield") {
		durabilityShieldItem(
			Config.SHIELDS_CONFIG.leadShield, 16,
			64,
			"ingots/lead".forgeTag
		)
	}

	val silverShield by REGISTRY.registerObject("silver_shield") {
		durabilityShieldItem(
			Config.SHIELDS_CONFIG.silverShield,
			30,
			48,
			"ingots/silver".forgeTag
		)
	}

	val nickelShield by REGISTRY.registerObject("nickel_shield") {
		durabilityShieldItem(
			Config.SHIELDS_CONFIG.nickelShield,
			30,
			240,
			"ingots/nickel".forgeTag
		)
	}

	val bronzeShield by REGISTRY.registerObject("bronze_shield") {
		durabilityShieldItem(
			Config.SHIELDS_CONFIG.bronzeShield,
			16,
			325,
			"ingots/bronze".forgeTag
		)
	}

	val electrumShield by REGISTRY.registerObject("electrum_shield") {
		durabilityShieldItem(
			Config.SHIELDS_CONFIG.electrumShield,
			28,
			192,
			"ingots/electrum".forgeTag
		)
	}

	val invarShield by REGISTRY.registerObject("invar_shield") {
		durabilityShieldItem(
			Config.SHIELDS_CONFIG.invarShield,
			13,
			300,
			"ingots/invar".forgeTag
		)
	}

	val constantanShield by REGISTRY.registerObject("constantan_shield") {
		durabilityShieldItem(
			Config.SHIELDS_CONFIG.constantanShield,
			10,
			250,
			"ingots/constantan".forgeTag
		)
	}

	val lapisShield by REGISTRY.registerObject("lapis_shield") {
		durabilityShieldItem(
			Config.SHIELDS_CONFIG.lapisShield,
			32,
			128,
			"gem/lapis".forgeTag,
		)
	}

	val steelShield by REGISTRY.registerObject("steel_shield") {
		durabilityShieldItem(
			Config.SHIELDS_CONFIG.steelShield,
			16,
			500,
			"ingots/steel".forgeTag
		)
	}

	val osmiumShield by REGISTRY.registerObject("osmium_shield") {
		durabilityShieldItem(
			Config.SHIELDS_CONFIG.osmiumShield,
			14,
			250,
			"ingots/osmium".forgeTag
		)
	}

	val refinedGlowstoneShield by REGISTRY.registerObject("refined_glowstone_shield") {
		durabilityShieldItem(
			Config.SHIELDS_CONFIG.refinedGlowstoneShield,
			20,
			384,
			"ingots/refined_glowstone".forgeTag
		)
	}

	val refinedObsidianShield by REGISTRY.registerObject("refined_obsidian_shield") {
		durabilityShieldItem(
			Config.SHIELDS_CONFIG.refinedObsidianShield,
			18,
			1680,
			"ingots/refined_obsidian".forgeTag
		)
	}

	val ironwoodShield by REGISTRY.registerObject("ironwood_shield") {
		durabilityShieldItem(
			Config.SHIELDS_CONFIG.ironwoodShield,
			25,
			512,
			"ingots/ironwood".forgeTag,
		)
	}

	val steeleafShield by REGISTRY.registerObject("steeleaf_shield") {
		durabilityShieldItem(
			Config.SHIELDS_CONFIG.steeleafShield,
			9,
			131,
			"ingots/steeleaf".forgeTag,
		)
	}

	val knightmetalShield by REGISTRY.registerObject("knightmetal_shield") {
		SuperiorShieldItem(
			Properties().durability(512),
			8,
			DurabilitySuperiorShield(Config.SHIELDS_CONFIG.knightmetalShield)
		) { Ingredient.of("ingots/knightmetals".forgeTag) }
	}

	val fieryShield by REGISTRY.registerObject("fiery_shield") {
		FireNovaSuperiorShieldItem(
			Properties().durability(512),
			8,
			DurabilitySuperiorShield(Config.SHIELDS_CONFIG.fieryShield)
		) { Ingredient.of("ingots/fiery".forgeTag) }
	}

	val netheriteShield by REGISTRY.registerObject("netherite_shield") {
		durabilityShieldItem(
			Config.SHIELDS_CONFIG.netheriteShield,
			Tiers.NETHERITE.enchantmentValue,
			Tiers.NETHERITE.uses,
			Tags.Items.INGOTS_NETHERITE
		)
	}

	val electricShield by REGISTRY.registerObject("electric_shield") {
		EnergySuperiorShieldItem(
			enchantmentValue = 12,
			type = EnergySuperiorShield(Config.SHIELDS_CONFIG.electricShield),
			maxEnergy = 48000,
			barColor = 0x3CFE9A
		)
	}

	val engineersShield by REGISTRY.registerObject("engineers_shield") {
		EnergySuperiorShieldItem(
			enchantmentValue = 14,
			type = EnergySuperiorShield(Config.SHIELDS_CONFIG.engineersShield),
			maxEnergy = 48000,
			barColor = 0xFF0000
		)
	}

	val fluxShield by REGISTRY.registerObject("flux_shield") {
		ThermalCompat.thermalShield(
			enchantmentValue = 14,
			type = EnergySuperiorShield(Config.SHIELDS_CONFIG.fluxShield),
			maxEnergy = 48000,
			barColor = 0xFF0000
		)
	}

	val manasteelShield by REGISTRY.registerObject("manasteel_shield") {
		BotaniaCompat.botaniaManaShieldBuilder(
			props = Properties().durability(300),
			enchantmentValue = 16,
			type = DurabilitySuperiorShield(Config.SHIELDS_CONFIG.manasteelShield),
			repairItem = { Ingredient.of("ingots/manasteel".forgeTag) }
		)
	}

	val terrasteelShield by REGISTRY.registerObject("terrasteel_shield") {
		BotaniaCompat.botaniaManaShieldBuilder(
			props = Properties().durability(600),
			enchantmentValue = 18,
			type = DurabilitySuperiorShield(Config.SHIELDS_CONFIG.terrasteelShield),
			repairItem = { Ingredient.of("ingots/terrasteel".forgeTag) }
		)
	}

	val elementiumShield by REGISTRY.registerObject("elementium_shield") {
		BotaniaCompat.elementiumShieldBuilder(
			props = Properties().durability(900),
			enchantmentValue = 20,
			type = DurabilitySuperiorShield(Config.SHIELDS_CONFIG.elementiumShield),
			repairItem = { Ingredient.of("ingots/elementium".forgeTag) }
		)
	}

	val soulStainedShield by REGISTRY.registerObject("soul_stained_shield") {
		MalumCompat.soulStainedShieldBuilder(
			props = Properties().durability(1250),
			enchantmentValue = 11,
			type = DurabilitySuperiorShield(Config.SHIELDS_CONFIG.soulStainedShield),
			repairItem = { Ingredient.of(SuperiorShieldsItemTags.SOUL_STAINED_STEEL_INGOT) }
		)
	}

	val spiritHunterShield by REGISTRY.registerObject("spirit_hunter_shield") {
		MalumCompat.spiritHunterShieldBuilder(
			props = Properties().durability(200),
			enchantmentValue = 15,
			type = DurabilitySuperiorShield(Config.SHIELDS_CONFIG.spiritHunterShield),
			repairItem = { Ingredient.of(SuperiorShieldsItemTags.SPIRIT_FABRIC) }
		)
	}

	val enchanterShield by REGISTRY.registerObject("enchanter_shield") {
		ArsCompat.arsManaShieldBuilder(
			props = Properties().durability(Tiers.IRON.uses),
			enchantmentValue = 24,
			type = DurabilitySuperiorShield(Config.SHIELDS_CONFIG.enchanterShield),
			repairItem = { Ingredient.of(SuperiorShieldsItemTags.SOURCE_GEM) }
		)
	}

	val darksteelShield by REGISTRY.registerObject("darksteel_shield") {
		EnergySuperiorShieldItem(
			enchantmentValue = 14,
			type = EnergySuperiorShield(Config.SHIELDS_CONFIG.darksteelShield),
			maxEnergy = 48000,
			barColor = 0xFF0000
		)
	}

	private fun durabilityShieldItem(
		stats: SuperiorShieldStats,
		enchantmentValue: Int,
		durability: Int,
		repairItem: TagKey<Item>,
	): SuperiorShieldItem<DurabilitySuperiorShield> =
		SuperiorShieldItem(
			props = Properties().durability(durability),
			enchantmentValue = enchantmentValue,
			type = DurabilitySuperiorShield(stats),
			repairItem = { Ingredient.of(repairItem) }
		)
}