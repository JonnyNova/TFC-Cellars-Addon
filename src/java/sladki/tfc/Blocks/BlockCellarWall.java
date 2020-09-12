package sladki.tfc.Blocks;

import com.dunk.tfc.Blocks.BlockTerra;
import com.dunk.tfc.Core.TFCTabs;
import com.dunk.tfc.Core.TFC_Climate;
import com.dunk.tfc.Core.TFC_Time;
import com.dunk.tfc.TileEntities.TEBarrel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import sladki.tfc.Cellars;

public class BlockCellarWall extends BlockTerra {


	public BlockCellarWall(Material material) {
		super(material);
		setTextureName(Cellars.MODID + ":" + "cellarWall");
		this.setCreativeTab(TFCTabs.TFC_BUILDING);
		this.setStepSound(Block.soundTypeWood);
	}
	
}
