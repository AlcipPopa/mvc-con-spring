package eu.alchip.session;

import eu.alchip.model.db.Avatar;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.Set;

@Component
@Scope(value= WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES)
public interface AppUserI {
    String getUsername();

    void setUsername(String username);

    int getAge();

    String getJob();

    String getName();

    String getSurname();

    Set<Avatar> getAvatar();

    void setAvatar(Set<Avatar> avatar);

    boolean isActive();
}
