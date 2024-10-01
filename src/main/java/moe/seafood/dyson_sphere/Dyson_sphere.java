package moe.seafood.dyson_sphere;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class Dyson_sphere implements ModInitializer {
    public static final String MOD_ID = "dyson_sphere";
    @Override
    public void onInitialize() {
    }
    public static @NotNull ResourceLocation of(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
