package com.stejskal.web.scala.fantasydrafter.servlets

import javax.servlet.http.{HttpServletResponse => Response, HttpServletRequest => Request, HttpServlet}
import org.fusesource.scalate.TemplateEngine
import javax.servlet.ServletConfig
import org.fusesource.scalate.servlet.{ServletTemplateEngine, ServletRenderContext}
import org.fusesource.scalate.servlet.Config._
import com.stejskal.web.scala.fantasydrafter.models.Player

class LoginServlet extends HttpServlet
{
  var templateEngine: TemplateEngine = null

  override def init(config: ServletConfig)
  {
    super.init(config)
    templateEngine = new ServletTemplateEngine(config)
  }

  override def doGet(request: Request, response: Response)
  {
    var players = List[Player]()
    players = new Player("Arron", "Rodgers", "Green Bay Packers", "Quarter Back", "Week 4") :: players
    players = new Player("Clay", "Mathews", "Green Bay Packers", "Linebacker", "Week 4") :: players
    players = new Player("Casey", "Mathews", "Philadelphia Eagles", "Linebacker", "Week 3") :: players
    val context = new ServletRenderContext(templateEngine, request, response, getServletContext)
    context.layout("/com/stejskal/web/scala/fantasydrafter/screens/default.scaml")
    {
      context.render("com/stejskal/web/scala/fantasydrafter/divs/PlayerTable.scaml", Map("players" -> players))
    }


  }

}