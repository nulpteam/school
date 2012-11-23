package epam.ph.sg.controllers;

/**
 * 
 * @author SergiyManko
 *
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import epam.ph.sg.models.User;
import epam.ph.sg.models.reversy.ReversyGame;
import epam.ph.sg.models.reversy.ReversyGameList;
import epam.ph.sg.models.reversy.ReversyPlayer;

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
	
	@RequestMapping(value = "/ReversyRules.html")
	public String reversyRules(HttpSession session) {
		log.debug(boundle.getString("message.hello"));
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return boundle.getString("jsp.login");
		}
		return boundle.getString("jsp.rules");
	}
	
	@RequestMapping(value = "/ReversyCreateGame.html")
	public String reversyCreateGame(HttpSession session) {
		log.debug(boundle.getString("message.hello"));
		ReversyGame reversyGame = ReversyGameList.addGameToList();
		ReversyPlayer player1 = new ReversyPlayer();
		player1.setName(((User) session.getAttribute("user")).getName());
		reversyGame.setPlayer1(player1);
		session.setAttribute("ReversyGame", reversyGame);
		return boundle.getString("jsp.game");
	}
	
	@RequestMapping(value = "/ReversyConnectGame.html", method = RequestMethod.POST)
	public @ResponseBody String reversyConnectGame(@RequestParam("gameID") Integer gameID, HttpSession session) {
		log.debug(boundle.getString("message.hello"));
		HashMap<Integer, ReversyGame> tempList = ReversyGameList.getGameList();
		ReversyGame reversyGame = tempList.get(gameID);
		ReversyPlayer player2 = new ReversyPlayer();
		player2.setName(((User) session.getAttribute("user")).getName());
		reversyGame.setPlayer2(player2);
		try {
			reversyGame.getPlayer1().getConnection().sendMessage(boundle.getString("game.connected"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(boundle.getString("message.err.cant.send.message"));
		}
		tempList.put(gameID, reversyGame);
		ReversyGameList.setGameList(tempList);
		session.setAttribute("ReversyGame", reversyGame);
		return boundle.getString("answer.possitive");
	}
	
	@RequestMapping(value = "/ReversyGamesList.html")
	public String reversyGameList(HttpSession session) {
		log.debug(boundle.getString("message.hello"));
		HashMap<Integer,ReversyGame> reversyGameList = ReversyGameList.getGameList();
		session.setAttribute("ReversyGameList", reversyGameList);
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
