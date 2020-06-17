package me.zeroeightsix.kami.feature.module.misc

import me.zeroeightsix.fiber.api.annotation.Setting
import me.zeroeightsix.fiber.api.annotation.Settings
import me.zeroeightsix.kami.feature.module.Module

/**
 * Created by 086 on 8/04/2018.
 */
@Module.Info(
    name = "NoEntityTrace",
    category = Module.Category.MISC,
    description = "Blocks entities from stopping you from mining"
)
@Settings(onlyAnnotated = true)
object NoEntityTrace : Module() {
    @Setting
    private val mode: TraceMode = TraceMode.DYNAMIC

    private enum class TraceMode {
        STATIC, DYNAMIC
    }

    @JvmStatic
    fun shouldBlock(): Boolean {
        return isEnabled() && (mode == TraceMode.STATIC || mc.interactionManager.isBreakingBlock)
    }
}