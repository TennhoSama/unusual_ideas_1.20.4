package name.unusualideas.item;

import name.unusualideas.UnusualIdeas;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

 public enum ModArmorMaterial implements ArmorMaterial {
     ZIRCONIUM("zirconium", 24, new int[]{3, 7, 6, 2}, 9,
             SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0f, 0.0f,
             () -> Ingredient.ofItems(ModItems.ZIRCONIUM)
     ),

     TITANIUM("titanium", 27, new int[]{3, 5, 7, 3}, 10,
             SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.5f, 0.05f,
             () -> Ingredient.ofItems(ModItems.TITANIUM)
     );

     private final String name;

     private final int durabilityMultiplier;

     private final int[] protectionAmounts;

     private final int enchantability;

     private final SoundEvent equipSound;

     private final float toughness;

     private final float knockbackResistance;

     private final Supplier<Ingredient> repairIngredientSupplier;

     public static final int[] BASE_DURABILITY = {11, 16, 15, 13};

     ModArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
         this.name = name;
         this.durabilityMultiplier = durabilityMultiplier;
         this.protectionAmounts = protectionAmounts;
         this.enchantability = enchantability;
         this.equipSound = equipSound;
         this.toughness = toughness;
         this.knockbackResistance = knockbackResistance;
         this.repairIngredientSupplier = repairIngredientSupplier;
     }

     @Override
     public int getDurability(ArmorItem.Type type) {
         return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
     }

     @Override
     public int getProtection(ArmorItem.Type type) {
         return this.protectionAmounts[type.ordinal()];
     }

     @Override
     public int getEnchantability() {
         return this.enchantability;
     }

     @Override
     public SoundEvent getEquipSound() {
         return this.equipSound;
     }

     @Override
     public Ingredient getRepairIngredient() {
         return this.repairIngredientSupplier.get();
     }

     @Override
     public String getName() {
         return UnusualIdeas.MOD_ID + ':' + this.name;
     }

     @Override
     public float getToughness() {
         return this.toughness;
     }

     @Override
     public float getKnockbackResistance() {
         return this.knockbackResistance;
     }
 }

