package ca.antonious.scratchkt.hooks

object ComponentRunner {
    private var cursor: Int = 0
    private val contexts = mutableListOf<Any>()
    private var root: (() -> Unit)? = null

    fun rerender() {
        cursor = 0
        root?.invoke()
    }

    fun <T> getContext(initialValue: T): T {
        if (cursor >= contexts.size) {
            contexts.add(initialValue as Any)
            cursor += 1;
            return initialValue;
        }

        return (contexts[cursor] as T).also {
            cursor += 1
        }
    }

    fun run(block: () -> Unit) {
        root = block
        rerender()
    }
}