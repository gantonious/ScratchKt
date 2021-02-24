package ca.antonious.scratchkt.hooks

class EffectContext(
    var dependencies: List<Any>?
)

fun useEffect(effectBlock: () -> Unit, dependencies: List<Any>? = null) {
    val context = ComponentRunner.getContext(EffectContext(dependencies = null))
    if (context.dependencies != dependencies || dependencies == null) {
        effectBlock()
    }
    context.dependencies = dependencies
}