package org.gestion.bp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.gestion.bp.dto.ClientDto;
import org.gestion.bp.entities.Client;
import org.gestion.bp.metier.IBanqueMetier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private IBanqueMetier banqueMetier;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("clientDto", new ClientDto());
		return "home";
	}
	
	@RequestMapping(value="/addClient", method = RequestMethod.POST)
    public String creer(@ModelAttribute("clientDto") @Valid final ClientDto clientDto, final BindingResult result, final Model model) {
		
        if (!result.hasErrors()) {
        	Client c = new Client();
        	c.setNomClient(clientDto.getNom());
            banqueMetier.addClient(c);
        }
        return "home";
    }
	
}
