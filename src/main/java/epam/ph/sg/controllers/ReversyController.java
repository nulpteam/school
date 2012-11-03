package epam.ph.sg.controllers;

/**
 * 
 * @author SergiyManko
 *
 */

import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import epam.ph.sg.models.User;

@Controller
public class ReversyController {
	private static Logger log = Logger.getLogger(ReversyController.class);
	
	private static String propertyFileName = "reversy";
	public static ResourceBundle boundle = ResourceBundle.getBundle(propertyFileName);
	
	@RequestMapping(value = "/ReversyMenu.html")
	public String reversyMenu(HttpSession session) {
		log.debug(boundle.getString("message.hello"));
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return boundle.getString("jsp.login");
		}
		
		return boundle.getString("jsp.menu");
	}
	
	@RequestMapping(value = "/ReversyCreateGame.html")
	public String reversyCreateGame(HttpSession session) {
		log.debug(boundle.getString("message.hello"));
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return boundle.getString("jsp.login");
		} else
		return boundle.getString("jsp.game");
	}
	
	@RequestMapping(value = "/ReversyConnectGame.html")
	public String reversyConnectGame(HttpSession session) {
		log.debug(boundle.getString("message.hello"));
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return boundle.getString("jsp.login");
		} else
		return boundle.getString("jsp.game");
	}
	
	@RequestMapping(value = "/ReversyGamesList.html")
	public String reversyGamesList(HttpSession session) {
		log.debug(boundle.getString("message.hello"));
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return boundle.getString("jsp.login");
		} else
		return boundle.getString("jsp.games");
	}
	
	@RequestMapping(value = "/Reversy.html")
	public String reversy(HttpSession session) {
		log.debug(boundle.getString("message.hello"));
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return boundle.getString("jsp.login");
		} else
		return boundle.getString("jsp.game");
	}

}
