function test(){
	var test = "Hello From External JS File ";
	return test;
}



var greet = function(name) {
    print('Hi there from Javascript, ' + name);
    return "Greetings from javascript";
};

var printObj = function (object, isPersonObject) {
	print("************************Inside printObj function **********************")
	
	if(isPersonObject){
		var info = object.getPersonInfo();
		print(info);
	}else{
		print(object);
	}
	
	return null;
};


var printSortedPersons = function(personList){
	print("************************Inside printSortedPersons function **********************")
	personList
	.stream()
	.forEach(
		function(p){
			print(p);
		});
};

var callJavaMethod = function(className){
	print("************************Inside callJavaMethod function **********************")
	
	var MyJavaClass = Java.type(className);
	var result = MyJavaClass.javaCall('Jerin');
	print(result);
	return "Return From JS!";
};

test(); //To return a data
