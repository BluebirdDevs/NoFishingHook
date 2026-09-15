package bluebird.nofishinghook.mixin;

//? if >= 1.21.2 {
import net.minecraft.client.renderer.culling.Frustum;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//?} else {
/*import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
*///?}
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.FishingHookRenderer;
import net.minecraft.world.entity.projectile.FishingHook;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(FishingHookRenderer.class)
public class FishingHookRendererMixin {
	//? if >= 1.21.2 {
	//? if > 26.2 {
	@Inject(at = @At("HEAD"), method = "shouldRender(Lnet/minecraft/world/entity/projectile/FishingHook;Lnet/minecraft/client/renderer/culling/Frustum;DDDF)Z", cancellable = true)
	public void nofishinghook$removeInFirstPerson(FishingHook entity, Frustum culler, double camX, double camY, double camZ, float partialTicks, CallbackInfoReturnable<Boolean> cir) {
		//?} else {
	/*@Inject(at = @At("HEAD"), method = "shouldRender(Lnet/minecraft/world/entity/projectile/FishingHook;Lnet/minecraft/client/renderer/culling/Frustum;DDD)Z", cancellable = true)
	public void nofishinghook$removeInFirstPerson(FishingHook entity, Frustum culler, double camX, double camY, double camZ, CallbackInfoReturnable<Boolean> cir) {
	*///?}
		Minecraft client = Minecraft.getInstance();
		if (entity.getHookedIn() == client.player && client.options.getCameraType().isFirstPerson()) {
			cir.setReturnValue(false);
		}
	}
	//?} else {
	/*@Inject(at = @At("HEAD"), method = "render(Lnet/minecraft/world/entity/projectile/FishingHook;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", cancellable = true)
	public void nofishinghook$removeInFirstPerson(FishingHook fishingHook, float f, float g, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, CallbackInfo ci) {
		Minecraft client = Minecraft.getInstance();
		if (fishingHook.getHookedIn() == client.player && client.options.getCameraType().isFirstPerson()) {
			ci.cancel();
		}
	}
	*///?}
}
