package sladki.tfc.Items.Tools;

import java.util.Set;

import com.dunk.tfc.api.Enums.EnumDamageType;
import com.dunk.tfc.api.Enums.EnumItemReach;
import com.dunk.tfc.api.Interfaces.IAttackSpeed;
import com.dunk.tfc.api.Interfaces.ICausesDamage;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sladki.tfc.Cellars;
import sladki.tfc.ModManager;

import com.dunk.tfc.Items.Tools.ItemTerraTool;
import com.dunk.tfc.api.TFCBlocks;
import com.google.common.collect.Sets;

public class ItemIceSaw extends ItemTerraTool implements ICausesDamage, IAttackSpeed {

	private static final Set<Block> blocksEffectiveAgainst = Sets.newHashSet(new Block[]{TFCBlocks.ice});

	
	public ItemIceSaw(ToolMaterial material) {
		super(1.0f, material, blocksEffectiveAgainst);
	}
	
	@Override
	public void registerIcons(IIconRegister register) {
		String name = this.getUnlocalizedName().replace("item.", "");
		this.itemIcon = register.registerIcon(Cellars.MODID + ":" + "tools/" + name);
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase player) {
		super.onBlockDestroyed(itemStack, world, block, x, y, z, player);
		
		if(world.isRemote) {
			return false;
		}
		
		if(block == TFCBlocks.ice || block == ModManager.IceBlock) {
			EntityItem entityItem = new EntityItem(world,
					x + 0.5, y + 0.5, z + 0.5, new ItemStack(ModManager.IceBlock, 1));
			world.spawnEntityInWorld(entityItem);
			world.setBlockToAir(x, y, z);
		}
        return true;
    }

	@Override
	public EnumItemReach getReach(ItemStack is) {
		return EnumItemReach.FAR;
	}

	@Override
	public EnumDamageType getDamageType(EntityLivingBase entityLivingBase) {
		return EnumDamageType.SLASHING;
	}
}
