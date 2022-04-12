export class Videojuego{
    private _id: number;
    private _titulo: string;
    private _compania: string;
    private _valoracion: string;
    private _caratula: string;
    
    private static contadorId: number = 0;

    constructor(titulo: string, compania: string, valoracion: string, caratula: string){
        this._id = Videojuego.contadorId++
        this._titulo = titulo
        this._compania = compania
        this._valoracion = valoracion
        this._caratula = caratula
    }

    public get id(): number {
        return this._id;
    }
    public get titulo(): string {
        return this._titulo;
    }
    public set titulo(value: string) {
        this._titulo = value;
    }
    public get compania(): string {
        return this._compania;
    }
    public set compania(value: string) {
        this._compania = value;
    }
    public get valoracion(): string {
        return this._valoracion;
    }
    public set valoracion(value: string) {
        this._valoracion = value;
    }
    public get caratula(): string {
        return this._caratula;
    }
    public set caratula(value: string) {
        this._caratula = value;
    }

}