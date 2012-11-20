package epam.ph.sg.controllers;

import javax.servlet.http.HttpSession;

import org.eclipse.jetty.util.log.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import epam.ph.sg.models.User;
import epam.ph.sg.models.infection.InfGame;
import epam.ph.sg.models.infection.InfGameMap;
import epam.ph.sg.models.infection.InfPlayer;

/*
 * author roman makovyak
 */

@Controller
@SessionAttributes("user")
public class InfectionMenuConroller {
	
	//������� �� ������� ���� ���
	@RequestMapping("Infection.html")
	public String infMenu(HttpSession session) {
		return "Infection/InfectionMenu";
	}
	//������� �� ������� ���
	@RequestMapping("InfectionGame.html")
	public String infGame(HttpSession session) {
		return "Infection/InfectionGame";
	}
    //��������� ���� ���
	@RequestMapping(value = "/InfectionCreateGame.html", method = RequestMethod.GET)
	public @ResponseBody
	boolean createGame(HttpSession session) {

		String oldGameId;
		User user;
		InfPlayer server;
		InfGame game;
        
		//���� � ��� � ��� �� ������� �� ������� ���
		oldGameId = (String) session.getAttribute("infGameId");
		if (oldGameId != null) {
			return true;
		}
        //���� � ����������� ��������� ���� ��� 
		user = (User) session.getAttribute("user");
		game = new InfGame();//���� ���
		server = new InfPlayer(user.getName(), game.getId());//����� ������� 
		game.setServer(server);//������������ ������
		InfGameMap.addGame(game);//������ ��� � ������ ����
				
		session.setAttribute("infGamesMap", InfGameMap.getGames());
		session.setAttribute("infGameId", game.getId());
		session.setAttribute("infUserType", "server");

		return true;
	}

	@RequestMapping(value = "/InfectionConnect.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean connectToGame(@RequestParam("gameId") String gameId,
			HttpSession session) {

		InfPlayer client;
		User user;
		InfGame game;

		user = (User) session.getAttribute("user");
		game = InfGameMap.getGames().get(gameId);
		client = new InfPlayer(user.getName(), game.getId());
		game.setClient(client);
		
		session.setAttribute("infUserType", "client");
		session.setAttribute("infGameId", game.getId());

		return true;
	}
	
	@RequestMapping(value = "/InfectionConnectList.html")
	public String getGameList(HttpSession session) {

		String oldGameId=null;
				
		session.setAttribute("infGamesMap", InfGameMap.getGames());
		oldGameId = (String)session.getAttribute("infGameId");
		if (oldGameId != null) {
			return "redirect:/InfectionGame.html";
		} else {
			return "Infection/InfectionGameList";
		}
       
	}

}
