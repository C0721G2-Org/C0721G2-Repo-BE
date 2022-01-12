package com.c0721g2srsrealestatebe.dto;

import com.c0721g2srsrealestatebe.model.account.Role;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Set;

public class AppUserDTO {
    private String id;
    private String username;
    private String password;
    private Boolean isEnabled;
    private String verificationCode;

    private Set<RoleDTO> rolesDTO;

    public AppUserDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Set<RoleDTO> getRolesDTO() {
        return rolesDTO;
    }

    public void setRolesDTO(Set<RoleDTO> rolesDTO) {
        this.rolesDTO = rolesDTO;
    }

    @Override
    public String toString() {
        return "AppUserDTO{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isEnabled=" + isEnabled +
                ", verificationCode='" + verificationCode + '\'' +
                ", rolesDTO=" + rolesDTO +
                '}';
    }
}
