package features_versions.nineteen_19.base;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.StructuredTaskScope;

/**
 * JEP 266: More Concurrency Updates
 */
public class StructuredConcurrencyAPI {

    record Response(String x, int y) {
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        StructuredConcurrencyAPI api = new StructuredConcurrencyAPI();
        api.structuredConcurrency();
    }

    /**
     * Example with executors and futures.
     * @return Response
     * @throws ExecutionException
     * @throws InterruptedException
     */
    Response handleUnStructureAPI() throws ExecutionException, InterruptedException {
        try (var executor = Executors.newFixedThreadPool(10)) {
            Future<String> user = executor.submit(this::findUser);
            Future<Integer> order = executor.submit(this::fetchOrder);
            String theUser = user.get();   // Join findUser
            int theOrder = order.get();  // Join fetchOrder
            return new Response(theUser, theOrder);
        }
    }

    /**
     * Example with structured concurrency.
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void structuredConcurrency() throws ExecutionException, InterruptedException {

        try (var scope = new StructuredTaskScope()) {

            StructuredTaskScope.Subtask user = scope.fork(this::findUser);
            StructuredTaskScope.Subtask order = scope.fork(this::fetchOrder);
            scope.join();           // Join both forks
            // Here, both forks have succeeded, so compose their results
            System.out.println(new Response((String) user.get(), (Integer) order.get()));
        }
    }


    private String findUser() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(1));
        return "John Doe";
    }

    private Integer fetchOrder() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(1));
        return 1;
    }


}
