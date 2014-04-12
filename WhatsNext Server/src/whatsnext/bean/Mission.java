package whatsnext.bean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Mission implements MissionConstants {

	private Map<String, Object>	info	= new HashMap<String, Object>();

	public void setValue(String key, Object value) {
		info.put(key, value);
	}

	public Object getValue(String key) {
		return info.get(key);
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
		return builder.append(info).toString();
	}
}
