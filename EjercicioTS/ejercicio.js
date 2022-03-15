let parcial1 = 6;
let parcial2 = 3;
let parcial3 = 8;
let parciales = (parcial1 + parcial2 + parcial3) / 3;
let examen = 7;
let trabajo = 8;
let notaFinal = 0.55 * parciales + 0.3 * examen + 0.15 * trabajo;
console.log("Tu nota en JS es: " + notaFinal);
let videojuegos = ["Pokemon", "Mario Bros.", "Doom", "Zelda", "Metroid", "Super Mario Odyssey", "Smash Bros."];
let videojuegosFiltrados = videojuegos.filter(x => !x.includes("Mario"));
console.log(videojuegosFiltrados);
let numero = 6;
let originalNum = numero;
let factorial = 1;
while (numero >= 1) {
    factorial = factorial * numero;
    numero--;
}
console.log("El factorial de " + originalNum + " es: " + factorial);
