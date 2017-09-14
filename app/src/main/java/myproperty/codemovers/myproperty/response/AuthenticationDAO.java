package myproperty.codemovers.myproperty.response;

import java.util.List;

/**
 * Created by Manny on 9/11/2017.
 */

public class AuthenticationDAO {

    private String authorization;
    private List<PermissionResponse> permissions;
    private Boolean isLoggedIn;

    public AuthenticationDAO() {
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public List<PermissionResponse> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionResponse> permissions) {
        this.permissions = permissions;
    }

    public Boolean getLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
