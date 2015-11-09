package com.example.bencher.json;

import java.io.StringWriter;
import java.util.ArrayList;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import com.example.bencher.entity.testEntity2;
import com.example.bencher.https.HttpUtils;
import android.content.Context;
import android.util.Log;

public class Json {

	private Context context;
	public Json(Context context){
		this.context = context;
	}
	public String getJsonString(Object object) throws Exception {//将object转为json格式
		return JacksonMapper.getmapper().writeValueAsString(object);
	}
	
	
	public String getJsonString1(Object object) throws Exception {
		ObjectMapper mapper = JacksonMapper.getmapper();
		StringWriter sw = new StringWriter();
		JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
		mapper.writeValue(gen, object);
		gen.flush();
		gen.close();
		return sw.toString();
	}
	
	
	public  void objectsToJson(Object o,int num) throws Exception {

		ArrayList<Object> objects = new ArrayList<Object>();
		for(int i=0;i<num;i++)
			objects.add(o);
		Log.d("objectsToJson", getJsonString1(objects));//修改测试getJsonString1（）
	}
	
	public void objectToJson(Object o) throws Exception {
		
		Log.d("objectToJson", getJsonString(o));
	}
	
	public static String createObjectJson() throws Exception {

		Person p = new Person("zhaokaiqiang",22, new Birthday(1992, 1, 19));

		StringWriter stringWriter = new StringWriter();

		// 必须通过这种方式获取
		JsonGenerator jsonGenerator = JacksonMapper.getmapper()
				.getJsonFactory().createJsonGenerator(stringWriter);

		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("name", "CEO");
		jsonGenerator.writeNumberField("age", 22006);
		jsonGenerator.writeObjectField("person", p);
		jsonGenerator.writeEndObject();

		jsonGenerator.flush();
		jsonGenerator.close();

		Log.d("复杂对象转化为Json", stringWriter.toString());
		return stringWriter.toString();

	}
	

	public void createArrayJson() throws Exception {

		Person p = new Person("zhaokaiqiang",22, new Birthday(1992, 1, 19));

		StringWriter stringWriter = new StringWriter();
		// 只能通过这种方式获取
		JsonGenerator jsonGenerator = JacksonMapper.getmapper()
				.getJsonFactory().createJsonGenerator(stringWriter);

		jsonGenerator.writeStartArray();
		jsonGenerator.writeString("zhaokaiqiang");//不是写键值对
		jsonGenerator.writeNumber(22);
		jsonGenerator.writeObject(p);
		jsonGenerator.writeEndArray();

		jsonGenerator.flush();
		jsonGenerator.close();

		Log.d("999999999999999", stringWriter.toString());
	}
	


	
	///////////////////////////////////////////////////////////////
	public void JsontoObject(String jsonstring,Class<?>cls) throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();
		//Person p = new Person("zhaokaiqiang",22,  new Birthday(1992, 1, 19));
		//String jsonString = getJsonString(p);
		Object o = objectMapper.readValue(jsonstring, cls);
		Log.d("解析", o.toString());

	}
	
	public void JsontoObjects() throws Exception {

		Person p = new Person("zhaokaiqiang",15,  new Birthday(1992, 1, 19));

		ArrayList<Person> persons = new ArrayList<Person>();
		persons.add(p);
		persons.add(p);
		persons.add(p);

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = getJsonString(persons);
		@SuppressWarnings("unchecked")
		ArrayList<Person> arrayList = objectMapper.readValue(jsonString,
				new ArrayList<Person>().getClass());
		Log.d("解析2", arrayList.toString());
		
	}
	
	///////
	
	public void fromJsons() throws Exception {

//		String jsonString = HttpUtils.postByHttpClient(
//				context,"http://112.74.128.120/app/FlowPackage/getFlowPackageApi?mobile=18850041234&range=0" );
//		ObjectMapper objectMapper = JacksonMapper.getmapper();
//		
//		JsonNode jsonNode = objectMapper.readTree(jsonString);
//		JsonNode nameNode = jsonNode.get("name");
//		JsonNode ageNode = jsonNode.get("age");
//		JsonNode persoNode = jsonNode.get("person");
//		
//		String personString = persoNode.toString();
//		Person person = objectMapper.readValue(personString, Person.class);
//
//		Log.d("455", "person=" + person.toString());
//		Log.d("456", "age=" + ageNode.asInt());
//		Log.d("9988", "name=" + nameNode.asText());
		String jsonString = HttpUtils.postByHttpClient(
				context,"http://112.74.128.120/app/FlowPackage/getFlowPackageApi?mobile=18850041234&range=0" );
		ObjectMapper objectMapper = JacksonMapper.getmapper();
		 Log.d("455", ">>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<");
			JsonNode jsonNode = objectMapper.readTree(jsonString);
			
			JsonNode codeNode = jsonNode.get("code");
			JsonNode msgNode = jsonNode.get("msg");
			JsonNode EntityNode = jsonNode.get("body");
			
			String EntityString = EntityNode.toString();
			@SuppressWarnings("unchecked")
			ArrayList<testEntity2> entity = objectMapper.readValue(EntityString, new ArrayList<testEntity2>().getClass());

			Log.d("455", "code=" + codeNode.asInt());
			Log.d("456", "msg=" + msgNode.asText());
			Log.d("9988", "entity=" + entity.toString());

	}
}
