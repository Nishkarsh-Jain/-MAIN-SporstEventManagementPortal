package com.player.entity;

public class JwtResponse {


    private String username;

    private boolean isValid;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }


    public JwtResponse() {
        super();

    }

    public JwtResponse( String username, boolean isValid) {
        super();

        this.username = username;
        this.isValid = isValid;
    }

    @Override
    public String toString() {
        return "JwtResponse [username=" + username + ", isValid=" + isValid + "]";
    }


}

