import { allBooksMock } from "../mock";
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { Book } from "../models";
import { findBook } from "../helper";
import { getLocation } from "../service";

function CreateBook() {
  const bookDefault = new Book(0, "", "", "", "", false, "", "", "");
  const { id } = useParams();
  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  const [,setBook] = useState(bookDefault);
    // eslint-disable-next-line @typescript-eslint/no-unused-vars
  const [, setFormattedAddress] = useState("");

  useEffect(() => {
    const book = findBook(parseInt(id || "0"), allBooksMock) || bookDefault;

    setBook(book);

    async function setLocationReadable() {
      const location = await getLocation(book.zipcode);
      setFormattedAddress(location);
    }

    setLocationReadable();
  }, [id]);

  return (
    <main className="container mx-auto">
      <div className="flex flex-col gap-y-3 gap-x-3 items-center mt-8">
        <div className="w-full bg-white rounded-lg shadow-2xl ">
          <div className="py-12 px-5 md:pl-10">
            <div className="flex flex-row gap-x-2">
              <label className="text-3xl font-bold tracking-widest">
                Title:
              </label>
              <input
                type="text"
                className="border text-slate-500 border-slate-400 rounded-sm focus:outline-none
                focus:border-green-700"
              />
            </div>

            <div className="flex flex-row mt-2 gap-x-2 items-center">
              <label className="text-md font-medium">Is Available: </label>
              <input
                type="checkbox"
                className="border-gray-300 rounded-sm  h-6 w-6"
              />
            </div>

            <div className="flex flex-row gap-x-2 mt-8">
              <label className="text-lg text-slate-500">Author:</label>
              <input
                type="text"
                className="border text-slate-500 border-slate-400 rounded-sm focus:outline-none
                focus:border-green-700"
              />
            </div>

            <div className="flex flex-row gap-x-2 mt-2">
              <label className="text-lg text-slate-500">Genre:</label>
              <input
                type="text"
                className="border text-slate-500 border-slate-400 rounded-sm focus:outline-none
                focus:border-green-700"
              />
            </div>

            <div className="flex flex-row gap-x-2 mt-2">
              <label className="text-lg text-slate-500">Zipcode:</label>
              <input
                type="text"
                className="border text-slate-500 border-slate-400 rounded-sm focus:outline-none
                focus:border-green-700"
              />
            </div>

            <div className="flex flex-col gap-x-2 mt-10">
              <label className="text-lg text-slate-500">Description:</label>
              <textarea
                id="id-l03"
                name="id-l03"
                rows={3}
                placeholder="Write your message"
                className="peer relative w-full rounded border border-slate-300 p-4 text-slate-500 outline-none transition-all autofill:bg-white invalid:border-pink-500 invalid:text-pink-500 focus:border-green-700 focus:outline-none invalid:focus:border-pink-500 disabled:cursor-not-allowed disabled:bg-slate-50 disabled:text-slate-400"
              ></textarea>
            </div>

            <div className="my-3 flex flex-col gap-x-2">
                <label className="text-lg text-slate-500">Attach Image: </label>
                <input type="file" className="bg-white " />
            </div>

            <div className="flex flex-row items-center w-full justify-center md:justify-normal gap-x-5 md:w-[40%] mt-10">
              <button className="rounded-lg px-4 py-2 font-medium bg-green-300 hover:bg-green-700 hover:text-white duration-300">
                Save
              </button>
              <button className="rounded-lg px-4 py-2 font-medium bg-yellow-500 hover:bg-yellow-800 hover:text-white duration-300">
                Save as Draft
              </button>
              <button className="rounded-lg px-4 py-2 font-medium bg-red-500 hover:bg-red-800 hover:text-white duration-300">
                Discard
              </button>
            </div>
          </div>
        </div>
      </div>
    </main>
  );
}

export default CreateBook;
