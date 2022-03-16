class Jugador {
    constructor(nombre, edad, pais, equipo, historial) {
        this._id = Jugador.idAcum;
        this._nombre = nombre;
        this._edad = edad;
        this._pais = pais;
        this._equipo = equipo;
        this._historial = historial;
        Jugador.idAcum++;
    }
    get id() {
        return this._id;
    }
    get nombre() {
        return this._nombre;
    }
    set nombre(value) {
        this._nombre = value;
    }
    get edad() {
        return this._edad;
    }
    set edad(value) {
        this._edad = value;
    }
    get pais() {
        return this._pais;
    }
    set pais(value) {
        this._pais = value;
    }
    get equipo() {
        return this._equipo;
    }
    set equipo(value) {
        this._equipo = value;
    }
    get historial() {
        return this._historial;
    }
    set historial(value) {
        this._historial = value;
    }
}
Jugador.idAcum = 0;
class Equipo {
    constructor(nombre, fechaFundacion) {
        this._id = Equipo.idAcum;
        this._nombre = nombre;
        this._fechaFundacion = fechaFundacion;
        Equipo.idAcum++;
    }
    get id() {
        return this._id;
    }
    get nombre() {
        return this._nombre;
    }
    set nombre(value) {
        this._nombre = value;
    }
    get fechaFundacion() {
        return this._fechaFundacion;
    }
    set fechaFundacion(value) {
        this._fechaFundacion = value;
    }
}
Equipo.idAcum = 0;
class Historial {
    constructor(goles, tarAmarillas, tarRojas) {
        this._id = Historial.idAcum;
        this._goles = goles;
        this._tarAmarillas = tarAmarillas;
        this._tarRojas = tarRojas;
        Historial.idAcum++;
    }
    get id() {
        return this._id;
    }
    get goles() {
        return this._goles;
    }
    set goles(value) {
        this._goles = value;
    }
    get tarAmarillas() {
        return this._tarAmarillas;
    }
    set tarAmarillas(value) {
        this._tarAmarillas = value;
    }
    get tarRojas() {
        return this._tarRojas;
    }
    set tarRojas(value) {
        this._tarRojas = value;
    }
}
Historial.idAcum = 0;
let betis = new Equipo("Betis", "12/09/1907");
let historialCanales = new Historial(9, 2, 0);
let canales = new Jugador("Sergio Canales", 31, "España", betis, historialCanales);
console.log(canales);
let historialFekir = new Historial(8, 3, 3);
let fekir = new Jugador("Fekir", 28, "Francia", betis, historialFekir);
console.log(fekir);
let historialGuido = new Historial(2, 8, 1);
let guido = new Jugador("Guido Rodríguez", 27, "Argentina", betis, historialGuido);
console.log(guido);
let historialCarvalho = new Historial(5, 5, 0);
let carvalho = new Jugador("William Carvalho", 29, "Portugal", betis, historialCarvalho);
console.log(carvalho);
let historialMoreno = new Historial(4, 2, 1);
let moreno = new Jugador("Álex Moreno", 28, "España", betis, historialMoreno);
console.log(moreno);
let historialBravo = new Historial(0, 2, 0);
let bravo = new Jugador("Claudio Bravo", 38, "Chile", betis, historialBravo);
console.log(bravo);
let historialJuanmi = new Historial(12, 4, 0);
let juanmi = new Jugador("Juanmi", 28, "España", betis, historialJuanmi);
console.log(juanmi);
