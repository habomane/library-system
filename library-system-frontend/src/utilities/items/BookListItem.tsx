import { Book } from "../../models";
import { Link } from "react-router-dom";

function BookListItem({ book }: { book: Book }) {
  return (
    <div className="w-full">
      <div className="bg-white rounded-lg shadow-lg">
        <div className="p-4">
            <div className="flex flex-row justify-between items-center mb-2">
            <h2 className="font-bold text-xl">
            {book.title}
          </h2>
          <p className=" text-green-700 font-sm font-medium">
          {book.genre}
          </p>
            </div>
 
            <div className="flex flex-row justify-between items-center">
            <p className="">
          {book.author}
          </p>

          <div className="flex flex-row gap-x-4">
          <Link to={`/details/${book.id}`}>
          <button className="rounded-lg px-4 py-1 font-medium bg-yellow-500 hover:bg-yellow-800 hover:text-white duration-300">Details</button>
        </Link>
          <Link to={`/edit/${book.id}`}>
          <button className="rounded-lg px-4 py-1 font-medium bg-green-300 hover:bg-green-700 hover:text-white duration-300">Edit</button>

          </Link>

          <button className="rounded-lg px-4 py-1 font-medium bg-red-500 hover:bg-red-800 hover:text-white duration-300">Delete</button>

          </div>
            </div>




        </div>
      </div>
    </div>
  );
}
export default BookListItem;
