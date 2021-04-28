export type RecordsResponse ={
    content:RecordItem[];
    totalPages:number;
}

export type RecordItem = {
    id:number; 
    moment: string;
    name:string;
    age:number;
    gameTitle: string;
    plataform: Plataform;
    genreName: string
}

export type Plataform = 'XBOX' | 'PC' | 'PLAY'