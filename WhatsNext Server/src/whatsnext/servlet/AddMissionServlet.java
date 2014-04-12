package whatsnext.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import whatsnext.bean.Mission;

/**
 * Servlet implementation class AddMissionServlet
 */
@WebServlet("/AddMissionServlet")
public class AddMissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Mission mission = new Mission();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMissionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name= request.getParameter("name");
		String year= request.getParameter("year");
		String agency= request.getParameter("agency");
		String launch_site= request.getParameter("launch_site");
		String type= request.getParameter("type");
		String earth_weight= request.getParameter("earth_weight");		
		String size= request.getParameter("size");
		String key_images= request.getParameter("key_images");
		String[] array_key_images = key_images.split(",");
		String images= request.getParameter("images");
		String[] array_images = images.split(",");
		String key_findings= request.getParameter("key_findings");
		String[] array_key_findings = key_findings.split(",");
		String enabling_techonlogies= request.getParameter("enabling_technologies");
		String[] array_enabling_techonlogies = enabling_techonlogies.split(",");
		String problems= request.getParameter("problems");
		String[] array_problems = problems.split(",");
		String start_date= request.getParameter("start_date");
		String end_date= request.getParameter("end_date");
		String sister_missions= request.getParameter("sister_missions");
		String[] array_sister_missions = sister_missions.split(",");
		String related_missions= request.getParameter("related_missions");
		String[] array_related_missions = related_missions.split(",");
		String music= request.getParameter("music");
		String more_info= request.getParameter("moreinfo");
		
		mission.setValue(mission.NAME, name);
		mission.setValue(mission.YEAR, year);
		mission.setValue(mission.AGENCY, agency);
		mission.setValue(mission.LAUNCH_SITE, launch_site);
		mission.setValue(mission.TYPE, type);
		mission.setValue(mission.EARTH_WEIGHT, earth_weight);
		mission.setValue(mission.SIZE, size);
		mission.setValue(mission.KEY_IMAGES, array_key_images);
		mission.setValue(mission.IMAGES, array_images);
		mission.setValue(mission.KEY_FINDINGS, array_key_findings);
		mission.setValue(mission.ENABLING_TECHNOLOGIES, array_enabling_techonlogies);
		mission.setValue(mission.PROBLEMS, array_problems);		
		mission.setValue(mission.START_DATE, start_date);
		mission.setValue(mission.END_DATE, end_date);
		mission.setValue(mission.SISTER_MISSIONS, array_sister_missions);
		mission.setValue(mission.RELATED_MISSIONS, array_related_missions);
		mission.setValue(mission.MUSIC, music);
		mission.setValue(mission.MORE_INFO, more_info);
		
		
	}

}
