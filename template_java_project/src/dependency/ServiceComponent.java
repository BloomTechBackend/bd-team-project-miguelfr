package dependency;

import activity.CreateProjectActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = { DaoModule.class })
public interface ServiceComponent {
    CreateProjectActivity provideCreateProjectActivity();
}
