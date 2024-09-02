
import { Link } from "react-router-dom";


function BookRequestPage()
{
    return (
        <main className="container mx-auto">
            <h1 className="my-5 text-3xl font-bold">My <span className="text-green-700">Requests</span></h1>

            <div className="mt-10">
                <h2 className="text-2xl font-semibold ">Requests <span className="text-green-700">Recieved</span></h2>
                <div className="border-t w-full mt-2">
                </div>
            </div>

            <div className="mt-10">
                <h2 className="text-2xl font-semibold ">Requests <span className="text-green-700">Sents</span></h2>
                <div className="border-t w-full mt-2">
                </div>
            </div>
        </main>
    )
}

export default BookRequestPage;