package lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dependency.DaggerServiceComponent;
import dependency.ServiceComponent;
import models.requests.GetProjectRequest;
import models.results.GetProjectResult;

public class GetProjectProvider implements RequestHandler<GetProjectRequest, GetProjectResult> {
    private static ServiceComponent app;

    @Override
    public GetProjectResult handleRequest(GetProjectRequest request, Context context) {
        return getServiceComponent().provideGetProjectActivity().handleRequest(request, context);
    }

    private ServiceComponent getServiceComponent() {
        if(app == null) {
            app = DaggerServiceComponent.create();
        }
        return app;
    }
}
