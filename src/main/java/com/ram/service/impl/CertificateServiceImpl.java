package com.ram.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.model.Certificate;
import com.ram.repository.CertificateRepository;
import com.ram.service.CertificateService;

@Service
public class CertificateServiceImpl implements CertificateService
{

	@Autowired
	private CertificateRepository certificateRepository;

	@Override
	public Certificate createCertificate(Certificate certificate) {
		
		return certificateRepository.save(certificate);
	}

	@Override
	public void updateCertificate(Certificate certificate) {
		
		certificateRepository.save(certificate);

	}

	@Override
	public Certificate getCertificate(int certificate_id) {
		Optional<Certificate> optional = certificateRepository.findById(certificate_id);
		Certificate certificate = optional.get();
		return certificate;
	}

	@Override
	public List<Certificate> getCertificates() {
		
		return (List<Certificate>)certificateRepository.findAll();
	}

	@Override
	public void deleteCertificate(int certificate_id) {
		
		certificateRepository.deleteById(certificate_id);
	}

	@Override
	public boolean isCertificateExist(int certificate_id) {
		
		return certificateRepository.existsById(certificate_id);
	}
	
	@Override
	public int getCount() {
		return (int) certificateRepository.count();
	}
}
