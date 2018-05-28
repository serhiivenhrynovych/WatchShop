package ua.com.serhii.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.com.serhii.entity.enumeration.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 1, max = 40, message = "User first name can't be longer than 40 characters")
    @Column(name = "username", length = 40)
    private String username;
    @NotNull
    @Size(min = 1, max = 254, message = "User email can't be longer than 254 characters")
    @Email
    @Column(length = 254, unique = true)
    private String email;
    @NotNull
    @Size(min = 6, max = 60)
    @Column(name = "user_password", length = 60)
    private String password;
    @Column(name = "start_date")
    private LocalDate startDate;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role authority = Role.ROLE_USER;
    @Size(min = 1, max = 255)
    @Column(name = "address")
    private String address;
    @Size(max = 18, message = "Mobile phone number can't be longer than 18 characters")
    @Column(name = "mobile_phone", length = 18)
    private String phone;
    @OneToOne
    private Basket basket;

    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(authority.name()));
        return authorities;
    }

    public User(String username, String email, String password, LocalDate startDate, String address, String phone, Basket basket) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.startDate = startDate;
        this.address = address;
        this.phone = phone;
        this.basket = basket;
    }
}
