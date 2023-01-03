package com.ram.service;

import java.util.List;

import com.ram.model.Certificate;

public interface CertificateService
{
	public abstract Certificate createCertificate(Certificate certificate);

	public abstract void updateCertificate(Certificate certificate);
	
	public abstract Certificate getCertificate(int certificate_id);
	
	public abstract List<Certificate> getCertificates();
	
	public abstract void deleteCertificate(int certificate_id);
	
	public abstract boolean isCertificateExist(int certificate_id);
	
	public abstract int getCount();
}
