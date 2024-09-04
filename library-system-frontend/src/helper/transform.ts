import { BookGenre, RequestStatus } from "../types";

export function transformGenreString(genre: string)
{   
    const res = Object.entries(BookGenre).find(([key,]) => key === genre);
    if(res === undefined || res === null) {return null;}
    return res[1];
}


export function transformGenreToRequestString(genre: string)
{   
    const resp = Object.keys(BookGenre).find((item) => BookGenre[item as keyof typeof BookGenre] === genre);
    if(resp !== undefined) { return resp}
    else {return genre.toUpperCase()}

}
    

export function transformBookStatusString(genre: string)
{   
    const res = Object.entries(RequestStatus).find(([key, ]) => key === genre);
    if(res === undefined || res === null) {return null;}
    return res[1];
}


export function transformBookStatusToRequestString(genre: string)
{   
    return Object.keys(RequestStatus).find((item) => RequestStatus[item as keyof typeof RequestStatus] === genre);

}
    