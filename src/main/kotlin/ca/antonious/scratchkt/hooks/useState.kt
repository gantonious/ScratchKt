package ca.antonious.scratchkt.hooks

class StateContext<T>(
    var state: T
)

fun <T> useState(initialState: T): Pair<T, (T) -> Unit> {
    val stateContext = ComponentRunner.getContext(StateContext(initialState))
    return stateContext.state to { newState ->
        stateContext.state = newState
        ComponentRunner.rerender()
    }
}