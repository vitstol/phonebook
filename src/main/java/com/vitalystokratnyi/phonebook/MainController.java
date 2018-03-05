package com.vitalystokratnyi.phonebook;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class MainController  {

    @Autowired
    private ContactsRepository contactsRepository;

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public @ResponseBody Iterable<Contacts> getContacts() throws NullPointerException
    {
        return contactsRepository.findAll();
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public @ResponseBody  String addContacts(@RequestBody ContactList contactList) throws NullPointerException
    {
        List<String> phones = contactList.getPhones();
        phones.forEach(x->{
            Contacts contacts = new Contacts(contactList.getName() , x);
            contactsRepository.save(contacts);
        });

        return String.valueOf(HttpStatus.OK);
    }

    @RequestMapping(value = "/contact", method = RequestMethod.DELETE)
    public @ResponseBody String removeContact(@RequestParam long id) throws NullPointerException
    {
        contactsRepository.deleteById(id);
        return String.valueOf(HttpStatus.OK);
    }

    @RequestMapping(value = "/contact", method = RequestMethod.PUT)
    public @ResponseBody String updateContact(@RequestBody Map<String, String> contact) throws NullPointerException
    {
        contactsRepository.updatePhone(contact.get("name"), contact.get("old_phone"), contact.get("new_phone"));
        return String.valueOf(HttpStatus.OK);
    }

    @RequestMapping(value = "/name", method = GET)
    public @ResponseBody ContactList getContacts(@RequestParam(value = "name") String name) throws NullPointerException
    {
        List<Contacts>  contacts = contactsRepository.findByName(name);
        List<String> phones = new ArrayList<>();
        contacts.forEach(x-> phones.add(x.getPhone()));
        return new ContactList(name, phones);
    }

}
