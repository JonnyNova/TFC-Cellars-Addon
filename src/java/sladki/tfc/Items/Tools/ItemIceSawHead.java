package sladki.tfc.Items.Tools;

import net.minecraft.client.renderer.texture.IIconRegister;
import sladki.tfc.Cellars;

import com.dunk.tfc.Core.TFCTabs;
import com.dunk.tfc.Items.ItemTerra;
import com.dunk.tfc.api.Enums.EnumSize;
import com.dunk.tfc.api.Enums.EnumWeight;

public class ItemIceSawHead extends ItemTerra {
	
	private ToolMaterial material = null;
	
	public ItemIceSawHead() {
		super();
//		this.setMaxDamage(100);
		this.setMaxStackSize(4);
		setCreativeTab(TFCTabs.TFC_MISC);
		this.setWeight(EnumWeight.MEDIUM);
		this.setSize(EnumSize.SMALL);
	}
	
	public ItemIceSawHead(ToolMaterial material) {
		this();
		this.material = material;
	}
	
	public ToolMaterial getMaterial() {
		return material;
	}
	
	@Override
	public void registerIcons(IIconRegister register) {
		String name = this.getUnlocalizedName().replace("item.", "");
		this.itemIcon = register.registerIcon(Cellars.MODID + ":" + "toolheads/" + name);
	}
}
