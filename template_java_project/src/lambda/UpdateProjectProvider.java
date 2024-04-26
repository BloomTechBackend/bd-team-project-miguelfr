package lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dependency.DaggerServiceComponent;
import dependency.ServiceComponent;
import models.requests.GetProjectRequest;
import models.requests.UpdateProjectRequest;
import models.results.GetProjectResult;
import models.results.UpdateProjectResult;

public class UpdateProjectProvider implements RequestHandler<UpdateProjectRequest, UpdateProjectResult> {
    private static ServiceComponent app;

    @Override
    public UpdateProjectResult handleRequest(UpdateProjectRequest request, Context context) {
        return getServiceComponent().provideUpdateProjectActivity().handleRequest(request,context);
    }

    private ServiceComponent getServiceComponent() {
        if(app == null) {
            app = DaggerServiceComponent.create();
        }
        return app;
    }

}
