package net.mrsistemas.healthy.business.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Users extends BaseIdEntity {

    @Getter
    @Setter
    @Column(insertable=false, updatable=false)
    private long id;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private boolean enabled;
    @Column(insertable=false, updatable=false)
    @OneToMany(mappedBy="id")
    private Set<DataUser> data;

    @Getter
    @Setter
    @Column(name = "account_locked")
    private boolean accountNonLocked;

    @Getter
    @Setter
    @Column(name = "account_expired")
    private boolean accountNonExpired;

    @Getter
    @Setter
    @Column(name = "credentials_expired")
    private boolean credentialsNonExpired;

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(name = "role_user", joinColumns = {
                @JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "role_id", referencedColumnName = "id")})
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Role> roles;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        roles.forEach(r -> {
            authorities.add(new SimpleGrantedAuthority(r.getName()));
            r.getPermissions().forEach(p -> {
                authorities.add(new SimpleGrantedAuthority(p.getName()));
            });
        });
        return authorities;
    }
}
