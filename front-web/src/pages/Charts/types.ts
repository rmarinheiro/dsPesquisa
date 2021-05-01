import { Plataform } from "../Records/types";

export type Game ={
    id:number;
    title : string;
    plataform: Plataform;
}

export type ChartItem ={
    x: string;
    y:number;
}