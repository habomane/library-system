import { allBooksMock } from "../mock";
import { useState, useEffect } from "react";
import { Book } from "../models";
import { queryBooks } from "../helper";
// Components 
import BookCard from "../utilities/items/BookCard";
import SearchBar from "../utilities/search/SearchBar";

function DiscoverPage()
{
    const blankBooks: Book[] =[]
    const [allBooks, setAllBooks] = useState(blankBooks);
    const [query, setQuery] = useState("");

    useEffect(() => {
        console.log(query);
        if(query === "") { setAllBooks(allBooksMock)}
        else 
        {
            const filteredBooks = queryBooks(query, allBooks);
            setAllBooks(filteredBooks);
        }

    }, [query])
    return (
        <main className="container  mx-auto">
            <div className="">
            <SearchBar setQuery={setQuery}></SearchBar>

            <div className="flex flex-wrap justify-center items-center gap-y-5 gap-x-5 py-5">
                {
                    allBooks.map((book, index) => {
                        return <BookCard key={index} book={book} />
                    })
                }
            </div>
            </div>

            <div className=""></div>

        </main>
    )
}

export default DiscoverPage;