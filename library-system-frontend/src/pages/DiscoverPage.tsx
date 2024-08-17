import { allBooksMock } from "../mock";
import { useState } from "react";
// Components 
import BookCard from "../utilities/items/BookCard";
import SearchBar from "../utilities/search/SearchBar";

function DiscoverPage()
{
    const [query, setQuery] = useState("");
    const [queryType, setQueryType] = useState("");

    return (
        <main className="container  mx-auto">
            <SearchBar></SearchBar>

            <div className="flex flex-wrap justify-center items-center gap-y-5 gap-x-5 py-5">
                {
                    allBooksMock.map((book) => {
                        return <BookCard book={book} />
                    })
                }
            </div>
        </main>
    )
}

export default DiscoverPage;