package org.tdddd.epca.impl.events;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;

/**
 * EPCA 转换事件。
 *
 * <p>在主模组把一只生物「转换」成另一只生物之前触发。</p>
 *
 * <p>转换完成时原生物是被 remove() 移除的，不会走死亡流程，
 * 因此本事件是附属模组（例如「依旧掉落」）唯一能在转换时
 * 把原生物掉落物掉出来的时机。</p>
 *
 * <p>本事件不可取消，只用于通知。</p>
 */
public class EpcaEntityConversionEvent extends LivingEvent {

    /** 转换目标的实体类型 id，可能为 null（例如融合时没有单一目标）。 */
    private final ResourceLocation targetTypeId;

    /**
     * @param original     被转换掉的原生物（此时还没被移除，位置也是原位）
     * @param targetTypeId 转换目标的实体类型 id，可为 null
     */
    public EpcaEntityConversionEvent(LivingEntity original, ResourceLocation targetTypeId) {
        super(original);
        this.targetTypeId = targetTypeId;
    }

    /** 被转换掉的原生物。 */
    public LivingEntity getOriginal() {
        return this.getEntity();
    }

    /** 转换目标的实体类型 id，可能为 null。 */
    public ResourceLocation getTargetTypeId() {
        return this.targetTypeId;
    }
}
