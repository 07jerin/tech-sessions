package com.jerin.presentation.nashhorn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.jerin.presentation.common.Person;
import com.jerin.presentation.interfacemethods.PersonInterface;

public class ExecuteJs {

	public static void main(String[] args) throws FileNotFoundException, NoSuchMethodException, ScriptException {
		executeInternalScript();
		executeExternalScript();
//		
//		executeJsFunctions();
		

	}

	public static void executeInternalScript() {
		ScriptEngineManager manager = new ScriptEngineManager();

		ScriptEngine engine = manager.getEngineByName("nashorn");
		String script = "function testFunction() {return 'Hi From JS Function';} testFunction();";

		Object result;
		try {
			result = engine.eval(script);
			System.out.println(result);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}
	
	
	private static ScriptEngine executeExternalScript() throws FileNotFoundException{
		
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("nashorn");
		
		File file = new File("src/com/jerin/presentation/nashhorn/sampleScript.js");
		Reader reader = new FileReader(file);
		Object result;
		try {
			result = engine.eval(reader);
			System.out.println(result);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return engine;
		
	}
	
	
	private static void executeJsFunctions() throws FileNotFoundException, NoSuchMethodException, ScriptException{

		ScriptEngine engine = executeExternalScript();
		Invocable invocable = (Invocable) engine;

		Object result = invocable.invokeFunction("greet", "Jerin Joseph");
		System.out.println(result);
		
		result = invocable.invokeFunction("printObj", PersonInterface.getSamplePersons());
		System.out.println(result);
		
		
		result = invocable.invokeFunction("printObj", PersonInterface.getSamplePersons().get(0), true);
		System.out.println(result);
		
		result = invocable.invokeFunction("printSortedPersons", PersonInterface.getSamplePersons());
		System.out.println(result);
		
		
		result = invocable.invokeFunction("callJavaMethod", ExecuteJs.class.getName());
		System.out.println(result);
	}
	
	
	public static String javaCall(String name) {
	   System.out.println("In Java class");
	    return "Greetings from java";
	}
}
