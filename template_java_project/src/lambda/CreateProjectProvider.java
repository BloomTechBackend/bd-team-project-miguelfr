package lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dependency.DaggerServiceComponent;
import dependency.ServiceComponent;
import models.requests.CreateProjectRequest;
import models.results.CreateProjectResult;

public class CreateProjectProvider implements RequestHandler<CreateProjectRequest, CreateProjectResult> {
    private static ServiceComponent app;

    @Override
    public CreateProjectResult handleRequest(CreateProjectRequest request, Context context) {
        return getServiceComponent().provideCreateProjectActivity().handleRequest(request, context);
    }

    private ServiceComponent getServiceComponent() {
        if(app == null) {
            app = DaggerServiceComponent.create();
        }
        return app;
    }
}
