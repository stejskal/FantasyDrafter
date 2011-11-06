package com.stejskal.fantasydrafter.servlets

import javax.servlet.http.{HttpServletResponse => Response, HttpServletRequest => Request, HttpServlet}
import org.fusesource.scalate.TemplateEngine
import javax.servlet.ServletConfig
import org.fusesource.scalate.servlet.{ServletTemplateEngine, ServletRenderContext}
import org.fusesource.scalate.servlet.Config._
import com.stejskal.fantasydrafter.models.{FantasyTeam, Player}
import org.squeryl.adapters.MySQLAdapter
import org.squeryl.{Session, SessionFactory}
import org.squeryl.PrimitiveTypeMode._

class BaseServlet extends HttpServlet
{
  var templateEngine: TemplateEngine = null
  var cssFiles = List("default.css", "MainNavigation.css", "PopoutContainer.css")

  override def init(config: ServletConfig)
  {
    super.init(config)
//    Class.forName("com.mysql.jdbc.Driver")
//    SessionFactory.concreteFactory = Some(()=>
//      Session.create(
//      java.sql.DriverManager.getConnection("..."),
//      new MySQLAdapter))
    templateEngine = new ServletTemplateEngine(config)
  }

  def getMyTeamList =
  {
    var myTeam = List[Player]()
    myTeam = new Player("Dez", "Bryant", "Dallas Cowboys", "Wide Reciever", "Week 5") :: myTeam
    myTeam = new Player("Owen", "Daniels", "Houston Texans", "Tight End", "Week 3") :: myTeam
    myTeam = new Player("Arian", "Foster", "Houston Texans", "Running Back", "Week 5") :: myTeam
    myTeam
  }

  def getDraftHistoryList =
  {
    var draftHistory = List[Player]()
    draftHistory = new Player("Arian", "Foster", "Houston Texans", "Running Back", "Week 5") :: draftHistory
    draftHistory = new Player("Michael", "Vick", "Dallas Cowboys", "Wide Reciever", "Week 5") :: draftHistory
    draftHistory = new Player("Adrian", "Peterson", "Houston Texans", "Tight End", "Week 3") :: draftHistory
    draftHistory
  }

  def getPickList =
  {
    var pickList = List[Player]()
    pickList = new Player("Dez", "Bryant", "Dallas Cowboys", "Wide Reciever", "Week 5") :: pickList
    pickList = new Player("Payton", "Manning", "Houston Texans", "Tight End", "Week 3") :: pickList
    pickList = new Player("Arian", "Foster", "Houston Texans", "Running Back", "Week 5") :: pickList
    pickList
  }

  def getSearchTableList =
  {
    var players = List[Player]()
    players = new Player("Arron", "Rodgers", "Green Bay Packers", "Quarter Back", "Week 4") :: players
    players = new Player("Clay", "Mathews", "Green Bay Packers", "Linebacker", "Week 4") :: players
    players = new Player("Casey", "Mathews", "Philadelphia Eagles", "Linebacker", "Week 35") :: players
    players
  }

  def getAllFantasyTeams =
  {
    var teams = List[FantasyTeam]()
    teams = new FantasyTeam("SLC Bush Pickles", "Spencer Stejskal", "BUSH") :: teams
    teams = new FantasyTeam("Duh Winning", "Clint Landry", "DUH") :: teams
    teams = new FantasyTeam("Wingmen", "Ryan Stout", "WING") :: teams
    teams
  }

  override def doGet(request: Request, response: Response)
  {
    val context = new ServletRenderContext(templateEngine, request, response, getServletContext)
    context.layout("/com/stejskal/fantasydrafter/screens/default.scaml", Map("myTeam" -> getMyTeamList,
      "draftHistory" -> getDraftHistoryList, "pickList" -> getPickList, "teams" -> getAllFantasyTeams, "cssFiles" -> cssFiles))
    {
      context.render("com/stejskal/fantasydrafter/divs/PlayerTable.scaml", Map("players" -> getSearchTableList))
    }
  }
}