import { Book } from "../../models";

function BookCard({ book }: { book: Book }) {
  return (
    <div className="w-[65%] md:w-[25%]">
      <div className="bg-white rounded-lg shadow-lg">
        <img
          src="https://images.unsplash.com/photo-1600054800747-be294a6a0d26?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1053&q=80"
          alt=""
          className="rounded-t-lg"
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

          <a
            href="#"
            className="text-purple-600 hover:text-purple-500 underline text-sm"
          >
            Read More 👉
          </a>
        </div>
      </div>
    </div>
  );
}
export default BookCard;
