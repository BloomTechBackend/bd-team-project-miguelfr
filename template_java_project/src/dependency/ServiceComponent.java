package dependency;

import activity.CreateProjectActivity;
import activity.GetAllProjectsActivity;
import activity.GetProjectActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = { DaoModule.class })
public interface ServiceComponent {
    CreateProjectActivity provideCreateProjectActivity();
    GetAllProjectsActivity provideGetAllProjectsActivity();
    GetProjectActivity  provideGetProjectActivity();
}
