package com.qs.tst.swg.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qs.tst.model.Person;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
public class TheController {
	private static final Logger logger = LoggerFactory.getLogger(TheController.class);

	@ApiOperation(value="The API is to show swagger info", nickname="nickname", notes="notes", response = String.class, tags= {"ABC-DE-SWAG", })
	@ApiResponses(value = {
			@ApiResponse(code=500, message="<table><tr><td>Type</td><td>Code</td><td>Detail</td></table>", response= String.class)
	})
	@RequestMapping(value="/v1/def", method = RequestMethod.GET)
	public ResponseEntity<String> showSwagger(
			@ApiParam(value = "Accept client body", required = true) @RequestHeader(value="Accept", required = true) String accept
			){
		logger.info("in showSwagger()");
		return new ResponseEntity<>("successful", HttpStatus.OK);
	}
	
	@RequestMapping(value="/v1/hello", method = RequestMethod.GET)
	public ResponseEntity<String> showHello(
			@ApiParam(value = "Accept client body", required = true) @RequestHeader(value="Accept", required = true) String accept
			){
		logger.info("in showHello()");
		return new ResponseEntity<>("Hello, World!", HttpStatus.OK);
	}
	//http://localhost:8082/v1/hello/Mark%20Towen! ===> Hello, Mark Towen!
	@RequestMapping(value="/v1/hello/{myName}",method = RequestMethod.GET)
    public String showHelloWithName( @PathVariable("myName") String myName) {
		 String theReturn = "Hello, " + myName;
         return theReturn;
    }
	 
	@RequestMapping(value="/v1/post",method = RequestMethod.POST)
    public String savePerson(@RequestBody Person person1) {
         return person1.toString() + " -- inserted not yet...";
    }
	
	@RequestMapping(value="/v1/put/{firstname}",method = RequestMethod.PUT)
    public String updateAddress( @PathVariable("firstname") String firstname, @RequestBody String address) {
        return String.format("This is the put");
    }

    @RequestMapping(value="/v1/delete/{lastname}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deletePersonByLastname( @PathVariable("lastname") String lastname) {
        return String.format("This is the Delete from lastname %s%n", lastname);
    }
}
