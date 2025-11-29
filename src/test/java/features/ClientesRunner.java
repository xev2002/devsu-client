package features;

import com.intuit.karate.junit5.Karate;

public class ClientesRunner {
    @Karate.Test
    Karate testClientes() {
        return Karate.run("clientes").relativeTo(getClass());
    }
}

