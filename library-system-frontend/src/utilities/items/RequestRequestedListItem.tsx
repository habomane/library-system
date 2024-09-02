import { Request } from "../../models";
import { Link } from "react-router-dom";
import * as requestService from '../../service'

function RequestRequestedListItem({ request }: { request: Request }) {

  async function deleteRequest()
  {
    const response = await requestService.deleteRequest(request.requestId);
    if(response !== null)
    {
      alert("Request has been deleted.")
      window.location.reload();
    }
    else 
    {
      alert("Error, something went wrong.")
    }
  }
  return (
    <div className="w-full">
      <div className="bg-white rounded-lg shadow-lg">
        <div className="p-4">
            <div className="flex flex-row justify-between items-center mb-2">
            <h2 className="font-bold text-xl">
            Request
          </h2>
          <p className=" text-green-700 font-sm font-medium">
          Sent: {request.dateCreated.toDateString()}
          </p>
            </div>
 
            <div className="flex flex-row justify-between items-center">
            <p className="">
          {request.status}
          </p>

          <div className="flex flex-row gap-x-4">
          <Link to={`/request/requested/${request.requestId}`}>
          <button className="rounded-lg px-4 py-1 font-medium bg-yellow-500 hover:bg-yellow-800 hover:text-white duration-300">Details</button>
        </Link>

          <button 
          onClick={deleteRequest}
          className="rounded-lg px-4 py-1 font-medium bg-red-500 hover:bg-red-800 hover:text-white duration-300">Delete</button>

          </div>
            </div>




        </div>
      </div>
    </div>
  );
}
export default RequestRequestedListItem;
