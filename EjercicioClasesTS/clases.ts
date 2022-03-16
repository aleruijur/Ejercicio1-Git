class Jugador{
    private _id: number;
    private _nombre: string;
    private _edad: number;
    private _pais: string;
    private _equipo: Equipo;
    private _historial: Historial;
    
    private static idAcum : number = 0;

    constructor(nombre: string, edad: number, pais: string, equipo: Equipo, historial: Historial){
        this._id = Jugador.idAcum;
        this._nombre = nombre;
        this._edad = edad;
        this._pais = pais;
        this._equipo = equipo;
        this._historial = historial;
        Jugador.idAcum++
    }

    public get id(): number {
        return this._id;
    }
    public get nombre(): string {
        return this._nombre;
    }
    public set nombre(value: string) {
        this._nombre = value;
    }
    public get edad(): number {
        return this._edad;
    }
    public set edad(value: number) {
        this._edad = value;
    }
    public get pais(): string {
        return this._pais;
    }
    public set pais(value: string) {
        this._pais = value;
    }
    public get equipo(): Equipo {
        return this._equipo;
    }
    public set equipo(value: Equipo) {
        this._equipo = value;
    }
    public get historial(): Historial {
        return this._historial;
    }
    public set historial(value: Historial) {
        this._historial = value;
    }
}

class Equipo{
    private _id: number;
    private _nombre: string;
    private _fechaFundacion: string;
    
    private static idAcum : number = 0;

    constructor(nombre: string, fechaFundacion: string){
        this._id = Equipo.idAcum;
        this._nombre = nombre;
        this._fechaFundacion = fechaFundacion;
        Equipo.idAcum++
    }

    public get id(): number {
        return this._id;
    }
    public get nombre(): string {
        return this._nombre;
    }
    public set nombre(value: string) {
        this._nombre = value;
    }
    public get fechaFundacion(): string {
        return this._fechaFundacion;
    }
    public set fechaFundacion(value: string) {
        this._fechaFundacion = value;
    }

}

class Historial{
    private _id: number;
    private _goles: number;
    private _tarAmarillas: number;
    private _tarRojas: number;
    
    private static idAcum : number = 0;

    constructor(goles: number, tarAmarillas: number, tarRojas: number){
        this._id = Historial.idAcum;
        this._goles = goles;
        this._tarAmarillas = tarAmarillas;
        this._tarRojas = tarRojas;
        Historial.idAcum++
    }

    public get id(): number {
        return this._id;
    }
    public get goles(): number {
        return this._goles;
    }
    public set goles(value: number) {
        this._goles = value;
    }
    public get tarAmarillas(): number {
        return this._tarAmarillas;
    }
    public set tarAmarillas(value: number) {
        this._tarAmarillas = value;
    }
    public get tarRojas(): number {
        return this._tarRojas;
    }
    public set tarRojas(value: number) {
        this._tarRojas = value;
    }
}

let betis = new Equipo("Betis", "12/09/1907")

let historialCanales = new Historial(9,2,0)
let canales = new Jugador("Sergio Canales", 31, "España", betis, historialCanales)
console.log(canales)

let historialFekir = new Historial(8,3,3)
let fekir = new Jugador("Fekir", 28, "Francia", betis, historialFekir)
console.log(fekir)

let historialGuido = new Historial(2,8,1)
let guido = new Jugador("Guido Rodríguez", 27, "Argentina", betis, historialGuido)
console.log(guido)

let historialCarvalho = new Historial(5,5,0)
let carvalho = new Jugador("William Carvalho", 29, "Portugal", betis, historialCarvalho)
console.log(carvalho)

let historialMoreno = new Historial(4,2,1)
let moreno = new Jugador("Álex Moreno", 28, "España", betis, historialMoreno)
console.log(moreno)

let historialBravo = new Historial(0,2,0)
let bravo = new Jugador("Claudio Bravo", 38, "Chile", betis, historialBravo)
console.log(bravo)

let historialJuanmi = new Historial(12,4,0)
let juanmi = new Jugador("Juanmi", 28, "España", betis, historialJuanmi)
console.log(juanmi)