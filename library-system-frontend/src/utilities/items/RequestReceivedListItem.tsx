import { Request } from "../../models";
import { Link } from "react-router-dom";


function RequestReceivedListItem({ request }: { request: Request }) {

  return (
    <div className="w-full">
      <div className="bg-white rounded-lg shadow-lg">
        <div className="p-4">
            <div className="flex flex-row justify-between items-center mb-2">
            <h2 className="font-bold text-xl">
            Request
          </h2>
          <p className=" text-green-700 font-sm font-medium">
          Received: {request.dateCreated.toDateString()}
          </p>
            </div>
 
            <div className="flex flex-row justify-between items-center">
            <p className="">
          {request.status}
          </p>

          <div className="flex flex-row gap-x-4">
          <Link to={`/request/received/${request.requestId}`}>
          <button className="rounded-lg px-4 py-1 font-medium bg-yellow-500 hover:bg-yellow-800 hover:text-white duration-300">Details</button>
        </Link>

          </div>
            </div>




        </div>
      </div>
    </div>
  );
}
export default RequestReceivedListItem;
