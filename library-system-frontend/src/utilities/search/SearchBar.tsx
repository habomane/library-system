

function SearchBar({setQuery} : {setQuery: React.Dispatch<React.SetStateAction<string>>})
{
    return (
    <div className="my-5 mx-20">
<div className="bg-white border-2 z-  shadow p-2 relative rounded-xl flex">
    <span className="w-auto flex justify-end  items-center text-gray-500 p-2">
      <svg xmlns="http://www.w3.org/2000/svg" className="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
        <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"></path>
      </svg>
    </span>
    <input 
    onChange={(e) => { setQuery(e.target.value) }}
     className="border-white outline-none border-0 w-full rounded-xl p-2" type="text" placeholder="Try a title, or an author, or a genre" />
    <button
     className="bg-black hover:bg-gray-700 rounded-xl text-white text-xl p-2 pl-4 pr-4 ml-2">
      <p className="font-semibold text-xs">Search</p>
    </button>
  </div>
    </div>)
}
export default SearchBar;
