package com.vitalystokratnyi.phonebook;

import java.util.List;

public class ContactList
{
    private String name;
    private List<String> phones;

    public ContactList()
    {
    }

    public ContactList(String name, List<String> phones)
    {
        this.name = name;
        this.phones = phones;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<String>  getPhones()
    {
        return phones;
    }

    public void setPhones(List<String>  phones)
    {
        this.phones = phones;
    }

}
