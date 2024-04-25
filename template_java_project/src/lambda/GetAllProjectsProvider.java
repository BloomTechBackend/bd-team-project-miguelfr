package lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dependency.DaggerServiceComponent;
import dependency.ServiceComponent;
import models.requests.GetAllProjectsRequest;
import models.results.GetAllProjectsResult;

public class GetAllProjectsProvider implements RequestHandler<GetAllProjectsRequest, GetAllProjectsResult> {
    private static ServiceComponent app;

    @Override
    public GetAllProjectsResult handleRequest(GetAllProjectsRequest request, Context context) {
        return getServiceComponent().provideGetAllProjectsActivity().handleRequest(request, context);
    }
    private ServiceComponent getServiceComponent() {
        if(app == null) {
            app = DaggerServiceComponent.create();
        }
        return app;
    }
}
