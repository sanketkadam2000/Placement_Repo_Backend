package com.ram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ram.exception.CertificateNotfoundException;
import com.ram.model.Certificate;
import com.ram.service.CertificateService;

@RestController
//@CrossOrigin(origins="http://localhost:3001")
@CrossOrigin(origins="*")
public class CertificateServiceController
{
	@Autowired
	private CertificateService certificateService;

	@RequestMapping(value = "/certificates", method = RequestMethod.POST)
	public ResponseEntity<Object> createCertificate(@RequestBody Certificate certificate)
	{
		certificate = certificateService.createCertificate(certificate);
		return new ResponseEntity<>("Certificate is created successfully with id = " +certificate.getCertificate_id(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/certificates/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateCertificate(@PathVariable("id") int id,
			@RequestBody Certificate certificate)
	{
		boolean isCertificateExist = certificateService.isCertificateExist(id);
		if (isCertificateExist)
		{
			certificate.setCertificate_id(id);
			certificateService.updateCertificate(certificate);
			return new ResponseEntity<>("Certificate is updated successsfully", HttpStatus.OK);
		}
		else
		{
			throw new CertificateNotfoundException();
		}

	}

	@RequestMapping(value = "/certificates/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getCertificate(@PathVariable("id") int id)
	{
		boolean isCertificateExist = certificateService.isCertificateExist(id);
		if (isCertificateExist)
		{
			Certificate certificate = certificateService.getCertificate(id);
			return new ResponseEntity<>(certificate, HttpStatus.OK);
		}
		else
		{
			throw new CertificateNotfoundException();
		}

	}

	@RequestMapping(value = "/certificates", method = RequestMethod.GET)
	public ResponseEntity<Object> getCertificates()
	{
		List<Certificate> certificateList = certificateService.getCertificates();
		return new ResponseEntity<>(certificateList, HttpStatus.OK);
	}

	@RequestMapping(value = "/certificates/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCertificate(@PathVariable("id") int id)
	{
		boolean isCertificateExist = certificateService.isCertificateExist(id);
		if (isCertificateExist)
		{
			certificateService.deleteCertificate(id);
			return new ResponseEntity<>("Certificate is deleted successsfully", HttpStatus.OK);
		}
		else
		{
			throw new CertificateNotfoundException();
		}

	}

}
