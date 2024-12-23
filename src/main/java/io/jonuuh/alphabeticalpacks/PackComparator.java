package io.jonuuh.alphabeticalpacks;

import net.minecraft.client.resources.ResourcePackListEntry;
import net.minecraft.client.resources.ResourcePackListEntryFound;
import net.minecraft.util.EnumChatFormatting;

import java.util.Comparator;
import java.util.Locale;

public class PackComparator implements Comparator<ResourcePackListEntry>
{
    @Override
    public int compare(ResourcePackListEntry entry1, ResourcePackListEntry entry2)
    {
        if (!(entry1 instanceof ResourcePackListEntryFound) || !(entry2 instanceof ResourcePackListEntryFound))
        {
            System.out.println("This should be impossible, possible mod conflict?");
            return 0;
        }

        String packName1 = ((ResourcePackListEntryFound) entry1).func_148318_i().getResourcePackName();
        String packName2 = ((ResourcePackListEntryFound) entry2).func_148318_i().getResourcePackName();

        packName1 = EnumChatFormatting.getTextWithoutFormattingCodes(packName1);
        packName2 = EnumChatFormatting.getTextWithoutFormattingCodes(packName2);

        if (packName1.charAt(0) == '!')
        {
            packName1 = packName1.substring(1);
        }

        if (packName2.charAt(0) == '!')
        {
            packName2 = packName2.substring(1);
        }

        packName1 = packName1.toLowerCase(Locale.ROOT).trim();
        packName2 = packName2.toLowerCase(Locale.ROOT).trim();

        return packName1.compareTo(packName2);
    }
}
