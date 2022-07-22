package pushgateway;

import io.prometheus.client.Counter;
import io.prometheus.client.exporter.PushGateway;
import io.prometheus.client.CollectorRegistry;
import java.io.IOException;

public class App {

	public static void main(String args[]) throws IOException {
		PushGateway client = new PushGateway("localhost:9091");
		CollectorRegistry registry = CollectorRegistry.defaultRegistry;
		
	    Counter counter = Counter.build().name("demo_counter").help("pushgateway poc").register(registry);
	    
	    counter.inc();
	    counter.inc();
	    // counter value should be 2 as we have performed counter.inc() twice
	    
	    client.push(registry,"monitor_app");
	}    
}
