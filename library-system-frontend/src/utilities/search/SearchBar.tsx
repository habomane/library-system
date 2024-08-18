import { useState } from "react";

function SearchBar({setQuery})
{
    const [queryText, setQueryText] = useState("");
    
    // Needs a container
    // Need to specify the type of search 
    return (
    <div className="my-5 mx-20">
<div className="bg-white border-2  shadow p-2 relative rounded-xl flex">
    <span className="w-auto flex justify-end  items-center text-gray-500 p-2">
      <svg xmlns="http://www.w3.org/2000/svg" className="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"></path>
      </svg>
    </span>
    <input 
    onChange={(e) => setQueryText(e.target.value)}
     className="border-white outline-none border-0 w-full rounded-xl p-2" type="text" placeholder="Try a title, or an author, or a genre" />
    <button
    onClick={() => setQuery(queryText)}
     className="bg-black hover:bg-gray-700 rounded-xl text-white text-xl p-2 pl-4 pr-4 ml-2">
      <p className="font-semibold text-xs">Search</p>
    </button>
  </div>
    </div>)
}
export default SearchBar;