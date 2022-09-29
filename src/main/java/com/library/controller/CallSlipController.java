package com.library.controller;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.dto.request.CallSlipForm;
import com.library.dto.request.SignUpForm;
import com.library.dto.response.ResponseMessage;
import com.library.entity.Role;
import com.library.entity.RoleName;
import com.library.entity.User;
import com.library.entity.book;
import com.library.entity.callSlip;
import com.library.entity.reader;
import com.library.repository.BookRepository;
import com.library.repository.CallSlipRepository;
import com.library.repository.ReaderRepository;
import com.library.repository.UserRepository;
import com.library.service.BookService;
import com.library.service.CallSlipService;
import com.library.service.impl.CallSlipServiceImpl;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/admin")
public class CallSlipController {

	@Autowired
	private CallSlipRepository callSlipRepository;
	
	@Autowired
	private CallSlipService callSlipService;

	@Autowired
	private CallSlipServiceImpl callSlipServiceImpl;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private ReaderRepository readerRepository;

	@Autowired
	private UserRepository userRepository;
	
	public List<callSlip> callCards = new ArrayList<callSlip>();


	@GetMapping("/callCards")
	public List<callSlip> getAll() {
		return callSlipRepository.findAll();
	}
	@PostMapping("/callCards/return/{id}")
    public ResponseEntity<?> returnBooks(@PathVariable Long id){
		callSlipServiceImpl.returnBooks(id, Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        return ResponseEntity.ok().body(id);
    }
	
	@PostMapping("/callCards")
	public ResponseEntity<?> callCards(@Valid @RequestBody CallSlipForm CallSlipForm) {
		reader  reader = readerRepository.getById(CallSlipForm.getIdReader());
		User  user = userRepository.getById(CallSlipForm.getIdUser());
		
		Collection<Long> idbooks = CallSlipForm.getIdbooks();
		Set<book> books = new HashSet<>();
		for (Long idbook : idbooks) {
			long amount = bookRepository.getById(idbook).getAmount();
			if(amount > 0) {
				books.add(bookRepository.getById(idbook));
				bookRepository.getById(idbook).setAmount(amount-1);
			}
			
		}
		callSlip  callSlip = new callSlip(reader, user, books);
		callSlipRepository.save(callSlip);
		return ResponseEntity.ok(new ResponseMessage("Tạo phiếu mượn thành công!"));
	}
	


	@DeleteMapping("/callCards/{id}")
	public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable Long id) {
		callSlipRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
	@GetMapping("/callCards/{id}")
	public callSlip getReaderById(@PathVariable Long id) {
		return callSlipRepository.findById(id).get();
	}
	
	@PutMapping("/callCards")
	public callSlip updateReader(@RequestBody callSlip callSlip) {
		return callSlipRepository.save(callSlip);
	}
	
	@GetMapping("/callCards/search")
    public ResponseEntity<List<callSlip>> findByCriteria(@RequestParam("query") String query){
        return ResponseEntity.ok(callSlipService.findByCriteria(query));
    }
}
