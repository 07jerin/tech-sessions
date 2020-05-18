
/**********************************************************************/
/******************************** Boolean *****************************/
/**********************************************************************/

var bool = 'false';
if(bool){
	console.log('TRUE');
}else{
	console.log('False');
}

/**********************************************************************/
/******************************** Scope *****************************/
/**********************************************************************/


function testScope(){
{
 var nestedBlock = "Nested Block";
}

console.log(nestedBlock);
} 

//Sample 2
var globalVar1 = 'Global Variable 1';
var globalVar2 = 'Global Variable 2';
function myFunction (){
    
    var globalVar1 = "Inner Varible 1";
    globalVar2 = "Inner Variable 2"
    
    console.log("Inside Function Global Variable 1 : " + globalVar1);
    console.log("Inside Function Global Variable 2 : " + globalVar2);
    console.log("Inside Function using Window Object Global Variable 1 : " + window.globalVar1);
    console.log("Inside Function using Window Object Global Variable 2 : " + window.globalVar2);
}

var globalX = 1; 
function outer(){
    globalX = 2;
    function inner(){
        globalX = 3;
    }
    console.log(window.globalX);
}
outer();


var myVar = "A global variable";
function grandparent(){
    var myVar = "A GrandParent variable";
    
    function parent(){
        var myVar = "A parent variable";
    
        function child(){
            var myVar = "A child variable";
            console.log(myVar);
        }
        child();
        console.log(myVar);
    }
    parent();
        console.log(myVar);
}
grandparent();
console.log(myVar);


/**********************************************************************/
/******************************** With Control Structure  *****************************/
/**********************************************************************/

var scope = "outside";
var object = {name: "Ignatius", scope: "inside"};
with(object) {
  console.log("Name == ", name, ", scope == ", scope);
  name = "Jerin";
  age = 10;
  var newVariable = 49;
}
console.log(object.name);
console.log(object.newVariable);


/**********************************************************************/
/******************************** Object Basics *****************************/
/**********************************************************************/


var student= {
  name: "Max",
  "number": 001,
  marks: {
    english: 80,
    malayalam : 90
  }
}
student.marks.english; //80
student["marks"]["english"]; // 80

student.marks.hindi = 75;

/**********************************************************************/
/******************************** Array Basics *****************************/
/**********************************************************************/

var a = new Array();
a[0] = "dog";
a[1] = "cat";
a[2] = "hen";
console.log("After Initialization : " +a.length);

a["X"] = "X VAL";
console.log("After Adding X : " + a.length);

a[100] = "LION";
console.log("After Adding LION : " + a.length);

console.log("Using For Loop");

for(var i = 0; i < a.length; i++){
console.log(a[i]);

}

console.log("Using For IN Loop");
for (var animalIndex in a){
console.log(a[animalIndex]);
}

console.log("Using For Each")
a.forEach(function(currentValue, index, array) {
  console.log(currentValue);
});

