package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Contact;
import in.ashokit.repository.ContactRepository;

@Service

public class ContactServiceimpl implements ContactService {
	@Autowired
	private ContactRepository repo;
	
	
	public String upsert(Contact contact) {
		Contact save = repo.save(contact);
		return "SUCCESS";
	}
	
	
    
	public List<Contact> getAllContacts() {
		return repo.findAll();
	}
    
    
	public Contact getContact(int cid) {
		Optional<Contact> findById =repo.findById(cid);
		if (findById.isPresent()) {
			return findById.get();
			
		}
		
		return null;
	
	}
    
    
    
	public String deleteContact(int cid) {
    	repo.deleteById(cid);
    	return "SUCCESS";
		

	}

}
