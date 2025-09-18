var num =10
num=34
console.log(num);
var num =12
console.log(num)

function hello(rev){

    console.log("Hello to JS")
}
hello(23);

let arr = [45,55,66,67]

console.log("-------------------------------")
//-------------------------///

let str = "dev"
let str1 = new String("dev")
let result = str==str1
let result1 = str===str1
console.log("double equals operator: "+result)
console.log("triple equals operator: " +result1);


// Logical Operators( && ( And ) & || ( OR ) )
let ref = true;
let ref1 = false;

let results= ref && ref1;
let results1 = ref || ref1;

console.log("Logocal && (AND) Operator: "+results);
console.log("Logical || (OR) Operator: "+results1);


console.log(arr)
console.log(typeof arr);

console.log("Ternary Operator.....")

age = 4

age > 18 ? console.log("Adult") : console.log("Minor");
age >10 ? console.log("Adult") : console.log("Child");

// age > 10 ? age > 18 ? console.log("Adult") : console.log("Minor") : console.log("Child"); // it is not recommended 

let x = 7

console.log(x++)
console.log(++x)

//Comma Seperators
let a, b
const result2 = (a=8, b=9, a+b)
console.log(result2);