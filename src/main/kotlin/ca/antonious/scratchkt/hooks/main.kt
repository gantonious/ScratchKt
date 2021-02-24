package ca.antonious.scratchkt.hooks

fun SampleComponent() {
    val (counter, setCounter) = useState(0)

    useEffect({
        println("Component mounted")
    }, emptyList())

    useEffect({
        if (counter < 10) {
            Thread {
                Thread.sleep(1000)
                setCounter(counter + 1)
            }.start()
        }
    }, listOf(counter, setCounter))

    println("Counter value is $counter.")
}

fun main() {
    ComponentRunner.run(::SampleComponent)
}