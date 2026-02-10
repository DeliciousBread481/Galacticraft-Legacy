package micdoodle8.mods.galacticraft.core.event;  
  
import net.minecraft.client.audio.PositionedSoundRecord;  
import net.minecraft.client.audio.Sound;  
import net.minecraft.util.ResourceLocation;  
import net.minecraft.util.SoundCategory;  
import net.minecraft.util.SoundEvent;  
  
public class SafePositionedSoundRecord extends PositionedSoundRecord  
{  
    public SafePositionedSoundRecord(SoundEvent soundIn, SoundCategory categoryIn, float volumeIn, float pitchIn, float xIn, float yIn, float zIn)  
    {  
        super(soundIn, categoryIn, volumeIn, pitchIn, xIn, yIn, zIn);  
    }  
  
    @Override  
    public float getVolume()  
    {  
        if (this.sound == null)  
        {  
            try  
            {  
                this.createAccessor(net.minecraft.client.Minecraft.getMinecraft().getSoundHandler());  
            }  
            catch (Exception e)  
            {  
                return 1.0F;  
            }  
        }  
        return super.getVolume();  
    }  
}