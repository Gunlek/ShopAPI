package com.simpleduino.shopAPI.APIObjects;


import org.bukkit.Material;

/**
 * Created by Simple-Duino on 23/08/2016.
 * Copyrights Simple-Duino, all rights reserved
 */
public enum ParticleType {

    FLAME("Flame", Material.FIREBALL, 500),
    NEIGE("Neige", Material.SNOW_BALL, 500),
    PLUIE("Pluie", Material.WATER_BUCKET, 500),
    NOTE("Note", Material.NOTE_BLOCK, 500),
    HEARTS("Hearts", Material.GOLDEN_APPLE, 500),
    ENCHANTMENT("Enchantment", Material.ENCHANTMENT_TABLE, 500),
    SLIMEBALL("Slimeball", Material.SLIME_BALL, 500),
    LAVA("Lava", Material.LAVA_BUCKET, 500),
    ANGRY_VILLAGER("Angry_villager", Material.FLINT, 500),
    HAPPY_VILLAGER("Happy_villager", Material.BOOK, 500),
    SMOKE("Smoke", Material.FLINT_AND_STEEL, 500),
    DIAMOND("Diamond", Material.DIAMOND, 500),
    EMERALD("Emerald", Material.EMERALD, 500);

    private String name;
    private Material material;
    private int price;

    ParticleType(String n, Material m, int p)
    {
        this.name = n;
        this.material = m;
        this.price = p;
    }

    public String toString()
    {
        return this.name;
    }

    public Material getMaterial()
    {
        return this.material;
    }

    public int getPrice()
    {
        return this.price;
    }
}
