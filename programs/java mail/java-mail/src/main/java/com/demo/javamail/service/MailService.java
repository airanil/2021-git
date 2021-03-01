package com.demo.javamail.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.mail.internet.MimeMessage;

import com.demo.javamail.config.EmailConfiguration;
import com.demo.javamail.exception.ServiceException;
import com.demo.javamail.model.BaseMessage;
import com.demo.javamail.model.UserProfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class MailService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MailService.class);

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private EmailConfiguration emailConfig;

	@Autowired
	private Configuration configuration;


	public MailService() {
	}

	public static int noOfQuickServiceThreads = 50;

	/**
	 * this statement create a thread pool of fifty threads here we are assigning
	 * send mail task using ScheduledExecutorService.submit();
	 */
	private ScheduledExecutorService quickService = Executors.newScheduledThreadPool(noOfQuickServiceThreads);
	// Creates a thread pool that reuses fixed number of threads(as specified by
	// noOfThreads in this case).




	public void sendASynchronousForgotPasswordMail(UserProfile userProfile) {
		try {
			quickService.submit(new Runnable() {
				@Override
				public void run() {
					try {
						MimeMessage msg = javaMailSender.createMimeMessage();
						MimeMessageHelper helper = new MimeMessageHelper(msg, true);
						helper.setFrom("air.anil4655@gmail.com");
						helper.setTo(userProfile.getEmailId());
						helper.setSubject("Forgot Password? Help is here from Testing-mai Cargo Team");
						
						Resource resource=new ClassPathResource("mediafile");
						helper.addAttachment("spring-boot.png", resource);


						Map<String, UserProfile> map = new HashMap<String, UserProfile>();
						map.put("data", userProfile);
						Template template = configuration.getTemplate("forgot_password.ftl");
						String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
						helper.setText(html, true);
						javaMailSender.send(msg);
						LOGGER.info("sending forgot password mail to " + userProfile.getEmailId());
					} catch (Exception e) {
						LOGGER.error("EXCEPTION.. while sending forgot password mail to " + userProfile.getEmailId()
								+ " exp=> " + e);
					}
				}
			});
		} catch (Exception e) {
			LOGGER.error("EXCEPTION.. while generating forgot password mail template to " + userProfile.getEmailId()
					+ " exp=> " + e);
		}
	}
	
	/*
	 * CURRENTLY USING THIS ONE FOR FORGOT PASSWORD MAIL
	 */
	public void sendSynchronousForgotPasswordMail(UserProfile userProfile) throws ServiceException {

		try {
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg, true);
			helper.setFrom("air.anil4655@gmail.com");  

			Resource resource=new FileSystemResource(new ClassPathResource("mediafile/testpdf.pdf").getFile()); 
			helper.addAttachment("testpdf.pdf", resource);

			helper.setTo(userProfile.getEmailId());
			helper.setSubject("Forgot Password? Help is here from Testing-mail ");

			Map<String, UserProfile> map = new HashMap<String, UserProfile>();
			map.put("data", userProfile);
			Template template = configuration.getTemplate("forgot_password.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
			helper.setText(html, true);
			javaMailSender.send(msg);
			LOGGER.info("sending forgot password mail to " + userProfile.getEmailId());
		} catch (Exception e) {
			LOGGER.error("EXCEPTION... while sending forgot password mail to " + userProfile.getEmailId()
					+ " exp=> " + e);
			BaseMessage errorMsg = BaseMessage.builder().code("E").message(
						"Server Error occurred while generating the mail"  )
						.build();		
			ServiceException serviceException = new ServiceException();
			serviceException.setBaseMessage(errorMsg);
			throw serviceException;
			
		}

	}

	
}
