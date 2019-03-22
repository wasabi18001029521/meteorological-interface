package cn.webyun.meteorologicalinterface.message.response;

import cn.webyun.meteorologicalinterface.entity.User;

import java.util.List;

public class JwtResponse extends ResponseBase {
    private Boolean authenticated = false;
    private String token = "";
    private String type = "Bearer";
    private String username;
    private String userfullname;
    private String unitfullname;
    private String email;
    private String address;
    private String phone;
    private List<String> authorities;

    public JwtResponse(String accessToken) {
        this.token = accessToken;
    }

    public JwtResponse(String accessToken, Boolean authenticated) {
        this.token = accessToken;
        this.authenticated = authenticated;
    }

    public JwtResponse(String accessToken, Boolean authenticated, List<String> authorities) {
        this.token = accessToken;
        this.authenticated = authenticated;
        this.authorities = authorities;
    }

    public JwtResponse(String accessToken, Boolean authenticated, User user, List<String> authorities) {
        this.token = accessToken;
        this.authenticated = authenticated;
        this.username = user.getUserName();
        this.userfullname = user.getUserFullName();
        this.unitfullname = user.getUnitFullName();
        this.email = user.getEmail();
        this.address = user.getAddress();
        this.phone = user.getPhone();
        this.authorities = authorities;
    }

    public JwtResponse(String accessToken, Boolean authenticated, String username, String userfullname, List<String> authorities) {
        this.token = accessToken;
        this.authenticated = authenticated;
        this.username = username;
        this.userfullname = userfullname;
        this.authorities = authorities;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserfullname() {
        return userfullname;
    }

    public void setUserfullname(String userfullname) {
        this.userfullname = userfullname;
    }

    public String getUnitfullname() {
        return unitfullname;
    }

    public void setUnitfullname(String unitfullname) {
        this.unitfullname = unitfullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }
}
