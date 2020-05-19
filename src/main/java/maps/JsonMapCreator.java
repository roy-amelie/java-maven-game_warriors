package maps;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import com.google.gson.stream.JsonReader;

import cases.CaseDeserializer;
import cases.Cases;
import warriors.contracts.Map;

public class JsonMapCreator implements InstanceCreator<Map>{

	@Override
	public Map createInstance(Type type) {
		// TODO Auto-generated method stub
		
		String PathToFile = "src/main/java/maps/map.json";
		Gson gson = new GsonBuilder().registerTypeAdapter(Cases.class, new CaseDeserializer()).create();
		FileReader reader = null;
		
		try {
			reader=new FileReader(PathToFile);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		JsonReader jsonreader= new JsonReader(reader);
		
		Board board = gson.fromJson(jsonreader, Board.class);
		System.out.println(gson);
		
	
		return board;
	}


		

		
		
	

}
