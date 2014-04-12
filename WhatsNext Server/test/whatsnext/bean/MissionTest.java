package whatsnext.bean;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class MissionTest {

	SimpleDateFormat	format	= new SimpleDateFormat("yyyy-MM-dd");
	Gson				gson	= new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd").create();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws ParseException {
		Mission mission = new Mission();
		mission.setValue(Mission.NAME, "Mariner 4");
		mission.setValue(Mission.YEAR, "1964");
		mission.setValue(Mission.AGENCY, "NASA");
		mission.setValue(Mission.LAUNCH_SITE, "Cape Canaveral");
		mission.setValue(Mission.TYPE, "Flyby");
		mission.setValue(Mission.EARTH_WEIGHT, 260.8);
		mission.setValue(Mission.SIZE,
				"metal frame 127 cm across a diagonal and 45.7 cm high; solar panels end-to-end span of 6.88 meters; total 2.89 m high");
		String[] keyImages = { "http://nssdc.gsfc.nasa.gov/imgcat/hires/m04_01d.gif",
				"http://nssdc.gsfc.nasa.gov/image/spacecraft/mariner04.gif" };
		mission.setValue(Mission.KEY_IMAGES, keyImages);
		String[] images = { "http://nssdc.gsfc.nasa.gov/imgcat/html/mission_page/MR_Mariner_4_page1.html" };
		mission.setValue(Mission.IMAGES, images);
		String[] keyFindings = { "First images of Martian surface", "Interplanetary magnetic field data",
				"Radiation data", "Solar flux", "Automatic star based navigation" };
		mission.setValue(Mission.KEY_FINDINGS, keyFindings);
		String[] enablingTechs = {
				"Star navigation for sense of direction locking on either the Sun, Earth, Mars or the star Canopus (second brightest star in the night sky)",
				"Tape recorder for data storage with 634 KB" };
		mission.setValue(Mission.ENABLING_TECHNOLOGIES, enablingTechs);
		String[] problems = {
				"Plasma probe had its performance degraded by a resistor failure",
				"Lock on Canopus lost multiple times due to particles released from the space craft driftin by the sensor",
				"Hits by micrometeors" };
		mission.setValue(Mission.PROBLEMS, problems);
		mission.setValue(Mission.START_DATE, format.parse("1964-11-28"));
		mission.setValue(Mission.END_DATE, format.parse("1967-12-21"));
		mission.setValue(Mission.SISTER_MISSIONS, "Mariner 3");
		mission.setValue(Mission.RELATED_MISSIONS, null);
		mission.setValue(Mission.MUSIC, "Little Red Rooster - The Rolling Stones");
//		System.out.println(mission);
//		List<Mission> missions = new ArrayList<>();
//		missions.add(mission);
//		missions.add(mission);
//		missions.add(mission);
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(mission.getInfo());
		list.add(mission.getInfo());
		list.add(mission.getInfo());
		System.out.println(gson.toJson(list));
	}

	@Test
	public void test2() throws FileNotFoundException {
		Reader reader = new FileReader("sample_mission_format.json");
		JsonParser parser = new JsonParser();
		JsonArray array = parser.parse(reader).getAsJsonArray();
//		Type type = new TypeToken<Map<String, Object>>() {}.getType();
//		Map<String, Object>[] list = gson.fromJson(reader, type);
		Map<String, Mission> missions = new HashMap<String, Mission>();
		for (JsonElement item : array) {
			Mission info = gson.fromJson(item, Mission.class);
		}
		
		for (Mission m : missions.values()) {
			System.out.println(m);
		}
	}
	
	@Test
	public void test3() throws FileNotFoundException {
		Reader reader = new FileReader("sample_mission_format.json");
		Mission m = gson.fromJson(reader, Mission.class);
		for (String key : m.getKeys()) {
			System.out.println(key);
		}
	}
	
	
	
	
	
	
}
