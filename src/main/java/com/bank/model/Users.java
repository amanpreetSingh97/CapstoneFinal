package com.bank.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
	/*
	 * @Column(name = "email") private String email;
	 */
    @Column(name = "password")
    private String password;
    @Column(name = "username")
    private String name;
	/*
	 * @Column(name = "last_name") private String lastName;
	 */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Users() {
    }

    public Users(Users users) {
        this.roles = users.getRoles();
        this.name = users.getName();
        this.id = users.getId();
        this.password = users.getPassword();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	/*
	 * public String getEmail() { return email; }
	 * 
	 * public void setEmail(String email) { this.email = email; }
	 */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	/*
	 * public String getLastName() { return lastName; }
	 * 
	 * public void setLastName(String lastName) { this.lastName = lastName; }
	 */

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
