import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("example")
@Produces("text/plain")
public class ExampleResource {
    //Vou colocar a referencia pra metricas assim posso analisar
    // usando o comando curl http://localhost:8080/q/metrics
    private final MeterRegistry registry;

    ExampleResource(MeterRegistry registry) {
        this.registry = registry;
    }



    @GET
    @Path("prime/{number}")
    public String checkIfPrime(@PathParam("number") long number) {
        if (number < 1) {
            //Encontre ou crie um contador example.prime.numberque tenha um typerótulo com o valor especificado.
            registry.counter("example.prime.number","type","not-natural").increment();//Incremente esse contador.
            return "Only natural numbers can be prime numbers.";
        }
        if (number == 1) {
            registry.counter("example.prime.number", "type", "one")
                    .increment();
            return number + " is not prime.";
        }
        if (number == 2 || number % 2 == 0) {
            registry.counter("example.prime.number", "type", "even")
                    .increment();
            return number + " is not prime.";
        }
        if (timedTestPrimeNumber(number)) {
            registry.counter("example.prime.number", "type", "prime")
                    .increment();
            return number + " is prime.";
        } else {
            registry.counter("example.prime.number", "type", "not-prime")
                    .increment();
            return number + " is not prime.";
        }
    }

    protected boolean timedTestPrimeNumber(long number) {
        Timer.Sample sample = Timer.start(registry);
        boolean result = testPrimeNumber(number);
        sample.stop(registry.timer("example.prime.number.test", "prime", result + ""));
        return result;
    }

    protected boolean testPrimeNumber(long number) {
        for (int i = 3; i < Math.floor(Math.sqrt(number)) + 1; i = i + 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
