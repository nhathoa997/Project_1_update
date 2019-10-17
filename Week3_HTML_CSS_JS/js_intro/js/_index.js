(function(){
    // alert('Hello, World!');

// creating variables
var x = 10; //var variables are subject to hoisting;
// hoisted to the top of the highest function 'window'

let y = "My String"; // locally scoped mutable variable
const z = "My Immutable String"; // locally scoped immutable variable

let a = 10;
let b = [];
let c = "String";
let d = false;
let e = {};
let f = function() {};

//arrays
let arr = [1, true, "cat", () => {}, [1,2,3]]; // JS arrays do not declar size;

// iteration
for(let i = 0; i < arr.length; i++) {
console.log(arr[i]);
}

for(let o in arr) { // o will be the indices of the arr
console.log(o);
}

for(let o of arr) { // o will be the object at any particular index
console.log(o);
}

arr.forEach((elem) => console.log(elem))
arr[100] = false;

arr.forEach((elem) => console.log(elem))
arr.push(17);
arr.shift({});
arr.unshift(1001);

arr.forEach((elem) => console.log(elem))


// Objects
const p = {
name: "August", // single quotes and double quotes work the same way
age: 36
}

console.log(p.name);
console.log(p["name"]);

function getObjProp(obj, prop) {
console.log(obj.prop);
console.log(obj[prop]);
}

getObjProp(p, "age");

p.speak = function() {
console.log("Isn't JS wonderful?");
}

console.log(p);
console.log(p["speak"]);
console.log(p["speak"]());
// delete p.speak;

// console.log(p);

var student = {
major: "Computer Science",
study: () => {console.log("sleep")}
}

student.__proto__ = p;
console.log(student);
console.log(student.name);
console.log(student.study());

//functions
// functions can return any object
//name functions
function myFunc(){}

//anonymous
const myFunc2 = function() {}
const ref2 = myFunc2;

//arrow function
// arrow functions don't create new scopes
// implicit return () => 2+2
// () are only needed for empty param lists and multi-param list
const myArrow = () => {}

//closures -- when a function (outer) return another function (inner)
function sum(x, y) {
if(y) {
return x + y;
}

//returning this function if y is null or undefined create a closure
//this inner function will have access to any parameters or locally scoped variables of
//outer function
return function(z) {
return x + z;
}
}

})()

const Person = (function(){
    let _name = "";

    function Person(name) {
        _name = name;
    }

    Person.prototype.getName = () => _name;
    // Person.getName = () => _name;

    return Person;
    
})(); // IIFE -- immediately invoking function expression