package com.endava.example.web.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.endava.example.domain.dto.CustomerDTO;
import com.endava.example.domain.validator.CustomerValidator;
import com.endava.example.service.CustomerService;
import com.endava.example.web.helper.BeanParameters;
import com.endava.example.web.helper.MappingUtils;
import com.endava.example.web.helper.Navigation;

@Controller
@RequestMapping(MappingUtils.CUSTOMER_CONTROLLER)
public class CustomerController {

	private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerValidator customerValidator;

	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) {
		binder.setValidator(customerValidator);
	}

	@RequestMapping(value = MappingUtils.CUSTOMER_CONTROLLER_CREATE, produces = MappingUtils.TEXT_HTML)
	public String createCustomer(final Model uiModel, final HttpServletRequest request) {
		populateModel(new CustomerDTO(), uiModel, request);
		return Navigation.CREATE_CUSTOMER.getTileName();
	}

	@RequestMapping(value = MappingUtils.CUSTOMER_CONTROLLER_SAVE, produces = MappingUtils.TEXT_HTML, method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute @Valid CustomerDTO customerDTO, final BindingResult bindingResult,
			final Model uiModel, final HttpServletRequest request, final Locale locale) {
		if (!bindingResult.hasErrors()) {
			customerService.saveCustomer(customerDTO);
			LOG.info("Customer has been successfully saved.");
		}
		populateModel(customerDTO, uiModel, request);
		return Navigation.CREATE_CUSTOMER.getTileName();
	}

	private void populateModel(CustomerDTO customerDTO, Model uiModel, HttpServletRequest request) {
		uiModel.addAttribute(BeanParameters.HOME.getValue(),
				MappingUtils.getHomePath(request, MappingUtils.CUSTOMER_CONTROLLER));
		uiModel.addAttribute(BeanParameters.CUSTOMER.getValue(), customerDTO);
	}

}