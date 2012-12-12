package epam.ph.sg.web.controllers;

/**
 * 
 * @author SergiyManko
 *
 */

import java.util.HashMap;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import epam.ph.sg.models.User;
import epam.ph.sg.models.reversy.ReversyGame;
import epam.ph.sg.models.reversy.ReversyGameList;
import epam.ph.sg.models.reversy.ReversyPlayer;
import epam.ph.sg.models.reversy.ReversyStatistic;
import epam.ph.sg.models.reversy.ReversyVinDefData;
import epam.ph.sg.models.sb.SBStatistics;

@Controller
public class ReversyController {
	private static Logger log = Logger.getLogger(ReversyController.class);
	public static HashMap<Integer, ReversyGame> activeGames = new HashMap<Integer, ReversyGame>();
	
	private static String propertyFileName = "reversy";
	public static ResourceBundle boundle = ResourceBundle.getBundle(propertyFileName);
	
	@RequestMapping(value = "/ReversyMenu.html")
	public String reversyMenu(HttpSession session) {
		log.debug(boundle.getString("message.hello"));
		return boundle.getString("jsp.menu");
	}
	
	@RequestMapping(value = "/ReversyRules.html")
	public String reversyRules(HttpSession session) {
		log.debug(boundle.getString("message.hello"));
		return boundle.getString("jsp.rules");
	}
	
	@RequestMapping(value = "/ReversyCreateGame.html")
	public String reversyCreateGame(HttpSession session) {
		log.debug(boundle.getString("message.hello"));
		if (session.getAttribute("ReversyGame") != null) {
			return boundle.getString("jsp.game");
		}
		ReversyGame reversyGame = ReversyGameList.addGameToList();
		ReversyPlayer player1 = new ReversyPlayer();
		player1.setName(((User) session.getAttribute("user")).getName());
		player1.setFigure(ReversyController.boundle.getString("game.figure.x"));
		reversyGame.setPlayer1(player1);
		ReversyGameList.setGame(reversyGame.getId(), reversyGame);
		session.setAttribute("ReversyGame", reversyGame);
		return boundle.getString("jsp.game");
	}
	
	@RequestMapping(value = "/ReversyConnectGame.html", method = RequestMethod.POST)
	public @ResponseBody String reversyConnectGame(Integer gameID, HttpSession session) {
		log.debug(boundle.getString("message.hello"));
		if (session.getAttribute("ReversyGame") != null) {
			return boundle.getString("jsp.game");
		}
		HashMap<Integer, ReversyGame> tempList = ReversyGameList.getGameList();
		if (tempList.get(gameID) == null) {
			return boundle.getString("answer.negative");
		}
		ReversyGame reversyGame = tempList.get(gameID);
		ReversyPlayer player2 = new ReversyPlayer();
		player2.setName(((User) session.getAttribute("user")).getName());
		player2.setFigure(ReversyController.boundle.getString("game.figure.o"));
		reversyGame.setPlayer2(player2);
		reversyGame.setPlayerNameToMove(reversyGame.getPlayer1().getName());
		try {
			reversyGame.getPlayer1().getConnection().sendMessage(boundle.getString("game.connected") + "&" + reversyGame.getPlayer2().getName() + "&" + reversyGame.getPlayer2().getFigure() + "&" + reversyGame.getPlayerNameToMove());
		} catch (Exception e) {
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
		if (session.getAttribute("ReversyGame") != null) {
			return boundle.getString("jsp.game");
		}
		HashMap<Integer,ReversyGame> reversyGameList = ReversyGameList.getGameList();
		session.setAttribute("ReversyGameList", reversyGameList);
		return boundle.getString("jsp.games");
	}
	
	@RequestMapping(value = "/Reversy.html")
	public String reversy(HttpSession session) {
		log.debug(boundle.getString("message.hello"));
		return boundle.getString("jsp.game");
	}
	
	@RequestMapping(value = "/move.html", method = RequestMethod.POST)
	public @ResponseBody String reversyMove(Integer gameID, int x, int y, String figure, String playerName, HttpSession session) {
		log.debug(boundle.getString("message.hello"));
		log.debug(gameID);
		log.debug(x);
		log.debug(y);
		log.debug(figure);
		log.debug(playerName);
		
		ReversyGame temp = activeGames.get(gameID);
		temp.changeBoard(x, y, figure);
		activeGames.put(gameID, temp);
		log.debug(activeGames.get(gameID));
		try {
			activeGames.get(gameID).getPlayer1().getConnection().sendMessage(boundle.getString("message.socket.onMessage.type.changes") + temp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			activeGames.get(gameID).getPlayer2().getConnection().sendMessage(boundle.getString("message.socket.onMessage.type.changes") + temp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.setAttribute("ReversyGame", activeGames.get(gameID));
		return boundle.getString("answer.possitive");
	}
	
	@RequestMapping(value = "/changes.html", method = RequestMethod.POST)
	public @ResponseBody String reversyChanges(Integer gameID, HttpSession session) {
		log.debug(boundle.getString("message.hello"));
		log.debug("/changes.html");
		log.debug(gameID);
		session.setAttribute("ReversyGame", activeGames.get(gameID));
		return boundle.getString("answer.possitive");
	}
	
	@RequestMapping(value = "/end.html", method = RequestMethod.POST)
	public @ResponseBody String reversyEnd(String player1, Integer xs, String player2, Integer os, HttpSession session) {
		log.debug(boundle.getString("message.hello"));
		log.debug("/end.html");
		int userId = ((User)session.getAttribute("User")).getId();
		String userName = ((User)session.getAttribute("User")).getName();
		if(userName.equals(player1))
		{
			if(xs>os)
			{
				ReversyStatistic.win(userId);
			}else if(xs<os)
			{
				ReversyStatistic.lose(userId);
			}
			else
			{
				ReversyStatistic.nichija(userId);
			}
		}
		if(userName.equals(player2))
		{
			if(os>xs)
			{
				ReversyStatistic.win(userId);
			}else if(os<xs)
			{
				ReversyStatistic.lose(userId);
			}
			else
			{
				ReversyStatistic.nichija(userId);
			}
		}
		ReversyVinDefData data = new ReversyVinDefData(player1, player2, xs, os);
		session.setAttribute("ReversyVinDefData", data);
		session.removeAttribute("ReversyGame");
		log.debug(data);
		return boundle.getString("answer.possitive");
	}
	
	@RequestMapping(value = "/ReversyVictory.html")
	public String victory(HttpSession session) {
		log.debug(boundle.getString("message.hello"));
		return boundle.getString("jsp.victory");
	}
	
	@RequestMapping(value = "/ReversyDefeat.html")
	public String defeat(HttpSession session) {
		log.debug(boundle.getString("message.hello"));
		return boundle.getString("jsp.defeat");
	}
	
	@RequestMapping(value = "/ReversyDraw.html")
	public String draw(HttpSession session) {
		log.debug(boundle.getString("message.hello"));
		return boundle.getString("jsp.draw");
	}
	
	@RequestMapping(value = "/ReversySurrender.html")
	public @ResponseBody String surrender(HttpSession session, Integer gameID, String playerName) {
		log.debug(boundle.getString("message.hello"));
		log.debug(gameID);
		log.debug(playerName);
		ReversyGame temp = activeGames.get(gameID);
		if ((temp.getPlayer1().getName() != null) && (playerName.equalsIgnoreCase(temp.getPlayer1().getName()))) {
			try {
				temp.getPlayer2().getConnection().sendMessage(boundle.getString("message.socket.onMessage.type.surrender"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if ((temp.getPlayer2().getName() != null) && (playerName.equalsIgnoreCase(temp.getPlayer2().getName()))) {
			try {
				temp.getPlayer1().getConnection().sendMessage(boundle.getString("message.socket.onMessage.type.surrender"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return boundle.getString("answer.possitive");
	}
}
