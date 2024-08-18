import { mockBook1, mockBook13 } from "../mock";

// Components
import BookListItem from "../utilities/items/BookListItem";
import BookFavoriteItem from "../utilities/items/BookFavoriteItem";

function LibraryPage()
{
    return (
        <main className="container mx-auto">
            <h1 className="mt-5 text-3xl font-bold">My <span className="text-green-700">Library</span></h1>

            <div className="mt-8 gap-x-3">
            <button className="rounded-lg px-4 py-2 bg-green-300 font-medium hover:bg-green-700 hover:text-white duration-300">Create +</button>
            </div>
            <div className="mt-10">
                <h2 className="text-2xl font-semibold ">My <span className="text-green-700">Items</span></h2>
                <div className="border-t w-full mt-2">
                    <BookListItem book={mockBook1}/>
                </div>
            </div>

            <div className="mt-10">
                <h2 className="text-2xl font-semibold ">My <span className="text-green-700">Favorites</span></h2>
                <div className="border-t w-full mt-2">
                    <BookFavoriteItem book={mockBook13} />
                </div>
            </div>
        </main>
    )
}

export default LibraryPage;