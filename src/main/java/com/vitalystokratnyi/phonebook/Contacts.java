package com.vitalystokratnyi.phonebook;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contacts")
public class Contacts
{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;
    @NotNull
    @Column(unique = true)
    private String phone;


    public Long getId()
    {
        return id;
    }

    public void setId(Long id){this.id = id;}

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public Contacts(){}

    public Contacts(String name, String phone)
    {
        this.name = name;
        this.phone = phone;
    }
}
