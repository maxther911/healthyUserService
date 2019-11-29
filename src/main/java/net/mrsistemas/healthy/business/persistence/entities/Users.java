package net.mrsistemas.healthy.business.persistence.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Users extends BaseIdEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @Getter @Setter
    private Long id;
    @Column(name = "account_expired")
    @JsonIgnore
    @Getter @Setter
    private Boolean accountExpired = false;
    @Column(name = "account_locked")
    @JsonIgnore
    @Getter @Setter
    private Boolean accountLocked = false;
    @Column(name = "credentials_expired")
    @JsonIgnore
    @Getter @Setter
    private Boolean credentialsExpired = false;
    @Getter @Setter
    private String email;
    @JsonIgnore
    @Getter @Setter
    private Boolean enabled = true;
    @Getter @Setter
    @JsonIgnore
    private String password;
    @Getter @Setter
    private String username;

    @Getter @Setter
    private String address;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name="birth_date")
    @Getter @Setter
    private LocalDate birthDate;
    @Getter @Setter
    private String cellphone;
    @Getter @Setter
    private String dni;
    @Column(name="id_contact")
    @JsonIgnore
    @Getter @Setter
    private Long idContact;
    @Column(name="last_name")
    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String phone;
    @JsonIgnore
    @Getter @Setter
    private BigDecimal state;

    @Getter
    @Setter
    @OneToOne
    @JsonProperty("contact")
    @JoinColumn(name = "id_contact", insertable = false, updatable = false)
    private Users contact;

    @ManyToOne
    @JoinColumn(name="id_city_birth")
    @Getter @Setter
    private City birth_city;

    @Getter
    @Setter
    private String photo;

    @ManyToMany
    @JoinTable(name = "role_user", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")})
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonProperty(value = "rol")
    private List<Role> roles;

    @JsonIgnore
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
