import { Book } from "../../models";
import { Link } from "react-router-dom";

function BookCard({ book }: { book: Book }) {
  return (
    <div className="w-[65%] md:w-[25%]">
      <div className="bg-white rounded-lg shadow-lg">
        <img
          src={book.image === "" ? "https://img.freepik.com/free-vector/hand-drawn-flat-design-stack-books-illustration_23-2149330605.jpg" : book.image}
          alt={book.title + " Book Cover."}
          className="rounded-t-lg h-[30vh] w-screen"
        />
        <div className="p-6">
          <h2 className="font-bold mb-2 text-xl">
            {book.title}
          </h2>
          <div className="mb-2 flex justify-between items-center">
          <p className="">
          {book.author}
          </p>
          <p className=" text-green-700 font-sm font-medium">
          {book.genre}
          </p>
          </div>

        <Link to={`/details/${book.bookId}`}>
          <p
            className="hover:text-green-700 font-semibold cursor underline underline-offset-4 text-sm"
          >
            More Details
          </p>
          </Link>
        </div>
      </div>
    </div>
  );
}
export default BookCard;
