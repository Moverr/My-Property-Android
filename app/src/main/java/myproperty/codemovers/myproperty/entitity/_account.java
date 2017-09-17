package myproperty.codemovers.myproperty.entitity;

import java.util.logging.Logger;

/**
 * Created by Manny on 9/16/2017.
 */

public class _account {
    private String names;
    private String password;
    private String email_address;


    public _account(){

    }



    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        _account account = (_account) o;

        if (!names.equals(account.names)) return false;
        if (!password.equals(account.password)) return false;
        return email_address.equals(account.email_address);

    }

    @Override
    public int hashCode() {
        int result = names.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email_address.hashCode();
        return result;
    }


}
