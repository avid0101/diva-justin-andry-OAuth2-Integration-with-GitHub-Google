package divajustinandry.oauth2login.repository;

import divajustinandry.oauth2login.model.AuthProvider;
import divajustinandry.oauth2login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AuthProviderRepository extends JpaRepository<AuthProvider, Long> {

    Optional<AuthProvider> findByProviderAndProviderUserId(String provider, String providerUserId);

    Optional<AuthProvider> findByUserAndProvider(User user, String provider);
}
