package whatsnext.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mission implements MissionConstants {

	@SerializedName("mission")
	private Map<String, Object>	info	= new HashMap<String, Object>();

	public void setValue(String key, Object value) {
		info.put(key, value);
	}

	public Object getValue(String key) {
		return info.get(key);
	}

	public Set<String> getKeys() {
		return info.keySet();
	}

	void setInfo(Map<String, Object> info) {
		this.info = info;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
		return builder.append(info).toString();
	}
}
