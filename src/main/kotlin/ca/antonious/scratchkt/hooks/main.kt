package ca.antonious.scratchkt.hooks

fun useCounter(): Triple<Int, () -> Unit, () -> Unit> {
    val (counter, setCounter) = useState(0)

    return Triple(
        counter,
        { setCounter(counter + 1) },
        { setCounter(counter - 1) }
    )
}

fun SampleComponent() {
    val (counter, incrementCounter) = useCounter()

    useEffect({
        println("Component mounted")
    }, emptyList())

    useEffect({
        if (counter < 10) {
            Thread {
                Thread.sleep(1000)
                incrementCounter()
            }.start()
        }
    }, listOf(counter, incrementCounter))

    println("Counter value is $counter.")
}

fun main() {
    ComponentRunner.run(::SampleComponent)
}