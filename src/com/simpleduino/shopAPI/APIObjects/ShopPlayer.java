package com.simpleduino.shopAPI.APIObjects;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Simple-Duino on 23/08/2016.
 * Copyrights Simple-Duino, all rights reserved
 */
public class ShopPlayer {

    private Player player;
    private YamlConfiguration playerData;
    private File shopCfg = new File("plugins/shopAPI/playerdata.yml");

    public ShopPlayer(Player p)
    {
        this.player = p;
        if(shopCfg.exists())
        {
            this.playerData = YamlConfiguration.loadConfiguration(shopCfg);
        }
        else
        {
            shopCfg.getParentFile().mkdirs();
            try {
                shopCfg.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.playerData = YamlConfiguration.loadConfiguration(shopCfg);
        }

        if(!this.playerData.isSet(this.player.getUniqueId().toString()+".particles"))
        {
            this.playerData.set(this.player.getUniqueId().toString()+".particles", "");
            try {
                this.playerData.save(shopCfg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<String> getParticleList() {
        ArrayList<String> particleList = new ArrayList<>();
        for (String particle : this.playerData.get(this.player.getUniqueId().toString() + ".particles").toString().split(", ")) {
            if (particle != null && !particle.equals("")) {
                particleList.add(particle);
            }
        }

        return particleList;
    }

    public void addParticleToList(String particleName)
    {
        String particleList = this.playerData.get(this.player.getUniqueId().toString() + ".particles").toString();
        particleList += particleName+", ";
        this.playerData.set(this.player.getUniqueId().toString() + ".particles", particleList);
        try {
            this.playerData.save(this.shopCfg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean hasParticle(ParticleType particleType)
    {
        return this.getParticleList().contains(particleType.toString().toLowerCase());
    }
}
