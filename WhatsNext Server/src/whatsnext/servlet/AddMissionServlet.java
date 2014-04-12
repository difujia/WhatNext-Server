package whatsnext.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import whatsnext.bean.Mission;

/**
 * Servlet implementation class AddMissionServlet
 */
@WebServlet("/AddMissionServlet")
public class AddMissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
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
		String name= request.getParameter(Mission.NAME);
		String year= request.getParameter(Mission.YEAR);
		String agency= request.getParameter(Mission.AGENCY);
		String launch_site= request.getParameter(Mission.LAUNCH_SITE);
		String type= request.getParameter(Mission.TYPE);
		String earth_weight= request.getParameter(Mission.EARTH_WEIGHT);		
		String size= request.getParameter(Mission.SIZE);
		String key_images= request.getParameter(Mission.KEY_IMAGES);
		String[] array_key_images = key_images.split(",");
		String images= request.getParameter(Mission.IMAGES);
		String[] array_images = images.split(",");
		String key_findings= request.getParameter(Mission.KEY_FINDINGS);
		String[] array_key_findings = key_findings.split(",");
		String enabling_techonlogies= request.getParameter(Mission.ENABLING_TECHNOLOGIES);
		String[] array_enabling_techonlogies = enabling_techonlogies.split(",");
		String problems= request.getParameter(Mission.PROBLEMS);
		String[] array_problems = problems.split(",");
		String start_date= request.getParameter(Mission.START_DATE);
		String end_date= request.getParameter(Mission.END_DATE);
		String sister_missions= request.getParameter(Mission.SISTER_MISSIONS);
		String[] array_sister_missions = sister_missions.split(",");
		String related_missions= request.getParameter(Mission.RELATED_MISSIONS);
		String[] array_related_missions = related_missions.split(",");
		String music= request.getParameter(Mission.MUSIC);
		String more_info= request.getParameter(Mission.MORE_INFO);
		
		
		mission.setValue(Mission.NAME, name);
		mission.setValue(Mission.YEAR, year);
		mission.setValue(Mission.AGENCY, agency);
		mission.setValue(Mission.LAUNCH_SITE, launch_site);
		mission.setValue(Mission.TYPE, type);
		mission.setValue(Mission.EARTH_WEIGHT, earth_weight);
		mission.setValue(Mission.SIZE, size);
		mission.setValue(Mission.KEY_IMAGES, array_key_images);
		mission.setValue(Mission.IMAGES, array_images);
		mission.setValue(Mission.KEY_FINDINGS, array_key_findings);
		mission.setValue(Mission.ENABLING_TECHNOLOGIES, array_enabling_techonlogies);
		mission.setValue(Mission.PROBLEMS, array_problems);		
		mission.setValue(Mission.START_DATE, start_date);
		mission.setValue(Mission.END_DATE, end_date);
		mission.setValue(Mission.SISTER_MISSIONS, array_sister_missions);
		mission.setValue(Mission.RELATED_MISSIONS, array_related_missions);
		mission.setValue(Mission.MUSIC, music);
		mission.setValue(Mission.MORE_INFO, more_info);
		String json = gson.toJson(mission);
		System.out.println(json);
	}

}
