package com.example.springboot;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	
	@GetMapping("/getallusers")
	public List<User> getAllUsers() {
		
		List<User> userList = userRepo.findAll();
		return userList;

	}

	@GetMapping("/getuserid/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		Optional<User> user = userRepo.findById(id);
		return user.get();
		

	}
//	 public void saveUser(User user) {
//	        userRepository.save(user);
//	    }
//	 @PostMapping("/")
//	    public void add(@RequestBody User user) {
//	        userService.saveUser(user); 
//	    }
     
	@PostMapping("/insertuser")
public String InsertUser(@RequestBody User userdetails){
		userRepo.save(userdetails);
		
		return "record inserted successfully...";
		
//		User user = new User();
////		User user=userRepo.findById(id).orElseThrow(()->new UserNotFoundException("User Not Found :"+id));
//		user.setUserAddress(userdetails.getUserAddress());
//		user.setUserName(userdetails.getUserName());
//		user.setUserPhoneno(userdetails.getUserPhoneno());
//	
			
//	public User InsertUser(@RequestBody User user) {
//		return userRepo.save(user);
//		
	}
	
	@PutMapping("/saveuser/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Integer id ,@RequestBody User userdetails){
		
		
		User user=userRepo.findById(id).orElseThrow(()->new UserNotFoundException("User Not Found :"+id));
		user.setUserAddress(userdetails.getUserAddress());
		user.setUserName(userdetails.getUserName());
		user.setUserPhoneno(userdetails.getUserPhoneno());
		
		User updateUser=userRepo.save(user);
			
		return ResponseEntity.ok(updateUser);
	} 
	
	
	@DeleteMapping(path="/deleteuser/{id}")
	public String deleteUser(@PathVariable Integer id) {
		
		Optional<User> user = userRepo.findById(id);
        userRepo.deleteById(id);
        
        return "record deleted successfully..";
        
	}

}
