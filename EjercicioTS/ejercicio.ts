let parcial1 : number = 6
let parcial2 : number = 3
let parcial3 : number = 8

let parciales : number = (parcial1+parcial2+parcial3)/3
let examen : number = 7
let trabajo : number = 8

let notaFinal : number = 0.55 * parciales + 0.3 * examen + 0.15 * trabajo

console.log("Tu nota en JS es: " + notaFinal)

let videojuegos : string[] = ["Pokemon","Mario Bros.","Doom","Zelda","Metroid","Super Mario Odyssey","Smash Bros."]
let videojuegosFiltrados = videojuegos.filter(x=>!x.includes("Mario"))

console.log(videojuegosFiltrados)

let numero : number = 6
let originalNum : number = numero

let factorial:number = 1

while(numero >=1) { 
   factorial = factorial * numero 
   numero--
} 

console.log("El factorial de " + originalNum + " es: " + factorial)