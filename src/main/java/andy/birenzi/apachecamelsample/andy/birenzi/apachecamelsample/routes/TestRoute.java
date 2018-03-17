package andy.birenzi.apachecamelsample.andy.birenzi.apachecamelsample.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TestRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
            from ("timer://foo?delay=-1").routeId("My test route")
         .log("just testing");
    }
}
