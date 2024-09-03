import { BookGenre, RequestStatus } from "../types";

export function transformGenreString(genre: string)
{   
    const res = Object.entries(BookGenre).find(([key, value]) => key === genre);
    if(res === undefined || res === null) {return null;}
    return res[1];
}


export function transformGenreToRequestString(genre: string)
{   
    return Object.keys(BookGenre).find(item => BookGenre[item] === genre);

}
    

export function transformBookStatusString(genre: string)
{   
    const res = Object.entries(RequestStatus).find(([key, value]) => key === genre);
    if(res === undefined || res === null) {return null;}
    return res[1];
}


export function transformBookStatusToRequestString(genre: string)
{   
    return Object.keys(RequestStatus).find((item) => RequestStatus[item] === genre);

}
    