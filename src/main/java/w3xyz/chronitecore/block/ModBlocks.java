package w3xyz.chronitecore.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.int_provider.UniformIntProvider;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import w3xyz.chronitecore.ChroniteCore;
import w3xyz.chronitecore.block.custom.Aquanite_Block;
import w3xyz.chronitecore.block.custom.IonizedChroniteBlock;

public class ModBlocks {

	public static final Block RAW_CHRONITE_BLOCK = registerBlock("raw_chronite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.RAW_COPPER_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block IONIZED_CHRONITE_BLOCK = registerBlock("ionized_chronite_block",
            new IonizedChroniteBlock(QuiltBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).sounds(BlockSoundGroup.CALCITE)));
	//public static final BlockWithEntity GAS_PACKING_STATION = registerBlock("gas_packing_station",
	//		new GasPackingStation(QuiltBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)));
	public static final Block CHRONITE_BLOCK = registerBlock("chronite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
	public static final Block CHRONITE_ORE = registerBlock("chronite_ore",
			new ExperienceDroppingBlock(QuiltBlockSettings.copyOf(Blocks.DIAMOND_ORE).strength(3f), UniformIntProvider.create(2,5)));
    public static final Block DEEPSLATE_CHRONITE_ORE = registerBlock("deepslate_chronite_ore",
            new ExperienceDroppingBlock(QuiltBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE).strength(5f), UniformIntProvider.create(2,5)));

	//elements and their blocks

	// Aquanite (Hydrogen)
	public static final Block AQUANITE_BLOCK = registerBlock("aquanite_block",
			new Aquanite_Block(QuiltBlockSettings.copyOf(Blocks.AIR)));
	// Luminite (Helium)
	public static final Block LUMINITE_BLOCK = registerBlock("luminite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Sparkstone (Lithium)
	public static final Block SPARKSTONE_BLOCK = registerBlock("sparkstone_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Gemforge (Beryllium)
	public static final Block GEMFORGE_BLOCK = registerBlock("gemforge_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Emberite (Boron)
	public static final Block EMBERITE_BLOCK = registerBlock("emberite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Graphite (Carbon)
	public static final Block GRAPHITE_BLOCK = registerBlock("graphite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Skybloom (Nitrogen)
	public static final Block SKYBLOOM_BLOCK = registerBlock("skybloom_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Airite (Oxygen)
	public static final Block AIRITE_BLOCK = registerBlock("airite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Frozite (Fluorine)
	public static final Block FROZITE_BLOCK = registerBlock("frozite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Glownite (Neon)
	public static final Block GLOWNITE_BLOCK = registerBlock("glownite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Seanite (Sodium)
	public static final Block SEANITE_BLOCK = registerBlock("seanite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Lavadite (Magnesium)
	public static final Block LAVADITE_BLOCK = registerBlock("lavadite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Alloyite (Aluminum)
	public static final Block ALLOYITE_BLOCK = registerBlock("alloyite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Silvasteel (Silicon)
	public static final Block SILVASTEEL_BLOCK = registerBlock("silvasteel_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Glowphite (Phosphorus)
	public static final Block GLOWPHITE_BLOCK = registerBlock("glowphite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Sulfire (Sulfur)
	public static final Block SULFIRE_BLOCK = registerBlock("sulfire_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Aqueousite (Chlorine)
	public static final Block AQUEOUSITE_BLOCK = registerBlock("aqueousite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Inertium (Argon)
	public static final Block INERTIUM_BLOCK = registerBlock("inertium_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Voltashard (Potassium)
	public static final Block VOLTASHARD_BLOCK = registerBlock("voltashard_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Stonemoss (Calcium)
	public static final Block STONEMOSS_BLOCK = registerBlock("stonemoss_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Etherium (Scandium)
	public static final Block ETHERIUM_BLOCK = registerBlock("etherium_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Titanforge (Titanium)
	public static final Block TITANFORGE_BLOCK = registerBlock("titanforge_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Metallurge (Vanadium)
	public static final Block METALLURGE_BLOCK = registerBlock("metallurge_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Chromalloy (Chromium)
	public static final Block CHROMALLOY_BLOCK = registerBlock("chromalloy_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Manasteel (Manganese)
	public static final Block MANASTEEL_BLOCK = registerBlock("manasteel_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Cobaltite (Cobalt)
	public static final Block COBALTITE_BLOCK = registerBlock("cobaltite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Magnetite (Nickel)
	public static final Block MAGNETITE_BLOCK = registerBlock("magnetite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Zincrush (Zinc)
	public static final Block ZINCRUSH_BLOCK = registerBlock("zincrush_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Lunalite (Gallium)
	public static final Block LUNALITE_BLOCK = registerBlock("lunalite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Geocrystal (Germanium)
	public static final Block GEOCRYSTAL_BLOCK = registerBlock("geocrystal_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Toxinbite (Arsenic)
	public static final Block TOXINBITE_BLOCK = registerBlock("toxinbite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Solarite (Selenium)
	public static final Block SOLARITE_BLOCK = registerBlock("solarite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Brimstone (Bromine)
	public static final Block BRIMSTONE_BLOCK = registerBlock("brimstone_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Cryptolite (Krypton)
	public static final Block CRYPTOLITE_BLOCK = registerBlock("cryptolite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Pyrofume (Rubidium)
	public static final Block PYROFUME_BLOCK = registerBlock("pyrofume_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Luminstone (Strontium)
	public static final Block LUMINSTONE_BLOCK = registerBlock("luminstone_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Mysticore (Yttrium)
	public static final Block MYSTICORE_BLOCK = registerBlock("mysticore_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Gemspark (Zirconium)
	public static final Block GEMSPARK_BLOCK = registerBlock("gemspark_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Netherium (Niobium)
	public static final Block NETHERIUM_BLOCK = registerBlock("netherium_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Molyforge (Molybdenum)
	public static final Block MOLYFORGE_BLOCK = registerBlock("molyforge_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Techneon (Technetium)
	public static final Block TECHNEON_BLOCK = registerBlock("techneon_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Starshard (Ruthenium)
	public static final Block STARSHARD_BLOCK = registerBlock("starshard_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Rhodite (Rhodium)
	public static final Block RHODITE_BLOCK = registerBlock("rhodite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Palladust (Palladium)
	public static final Block PALLADUST_BLOCK = registerBlock("palladust_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Argentum (Silver)
	public static final Block ARGENTUM_BLOCK = registerBlock("argentum_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Luminium (Cadmium)
	public static final Block LUMINIUM_BLOCK = registerBlock("luminium_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Indigem (Indium)
	public static final Block INDIGEM_BLOCK = registerBlock("indigem_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Tinforge (Tin)
	public static final Block TINFORGE_BLOCK = registerBlock("tinforge_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Venomite (Antimony)
	public static final Block VENOMITE_BLOCK = registerBlock("venomite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Tellubright (Tellurium)
	public static final Block TELLUBRIGHT_BLOCK = registerBlock("tellubright_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Iridescentite (Iodine)
	public static final Block IRIDESCENTITE_BLOCK = registerBlock("iridescentite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Xenolight (Xenon)
	public static final Block XENOLIGHT_BLOCK = registerBlock("xenolight_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Pyrosurge (Cesium)
	public static final Block PYROSURGE_BLOCK = registerBlock("pyrosurge_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Radiancestone (Barium)
	public static final Block RADIANCESTONE_BLOCK = registerBlock("radiancestone_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Magusite (Lanthanum)
	public static final Block MAGUSITE_BLOCK = registerBlock("magusite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Celestium (Cerium)
	public static final Block CELESTIUM_BLOCK = registerBlock("celestium_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Prismaticore (Praseodymium)
	public static final Block PRISMATICORE_BLOCK = registerBlock("prismaticore_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Lustronite (Neodymium)
	public static final Block LUSTRONITE_BLOCK = registerBlock("lustronite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Energonium (Promethium)
	public static final Block ENERGONIUM_BLOCK = registerBlock("energonium_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Auralite (Samarium)
	public static final Block AURALITE_BLOCK = registerBlock("auralite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Eurocrystal (Europium)
	public static final Block EUROCRYSTAL_BLOCK = registerBlock("eurocrystal_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Geminite (Gadolinium)
	public static final Block GEMINITE_BLOCK = registerBlock("geminite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Terresteel (Terbium)
	public static final Block TERRESTEEL_BLOCK = registerBlock("terresteel_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Draconite (Dysprosium)
	public static final Block DRACONITE_BLOCK = registerBlock("draconite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Harmonium (Holmium)
	public static final Block HARMONIUM_BLOCK = registerBlock("harmonium_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Gemerald (Erbium)
	public static final Block GEMERALD_BLOCK = registerBlock("gemerald_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Ethertide (Thulium)
	public static final Block ETHERTIDE_BLOCK = registerBlock("ethertide_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Spectronite (Ytterbium)
	public static final Block SPECTRONITE_BLOCK = registerBlock("spectronite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Lucentium (Lutetium)
	public static final Block LUCENTIUM_BLOCK = registerBlock("lucentium_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Plasmium (Hafnium)
	public static final Block PLASMIUM_BLOCK = registerBlock("plasmium_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Misticore (Tantalum)
	public static final Block MISTICORE_BLOCK = registerBlock("misticore_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Wolframite (Tungsten)
	public static final Block WOLFRAMITE_BLOCK = registerBlock("wolframite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Rheoflux (Rhenium)
	public static final Block RHEOFLUX_BLOCK = registerBlock("rheoflux_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Osmistone (Osmium)
	public static final Block OSMISTONE_BLOCK = registerBlock("osmistone_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Iridespire (Iridium)
	public static final Block IRIDESPIRE_BLOCK = registerBlock("iridespire_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Platinaurum (Platinum)
	public static final Block PLATINAURUM_BLOCK = registerBlock("platinaurum_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Quicksilva (Mercury)
	public static final Block QUICKSILVA_BLOCK = registerBlock("quicksilva_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Radiolite (Thallium)
	public static final Block RADIOLITE_BLOCK = registerBlock("radiolite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Leadtide (Lead)
	public static final Block LEADTIDE_BLOCK = registerBlock("leadtide_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Prismabite (Bismuth)
	public static final Block PRISMABITE_BLOCK = registerBlock("prismabite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Polonite (Polonium)
	public static final Block POLONITE_BLOCK = registerBlock("polonite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Nebulite (Astatine)
	public static final Block NEBULITE_BLOCK = registerBlock("nebulite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Radionite (Radon)
	public static final Block RADIONITE_BLOCK = registerBlock("radionite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Volcanium (Francium)
	public static final Block VOLCANIUM_BLOCK = registerBlock("volcanium_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Radite (Radium)
	public static final Block RADITE_BLOCK = registerBlock("radite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Actinastone (Actinium)
	public static final Block ACTINASTONE_BLOCK = registerBlock("actinastone_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Thorinite (Thorium)
	public static final Block THORINITE_BLOCK = registerBlock("thorinite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Protomyst (Protactinium)
	public static final Block PROTOMYST_BLOCK = registerBlock("protomyst_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Nauticalite (Neptunium)
	public static final Block NAUTICALITE_BLOCK = registerBlock("nauticalite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Plutonium (Plutonium)
	public static final Block PLUTONIUM_BLOCK = registerBlock("plutonium_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Starstruckite (Americium)
	public static final Block STARSTRUCKITE_BLOCK = registerBlock("starstruckite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Curioflux (Curium)
	public static final Block CURIOFLUX_BLOCK = registerBlock("curioflux_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Quantumite (Berkelium)
	public static final Block QUANTUMITE_BLOCK = registerBlock("quantumite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Calioptron (Californium)
	public static final Block CALIOPTRON_BLOCK = registerBlock("calioptron_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Einstarite (Einsteinium)
	public static final Block EINSTARITE_BLOCK = registerBlock("einstarite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Fermetron (Fermium)
	public static final Block FERMETRON_BLOCK = registerBlock("fermetron_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Mendelstone (Mendelevium)
	public static final Block MENDELSTONE_BLOCK = registerBlock("mendelstone_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Nobellite (Nobelium)
	public static final Block NOBELLITE_BLOCK = registerBlock("nobellite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Lawrencite (Lawrencium)
	public static final Block LAWRENCITE_BLOCK = registerBlock("lawrencite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Rutherfordium (Rutherfordium)
	public static final Block RUTHERFORDIUM_BLOCK = registerBlock("rutherfordium_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Dubnium (Dubnium)
	public static final Block DUBNIUM_BLOCK = registerBlock("dubnium_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Seaborite (Seaborgium)
	public static final Block SEABORITE_BLOCK = registerBlock("seaborite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Bohrstone (Bohrium)
	public static final Block BOHRSTONE_BLOCK = registerBlock("bohrstone_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Hassisurge (Hassium)
	public static final Block HASSISURGE_BLOCK = registerBlock("hassisurge_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Meitnerium (Meitnerium)
	public static final Block MEITNERIUM_BLOCK = registerBlock("meitnerium_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Darmstadium (Darmstadtium)
	public static final Block DARMSTADIUM_BLOCK = registerBlock("darmstadium_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Roentgenium (Roentgenium)
	public static final Block ROENTGENIUM_BLOCK = registerBlock("roentgenium_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Copernicite (Copernicium)
	public static final Block COPERNICITE_BLOCK = registerBlock("copernicite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Nihonite (Nihonium)
	public static final Block NIHONITE_BLOCK = registerBlock("nihonite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Flerovium (Flerovium)
	public static final Block FLEROVIUM_BLOCK = registerBlock("flerovium_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Moscovite (Moscovium)
	public static final Block MOSCOVITE_BLOCK = registerBlock("moscovite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Luminitium (Livermorium)
	public static final Block LUMINITIUM_BLOCK = registerBlock("luminitium_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Tennelite (Tennessine)
	public static final Block TENNELITE_BLOCK = registerBlock("tennelite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	// Oganite (Oganesson)
	public static final Block OGANITE_BLOCK = registerBlock("oganite_block",
			new Block(QuiltBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));




	private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return  Registry.register(Registries.BLOCK, new Identifier(ChroniteCore.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(ChroniteCore.MOD_ID, name),
                new BlockItem(block, new QuiltItemSettings()));
    }

    public static void registerModBlocks() {
        ChroniteCore.LOGGER.info("Registering Blocks for" + ChroniteCore.MOD_ID);
    }
}
