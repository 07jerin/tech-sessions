
/**********************************************************************/
/******************************** What is Prototype *****************************/
/**********************************************************************/
var myProtoObject = {};
function myProtoFunction(){};
var noProto = Object.create(null);

/**********************************************************************/
/******************************** Simple Prototypal Example *****************************/
/**********************************************************************/
var parent ={
    get : function fn (){
        return this.val;
    },
    val : 42
};

var child = Object.create(parent);
child.val = 3.14159;

var grandChild = Object.create(child);


console.log("parent.get()      : " +parent.get());
console.log("child.get()       : " +child.get());
console.log("grandChild.get()  : " +grandChild.get());  


/**********************************************************************/
/******************************** Extended Prototypal Example *****************************/
/**********************************************************************/

var AnswerPrototype = {
    construtor : function fn0 (value){
        this._val = value;
    },
    get : function fn1(){
        return this._val;
    }
};

var lifeAnswer = Object.create(AnswerPrototype);
lifeAnswer.construtor(42);
lifeAnswer.get();


var dessertAnswer = Object.create(AnswerPrototype);
dessertAnswer.construtor(3.1415);
dessertAnswer.get();

var FirmAnswerPrototype = Object.create(AnswerPrototype);
FirmAnswerPrototype.get = function fn2(){
  return AnswerPrototype.get.call(this) + "!!";
};

var luckyAnswer = Object.create(FirmAnswerPrototype);
luckyAnswer.construtor(7);
luckyAnswer.get();


var magicAnswer = Object.create(FirmAnswerPrototype);
magicAnswer.construtor(3);
magicAnswer.get();



/**********************************************************************/
/******************************** Simple Classical Example *****************************/
/**********************************************************************/

function Answer(value){
    this._val = value;
}

Answer.prototype.get = function fn1(){
  return this._val;  
};

var lifeAnswer = new Answer(42);
lifeAnswer.get();

var dessertAnswer = new Answer(3.1415);
dessertAnswer.get();




/**********************************************************************/
/******************************** Extended Classical Example *****************************/
/**********************************************************************/

function Answer(value){
    this._val = value;
}

Answer.prototype.get = function fn1(){
  return this._val;  
};

var lifeAnswer = new Answer(42);
lifeAnswer.get();

var dessertAnswer = new Answer(3.1415);
dessertAnswer.get();

function FirmAnswer (value){
    Answer.call(this, value);
}

FirmAnswer.prototype = Object.create(Answer.prototype);
FirmAnswer.prototype.construtor = FirmAnswer;
FirmAnswer.prototype.get = function fn2(){
  return Answer.prototype.get.call(this) + "!!";  
};

var luckyAnswer = new FirmAnswer(7);
luckyAnswer.get();


var magicAnswer = new FirmAnswer(3);
magicAnswer.get();













