import { BookGenre } from "../types";

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
    