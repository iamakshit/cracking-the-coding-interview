import java.lang.reflect.Field;
import java.util.LinkedHashMap;

public class MobikWik {

	public static String x = "{ \"Id\": \"610\", \"Name\": \"15\", \"Description\": \"1.99\",\"ItemModList\": [ 0,375,1]}";
	static String json = "{name:\"X\",age:\"3\",wage:\"13\" }";

	public static Object generateClass(String json, MWClass obj)
			throws IllegalArgumentException, IllegalAccessException, InstantiationException {

		Object objectInstance = (Object) obj.getClass().newInstance();

		LinkedHashMap<String, String> map = new LinkedHashMap<>();

		String[] parts = json.replaceAll("^\\{|\\}$", "").split("\"?(:|,)(?![^\\{]*\\})\"?");
		for (int i = 0; i < parts.length - 1; i += 2)
			map.put(parts[i], parts[i + 1]);

		for (Field field : obj.getClass().getDeclaredFields()) {
			String name = field.getName();
			Object value = map.get("name");
			field.set(objectInstance, value);

		}

		return objectInstance;
	}

	public static void main(String args[]) {

		MWClass obj = new MWClass();
		try {
			generateClass(json, obj);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
