/**********************************************************************/
/******************************** Overloading And Argumenst Concept *****************************/
/**********************************************************************/

function add(num1,num2){    
  console.log("In add with parameter");
}

function add(){
  console.log("In add without parameter");
  for (var i = 0, j = arguments.length; i < j; i++) {
    console.log( arguments[i] );
  }
}

/**********************************************************************/
/******************************** Use of Anonymous Funtions *****************************/
/**********************************************************************/

var jsSuffix = function(data){
   return data + " :JS";
};

var jsPrefix = function(data){
   return "JS : " + data;
};

function logMe(appender , data){
    console.log(appender(data));
} 

logMe(jsSuffix, "Hello using jsSuffix");
logMe(jsPrefix, "Hello using jsPrefix");

/**********************************************************************/
/******************************** This keyword *****************************/
/**********************************************************************/


function myMethod(){
    return this.val;
}

var object1 = {
    get: myMethod,
    val: 42
};


var object2 = {
    get: myMethod,
    val: 3.14159
};

console.log( object1.get());
console.log( object2.get());
console.log( myMethod());
console.log( myMethod.call(object1));

/**********************************************************************/
/******************************** Call Apply And Bind *****************************/
/**********************************************************************/

var firstObj = {
    fixedVal : 10,
    sum : function (a, b){
        return a + b + this.fixedVal;
    }
}

var secondObj = {
    fixedVal : 20
}
console.log(firstObj.sum(1,2));
console.log(firstObj.sum.call(secondObj, 1,2));
console.log(firstObj.sum.apply(secondObj, [1,2]));

var boundSecond = firstObj.sum.bind(secondObj);
console.log(boundSecond(1,2));
